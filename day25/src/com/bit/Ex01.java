package com.bit;

import java.sql.SQLException;

public class Ex01 {
	public static void main(String[] args) {
		com.mysql.jdbc.Driver driver;
		java.sql.Connection conn=null;
		try {
			driver=new com.mysql.jdbc.Driver();
			System.out.println(driver);
			
//			여기 그냥 적을게 아니라 드라이버 제공자 api 읽어보고 해야함 :  url형식, Properties
//			https://dev.mysql.com/doc/connectors/en/connector-j-reference-jdbc-url-format.html
//			구글검색어 mysql.com api java  패키지명 참조
			String url="jdbc:mysql://localhost:3306/lecture01";
			java.util.Properties props=null;
			props=new java.util.Properties();
			props.setProperty("user", "scott");
			props.setProperty("password", "tiger");
			conn=java.sql.DriverManager.getConnection(url,props);
			
			String sql="insert into dept (deptno, dname, loc) "
					+"values(50,'블루','부산')";
			
			java.sql.Statement stmt=null;
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);//쿼리실행
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
				try {
					if(conn!=null)conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
	}
}
