package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(JDBCPassword.DRIVER_CLASS);
			System.out.println("Driver class loaded");
			con = DriverManager.getConnection(JDBCPassword.URL, JDBCPassword.USER, JDBCPassword.PSWD);
		} catch (Exception e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
		return con;
	}
public static void closeConnection(Connection con) {
	try {
		con.close();
	} catch (SQLException e) {
		System.out.println("Connection  closing error");
		e.printStackTrace();
	}
}
public static void closeStatement(PreparedStatement pst) {
	try {
		pst.close();
	} catch (SQLException e) {
		System.out.println("statement  closing error");
		e.printStackTrace();
	}
}
}
