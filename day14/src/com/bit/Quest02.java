package com.bit;
import java.util.*;


public class Quest02 {
public static void main(String[] args) {
	List<String[]> stuList=new ArrayList<String[]>();
	System.out.println("학생성적관리프로그램(ver 0.5.0)");
	while (true) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료>");
		int input = sc.nextInt();
		
		if(input==0) break;//종료
		else if(input==1) {//리스트
			
			
		}else if(input==2) {//입력
			
		}else if(input==3) {//수정
			
		}else if(input==4) {//삭제
			
		}else if(input==5) {//상세보기
			
		}else {
			System.out.println("없는 메뉴 입니다");
			continue;
		}

	}
}
}
