package com.bit;

public class Ex06 {

	public static void main(String[] args) {
		System.out.println("main start");
		int su1=4;
		int[] arr= {-1,-2,0,1,2};
		
		try {//try catch 어디에 하느냐에 따라 퍼포먼스가 달라짐 전체를 회피, 그부분만 회피
			//여기 붙이면 for 전체를 회피 2개만 나옴  for 안이면 4개
		for(int i=0; i<arr.length; i++) {
			System.out.println(su1/arr[i]);
		}
		}catch(java.lang.AbstractMethodError e){
			//이렇게 바로 출력할 수도 있고
			System.out.println(e.toString());//에러명, 사유
			System.out.println(e.getMessage());//사유
			System.out.println(e.getClass());
			
			//지금 바쁘니까 로그 남겨뒀다 나중에 출력하도록   for 다출력하고 마저하자? -1,-2에서 끊지말고
			//나중에 빨간색으로 나오는데 에러아님 결국에 실행은 정상적으로 끝까지 됨
			//에러메세지 띄워달라고 했으니 빨간색으로 띄워달라 한거임
			e.printStackTrace();//얘로해야 프로그램에 영향이 적음
			                    //우리가 ptint로 에러 확인하면 OS에 요청하고 그러면 논다->성능↓
		}
		System.out.println("main end");
	}
}
