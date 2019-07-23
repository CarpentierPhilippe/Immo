package com.edu.realestate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDaoJDBC {

	private static Connection connection;
	
	Connection getConnection() {
		if (connection == null) {
			try {
			String connectParam = "?serverTimezone=UTC";
			String connectURL = "jdbc:mysql://localhost:3307/realestate"+connectParam;
			String user = "root";
			String password = "";
			Class clz = Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectURL,user,password);
			}catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	void disconnect() {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
