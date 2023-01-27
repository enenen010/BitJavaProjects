package com.bit;
import java.util.*;

class Lec12 implements Comparable{

//	@Override
//	public int compareTo(Object arg0) {
//		return 0; //전부넣지마
//	}
	
//	@Override
//	public int compareTo(Object arg0) {
//		return 1; //전부넣어
//	}
	
	
//	int val=1;
//	@Override
//	public int compareTo(Object arg0) {
//		
//		return 0;
//	}
	
	public Lec12(int su) {
		
	}
	@Override
	public int compareTo(Object o) {
		
		return ((Lec12)o).val-val;//값비교를 통한 오름차순 내림차순
	}
	
	
}

public class Ex12 {
public static void main(String[] args) {
	//왠만해선 문제없다 -> 아무생각없이 쓸땐 해시셋
	Set set=new TreeSet();
	//순서가 없는 자료구조 - 집합
	//1. 중복을 허용하지 않는다
	//2. 순서 O 무작위 처럼 정렬   -> 이거에따라 HashSet(해시사용) TreeSet(이진트리) 나눔
	
	//이진트리 - 원래 값새로들어오면 전부검사해야 자리찾았는데 이건 절반,절반,검사량 줄음   성능Good
	//어떤크기?
	//극대화하면 
	
	set.add(new Lec12());//뭔값이 들어오든 캐스팅부터
	set.add(new Lec12());//0이면 입력X//다른값 입력O-> 비교결과 음수면 왼쪽 아니면 오른쪽
	set.add(new Lec12());
	
	set.add(1);
	set.add(2);
	set.add(3);
	set.add(4);
	set.add(5);
	
	
	Iterator ite=set.iterator();
	while(ite.hasNext()) {
		
	}
}
}
