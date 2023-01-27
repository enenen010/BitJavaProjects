package com.bit;

import java.io.*;
import java.util.*;

public class Ex02 {
	//자바를 하는 사람은 설사 객체지향일지라도 
	//한가지 개념에 빠지면 안됨
	//자바는 무언가 가져와서 사용하도록 특화되어있기 때문
	
	//자바중요순위 
	//1.자료구조, 2.Io
	//전산의 기본은 IO 꼭 파일이 아니더라도
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램 (ver 0.5.0)");
		Scanner sc = new Scanner(System.in);
		File f = new File("./src/com/stu02/data.bin");
		int input = -1;
		while (true) {
			System.out.print("1.리스트  2.상세보기  3.입력  4.수정  5.삭제  0.종료>");
			input = sc.nextInt();
			if (input == 0)
				break;
			if (input == 1) {
				System.out.println("--------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("--------------------------------");
				if(f.exists()) {
					InputStream is=null;
					
					try {
						is=new FileInputStream(f);
						while((input=is.read())!=-1) {
							System.out.println((char)input);
						}
						if(is!=null)is.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (input == 2) {
				System.out.print("학번>");
				int num = sc.nextInt();
				input=sc.nextInt();
				InputStream is=null;
				BufferedInputStream bis=null;
				try {
					is=new FileInputStream(f);
					bis=new BufferedInputStream(is);
					ArrayList<Byte> arr=new ArrayList<Byte>();
					while(true) {
						int su=bis.read();
						if(su==-1)break;
						
						if(su=='\t'||su=='\n') {
							
							//Byte[] arr3=arr.toArray(new Byte[0]);//toArray객체만지원..
							
							Object[] arr2=arr.toArray();
							byte[] arr3=new byte[arr2.length];
							for(int i=0;i<arr3.length;i++) {
								arr3[i]=(byte)arr2[i];
							}
							String msg=new String(arr3);
							
							//요게 학번검사  친거+\t로 시작하는지
							if(msg.startsWith(input+"\t"))//시작이학번+\t
								System.out.println(msg);
							arr.clear();
						}
						else{
							arr.add((byte) su);
						}
					}
					
					if(bis!=null)bis.close();
					if(is!=null)is.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if (input == 3) {
				System.out.print("학번>");
				int num = sc.nextInt();
				System.out.print("국어>");
				int kor = sc.nextInt();
				System.out.print("영어>");
				int eng = sc.nextInt();
				System.out.print("수학>");
				int math = sc.nextInt();
				OutputStream os=null;
				PrintStream ps=null;
				try {
					if(!f.exists())f.createNewFile();
					//어레이스트림에 잠시써놓고 기존데이터+새데이터
					os=new FileOutputStream(f,true);
					ps=new PrintStream(os);
					ps.println(num+"\t"+kor+"\t"+eng+"\t"+math);
					if(ps!=null)ps.close();
					if(os!=null)os.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			if (input == 4) {
			}
			if (input == 5) {
			}

		}
	}

}