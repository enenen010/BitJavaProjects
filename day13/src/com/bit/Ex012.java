package com.bit;

public class Ex012 {
public static void main(String[] args) {
	java.util.Set set1;
	set1=new java.util.TreeSet(); //HashSet과다르게 add시 배치순서가 매번바뀜
	
	
	set1.add("첫번쨰");
	set1.add("두번쨰");
	set1.add("세번쨰");
	set1.add("네번쨰");
	set1.add("다섯번쨰");
	
	
	java.util.Iterator ite;
	ite=set1.iterator();
	while(ite.hasNext()) {
		System.out.println(ite.next());
	}
}
}
