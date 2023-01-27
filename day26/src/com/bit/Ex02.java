package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Ex02 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String url="";
	Map<String, String> env = System.getenv();
	url = "jdbc:mysql://localhost:3306/lecture";
	Properties info = new Properties();
	info.setProperty("user", env.get("local.mysql.user"));
	info.setProperty("password", env.get("local.mysql.password"));
	
	System.out.print("사번>");
	int num=Integer.parseInt(sc.nextLine());
	System.out.print("이름>");
	String name=sc.nextLine();
	System.out.print("금액>");
	int money=Integer.parseInt(sc.nextLine());
	System.out.print("커미션>");
	int comm=Integer.parseInt(sc.nextLine());
	String sql="insert into emp (empno,ename,hiredate,sal,comm)";
	sql+="values ("+num+","+","+name+",now(),"+money+","+comm+")";
	
	System.out.println(sql);
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, info);
		stmt = conn.createStatement();
		rs =  stmt.executeQuery(sql);
		System.out.println();
	} catch (SQLException e) {
		System.out.println("문법 오류 또는 실행오류");
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 로딩 확인");
		System.out.println("드라이버 등록이 잘못되었습니다.");
	} finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
