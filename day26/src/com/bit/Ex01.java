package com.bit;

import java.sql.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Ex01 {

	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		System.out.println(env.get("PATH"));
//		System.out.println(env.get("local.mysql.user"));
//		System.out.println(env.get("local.mysql.password"));
		Set<String> keys = env.keySet();
		Iterator<String> ite = keys.iterator();
		
//		while(ite.hasNext()) {
//			System.out.println(ite.next());
//		}

		String sql = "select empno, ename, hiredate, ";
		sql+="sal+ifnull(comm, 0) as money ";
		sql+="from emp;";
		String url = "jdbc:mysql://localhost:3306/lecture01";
		Properties info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			Driver driver = new com.mysql.jdbc.Driver();
//			new com.mysql.jdbc.Driver();
			
			//참조변수가 필요없기 때문에 과정을 최소화
			Class.forName("com.mysql.cj.jdbc.Driver");//다형성: 어떤드라이버를 사용할지 DriverManager에 알림
			conn = DriverManager.getConnection(url, info);//가장 마지막에 선언된 드라이버
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			
			System.out.println("사번\t이름\t입사일\t\t연봉");
			while(rs.next()) {
				for (int i = 1; i <= 4; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
//			while(rs.next()) {
//				System.out.print(rs.getString(1)+"\t");
//				System.out.print(rs.getString(2)+"\t");
//				System.out.print(rs.getString(3)+"\t");
//				System.out.print(rs.getString(4)+"\n");
//			}
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
