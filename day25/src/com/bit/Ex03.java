package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
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
			
			
			String num;
			
			while(true) {
				System.out.print(">");
				num=sc.nextLine();
				sql="select EMPNO,ENAME,SAL from emp where EMPNO="+num;
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.print(rs.getObject(1)+"\t");
					System.out.print(rs.getObject(2)+"\t");
					System.out.println(rs.getObject(3));
				}
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
