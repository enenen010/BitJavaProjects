package com.bit;

import java.util.Vector;

public class Ex10 {
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
	//Stack은 Vector를 상속받아서 stack에서 vecter기능 쓸순있는데 제한 없어서 잘써야함
	
	java.util.Enumeration enu;//오로지 벡터를 위해 존재
	//int su=(int)enu.nextElement();
	//비선형 자료구조를 지원   
	//선형은
	//비선형 순서가 없다보니 넣더라도 어떻게 가져올꺼냐 순서가 없는데?  딜레마
	//개념적으론 가능한데 어떻게 구현하냐
	//JDK1.2때 enu=vec.elements()얘를 통해 구현
	//
	enu=vec.elements();//출력용으로 깊은복사  -> set등 뒤의 비선형 자료구조 등장에 영향
	System.out.println(enu.nextElement());
	System.out.println(enu.nextElement());
	System.out.println(enu.nextElement());
	System.out.println(enu.nextElement());
	System.out.println(enu.nextElement());
	
	while(enu.hasMoreElements()) {
		System.out.println(enu.hasMoreElements());
	}//커서를 두고 움직이는 방식
	
	//선형
	System.out.println("------------------");
	System.out.println(vec.elementAt(0));//이인덱스값빼고 앞으로밈
	System.out.println(vec.elementAt(1));
	System.out.println(vec.elementAt(2));
	System.out.println(vec.elementAt(3));
	System.out.println(vec.elementAt(4));
	System.out.println(vec.elementAt(5));
}
}
