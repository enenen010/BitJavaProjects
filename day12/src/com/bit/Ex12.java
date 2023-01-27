package com.bit;

public class Ex12 {
	public static void main(String[] args) {
		int[] arr1= {-2,-1,0,1,2};
		for(int i=0;i<6;i++) {
			try {
				System.out.print(3/arr1[i]);
//			}catch(java.lang.Exception e) { 부모에서 오류다처리해서 밑에 필요없어서 오류
			}catch(java.lang.ArrayIndexOutOfBoundsException e) {//최하위부터
			}catch(java.lang.RuntimeException e) { //다중 캐치 가능
//			부모익셉션 RuntimeException은 0나누기와 배열인덱스를 둘다한다
//			부모익셉션은 범위가 더 넓음
			
				System.out.print(e.toString());
			}
		}
	}
}
