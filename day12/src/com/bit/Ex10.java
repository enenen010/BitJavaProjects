package com.bit;

public class Ex10 {
	public static void main(String[] args) {

		// StringBuffer st1="me";
		StringBuffer st1 = new StringBuffer();
		StringBuffer st2 = new StringBuffer("java");
		StringBuffer st3 = new StringBuffer("web");

		// StringBuffer st4=st2+st3;
		StringBuffer st4 = st2.append(st3);// 동적할당해서 붇임 st2에 붙이고 반환
		StringBuffer st5 = st2.append("framework");// 중요한건 st2도 바뀐다.
		System.out.println(st2 == st3);
		// 동적할당 방법 미리 큰 사이즈에 배열 만들고
		// 꽉차면 그때 확 늘려서 봄
		// 느리고 무거운게 배열복사이므로 그냥 넣을때는 성능 빠름
		// 이렇게 안하면 String랑 똫같음

		// String은 매번 새로운객체를 반환
		// -> "",+로 할때 빼고 new나 다른거
		
		

		// 이건 있는 객체를 계속 사용 -> 성능은 더 졸다 쓰기어려우니 힘들면 그냥 Sting 써라
		// String는 객체가커서 성능이 중요할 떈 쓰기 힘듬
		// 쓰기편함 vs 성능
		System.out.println(st2);// 같음
		System.out.println(st5);// 같음

		// 현재 총길이: 배열이 꽉차면 그때 늘어남(처음크기+1)*2 양으로 늘어남
		System.out.println(st1.capacity());

		st1.trimToSize();// 자동으로 늘어났는데 안쓰는 공간 날림(여러번쓰면 안좋음)
		// 쓸 시기를 잘 결정 서비스하면서 변동폭이 확늘어나는 구간 전까지
	}
}
