package com.bit;
import java.util.*;
import java.io.*;
public class Ex22 {
public static void main(String[] args) {
	
	File f=new File("Lec21.txt");
//	버퍼배열로 묶어 읽기
//	byte[] arr=new byte[(int) f.length()];
//	byte[] arr=new byte[1024];//1024바이트 크기를 무조건가지게 파일에출력 ->파일크기up
//	성능을 위해 버퍼를 사용하는 순간부터 여러문제들이 생김 해결법내일
	byte[] arr=new byte[10];
	InputStream is;
	InputStream os;
		try {
			is=new FileInputStream(f);
			while(true) {
				int su=is.read(arr);//배열들어가면 그단위로 읽음
				if(su==-1)break;
				System.out.println(new String(arr));
			}
			is.read(arr);
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

}
}
