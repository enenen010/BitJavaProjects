package com.bit;

import java.sql.*;
import java.util.*;
import com.mysql.jdbc.*;

public class Ex02 {
	public static void main(String[] args) {
		String sql="select * from emp";
		
		Connection conn=null;
		Statement stmt=null;
		Properties props=null;
		ResultSet rs=null;
		props=new java.util.Properties();
		props.setProperty("user", "scott");
		props.setProperty("password", "tiger");
		try {
			com.mysql.jdbc.Driver driver;
			driver=new com.mysql.jdbc.Driver();
			System.out.println(driver);
			
			String url="jdbc:mysql://localhost:3306/lecture01";
			conn=DriverManager.getConnection(url,props);
			
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getObject(1)+"\t");
				System.out.print(rs.getObject(2)+"\t");
				System.out.println(rs.getObject(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

