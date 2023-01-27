package com.bit;

import java.util.*;

import org.bson.Document;

import java.io.*;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MysqlWork {
	Map<String, String> env = System.getenv();

	String url = "jdbc:mysql://localhost:3306/lecture01";
	
	Properties info = null;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	long rowCount;
	
	public MysqlWork() {
		info = new Properties();
		info.setProperty("user", env.get("local.mysql.user"));
		info.setProperty("password", env.get("local.mysql.password"));
	}
	
	//다수의 값을 List로 반환받는 메서드 
	public List<Object[]> executeQuery(String sql, int colSize) {
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			
			while(rs.next()) {
				Object[] temp = new Object[colSize];
				for (int i = 0; i < colSize; i++) {
					temp[i] = rs.getObject(i+1);
				}
				list.add(temp);
			}
			rowCount=list.size();
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
		return list;
	}
	
	//하나의 값을 List로 반환받는 메서드 
	public Object[] executeQueryOne(String sql, int colSize) {
		Object[] temp = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			
			if(rs.next()) {
				rowCount=1;
				temp = new Object[colSize];
				for (int i = 0; i < colSize; i++) {
					temp[i] = rs.getObject(i+1);
				}
			}
			if(temp==null) rowCount=0;
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
		return temp;
	}
	
	//입력, 수정, 삭제 등에 사용하는 메서드
	public void executeUpdate(String sql) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, info);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
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


public class Mysql06 {
	
