package com.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySQLConnector
 */
@WebServlet("/connect")
public class MySQLConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLConnector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/thanks.jsp").forward(request, response);
		
				String message = "";
				String result ="";
				String dbQuery2 ="Use ";
				String dbName = request.getParameter("dbName");
				String rootName = request.getParameter("rootName");
				String rootPwd = request.getParameter("rootPwd");
				String dbQuery = request.getParameter("dbQuery");
				
			
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ dbName + "?trueSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", rootName, rootPwd);
					message = "connect succesfully";
					if(connect!=null) {
						java.sql.Statement statement = connect.createStatement();
						 
						if(dbQuery.trim().startsWith("SELECT")){
						ResultSet resultset = statement.executeQuery(dbQuery);
						result=com.model.SqlBuffer.getHtmlTable(resultset);
						}
						else {
							PreparedStatement preState=connect.prepareStatement(dbQuery);
							int rowEffect =(preState.executeUpdate());
							result= ("your numbers of rows efected :" + rowEffect );
							
							
						}
						
					
						
						//Testing to Print out the query
						/*while(resultset.next()){
							// System.out.println(resultset.getString(1) + " : " + resultset.getString(2) + " : " +resultset.getString(3) );
								for(int i =0; i <=3 ; i++) {
								result+="<p>" +resultset.getString(1) + " : " + resultset.getString(2) + " : " +resultset.getString(3) + "</p>";
								}
							}*/
						
						
						}
															
				}
				
				catch (Exception e) {
				  
				    message = e.getMessage() ;
				}
				//request.setAttribute("message", message);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
