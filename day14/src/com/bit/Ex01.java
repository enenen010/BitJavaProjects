package com.bit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex01 {
public static void main(String[] args) {
	//map <- 사용은 인터페이스로 보라고 했음
	//반복을 위한게 아니라 키값을 통해 밸류를 얻어내려고 사용(인덱스를 0,1 아닌 원하는대로)
	//set과 List가 있어야 만들 수 있어서 좀 늦게 나옴
	
	
	Map map=new HashMap();//별문제 없으려면 HashMap
	map.put("key1", "val1");
	map.put("key2", "val2");
	map.put("key3", "val3");
	map.put("key4", "val4");
	map.put("key5", "val5");
	
	System.out.println(map.get("key1"));
	System.out.println(map.get("key2"));
	System.out.println(map.get("key3"));
	System.out.println(map.get("key4"));
	System.out.println(map.get("key5"));
	System.out.println(map.get("key6"));//없는값 value=null(null과 언디파인 구분x)
	
	
	// 키=유일, 밸류=중복     =>  키는 hashSet으로 관리  밸류는 List로 관리
	
	//특성
	map.put(1234, "val");
	map.put('a', "val");
	map.put(true, "val");
	map.put(null, "val");
	
	// 키중복X= 밸류중복O =>오류가 아니라 덮어씀 아닐때도 있음 객체에따라
	//map.put("key2", "val2");
	map.put("key3", true);
	map.put("key4", 1234);
	map.put("key5", null);
	
	//==============================
	map.clear();
	
	map.put("key1", "val1");
	map.put("key2", "val2");
	map.put("key3", "val3");
	map.put("key4", "val4");
	map.put("key5", "val5");
	
	//이터레이팅
	//반복 못하는건 아님
	Set entrys=map.entrySet();//키밸류 합친 객체배열을 리턴 (이젠 순서가 없다)
	Iterator ite= entrys.iterator();
	while(ite.hasNext()) {
		java.util.Map.Entry entry;
		entry=(java.util.Map.Entry) ite.next();
		System.out.println(entry.getKey()
				+":"+entry.getValue());
	}
	
	//반복 못하는건 아님
//	Set keys=map.keySet();
//	Iterator ite2=keys.iterator();
//	while(ite.hasNext()) {
//		Object key=ite2.next();
//		System.out.println(key);
//		System.out.println(map.get(key));
//	}
//	
	System.out.println("size:"+map.size());//키가기준
	Collection list= map.values(); //컬렉션->순서없음->이터레이팅
	Iterator ite3=list.iterator();
	while(ite3.hasNext()) {
		System.out.println(ite3.next());
	}
	
	//com.bit.Ex01 cannot be cast to java.lang.Comparable
	Map map2=new TreeMap();
//	map2.put(new Ex01(), "val1");
}
}
