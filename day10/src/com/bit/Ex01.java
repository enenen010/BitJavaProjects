package com.bit;

public class Ex01 {

	public static void main(String[] args) {
		/*
		 * 학생성적관리프로그램(0.2.0)
		 *  교과목- java, web, framework
		 *  1.리스트 2.입력 3.상세보기 4.삭제 0.종료>
		 *  리스트에서 데이터만 -학번,j,w,f
		 *  상세보기- 학생선택 학번입력 -> 합계 평균(소수둘째자리,해당학생평균/전체평균) 학점
		 */
		//1.수업내용 동적할당(20) 2.수업외 동적할당
		//3.시작시 총인원 입력받기
		
		
		
		//.UI 설계
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc=new java.util.Scanner(System.in);
		int input=0;
		
		while(true) {
			System.out.println("1.리스트 2.입력 3.상세보기 4.삭제 0.종료>");
			input=sc.nextInt();
			if(input==0)break;
			if(input==1) {
				System.out.println("리스트 출력");
			}
			if(input==2) {//입력
				System.out.print("학번>");
				input=sc.nextInt();
				System.out.print("학번>");
				input=sc.nextInt();
				System.out.print("학번>");
				input=sc.nextInt();
				System.out.print("학번>");
				input=sc.nextInt();
			}
			if(input==3) {//상세보기
				System.out.print("학번>");
				input=sc.nextInt();
				System.out.println(input+"학번의 합계,평군,전체평균");
			}
		}
	}//만들고 테스트로 잘 나오는지 확인 -> 기본적인 틀이 잘 만들어졌는지 ->이다음 메서드 등 만들기
}