	public static void main(String[] args) {

		String input = null;
		Scanner sc = new Scanner(System.in);
		MysqlWork mysqlWork = new MysqlWork();
		
		String[] colunm = { "학번", "이름" ,"국어", "영어", "수학" };
		System.out.println("학생성적관리프로그램(ver 0.7.0)");
		while (true) {

			sc = new Scanner(System.in);
			System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료> ");
			input = sc.nextLine();

			if (input.equals("0")) {
				System.out.println("이용에 감사드립니다.");
				break;
			} else if (input.equals("1")) {// 리스트
				List<Object[]> list=null;
				String sql="select num, kor, enu, meth "
						+"from stuList ";
				list = mysqlWork.executeQuery(sql, 4);
				
				if(list!=null) {
					System.out.println("학번\t국어\t영어\t수학");
					System.out.println("===================================");
					for (int i = 0; i < list.size(); i++) {
						System.out.println(
								list.get(i)[0]+"\t"
								+list.get(i)[1]+"\t"
								+list.get(i)[2]+"\t"
								+list.get(i)[3]+"\t"
								);
					}
					System.out.println("===================================\n");
				}else {
					System.out.println("검색 결과가 없습니다.");
				}
			} else if (input.equals("2")) {// 상세보기
				System.out.print("학번> ");
				int num = Integer.parseInt(sc.nextLine());
				
				//학번 중복 검사
				Object[] row = null;
				String sql = "select num, name, kor, enu, meth from stuList where num="+num;
				row = mysqlWork.executeQueryOne(sql, 5);
				
				if(row!=null) {
					
					sql = "SELECT A, B, " + 
							"CASE " + 
							"	WHEN A > 90 THEN 'A' " + 
							"	WHEN A > 80 THEN 'B' " + 
							"	WHEN A > 70 THEN 'C' " + 
							"	WHEN A > 60 THEN 'D' " + 
							"	ELSE 'F' " + 
							"END " + 
							"FROM (SELECT  " + 
							"(SELECT TRUNCATE((kor + enu + meth)/3,2) FROM stulist WHERE num = "+num+" ) A " + 
							",TRUNCATE((AVG(kor) + AVG(enu) + AVG(meth))/3,2) B " + 
							"FROM stulist) A1";
					Object[] row2 = null;
					row2 = mysqlWork.executeQueryOne(sql, 3);
					
					System.out.println("===============================");
					System.out.println(colunm[0]+": "+row[0]+", \t"+colunm[1]+": "+row[1]);
					System.out.println("===============================");
					System.out.println(colunm[2]+": "+row[2]);
					System.out.println(colunm[3]+": "+row[3]);
					System.out.println(colunm[4]+": "+row[4]);
					System.out.println("===============================");
					System.out.println("평균/전체평균: "+row2[0]+"/"+row2[1]+"\t학점: "+row2[2]);
					System.out.println();
				}else {
					System.out.println("없는 학번입니다.");
					continue;
				}
			} else if (input.equals("3")) {// 입력
				int num=0;
				String name=null;
				int kor=0;
				int enu=0;
				int meth=0;
				try {
					System.out.print("학번> ");
					num = Integer.parseInt(sc.nextLine());
					System.out.print("이름> ");
					name = sc.nextLine();
					System.out.print("국어> ");
					kor = Integer.parseInt(sc.nextLine());
					System.out.print("영어> ");
					enu = Integer.parseInt(sc.nextLine());
					System.out.print("수학> ");
					meth = Integer.parseInt(sc.nextLine());
				}catch(Exception e) {
					System.out.println("숫자를 입력하세요");
					continue;
				}
				
				//성적값 검사
				int[] scores = {kor,enu,meth};
				boolean scoreOver=false;
				for (int i= 0; i < scores.length; i++) {
					if(0 > scores[i] || scores[i]>100) scoreOver=true;
				}
				if(scoreOver) {
					System.out.println("성적은 0이상 100이하의 숫자여야 합니다");
					continue;
				}
				
				//학번 중복 검사
				long cnt=1;
				String sql = "select 1 from stuList where num="+num;
				mysqlWork.executeQueryOne(sql, 1);
				cnt=mysqlWork.rowCount;
				
				if(cnt==0) {
					sql="insert into stuList"
							+"(num, name, kor, enu, meth) "
							+"values"
							+"("
							+num+", "
							+"'"+name+"', "
							+kor+", "
							+enu+", "
							+meth
							+")";
					mysqlWork.executeUpdate(sql);
				}else {
					System.out.println("이미 있는 학번입니다.");
					continue;
				}
			} else if (input.equals("4")) {// 수정
				System.out.print("학번> ");
				int num = Integer.parseInt(sc.nextLine());
				
				//학번 중복 검사
				Object[] row = null;
				String sql = "select num, name, kor, enu, meth from stuList where num="+num;
				row = mysqlWork.executeQueryOne(sql, 5);
				
				//대상 정보 확인
				if(row!=null) {
					System.out.println("===============================");
					System.out.println(colunm[0]+": "+row[0]+",\t"+colunm[1]+": "+row[1]);
					System.out.println(colunm[2]+": "+row[2]);
					System.out.println(colunm[3]+": "+row[3]);
					System.out.println(colunm[4]+": "+row[4]);
					System.out.println("===============================");
					System.out.println();
					
					
					while(true) {
						System.out.println("변경할 항목을 선택하세요.");
						for (int i = 1; i < colunm.length; i++) {
							System.out.print(i+"."+colunm[i]+" ");
						}
						System.out.print("0.입력시작 >");
						
						int idx=-1;
						try {
							idx = Integer.parseInt(sc.nextLine());
						}catch(Exception e){
							System.out.println("숫자를 입력해야 합니다");
							continue;
						}
						
						//0을 입력하면 수정을 그만두고 update 진행
						if(idx==0)break;
						
						//0이 아니면 해당 항목의 수정값을 입력
						System.out.print(colunm[idx]+">");
						
						Object temp=null;
						//성적이면 점수 조건
						if(idx==1) {
							temp = sc.nextLine();
						}else {
							temp = Integer.parseInt(sc.nextLine());
							
							int score = (int)temp;
							if(0 > score || score>100) {
								System.out.println("성적은 0이상 100이하의 숫자여야 합니다");
								continue;
							}
						}
						row[idx] = temp;
					}
					
					//쿼리 작성 및 입력
					sql = "update stuList set "
							+"name='"+row[1]+"', "
							+"kor="+row[2]+", "	
							+"enu="+row[3]+", "	
							+"meth="+row[4]
							+" where num="+num;
					mysqlWork.executeUpdate(sql);
					
				}else {
					System.out.println("없는 학번입니다.");
					continue;
				}
				
			} else if (input.equals("5")) {// 삭제
				System.out.print("학번> ");
				int num = Integer.parseInt(sc.nextLine());
				
				//학번 중복 검사
				Object[] row = null;
				String sql = "select num, name, kor, enu, meth from stuList where num="+num;
				row = mysqlWork.executeQueryOne(sql, 5);
				
				//대상 정보 확인
				if(row!=null) {
				System.out.println("===============================");
				System.out.println(colunm[0]+": "+row[0]+",\t"+colunm[1]+": "+row[1]);
				System.out.println(colunm[2]+": "+row[2]);
				System.out.println(colunm[3]+": "+row[3]);
				System.out.println(colunm[4]+": "+row[4]);
				System.out.println("===============================");
				System.out.println();
					
				System.out.print("삭제하시겠습니까? [y/다른키] >");
				input = sc.nextLine();
				
					if(input.equals("y")) {
						//쿼리 작성 및 입력
						sql = "delete from stuList"
							+" where num="+num;
						mysqlWork.executeUpdate(sql);
					System.out.println("삭제 되었습니다");
					}else {
						System.out.println("삭제 취소");
					}
				
				}else {
					System.out.println("없는 학번입니다.");
					continue;
				}
				
			}  else {
				System.out.println("없는 메뉴입니다");
			}
		}
	}
}