package com.bit;

import java.util.*;

public class Ex08 {
public static void main(String[] args) {
	/*
	 * 학생성적관리프로그램(ver 0.5.0)
	 * 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> 
	 * 국어 영어 수학
	 * 
	 * 구현 방법 ->  배열저장 or 객체저장
	 */
	List<int[]> data=new ArrayList<int[]>();
	System.out.println("학생성적관리프로그램(ver 0.5.0)");
	int input=-1;
	while (true) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료>");
		try {
		input = sc.nextInt();
		}catch(Exception e) {
			System.out.println("숫자를 입력바랍니다");
			sc=new Scanner(System.in);
			continue;
		}
		if(input==0) break;//종료
		else if(input==1) {//리스트
			
		}else if(input==2) {//입력
			int[] stu=new int[4];
			System.out.println("학번>");
		}else if(input==3) {//수정
			
		}else if(input==4) {//삭제
			
		}else if(input==5) {//상세보기
			
		}else {
			System.out.println("없는 메뉴 입니다");
			continue;
		}
	}
	System.out.println("이용해주셔서 감사합니다");
}
}
