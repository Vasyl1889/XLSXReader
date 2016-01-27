package com.mycompany.XLSXReader.impl;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.XLSXReader.XLSXReader;

public class XLSXReaderImpl implements XLSXReader {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@SuppressWarnings("resource")
	@Override
	public JSONArray readXLSX(String filePath) {
		JSONArray jsonArray = new JSONArray();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowIndex = 1;

			for (Row row : sheet) {
				JSONObject JSONObj = new JSONObject();
				for (int cn = 0; cn < row.getLastCellNum(); cn++) {
					Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
					JSONObj.put(" ", rowIndex);
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						JSONObj.put(String.valueOf((char) (cell.getColumnIndex() + 65)), cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						JSONObj.put(String.valueOf((char) (cell.getColumnIndex() + 65)), cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						JSONObj.put(String.valueOf((char) (cell.getColumnIndex() + 65)), "");
						break;
					case Cell.CELL_TYPE_STRING:
						JSONObj.put(String.valueOf((char) (cell.getColumnIndex() + 65)), cell.getStringCellValue());
						break;
					}
				}
				rowIndex++;
				jsonArray.put(JSONObj);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
