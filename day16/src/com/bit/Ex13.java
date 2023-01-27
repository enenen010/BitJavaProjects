package com.bit;

import java.io.*;
public class Ex13 {
public static void main(String[] args) {
	File f=new File("Lec02.txt"); //디렉터리넣으면디렉터리삭제
	if(f.exists()) {
		boolean boo=f.delete();
		if(boo)System.out.println("삭제완료");
		else {
			File[] arr;
			System.out.println("삭제실패");
		}
	}else {
		System.out.println("파일없음");
	}
// 	Dir 안에 뭐 하나라도 있으면 삭제실패
//	 파일먼저 지우고 지워야함 디렉토리 있으면 그안도 다지워야함

	
}
}
