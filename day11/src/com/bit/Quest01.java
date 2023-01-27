package com.bit;

public class Quest01 {
	/*
	 * 학생성적관리프로그램(0.2.0)
	 *  교과목- java, web, framework
	 *  1.리스트 2.입력 3.상세보기 4.삭제 0.종료>
	 *  리스트에서 데이터만 -학번,j,w,f
	 *  상세보기- 학생선택 학번입력 -> 합계 평균(소수둘째자리,해당학생평균/전체평균) 학점
	 */
	//1.수업내용 동적할당(20) 2.수업외 동적할당
	//3.시작시 총인원 입력받기
	
	
	
	int[][] quest2 = new int[0][0];

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("학생성적관리프로그램(0.3.0)"); 
		System.out.println("모드를 선택하시오, 1.단일, 2.2차원"); 
		pArr dataTeble = null;
		int input1 = sc.nextInt();
		switch(input1) {
		case 1:
			dataTeble = new Arr1();
			System.out.println("단일모드입니다."); 
			break;
		case 2:
			dataTeble = new Arr2();
			System.out.println("2차원모드입니다."); 
			break;
		}
		
		while(true) {
			
			
			System.out.print("1.리스트 2.입력 3.상세보기 4.삭제 0.종료>"); 
			int input2 = sc.nextInt();
			
			switch(input2) {
			case 0: //종료
				return;
			case 1: //리스트
				System.out.println("학번\tj\tw\tf");
				System.out.println("======================================");
				for(int i=0;i<dataTeble.RowLeng();i++) {
					dataTeble.println(i);
				}
				break;
			case 2: //입력
				System.out.println("입력시작합니다.");
				int[] temp = new int[4];
				System.out.print("학번>");
				temp[0]=sc.nextInt();
				System.out.print("java>");
				temp[1]=sc.nextInt();
				System.out.print("web>");
				temp[2]=sc.nextInt();
				System.out.print("framework>");
				temp[3]=sc.nextInt();
				dataTeble.Add(temp);
				break;
			case 3: //상세보기
				System.out.println("");
				System.out.print("확인할 학번을 입력하세요>");
				int stuID1=sc.nextInt();
				int rowIdx= dataTeble.selectIdx(stuID1);
				int[] row= new int[4];
				dataTeble.getRow(rowIdx, row);
				
				System.out.println("======================================");
				System.out.println("학번: "+row[0]);
				System.out.println("======================================");
				System.out.println("java:\t\t"+row[1]);
				System.out.println("web:\t\t"+row[2]);
				System.out.println("framework :\t"+row[3]);
				System.out.println("======================================");
				System.out.println("평균/전체평균 :\t"+(((row[1]+row[2]+row[3])*100/3)/100.0)
					+"/"+((dataTeble.sum(1)+dataTeble.sum(2)+dataTeble.sum(3))
							*100/3/dataTeble.RowLeng())/100.0);
				
				int in=(row[1]+row[2]+row[3])/3/10;
				char rank;
				switch(in) {
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
				System.out.println("학점 :\t\t"+rank);
				break;
			case 4: //삭제
				System.out.println("삭제할 학번을 입력하세요.");
				int stuID2=sc.nextInt();
				int stuIdx = dataTeble.selectIdx(stuID2);
				dataTeble.remove(stuIdx);
				break;
			}
		}
		
	}

}

interface pArr{
	void Add(int[] arr);//row추가
	void remove(int idx);//row삭제
	void println(int idx);//row출력
	int RowLeng();//row갯수
	int selectIdx(int num);//기본키값으로row인덱스
	void getRow(int rowIdx, int[] returnArr);//row배열반환
	int sum(int colIdx);//컬럼값합
}

class Arr1 implements pArr {
	int[][] quest1;
	
	public Arr1() {
		quest1= new int[0][4];
	}
	
	public void Add(int[] arr) {
		int[][] temp= new int[quest1.length+1][4];
		System.arraycopy(quest1, 0, temp, 0, quest1.length-1); 
		temp[quest1.length]=arr;
		quest1=temp;
	}
	
	public void remove(int idx) {
		int[][] temp= new int[quest1.length-1][4];
		System.arraycopy(quest1, 0, temp, 0, idx-1);
		System.arraycopy(quest1, idx+1, temp, idx, temp.length-1);
		quest1=temp;
	}
	
	public int RowLeng() {
		return quest1.length;
	}
	
	public int selectIdx(int num) {
		for(int i=0;i<quest1.length;i++) {
			if(quest1[i][0]==num) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public void println(int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRow(int rowIdx, int[] returnArr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sum(int colIdx) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}

class Arr2 implements pArr { //2차원배열 클래스
	int[][] quest1= new int[0][4];
	
	public void Add(int[] arr) {
		int[][] temp= new int[quest1.length+1][4];
		if(quest1.length!=0) {               //복사할개수임 인덱스 아님!!!
			System.arraycopy(quest1, 0, temp, 0, quest1.length); 
		}
		temp[quest1.length]=arr;
		quest1=temp;
	}
	
	public void remove(int idx) {
		int[][] temp= new int[quest1.length-1][4];
		System.arraycopy(quest1, 0, temp, 0, idx);
		System.arraycopy(quest1, idx+1, temp, idx, temp.length-idx);
		quest1=temp;
	}
	
	public void println(int idx) {
		System.out.println(quest1[idx][0]+"\t"
	+quest1[idx][1]+"\t"+quest1[idx][2]+"\t"+quest1[idx][3]);
	}

	@Override
	public int RowLeng() {
		return quest1.length;
	}

	@Override
	public int selectIdx(int num) {
		for(int i=0;i<quest1.length;i++) {
			if(quest1[i][0]==num) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public void getRow(int rowIdx, int[] returnArr) {
		System.arraycopy(quest1[rowIdx], 0, returnArr, 0, returnArr.length); 
	}

	@Override
	public int sum(int colIdx) {
		int sum=0;
		for(int i=0;i<quest1.length;i++) {
			sum += quest1[i][colIdx];
		}
		return sum;
	}

}

