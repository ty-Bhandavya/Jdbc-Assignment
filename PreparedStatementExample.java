package com.tyss.jdbc.staticinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "root");
			
			String query = "select * from employee where eid=?";

			pstmt = con.prepareStatement(query);
			String eid = args[0];
			int employeeid = Integer.parseInt(eid);

			pstmt.setInt(1, employeeid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int empid = rs.getInt("eid");
				String empname = rs.getString("ename");
				int empsalary = rs.getInt("salary");
				String empdept = rs.getString("dept");
				int empphoneno = rs.getInt("phoneno");
				
				System.out.println("Employee ID:"+empid);
				System.out.println("Employee Name:"+empname);
				System.out.println("Employee Salary"+empsalary);
				System.out.println("Employee Dept:"+empdept);
				System.out.println("Employee phoneno:"+empphoneno);
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				
					con.close();
				
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		}

	}
}
