package com.bit;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
public class Ex10 {
public static void main(String[] args) {
//	File file=new File("test01");
//	File file=new File("Lec01.txt");//묵시적 상대경로(현재)
//	File file=new File(".\\Lec01.txt");//명시적 상대경로
	File file=new File("E:\\JAVA\\day16\\.\\..\\day16\\Lec01.txt");
//	경로 2가지 절대경로(루트부터전부), 상대경로(기준잡고거기)
	
	
	System.out.println("유무?"+file.exists());//파일있니?//폴더있니?
	if(file.exists()) {
		System.out.println("dir?"+file.isDirectory());
		System.out.println("file?"+file.isFile());
		
		//문자열 끊어읽는 방식
		System.out.println("경로:"+file.getPath());
		System.out.println("파일위치:"+file.getParent());
		System.out.println("파일이름:"+file.getName());
		System.out.println("절대경로:"+file.getAbsolutePath());
		
		try {//절대경로 정리함 실패의가능성으로 익셉션 처리
			System.out.println("진짜절대:"+file.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//권한
		System.out.println("r:"+file.canRead());
		System.out.println("w:"+file.canWrite());
		System.out.println("x:"+file.canExecute());
		
		//사이즈
		System.out.println("size:"+file.length()+"byte");
		
		//수정일자
		System.out.println(new Date(file.lastModified()));
		
		//폴더, 디렉터리 파일 리스트
		String[] arr=file.list();
		System.out.println(Arrays.toString(arr));
		
//		리눅스에서는 디렉터리도 결국 파일 - 폴더와 디렉터리 개념적으로 좀 다름
//		다른 OS (디렉터리) = 포인터개념 흩어진 파일들의 메모리 주소가지고 호출  - 조각x
//		윈도우    (폴더)   =정확히 그 메모리 위치에 둘려고 함  - 조각 발생 (크기다다른 배열느낌이랄까)
//		
//		.(현재디렉터리가리키는파일), ..(이전디렉터리가리키는파일)
		
		
//		다중접속이 가능해지며 파일접속권한의 필요성이 대두 
//		- 윈도우는(권한 설정 약함) 그래서 다른거(권한 설정 강함), 윈도우 server버전은 권한강하게 가능 굳이 쓴다면 이거
		
//		디렉터리 크기0? 디렉터리는 포인터 쉽게만든거고 해시테이블 같은게 있다
		
	}
}
}
