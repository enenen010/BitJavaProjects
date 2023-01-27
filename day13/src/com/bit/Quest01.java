package com.bit;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Quest01 {
public static void main(String[] args) {
	Set set=new TreeSet();
	while(set.size()<6) {
		set.add((int)(Math.random()*45+1));
	}	
	Object[] arr=set.toArray();
	System.out.println("["+arr[0]+", "+arr[1]+", "+arr[2]+", "+arr[3]+", "+arr[4]+", "+arr[5]+"]");
}
}
