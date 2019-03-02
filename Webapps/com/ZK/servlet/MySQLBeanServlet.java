package com.ZK.servlet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZK.SQL.DB;

/**
 * Servlet implementation class MySQLBeanServlet
 */
@WebServlet("/MySQLBeanServlet")
public class MySQLBeanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String USER = "root";
	private final String PASSWORD = "1234";
	private final String URL = "jdbc:mysql://localhost:3306/myDatabase";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLBeanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		//Statement stmt = null;
		ResultSet rs = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<TABLE BORDER=1>");
		pw.println("<tr>"
				+ "<th>ID:</td>"
				+ "<th>Contend:</td>"
				+ "</tr>");
		
		conn = DB.getConnection(URL, USER, PASSWORD);
		//stmt = DB.getStatement(conn);
		rs = DB.getResultSet(conn, "SELECT * FROM article");
		try {
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt(1) +"</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("</tr>");
			}
		pw.println("</TABLE>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			//DB.close(stmt);
			DB.close(conn);
		}
		System.out.println("SQL Query success!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
