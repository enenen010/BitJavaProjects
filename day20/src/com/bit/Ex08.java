package com.bit;

import java.io.IOException;

public class Ex08 {
	public static void func() {
		System.out.println("func start..");
		try {
			int a=4;
			int b=0;
			int c=a/b;	
			
		} catch (Exception e) {
			return;
		}finally {
			if(c==2)return;//무조건 수행안됨
		}
			if(c==2)return;//무조건 수행안됨
		
//		try {
//			int a=4;
//			int b=0;
//			int c=a/b;	
//			return;
//		}finally { //위에 return 있어도 무조건 수행
//			if(c==2)return;//무조건 수행안됨
//		}
//		if(c==2)return;//무조건 수행안됨
		
		
//		예외처리를 위해 try안에 적어야되는데 오류나면 close건너 뛸수 있어서 
//		finally {//사실 이렇게 했어야..
//			try {
//				if(pw!=null)pw.close();
//				if(fw!=null)fw.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}	
//		}
			
		System.out.println();
		System.out.println("func start..");
	}
public static void main(String[] args) {
	func();
	
}
}
