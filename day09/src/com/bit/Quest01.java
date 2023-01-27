package com.bit;

public class Quest01 {

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
		 
		String[][] studentDB = new String[4][0];
		System.out.println("학생성적관리프로그램(0.2.0)");
		boolean exit1=true;
		do {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제 0.종료>");
			int command = sc.nextInt();
			
			switch(command) {
				case 1: //리스트
					System.out.println("학번, java, web, framework ");
					for(int i=0; i<studentDB[0].length;i++) {
						System.out.println(studentDB[0][i]+", "
					+studentDB[1][i]+", "
					+studentDB[2][i]+", "+studentDB[3][i]);
					}
					break;
				case 2: //입력
					java.util.Scanner sc2 = new java.util.Scanner(System.in);
					System.out.print("학번 java web framework 형식으로 입력하시오>");
					String[] inputData = sc2.nextLine().split(" ");
					
					for(int i=0; i<inputData.length;i++) {
						System.out.println("studentDB.length="+studentDB[i].length);
						if(studentDB.length==1) {
							studentDB[i][0]=inputData[i];
						}else {
							String[] tempData=new String[studentDB[i].length+1];
							for(int j=0; j<studentDB[i].length;j++) {
								tempData[j]=studentDB[i][j];
							}
							tempData[studentDB[i].length] = inputData[i];
							studentDB[i]=tempData;
						}
					}
					break;
				case 3: //상세보기
					java.util.Scanner sc3 = new java.util.Scanner(System.in);
					System.out.print("학번을 입력하시오>");
					String SchKey = sc3.nextLine();
					int schIndex = 0;
					for(int i=0; i<studentDB[0].length;i++) { //검색 인덱스 찾기
						if(studentDB[0][i].equals(SchKey)) {
							schIndex=i;
						}
					}
					
					int[][] SungeArr = new int[3][studentDB[0].length];
					System.out.print(SungeArr[0].length);
					
					for(int i=1; i<4;i++) {
						for(int j=0; j<studentDB[0].length;j++) {
							if(studentDB[i][j].length()==3) {
								SungeArr[i-1][j]=(studentDB[i][j].charAt(0)-'0')*100
										+(studentDB[i][j].charAt(1)-'0')*10
										+(studentDB[i][j].charAt(2)-'0');
							}else if(studentDB[i][j].length()==2) {
								SungeArr[i-1][j]=(studentDB[i][j].charAt(0)-'0')*10
										+(studentDB[i][j].charAt(1)-'0');
							}else {
								SungeArr[i-1][j]=(studentDB[i][j].charAt(0)-'0');
							}
						}
					}
					
					
					int javaSum=0;
					int webSum=0;
					int framSum=0;
					
					for(int i=0;i<SungeArr[0].length;i++) {
						javaSum+=SungeArr[0][i];
						webSum+=SungeArr[1][i];
						framSum+=SungeArr[2][i];
					}
					
					System.out.println("학번  java web framework 해당학생평균/전체평균 학점");
					System.out.println(studentDB[0][schIndex]+"  "
					+studentDB[1][schIndex]+" "
					+studentDB[2][schIndex]+" "
					+studentDB[3][schIndex]+" "
					+((((SungeArr[0][schIndex])
							+(SungeArr[0][schIndex])
							+(SungeArr[0][schIndex]))*100/3)/100.0)
					+"/"
					+(((javaSum+webSum+framSum)*100/3)/100.0)
					+" "
					+"학점");
					break;
				case 4: //삭제
					java.util.Scanner sc4 = new java.util.Scanner(System.in);
					System.out.print("삭제할 학번을 입력하시오>");
					String removeKey = sc4.nextLine();
					int removeIndax = 0;
					for(int i=1; i<studentDB[0].length;i++) { //삭제 인덱스 찾기
						if(studentDB[0][i].equals(removeKey)) {
							removeIndax=i;
						}
					}
					
					
					for(int i=0; i<4;i++) { //데이터 삭제
						String[] tempData=new String[studentDB[i].length-1];
						for(int j=0; j<studentDB[i].length;j++) {
							if(j>removeIndax) {                //삭제 인덱스를 제외하고 1값작은배열 값입력
								tempData[j-1]=studentDB[i][j]; 
							}else if(j!=removeIndax){
								tempData[j]=studentDB[i][j]; 
							}
						}
						studentDB[i]=tempData;
						System.out.println("studentDB.length="+studentDB[i].length);
					}
					break;
				case 0: //종료
					exit1=false;
					break;
			}
			
			//System.out.println("학번, j, w, f");
			//System.out.println("합계 평균(소수둘째자리,해당학생평균/전체평균) 학점");
		}while(exit1);
	}

}
