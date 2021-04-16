package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");
			String query = "update employee set ename=? where eid=?";
			pstmt = con.prepareStatement(query);
			//Binding the Parameters
			pstmt.setString(1, "Nishu");
			pstmt.setInt(2, 10);
			
			int count =pstmt.executeUpdate();
			System.out.println("Update sucessfully!");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}finally {
			if(con!=null)
				con.close();
			if(pstmt!=null)
				pstmt.close();
		}

	}

}
