package com.bit;

import java.util.*;

public class Quest02 {
/*
 * 학생성적관리프로그램(ver 0.4.0)
 * 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료>
 * 국어 영어 수학
 * */
	//자바역할 데이터베이스 정보 프론트정보 종합해 전달
	public static void main(String[] args) {
		
		
		Set set=new TreeSet();//학번
		ArrayList dataList = new ArrayList();//학번,국,영,수 
		ArrayList keyList = new ArrayList();//학번
		
		
		System.out.println("학생성적관리프로그램(ver 0.4.0)");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료>");
			int input1 = sc.nextInt();
			
			switch(input1) {
			case 0://종료
				return;
			case 1://리스트
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("=====================================");
				for(int i=0;i<dataList.size();i++) {
					System.out.println(
							((int[])dataList.get(i))[0]+"\t"
							+((int[])dataList.get(i))[1]+"\t"
							+((int[])dataList.get(i))[2]+"\t"
							+((int[])dataList.get(i))[3]);
				}
				break;
			case 2://입력
				while(true) {
					int stuId;  //학번
					int Korean; //국어
					int english;//영어
					int math;   //수학
					System.out.println("학번과 각 과목 성적을 입력하세요");
					System.out.print("학번>");
					stuId=sc.nextInt();
					System.out.print("국어>");
					Korean=sc.nextInt();
					System.out.print("영어>");
					english=sc.nextInt();
					System.out.print("수학>");
					math=sc.nextInt();
					if(set.add(stuId)) {
						int[] arr= {stuId,Korean,english,math};
						dataList.add(arr);
						keyList.add(stuId);
						break;
					}else {
						System.out.println("학번 중복입니다. 다시 입력하세요");
						continue;
					}
				}
				break;
			case 3://수정
				System.out.print("수정할 학번을 입력하세요>");
				int setValue= sc.nextInt();
				int keyIdx2=keyList.indexOf(setValue);
				if(keyIdx2==-1) {
					System.out.println("수정할 학번이 없습니다.");
					break;
				}
				
				int Korean; //국어
				int english;//영어
				int math;   //수학
				System.out.println("수정할 각 과목 성적을 입력하세요");
				System.out.print("국어>");
				Korean=sc.nextInt();
				System.out.print("영어>");
				english=sc.nextInt();
				System.out.print("수학>");
				math=sc.nextInt();
				
				int[] arr= {setValue,Korean,english,math};
				dataList.set(keyIdx2, arr);
				
				break;
			case 4://삭제
				System.out.print("삭제할 학번을 입력하세요>");
				int removeValue= sc.nextInt();
				int keyIdx=keyList.indexOf(removeValue);
				if(keyIdx==-1) {
					System.out.println("삭제할 학번이 없습니다.");
					break;
				}
				keyList.remove(keyIdx);
				dataList.remove(keyIdx);
				set.remove(removeValue);
				break;
			case 5://상세보기
				System.out.print("상세보기 학번을 입력하시오>");
				int input=sc.nextInt();
				
				int keyIdx3=keyList.indexOf(input);
				if(keyIdx3==-1) {
					System.out.println("없는 학번입니다.");
					break;
				}
				int[] row=(int[]) dataList.get(keyIdx3);
				System.out.println("학번:\t"+row[0]);
				System.out.println("국어:\t"+row[1]);
				System.out.println("영어:\t"+row[2]);
				System.out.println("수학:\t"+row[3]);
				
				int allSum=0;
				for(int i=0;i<dataList.size();i++) {
					int[] arr1=(int [])dataList.get(i);
					allSum+=arr1[1]+arr1[2]+arr1[3];
				}
				System.out.println("평군/전체평균:\t"
						+(((row[1]+row[2]+row[3])*100/3)/100.0)+"/"
						+((allSum*100/3/dataList.size())/100.0)
						);
				
				char rank;
				switch(((row[1]+row[2]+row[3])/3)/10) {
				case 10: case 9:
					rank='A';
					break;
				case 8:
					rank='B';
					break;
				case 7:
					rank='C';
					break;
				case 6:
					rank='D';
					break;
				default:
					rank='F';
					break;
				}
				System.out.println("학점:\t"+rank);
				break;
			}
		}
		
		
	}
}
