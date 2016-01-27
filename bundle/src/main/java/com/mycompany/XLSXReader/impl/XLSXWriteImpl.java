package com.mycompany.XLSXReader.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.XLSXReader.XLSXWriter;

public class XLSXWriteImpl implements XLSXWriter {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("resource")
	@Override
	public String writeXLSX(String filePath, JSONArray jsonArray) {
		String operationResult = "error";
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		File file = new File(filePath);
		String sheetName = file.getName().substring(0, file.getName().indexOf("."));
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet(sheetName);

		int rowCount = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (int j = 1; j < jsonObject.length(); j++) {
				Cell cell = row.createCell(columnCount++);
				Object field = jsonObject.get(String.valueOf((char) (j - 1 + 65)));

				if (field instanceof String) {
					String current = " ";
					String decode = " ";
					if (field == null || field == "") {
					} else {
						current = (String) field;
					}

					try {
						decode = new String(current.getBytes("ISO-8859-1"), "UTF-8");
						cell.setCellValue(decode);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}

			}
			}

		try (FileOutputStream outputStream = new FileOutputStream(file)) {
			workbook.write(outputStream);
			log.debug(sheetName + " is written successfully on disk.");
			operationResult = "success";
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return operationResult;
	}
}
