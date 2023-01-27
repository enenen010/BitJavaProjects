package com.test;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Quest01 {
	List<String[]> stuList = new ArrayList<String[]>();
	
	public void fileWrite(File f) throws IOException {

		OutputStream os;
		BufferedOutputStream bos;
		byte[] buf=new byte[5];
		if (!f.exists())f.createNewFile();
		// FileWriter fw = new FileWriter();
		os = new FileOutputStream(f);
		bos = new BufferedOutputStream(os);
		
		for (int i = 0; i < stuList.size(); i++) {
			String data = "";
			for (int j = 0; j < stuList.get(i).length; j++) {
				data += stuList.get(i)[j] + " ";
			}
			data += "\n";
			bos.write(data.getBytes());
		}
		bos.close();
		os.close();

	}

	public void fileRead(File f) throws IOException {
		
		
//		InputStream is;
//		DataInputStream dis;
//		is=new FileInputStream(f);
//		dis=new DataInputStream(is);
//		
//		
//		while(true) {
//			
//			String line = dis.readUTF();
//			stuList.add(line.split(" "));
//			
//			
//		}
//		if(dis!=null)dis.close();
//		if(is!=null)is.close();
		
		Scanner sc=new Scanner(f);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			stuList.add(line.split(" "));
		}
		sc.close();
	}
	public static void main(String[] args)  {
		/*
		 * 학생성적관리프로그램(ver 0.5.0) 
		 * 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> 
		 * 국어 영어 수학
		 */
		 
		 Quest01 que = new Quest01();
		 try {
			 que.fileRead(new File("E:\\JAVA\\test\\out.txt"));
		 }catch(IOException e) {
			 
		 }
		 
		 String[] colunm = {"학번","국어","영어","수학"};
		 System.out.println("학생성적관리프로그램(ver 0.5.0)");
		 while(true) {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> ");
			 int menu=sc.nextInt();
			 if(menu==0)break;
			 
			 else if(menu==1) {//리스트
				 for(int i=0; i<que.stuList.get(0).length;i++) {
					 System.out.print(que.stuList.get(0)[i]+"\t");
				 }
				 System.out.println();
				 System.out.println("====================================================");
				 for(int i=1; i<que.stuList.size();i++) {
					 for(int j=0; j<que.stuList.get(0).length;j++) {
						 System.out.print(que.stuList.get(i)[j]+"\t");
					 }
					 System.out.println();
				 }
				 System.out.println("====================================================");
				} else if (menu == 2) {// 입력
					try {
						que.stuList.get(0);
					}catch(java.lang.IndexOutOfBoundsException e) {
						System.out.println("저장된 데이터가 없습니다 기본 데이터로 진행합니다.");
						que.stuList.add(colunm);
					}
					String[] temp=new String[que.stuList.get(0).length];
					sc=new Scanner(System.in);
					for(int i=0;i<que.stuList.get(0).length;i++) {
						System.out.print(que.stuList.get(0)[i]+">");
						temp[i]=sc.nextLine();
					}
					que.stuList.add(temp);

				} else if (menu == 3) {// 수정
					

				} else if (menu == 4) {// 삭제

				} else if (menu == 5) {// 상세보기
					System.out.print(que.stuList.get(0)[0]+">");
					sc=new Scanner(System.in);
					String input=sc.nextLine();
					
					for(int i=0;i<que.stuList.size();i++) {
						if(que.stuList.get(i)[0]==input) {
							
							
							break;
						}
					}

				} else if (menu == 6) {// 파일출력
					try {
						que.fileWrite(new File("E:\\JAVA\\test\\out.txt"));
						System.out.println("출력 하였습니다.");
					} catch (IOException e) {
						System.out.println("출력 실패하였습니다.");
					}
					
				} 
			}

		}
	}
