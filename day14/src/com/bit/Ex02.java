package com.bit;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Ex02 {
public static void main(String[] args) {
	//List list=new ArrayList();
	List list = new Vector();
	list.add(1111);
	list.add(2222);
	list.add(3333);
	list.add(4444);
	
	//리스트 순서있어서 가능
	for(int i=0;i<list.size(); i++) {
		System.out.println(list.get(i));
	}
	
	//인덱스의 순서대로 꺼냄 - ArrayList
	Iterator ite = list.iterator();
	while(ite.hasNext()) {
		System.out.println(ite.next());
	}
	
	//vector1
	Enumeration enu=((Vector)list).elements();
	while(enu.h) {
		
	}
	
	//왜 Iterator 가지는가?  최상위 컬렉션이 가지니까! -> map은 컬렉션 상속x Iterator없음
	//가장많은 오해가 다컬렉션이니까 컬랙션으로 받으려하는데 map은 아님
	
	
}
}
