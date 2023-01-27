package com.bit;

import java.util.Vector;

public class Ex09 {
public static void main(String[] args) {
	java.util.Vector vec;
	vec=new Vector(); //나중에 리스트를 상속 받아 그 기능 있지만
	//태초기능들 태초의 동적할당
	//큐,스택 없었을땐 이걸로 다했다, 그당시엔 이걸로 모든 자료구조
	//쓰는 사람이 잘써야 했음
	//ArrayList로도 큐,스택 할 수 있음 쓰는 사람이 잘쓰면
	//LinkedList는 맨앞뺄땐 성능차이 없으므로 Queue에 적합
	vec.addElement(1111);
	vec.addElement(2222);
	vec.addElement(3333);
	vec.addElement(4444);
	vec.addElement(5555);
	vec.addElement(1111);
	
	System.out.println(vec.elementAt(0));//이인덱스값빼고 앞으로밈
	System.out.println(vec.elementAt(1));
	System.out.println(vec.elementAt(2));
	System.out.println(vec.elementAt(3));
	System.out.println(vec.elementAt(4));
	System.out.println(vec.elementAt(5));
}
}
