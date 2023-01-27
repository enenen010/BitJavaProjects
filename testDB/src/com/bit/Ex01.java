//package com.bit;
//
//import java.util.*;
//
//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//class ColElement{
//	Object element;
//	
//	public int getInt() {
//		return (int)element;
//	}
//	public String getString() {
//		return (String)element;
//	}
//	public Date getDate() {
//		return (Date)element;
//	}
//	public int get() {
//		return (int)element;
//	}
//}
//
//class MysqlWork {
//	Map<String, String> env = System.getenv();
//
//	String url = "jdbc:mysql://localhost:3306/lecture01";
//	
//	Properties info = null;
//	
//	Connection conn = null;
//	Statement stmt = null;
//	ResultSet rs = null;
//	
//	long rowCount;
//	
//	public MysqlWork() {
//		info = new Properties();
////		info.setProperty("user", env.get("local.mysql.user"));
////		info.setProperty("password", env.get("local.mysql.password"));
//		info.setProperty("user", "scott");
//		info.setProperty("password", "tiger");
//	}
//	
//	public List<Object[]> executeQuery(String sql, int colSize) {
//		List<Object[]> list = new ArrayList<Object[]>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, info);
//			stmt = conn.createStatement();
//			rs =  stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				Object[] temp = new Object[colSize];
//				for (int i = 0; i < colSize; i++) {
//					temp[i] = rs.getObject(i+1);
//				}
//				list.add(temp);
//			}
//			rowCount=list.size();
//		} catch (SQLException e) {
//			System.out.println(e.toString()+"문법 오류 또는 실행오류");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 확인");
//			System.out.println("드라이버 등록이 잘못되었습니다.");
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(conn!=null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
//	
//	public Object[] executeQueryOne(String sql, int colSize) {
//		Object[] temp = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, info);
//			stmt = conn.createStatement();
//			rs =  stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				rowCount=1;
//				temp = new Object[colSize];
//				for (int i = 0; i < colSize; i++) {
//					temp[i] = rs.getObject(i+1);
//				}
//			}
//			if(temp==null) rowCount=0;
//		} catch (SQLException e) {
//			System.out.println("문법 오류 또는 실행오류");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 확인");
//			System.out.println("드라이버 등록이 잘못되었습니다.");
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(conn!=null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return temp;
//	}
//	
//	public void executeUpdate(String sql) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection(url, info);
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			
//		} catch (SQLException e) {
//			System.out.println("문법 오류 또는 실행오류");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 확인");
//			System.out.println("드라이버 등록이 잘못되었습니다.");
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(conn!=null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
//
//class MongoWork {
//	String addr="127.0.0.1";
//	MongoClient client = null;
//	long docCount;
//	
//	public List<Object[]> find(String[] cols) {
//		List<Object[]> list = new ArrayList<Object[]>();
//		MongoClient client=null;
//		try {
//			client = new MongoClient(addr);
//			MongoDatabase db = client.getDatabase("test01");
//			MongoCollection<Document> coll = db.getCollection("stuList");
//			MongoCursor<Document> cur = coll.find().iterator();
//			while(cur.hasNext()) {
//				Document doc = cur.next();
//
//				Object[] temp = new Object[cols.length];
//				for (int i = 0; i < cols.length; i++) {
//					temp[i] = doc.get(cols[i]);
//				}
//				list.add(temp);
//			}
//			docCount=list.size();
//		}catch(Exception e) {
//			System.out.println(e.toString()+" 오류");
//			System.out.println("관리자에게 문의하세요");
//		}finally {
//			if(client!=null)client.close();
//		}
//		return list;
//	}
//	
//	public Object[] findOne(String[] cols, Document dOption) {
//		Object[] temp=null;
//		MongoClient client=null;
//		try {
//			client = new MongoClient(addr);
//			MongoDatabase db = client.getDatabase("test01");
//			MongoCollection<Document> coll = db.getCollection("stuList");
//			MongoCursor<Document> cur = coll.find(dOption).iterator();
//			if(cur.hasNext()) {
//				docCount=1;
//				Document doc = cur.next();
//				
//				temp = new Object[cols.length];
//				for (int i = 0; i < cols.length; i++) {
//					temp[i] = doc.get(cols[i]);
//				}
//			}
//			if(temp==null) docCount=0;
//		}catch(Exception e) {
//			System.out.println(e.toString()+" 오류");
//			System.out.println("관리자에게 문의하세요");
//		}finally {
//			if(client!=null)client.close();
//		}
//		return temp;
//	}
//	
//	public void insertOne(String[] cols, Object[] values) {
//		MongoClient client=null;
//		try {
//			client = new MongoClient("127.0.0.1");
//			MongoDatabase db = client.getDatabase("test01");
//			MongoCollection<Document> coll = db.getCollection("stuList");
//			Document doc = new Document();
//			for (int i = 0; i < cols.length; i++) {
//				doc.append(cols[i], values[i]);
//			}
//			coll.insertOne(doc);
//			
//		}catch(Exception e) {
//			System.out.println(e.toString()+" 오류");
//			System.out.println("관리자에게 문의하세요");
//		}finally {
//			if(client!=null)client.close();
//		}
//	}
//	
//	public void UpdateOne(String[] cols, Object[] values) {
//		MongoClient client=null;
//		try {
//			client = new MongoClient("127.0.0.1");
//			MongoDatabase db = client.getDatabase("test01");
//			MongoCollection<Document> coll = db.getCollection("stuList");
//			Document doc = new Document();
//			for (int i = 0; i < cols.length; i++) {
//				doc.append(cols[i], values[i]);
//			}
//			
//			
//			coll.updateOne(new Document("num", values[0]), new Document("$set",doc));
//			
//		}catch(Exception e) {
//			System.out.println(e.toString()+" 오류");
//			System.out.println("관리자에게 문의하세요");
//		}finally {
//			if(client!=null)client.close();
//		}
//	}
//}
//
//
//public class Ex01 {
//	
//	public static void main(String[] args) {
//
//		String input = null;
//		Scanner sc = new Scanner(System.in);
//		MysqlWork mysqlWork = null;
//		MongoWork mongoWork = null;
//		
//		System.out.print("사용할 DB를 결정해주세요. 1.mysql, 2.mongoDB>");
//		input = sc.nextLine();
//		if (input.equals("1")) {
//			mysqlWork=new MysqlWork();
//		} else if (input.equals("2")) {
//			mongoWork = new MongoWork();
//		} else {
//			System.out.println("잘못된 입력입니다 ");
//			return;
//		}
//
//		String[] colunm = { "학번", "이름" ,"국어", "영어", "수학" };
//		System.out.println("학생성적관리프로그램(ver 0.6.0)");
//		while (true) {
//
//			sc = new Scanner(System.in);
//			System.out.print("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> ");
//			input = sc.nextLine();
//
//			if (input.equals("0")) {
//				System.out.println("이용에 감사드립니다.");
//				break;
//			} else if (input.equals("1")) {// 리스트
//				List<Object[]> list=null;
//				if(mysqlWork!=null) {
//					String sql="select num, kor, enu, meth "
//							+"from stuList ";
//					list = mysqlWork.executeQuery(sql, 4);
//				}else {
//					 String[] cols= {"num", "kor", "enu", "meth"};
//					 list = mongoWork.find(cols);
//				}
//				
//				if(list!=null) {
//					System.out.println("학번\t국어\t영어\t수학");
//					System.out.println("===================================");
//					for (int i = 0; i < list.size(); i++) {
//						System.out.println(
//								list.get(i)[0]+"\t"
//								+list.get(i)[1]+"\t"
//								+list.get(i)[2]+"\t"
//								+list.get(i)[3]+"\t"
//								);
//					}
//					System.out.println("===================================\n");
//				}else {
//					System.out.println("검색 결과가 없습니다.");
//				}
//			} else if (input.equals("2")) {// 입력
//				System.out.print("학번> ");
//				int num = Integer.parseInt(sc.nextLine());
//				System.out.print("이름> ");
//				String name = sc.nextLine();
//				System.out.print("국어> ");
//				int kor = Integer.parseInt(sc.nextLine());
//				System.out.print("영어> ");
//				int enu = Integer.parseInt(sc.nextLine());
//				System.out.print("수학> ");
//				int meth = Integer.parseInt(sc.nextLine());
//				
//				//성적값 검사
//				int[] scores = {kor,enu,meth};
//				boolean scoreOver=false;
//				for (int i= 0; i < scores.length; i++) {
//					if(0 > scores[i] || scores[i]>100) scoreOver=true;
//				}
//				if(scoreOver) {
//					System.out.println("성적은 0이상 100이하의 숫자여야 합니다");
//					continue;
//				}
//				
//				//학번 중복 검사
//				long cnt=1;
//				if(mysqlWork!=null) {
//					String sql = "select 1 from stuList where num="+num;
//					mysqlWork.executeQueryOne(sql, 1);
//					cnt=mysqlWork.rowCount;
//					System.out.println(mysqlWork.rowCount);
//				}else {
//					String[] cols= {"num"};
//					mongoWork.findOne(cols, new Document("num",num));
//					cnt=mongoWork.docCount;
//				}
//				
//				if(cnt==0) {
//					if(mysqlWork!=null) {
//						String sql="insert into stuList"
//								+"(num, name, kor, enu, meth) "
//								+"values"
//								+"("
//								+num+", "
//								+"'"+name+"', "
//								+kor+", "
//								+enu+", "
//								+meth
//								+")";
//						mysqlWork.executeUpdate(sql);
//					}else {
//						String[] cols= {"num", "name" ,"kor", "enu", "meth"};
//						Object[] values = {num,name,kor,enu,meth};
//						mongoWork.insertOne(cols, values);
//					}
//				}else {
//					System.out.println("이미 있는 학번입니다.");
//					continue;
//				}
//			} else if (input.equals("3")) {// 수정
//				System.out.print("학번> ");
//				int num = Integer.parseInt(sc.nextLine());
//				
//				//학번 중복 검사
//				Object[] row = null;
//				if(mysqlWork!=null) {
//					String sql = "select num, name, kor, enu, meth from stuList where num="+num;
//					row = mysqlWork.executeQueryOne(sql, 5);
//				}else {
//					String[] cols= {"num", "name" ,"kor", "enu", "meth"};
//					row = mongoWork.findOne(cols, new Document("num",num));
//				}
//				
//				if(row!=null) {
//					System.out.println("===============================");
//					System.out.println(colunm[0]+": "+row[0]+",\t"+colunm[1]+": "+row[1]);
//					System.out.println(colunm[2]+": "+row[2]);
//					System.out.println(colunm[3]+": "+row[3]);
//					System.out.println(colunm[4]+": "+row[4]);
//					System.out.println("===============================");
//					System.out.println();
//					
//					
//					while(true) {
//						System.out.println("변경할 항목을 선택하세요.");
//						for (int i = 1; i < colunm.length; i++) {
//							System.out.print(i+"."+colunm[i]+" ");
//						}
//						System.out.print("0.입력시작 >");
//						
//						int idx=-1;
//						try {
//							idx = Integer.parseInt(sc.nextLine());
//						}catch(Exception e){
//							System.out.println("숫자를 입력해야 합니다");
//							continue;
//						}
//						
//						if(idx==0)break;
//						
//						System.out.print(colunm[idx]+">");
//						if(idx==1) {
//							row[idx] = sc.nextLine();
//						}else {
//							row[idx] = Integer.parseInt(sc.nextLine());
//						}
//					}
//					
//					if(mysqlWork!=null) {
//						String sql = "update stuList set "
//							+"name='"+row[1]+"', "
//							+"kor="+row[2]+", "	
//							+"enu="+row[3]+", "	
//							+"meth="+row[4]
//							+" where num="+num;
//						mysqlWork.executeUpdate(sql);
//					}else {
//						String[] cols= {"num", "name" ,"kor", "enu", "meth"};
//						mongoWork.UpdateOne(cols, row);
//					}
//					
//				}else {
//					System.out.println("없는 학번입니다.");
//					continue;
//				}
//				
//			} else if (input.equals("4")) {// 삭제
//				if(mysqlWork!=null) {
//					
//				}else {
//					
//				}
//			} else if (input.equals("5")) {// 상세보기
//				System.out.print("학번> ");
//				int num = Integer.parseInt(sc.nextLine());
//				
//				//학번 중복 검사
//				Object[] row = null;
//				if(mysqlWork!=null) {
//					String sql = "select num, name, kor, enu, meth from stuList where num="+num;
//					row = mysqlWork.executeQueryOne(sql, 5);
//				}else {
//					String[] cols= {"num", "name" ,"kor", "enu", "meth"};
//					row = mongoWork.findOne(cols, new Document("num",num));
//				}
//				
//				if(row!=null) {
//					String name = (String)row[1];
//					int kor = (int)row[1];
//					int enu = (int)row[1];
//					int meth = (int)row[1];
//					System.out.println();
//					
//				}else {
//					System.out.println("없는 학번입니다.");
//					continue;
//				}
//			} else {
//				System.out.println("없는 메뉴입니다");
//			}
//		}
//	}
//}