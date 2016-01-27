package com.mycompany.XLSXReader.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.XLSXReader.XLSXReader;
import com.mycompany.XLSXReader.impl.XLSXReaderImpl;

@SlingServlet(methods = "GET", paths = "/apps/XLSXReaderServlet")
public class XLSXReaderServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	private static final long serialVersionUID = 9119331705946872276L;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {

		String stringDataJSON = null;
		String filePath = request.getParameter("filePath");

		try {
			XLSXReader xlsxReader = new XLSXReaderImpl();
			JSONArray dataJson = xlsxReader.readXLSX(filePath);

			stringDataJSON = dataJson.toString();

		} catch (Exception e) {
			log.error("filePath in bundle!!" + filePath);
			log.error(e.getMessage());
		}
		log.error("stringDataJSON" + stringDataJSON);
		// Return the JSON formatted data
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(stringDataJSON);
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {
		doPost(request, response);
	}
}
