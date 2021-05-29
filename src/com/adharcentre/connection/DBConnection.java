package com.adharcentre.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdharCentre", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
}
