package com.mycompany.XLSXReader.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.XLSXReader.XLSXWriter;
import com.mycompany.XLSXReader.impl.XLSXWriteImpl;

@SlingServlet(methods = "GET", paths = "/apps/XLSXWriteServlet")
public class XLSXWriteServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	private static final long serialVersionUID = 9119331705946872276L;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {
		String xlsxWriteOperationResult = "Error in write data.";

		String filePath = request.getParameter("filePath");
		String fileData = request.getParameter("fileData");

		if (filePath != null && fileData != null) {
			try {
				XLSXWriter xlsxWriter = new XLSXWriteImpl();
				JSONArray jsonArray = new JSONArray(fileData);
				xlsxWriteOperationResult = xlsxWriter.writeXLSX(filePath, jsonArray);

				log.error("filePath current!!" + filePath);
				log.error("fileData current!!" + fileData);
			} catch (Exception e) {
				log.error("filePath in bundle!!" + filePath);
				log.error("fileData in bundle!!" + fileData);
				log.error(e.getMessage());
			}
		}
		// Return the JSON formatted data
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(xlsxWriteOperationResult);
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {
		doPost(request, response);
	}
}
