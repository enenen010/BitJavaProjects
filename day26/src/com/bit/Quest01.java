package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Quest01 {
	
	
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String url="";
	Map<String, String> env = System.getenv();
	url = "jdbc:mysql://localhost:3306/lecture01";
	Properties info = new Properties();
	info.setProperty("user", env.get("local.mysql.user"));
	info.setProperty("password", env.get("local.mysql.password"));
	String sql="";
	
	while(true) {
		System.out.println("1.emp, 2.dept, 0.종료");
		System.out.print(">");
		int input=Integer.parseInt(sc.nextLine());
		
		String table=null;
		if(input==0) break;
		else if(input==1) table="emp";
		else table="dept";
		
		String query;
		System.out.println("1.list, 2.insert 3.delete 4.update");
		System.out.print(">");
		input=Integer.parseInt(sc.nextLine());
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();

			ArrayList<String[]> cols = new ArrayList<String[]>();
			
			
			sql="SELECT COLUMN_NAME, DATA_TYPE " + 
					"FROM INFORMATION_SCHEMA.COLUMNS " + 
					"WHERE TABLE_NAME = '"+table+"'";
			System.out.println(sql);
			rs =  stmt.executeQuery(sql);
			if(rs.next()) {
				String[] temp={rs.getString(1),rs.getString(2)};
				cols.add(temp);
			}
			
			
			if(input==1) {
				query="select * from "+table;
			}
			else if(input==2) {
				query="insert into "+table+"(";
				for (int i = 0; i < cols.size(); i++) {
					if(cols.get(i)[1].equals("varchar")) {
						query+="'"+cols.get(i)[0]+"'";
					}
					else if(cols.get(i)[1].equals("int")) {
						query+=cols.get(i)[0];
					}
					else if(cols.get(i)[1].equals("date")) {
						query+="now()";
					}
					if(i != cols.size()-1) {
						query+=",";
					}
				}
				query+=" ) values ( ";
				for (int i = 0; i < cols.size(); i++) {
					String value="";
					if(cols.get(i)[1].equals("int")) {
						System.out.print(cols.get(i)[0]+">");
						value = sc.nextLine();
					}
					
					if(cols.get(i)[1].equals("varchar")) {
						query+="'"+value+"'";
					}
					else if(cols.get(i)[1].equals("int")) {
						query+=value;
					}
					else if(cols.get(i)[1].equals("date")) {
						query+="now()";
					}
					if(i != cols.size()-1) {
						query+=",";
					}
				}
				query+=")";
				System.out.println(query);
			}
			else if(input==3) query="delete from "+table+" ";
			else if(input==4) query="update "+table+" ";
			else {
				System.out.println("잘못된 입력");
				continue;
			}
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println(e.toString()+"문법 오류 또는 실행오류");
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
}
