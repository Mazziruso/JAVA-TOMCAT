package com.ZK.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class MySQLServlet
 */
@WebServlet("/MySQLServlet")
public class MySQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USER = "root";
	private final String PASSWORD = "1234";
	private final String URL = "jdbc:mysql://localhost:3306/myDatabase";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySQLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<TABLE BORDER=1>");
		pw.println("<tr>"
				+ "<th>ID:</td>"
				+ "<th>Contend:</td>"
				+ "</tr>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM article");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt(1) +"</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("</tr>");
			}
			pw.println("</TABLE>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
