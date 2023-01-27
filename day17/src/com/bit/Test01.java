package com.bit;

import java.util.*;

class DataTable0{
	private List Data=new ArrayList<HashMap<String, String>>();
	
	
	public int size() {
		return Data.size();
	}
}


public class Test01 {
	public static void main(String[] args) {
		DataTable0 stuData = new DataTable0();
		
		String[] colunm = { "학번", "국어", "영어", "수학" };
		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> ");
			int menu = sc.nextInt();
			
			if(menu==0)break;
			else if(menu==1) {//리스트
				System.out.println("학번"+"국어"+"영어"+"수학");
				
				for(int i=0;i<stuData.size();i++) {
					
				}
				
				
				
				
			}else if(menu==2) {//입력
				
			}else if(menu==3) {//수정
				
			}else if(menu==4) {//삭제
				
			}else if(menu==5) {//상세보기
				
			}
			
		}
	}
}