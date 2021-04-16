package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {

	public static void main(String[] args) throws SQLException  {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =  null;
		
		try {
			// 1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Get Connection via driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			
			// 3.Issue SQL query via Connection
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employee");
			
			// 4.Process the result
			while(rs.next()) {
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("salary"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getInt("phoneno"));
				System.out.println("--------------------");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5. close all JDBC Object
		finally {
			if(con!=null)
				con.close();
			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
		}

	}

}
