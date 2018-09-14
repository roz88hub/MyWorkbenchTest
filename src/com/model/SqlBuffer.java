package com.model;

import java.sql.*;

public class SqlBuffer {

	//static method buildTable that takes ResultSet
	public static String getHtmlTable(ResultSet results) throws SQLException {
		StringBuilder htmlTable = new StringBuilder();
		//		results = DBConnectServlet.resultset;
		ResultSetMetaData metaData = results.getMetaData();
		int columnCount = metaData.getColumnCount();
		htmlTable.append("<table>");
		//add header row
		htmlTable.append("<tr>");
		for(int i=1;i<=columnCount;i++) {
			htmlTable.append("<th>");
			htmlTable.append(metaData.getColumnName(i));
			htmlTable.append("</th>");
		}
		htmlTable.append("</tr>");
		//add all other rows
		while(results.next()) {
			htmlTable.append("<tr>");
			for(int i=1;i<=columnCount;i++) {

				htmlTable.append("<td>");
				htmlTable.append(results.getString(i));
				htmlTable.append("</td>");
			}
			htmlTable.append("</tr>");
		}
		htmlTable.append("</table>");
		// System.out.println(htmlTable.toString());
		return htmlTable.toString().toUpperCase();	
	}
}