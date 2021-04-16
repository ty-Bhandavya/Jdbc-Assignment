package com.tyss.jdbc.DynamicProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicSelect {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			String query ="select * from employee where eid=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("salary"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getInt("phoneno"));
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
