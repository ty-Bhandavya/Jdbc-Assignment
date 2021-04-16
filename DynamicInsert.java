package com.tyss.jdbc.DynamicProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicInsert {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			String query = "insert into employee values(?,?,?,?,?)";

			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, args[3]);
			pstmt.setInt(5, Integer.parseInt(args[4]));
			int rs = pstmt.executeUpdate();
			
			if(rs!=0)
			{
				System.out.println("Employee Record Inserted");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
