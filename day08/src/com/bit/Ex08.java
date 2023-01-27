package com.bit;

public class Ex08 {

	public static void main(String[] args) {
		String[] arr1=new String[4];
		Ex08[] arr2=new Ex08[3];
		arr2[0]=new Ex08();
		int[][] arr3;
		
		arr3=new int[3][2];
		/*
		 arr3은 참조변수다 실제로 그 공간이 들어가는 것이 아니라.
		 3칸자리 공간을 가리키는 주소거 들어가 있다.
		 [3][]= 처음 배정된 3칸에 참조변수(주소)를 넣은 뒤 공간을 3개 만든다.
		 
		 힙에3칸을 만들고 arr3-> [ , , ] 가리킨 뒤 
		 arr3[0]=new int[] {0,0};
		 arr3[1]=new int[] {0,0};
		 arr3[2]=new int[] {0,0};
		 이것을 자동화 한것
		 */
		arr3[0]=new int[] {1,2,3};
		arr3[0]=new int[] {1,2};
		arr3[0]=new int[] {1};
		
		for(int i=0;i<arr3.length; i++) {
			for(int j=0;j<arr3[i].length; j++) {
				System.out.println(arr3[i][j]);
			}
		}
		
		
	}

}
