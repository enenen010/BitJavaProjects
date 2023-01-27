package com.bit;

import java.util.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

class Element{
	Object value;
	String type;
	String name;
	
	public Element(Object value,String type,String name) {
		this.value = value;
		this.type = type;
		this.name = name;
	}
}

class MongoWork {
	String addr="127.0.0.1";
	MongoClient client = null;
	long docCount;
	
	public List<Object[]> find(String[] cols) {
		List<Object[]> list = new ArrayList<Object[]>();
		MongoClient client=null;
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("test01");
			MongoCollection<Document> coll = db.getCollection("stuList");
			MongoCursor<Document> cur = coll.find().iterator();
			while(cur.hasNext()) {
				Document doc = cur.next();

				Object[] temp = new Object[cols.length];
				for (int i = 0; i < cols.length; i++) {
					temp[i] = doc.get(cols[i]);
				}
				list.add(temp);
			}
			docCount=list.size();
		}catch(Exception e) {
			System.out.println(e.toString()+" 오류");
			System.out.println("관리자에게 문의하세요");
		}finally {
			if(client!=null)client.close();
		}
		return list;
	}
	
	public Object[] findOne(String[] cols, Document dOption) {
		Object[] temp=null;
		MongoClient client=null;
		try {
			client = new MongoClient(addr);
			MongoDatabase db = client.getDatabase("test01");
			MongoCollection<Document> coll = db.getCollection("stuList");
			MongoCursor<Document> cur = coll.find(dOption).iterator();
			if(cur.hasNext()) {
				docCount=1;
				Document doc = cur.next();
				
				temp = new Object[cols.length];
				for (int i = 0; i < cols.length; i++) {
					temp[i] = doc.get(cols[i]);
				}
			}
			if(temp==null) docCount=0;
		}catch(Exception e) {
			System.out.println(e.toString()+" 오류");
			System.out.println("관리자에게 문의하세요");
		}finally {
			if(client!=null)client.close();
		}
		return temp;
	}
	
	public void insertOne(Element[] element) {
		MongoClient client=null;
		try {
			client = new MongoClient("127.0.0.1");
			MongoDatabase db = client.getDatabase("test01");
			MongoCollection<Document> coll = db.getCollection("stuList");
			Document doc = new Document();
			for (int i = 0; i < element.length; i++) {
				if(element[i].type.equals("int"))doc.append(element[i].name, (int)element[i].value);
				else if(element[i].type.equals("String"))doc.append(element[i].name, (String)element[i].value);
			}
			coll.insertOne(doc);
			
		}catch(Exception e) {
			System.out.println(e.toString()+" 오류");
			System.out.println("관리자에게 문의하세요");
		}finally {
			if(client!=null)client.close();
		}
	}
	
	public void UpdateOne(Element[] conElements, Element[] setElements) {
		MongoClient client=null;
		try {
			client = new MongoClient("127.0.0.1");
			MongoDatabase db = client.getDatabase("test01");
			MongoCollection<Document> coll = db.getCollection("stuList");
			
			Document doc1 = new Document();
			for (int i = 0; i < conElements.length; i++) {
				if(conElements[i].type.equals("int"))doc1.append(conElements[i].name, (int)conElements[i].value);
				else if(conElements[i].type.equals("String"))doc1.append(conElements[i].name, (String)conElements[i].value);
			}
			
			Document doc2 = new Document();
			for (int i = 0; i < setElements.length; i++) {
				if(setElements[i].type.equals("int"))doc2.append(setElements[i].name, (int)setElements[i].value);
				else if(setElements[i].type.equals("String"))doc2.append(setElements[i].name, (String)setElements[i].value);
			}
			
			
			coll.updateOne(doc1, new Document("$set",doc2));
			
		}catch(Exception e) {
			System.out.println(e.toString()+" 오류");
			System.out.println("관리자에게 문의하세요");
		}finally {
			if(client!=null)client.close();
		}
	}
	
	public void DeleteOne(Element[] conElements) {
		MongoClient client=null;
		try {
			client = new MongoClient("127.0.0.1");
			MongoDatabase db = client.getDatabase("test01");
			MongoCollection<Document> coll = db.getCollection("stuList");
			
			Document doc = new Document();
			for (int i = 0; i < conElements.length; i++) {
				if(conElements[i].type.equals("int"))doc.append(conElements[i].name, (int)conElements[i].value);
				else if(conElements[i].type.equals("String"))doc.append(conElements[i].name, (String)conElements[i].value);
			}

			coll.deleteOne(doc);
			
		}catch(Exception e) {
			System.out.println(e.toString()+" 오류");
			System.out.println("관리자에게 문의하세요");
		}finally {
			if(client!=null)client.close();
		}
	}
}


public class MongoDB06 {
	
