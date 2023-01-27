package com.bit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Ex03 {
	public static void save(){
		OutputStream os=null;
		try {
			
			os=new FileOutputStream(f);
			for(int i=0;i<data.size();i++) {
				int[] arr=data.get(i);
				os.write(Arrays.toString(arr).getBytes());
			}
			if(os!=null)os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		InputStream is=null;
		ArrayList<Byte> arr2=new ArrayList<Byte>(); 
		if(f.exists()) {
			try {
				is=new FileInputStream(f);
				while((input=is.read())!=-1) {
					arr2.add((byte)input);
				}
				if(is!=null)is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Object[] arr3=arr2.toArray();
			byte[] arr4=new byte[arr3.length];
			for(int i=0;i<arr4.length;i++) {
				arr4[i]=(byte) arr3[i];
			}
			String msg=new String(arr4);
			if(!msg.isEmpty()) {
//				[1, 11, 22, 33][2, 44, 55, 66]
//				1, 11, 22, 33][2, 44, 55, 66
//				1, 11, 22, 33 2, 44, 55, 66
//				
				msg=msg.substring(1,msg.length()-1);
				String[] arr5=msg.split("\\]\\[");
				for(int i=0; i<arr5.length; i++) {
					String stu=arr5[i];
					String[] arr6=stu.split(", ");
					int[] arr7=new int[arr6.length];
//					for(int j=0;j<arr7.length;j++) {
//						arr7[i]=Integer.parseInt(arr6[i]);
//					}
					data.add(arr7);
				}
			}
			
				
		}
	}
	
	static List<int[]> data=new ArrayList<int[]>();
	static File f = new File("./src/com/stu01/data.bin");
	static int input = -1;
	
public static void main(String[] args) {
	//1.파일로 받음
	//2.문자열로 받음
	//3.자료구조 메모리에 받음
	
	
	
	System.out.println("학생성적관리프로그램 (ver 0.5.0)");
	Scanner sc = new Scanner(System.in);
	
	while (true) {
		//프로그램을 켰을때 data 초기화
		init();
		System.out.print("1.리스트  2.상세보기  3.입력  4.수정  5.삭제  0.종료>");
		input = sc.nextInt();
		if (input == 0)break;
		else if (input == 1) {
			System.out.println("--------------------------------");
			System.out.println("학번\t국어\t영어\t수학");
			System.out.println("--------------------------------");
			
			
			
			System.out.println("--------------------------------");
			
		}else if(input == 2) {
			
		}else if(input == 2) {
			int[] stu=new int[4];
			System.out.println("학번>");
			stu[0]=sc.nextInt();
			System.out.println("국어>");
			stu[1]=sc.nextInt();
			System.out.println("영어>");
			stu[2]=sc.nextInt();
			System.out.println("수학>");
			stu[3]=sc.nextInt();
			data.add(stu);
			
			
			
		}else if(input == 2) {
			
		}else if(input == 2) {
			
		}else if(input == 2) {
			
		}
	}
}
}
