package com.ZK.SQL;

import java.sql.*;

public class DB {
	public static Connection getConnection(String URL, String USER, String PASSWORD) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			if(conn != null) {
				stmt = conn.createStatement();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public static ResultSet getResultSet(Statement stmt, String SQL) {
		ResultSet rs = null;
		try {
			if(stmt != null) {
				rs = stmt.executeQuery(SQL);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet getResultSet(Connection conn, String SQL) {
		Statement stmt = DB.getStatement(conn);
		return DB.getResultSet(stmt, SQL);
	}
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
