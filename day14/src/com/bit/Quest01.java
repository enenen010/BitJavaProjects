package com.bit;
import java.util.*;
import java.util.Map.Entry;

public class Quest01 {
	public static void main(String[] args) {
		/*
		 * 학생성적관리프로그램(ver 0.5.0) 
		 * 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> 
		 * 국어 영어 수학
		 */
		Map<Integer,Map<String,Integer>> map=new HashMap<Integer, Map<String,Integer>>();
		Set<Entry<Integer,Map<String,Integer>>> entrys;
		entrys=map.entrySet();
		
		Set<Entry<Integer,Map<String,Integer>>> entry;
		entry=ite.next();
		
		Map<String,Integer> stu=entry.getValue();
		
		//arrayList 쉬움 set어려움 -> List 입력순, set 중복제거자동 treeset-순서정할수있다-> 객체면
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
			if(input==0) {//종료
				
			}else if(input==1) {//리스트
				
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
