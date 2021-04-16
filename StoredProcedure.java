package com.tyss.jdbc.DynamicProgram;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StoredProcedure {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS?user=root&password=root");

cstmt = con.prepareCall("call Emp()");
		
			
			 rs = cstmt.executeQuery();
			while(rs.next()) {
				System.out.println("Eid:"+rs.getInt("eid"));
				System.out.println("EName:"+rs.getString("ename"));
				System.out.println("ESalary:"+rs.getInt("salary"));
				System.out.println("EDept:"+rs.getString("dept"));
				System.out.println("EPhoneno:"+rs.getInt("phoneno"));
				System.out.println("--------------------");
				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (cstmt != null)
				cstmt.close();
			if(rs!=null)
				rs.close();

		}
	}

}