	public static void main(String[] args) {

		String input = null;
		Scanner sc = new Scanner(System.in);
		MongoWork mongoWork = mongoWork = new MongoWork();
		
		String[] colunm = { "학번", "이름" ,"국어", "영어", "수학" };
		System.out.println("학생성적관리프로그램(ver 0.6.0)");
		while (true) {

			sc = new Scanner(System.in);
			System.out.print("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료> ");
			input = sc.nextLine();

			if (input.equals("0")) {
				System.out.println("이용에 감사드립니다.");
				break;
			}
			else if (input.equals("1")) {// 리스트
				List<Object[]> list=null;
				String[] cols= {"num", "kor", "enu", "meth"};
				 list = mongoWork.find(cols);
				
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
				String[] cols= {"num", "name" ,"kor", "enu", "meth"};
				row = mongoWork.findOne(cols, new Document("num",num));
				
				if(row!=null) {
					cols = new String[]{"kor", "enu", "meth"};
					List<Object[]> list = mongoWork.find(cols);
					int sum=0;
					for (int i = 0; i < list.size(); i++) {
						sum+=(int)list.get(i)[0]+(int)list.get(i)[1]+(int)list.get(i)[2];
					}
					
					System.out.println("===============================");
					System.out.println(colunm[0]+": "+row[0]+", \t"+colunm[1]+": "+row[1]);
					System.out.println("===============================");
					System.out.println(colunm[2]+": "+row[2]);
					System.out.println(colunm[3]+": "+row[3]);
					System.out.println(colunm[4]+": "+row[4]);
					System.out.println("===============================");
					int kor1 = (int)row[2];
					int enu1 = (int)row[3];
					int meth1 = (int)row[4];
					int jum = ((kor1+enu1+meth1)/3/10);
					char rank;
					switch(jum) {
					case 10: case 9:
						rank='A';
						break;
					case 8:
						rank='B';
						break;
					case 7:
						rank='C';
						break;
					case 6:
						rank='D';
						break;
					default:
						rank='F';
						break;
						
					}
					
					System.out.println("평균/전체평균: "+((kor1+enu1+meth1)*100/3/100.0)+"/"+(sum*100/3/list.size()/100.0)+"\t학점: "+rank);
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
				String[] cols= {"num"};
				mongoWork.findOne(cols, new Document("num",num));
				cnt=mongoWork.docCount;
				
				//학번이 없으면
				if(cnt==0) {
					Element[] elements = {
							new Element(num, "int", "num"),
							new Element(name, "String", "name"),
							new Element(kor, "int", "kor"),
							new Element(enu, "int", "enu"),
							new Element(meth, "int", "meth")
							};
					mongoWork.insertOne(elements);
					
				}else {
					System.out.println("이미 있는 학번입니다.");
					continue;
				}
			} else if (input.equals("4")) {// 수정
				System.out.print("학번> ");
				int num = Integer.parseInt(sc.nextLine());
				
				//학번 중복 검사
				Object[] row = null;
				String[] cols= {"num", "name" ,"kor", "enu", "meth"};
				row = mongoWork.findOne(cols, new Document("num",num));
				
				if(row!=null) {//학번이 있으면
					
					//수정할 doc 정보 출력
					System.out.println("===============================");
					System.out.println(colunm[0]+": "+row[0]+",\t"+colunm[1]+": "+row[1]);
					System.out.println(colunm[2]+": "+row[2]);
					System.out.println(colunm[3]+": "+row[3]);
					System.out.println(colunm[4]+": "+row[4]);
					System.out.println("===============================");
					System.out.println();
					
					
					while(true) {//원하는 만큼 해당 항목을 수정
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
						
						Element temp=null;
						cols= new String[]{"num", "name" ,"kor", "enu", "meth"};
						//성적이면 점수 조건
						if(idx==1) {
							temp = new Element(sc.nextLine(), "String", "name");
						}else {
							temp = new Element(Integer.parseInt(sc.nextLine()), "int", cols[idx]);
							
							int score = (int)temp.value;
							if(0 > score || score>100) {
								System.out.println("성적은 0이상 100이하의 숫자여야 합니다");
								continue;
							}
						}
						row[idx] = temp.value;
					}
					
					//만들어진 결과 row를 통한 update
					Element[] elements = {
							new Element(row[0], "int", "num"),
							new Element(row[1], "String", "name"),
							new Element(row[2], "int", "kor"),
							new Element(row[3], "int", "enu"),
							new Element(row[4], "int", "meth")
							};
					mongoWork.UpdateOne(new Element[]{new Element(row[0], "int", "num")} ,elements);
					
				}else {
					System.out.println("없는 학번입니다.");
					continue;
				}
				
			} else if (input.equals("5")) {// 삭제
				System.out.print("학번> ");
				int num = Integer.parseInt(sc.nextLine());
				
				//학번 중복 검사
				Object[] row = null;
				String[] cols= {"num", "name" ,"kor", "enu", "meth"};
				row = mongoWork.findOne(cols, new Document("num",num));
				
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
				
					if(input.equals("y")) {//y면 삭제진행
						mongoWork.DeleteOne(new Element[]{new Element(row[0], "int", "num")});
						
						System.out.println("삭제 되었습니다");
					}else {
						System.out.println("삭제 취소");
					}
				
				}else {
					System.out.println("없는 학번입니다.");
					continue;
				}
			} else {
				System.out.println("없는 메뉴입니다");
			}
		}
	}
}