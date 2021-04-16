package com.tyss.jdbc.staticinsert;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SelectProperties {

	public static void main(String[] args) throws  SQLException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			FileReader reader = new FileReader("C:\\FileHandling\\MyProp.properties");
			Properties prop= new Properties();
			prop.load(reader);
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = prop.getProperty("dburl");
			con = DriverManager.getConnection(dburl, prop);
			String query ="select * from employee";
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("salary"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getInt("phoneno"));
				System.out.println("--------------------");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
