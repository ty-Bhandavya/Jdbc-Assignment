package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticInsert {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		// 1.load the driver
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded sucessfully");

			// 2. Get connection via driver
			String dburl = "jdbc:mysql://localhost:3306/CMS?user=root&password=root"; 
			con = DriverManager.getConnection(dburl);

			// 3.Issuse the sql query via connection
			String query = "insert into employee values(40,'kuldeep',6000,'Salesman',96767)";
			stmt = con.createStatement();
			// 4.process the result
			int count = stmt.executeUpdate(query);
			System.out.println("Number of row affected:" + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.close all jdbc object
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
