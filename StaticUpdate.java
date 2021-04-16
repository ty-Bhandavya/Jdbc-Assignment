package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticUpdate {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("driver load succefully");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");

			String query = "update employee " + "set ename='chaitra'" + "where eid=20";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			System.out.println("Number of rows affected:" + count);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
