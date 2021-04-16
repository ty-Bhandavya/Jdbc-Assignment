package com.tyss.jdbc.DynamicProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDelect {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			pstmt = con.prepareStatement("delete from employee where eid =?");
			pstmt.setInt(1,60);
			int count = pstmt.executeUpdate();
			System.out.println("Number of row delected:"+count);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
