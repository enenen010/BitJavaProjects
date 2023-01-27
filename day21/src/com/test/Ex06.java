package com.test;

import java.util.*;
import java.io.*;

public class Ex06 {
	static Map<Integer,int[]> stuMap=new TreeMap<Integer, int[]>();
	static File f=new File("ex06.bin");
	
	public static int overRange(int num) {
		if(0<=num&&num<=100) {
			return num;
		}
		return -1;
	}
	
	public static void FileWrite() {
		OutputStream os = null;
		ObjectOutputStream oos=null;
		
		try {
			os=new FileOutputStream(f);
			oos=new ObjectOutputStream(os);
			
			oos.writeObject(stuMap);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(oos!=null)oos.close();
					if(os!=null)os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	public static void FileRead() {
		InputStream is = null;
		ObjectInputStream ois=null;
		
		try {
			is=new FileInputStream(f);
			ois=new ObjectInputStream(is);
			
			stuMap=(TreeMap<Integer, int[]>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if(ois!=null)ois.close();
					if(is!=null)is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
public static void main(String[] args) {
	
	if(!f.exists()) {
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
		
	
	String[] colunm = {"학번","국어","영어","수학"};
	 System.out.println("학생성적관리프로그램(ver 0.5.0)");
	 while(true) {
		 
		 
		 if(f.length()!=0) {
			 FileRead();//파일 불러오기 
		 }
		 int input=-1;
		 Scanner sc = new Scanner(System.in);
		 System.out.print("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> ");
		 try {
			 input=sc.nextInt();
		 }catch(InputMismatchException e) {
			 System.out.println("숫자를 입력하세요");
			 sc=new Scanner(System.in);
		 }
		 
		 if(input==0) {
			 System.out.println("이용에 감사드립니다.");
			 break;
		 }else if(input==1) {//리스트
			 System.out.println("학번\t국어\t영어\t수학");
			 System.out.println("===================================");
			 Iterator ite=stuMap.keySet().iterator();
			 while(ite.hasNext()) {
				 int key=(int)ite.next();
				 System.out.println(
						 key+"\t"
						 +stuMap.get(key)[0]+"\t"
						 +stuMap.get(key)[1]+"\t"
						 +stuMap.get(key)[2]+"\t");
			 }
			 System.out.println("===================================");
		 }else if(input==2) {//입력
			 
			 System.out.print("학번>");
			 int id=sc.nextInt();
			 if(stuMap.containsKey(id)) {
				 System.out.println("중복된 학번입니다.");
				 continue;
			 }else {
				 System.out.print("국어>");
				 int kor=overRange(sc.nextInt());
				 System.out.print("영어>");
				 int eng=overRange(sc.nextInt());
				 System.out.print("수학>");
				 int meth=overRange(sc.nextInt());
				 if(kor==-1||eng==-1||meth==-1) {
					 System.out.println("점수는 0이상 100이하의 값을 입력입니다.");
					 continue;
				 }
				 int[] row= {kor,eng,meth}; 
				 stuMap.put(id, row);
				 FileWrite();//파일쓰기
				 System.out.println("성공적으로 입력하였습니다.");
			 }
			 
			 
		 }else if(input==3) {
			 System.out.print("학번>");
			 int id=sc.nextInt();
			 if(stuMap.containsKey(id)) {
				 while(true) {
					 System.out.print("수정할 학번 1.국어 2.영어 3.수학 0.취소> ");
					 input=sc.nextInt();
					 if(input==1) {
						 System.out.print("국어>");
					 }else if(input==2) {
						 System.out.print("영어>");
					 }else if(input==3) {
						 System.out.print("수학>");
					 }else if(input==0) {
						 break;
					 }else {
						 System.out.println("잘못된 과목입니다.");
						 continue;
					 }
					 int temp=overRange(sc.nextInt());
					 if(temp==-1) {
						 System.out.println("점수는 0이상 100이하의 값을 입력입니다.");
						 continue;
					 }
					 stuMap.get(id)[input-1]=temp;
					 System.out.println("수정 완료");
					 FileWrite();//파일쓰기
					 break;
				 }
			 }else {
				 System.out.println("없는 학번입니다.");
				 continue;
			 }
		 }else if(input==4) {
			 System.out.print("학번>");
			 int id=sc.nextInt();
			 if(stuMap.containsKey(id)) {
				 stuMap.remove(id);
				 System.out.println("삭제완료");
				 FileWrite();//파일쓰기
			 }else {
				 System.out.println("없는 학번입니다.");
				 continue;
			 }
			 
		 }else if(input==5) {
			 System.out.print("학번>");
			 int id=sc.nextInt();
			 if(stuMap.containsKey(id)) {
				 System.out.println("===================================");
				 System.out.println("학번:\t"+id);
				 System.out.println("===================================");
				 System.out.println("국어:\t"+stuMap.get(id)[0]);
				 System.out.println("영어:\t"+stuMap.get(id)[1]);
				 System.out.println("수학:\t"+stuMap.get(id)[2]);
				 System.out.println("===================================");	 
				 int oneSum=stuMap.get(id)[0]+stuMap.get(id)[1]+stuMap.get(id)[2];
				 System.out.print("평균/전체평균:\t"+(oneSum*100/3/100.0));
				 Iterator ite=stuMap.keySet().iterator();
				 int Allsum=0;
				 int cnt=0;
				 while(ite.hasNext()) {
					 cnt++;
					 int key=(int)ite.next();
					 Allsum+=stuMap.get(key)[0]+stuMap.get(key)[1]+stuMap.get(key)[2];
				 }
				 System.out.println("/"+(Allsum*100/3/cnt/100.0));
				 char rank;
					int score = oneSum / 3 / 10;
					switch (score) {
					case 10:case 9:
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
					System.out.println("학점:\t"+rank);
					System.out.println("===================================");
			 }else {
				 System.out.println("없는 학번입니다.");
				 continue;
			 }
		 }else {
			 System.out.println("없는 메뉴입니다");
		 }
	 }
}
}
