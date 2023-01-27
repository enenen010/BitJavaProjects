package com.bit;

import java.util.*;

public class Ex13 {
public static void main(String[] args) {
	//IO를 뺀 나머지 먼저 설명
	//interface Map을 상속
	Properties props;
	props=new Properties();
	
	props.setProperty("key", "val1");
	
	System.out.println(props);
	
	props=System.getProperties();//얘를 객체로하는 IO내장 속성이 있음
	
	Set set=props.keySet();
	Iterator ite = set.iterator();
	while(ite.hasNext()) {
		Object key=ite.next();
		System.out.println(key+"@"+props.get(key));
	}
	//IO속성, 자료구조속성 값 자바에서 내장시켜논거 여기서 구함
}
}
