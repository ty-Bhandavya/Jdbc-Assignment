package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticDelect {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("driver load succefully");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			String query = "delete from employee where eid =50";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			System.out.println("Number of row delected:"+count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
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
