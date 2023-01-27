package com.bit;

import java.util.Set;
import java.util.TreeSet;

class Lec001 implements Comparable{
	int me;
	public Lec001(int a) {
		this.me=a;
	}
	
	@Override
	public int compareTo(Object o) {
		return me-((Lec001)o).me;
	}
	
}

public class test01 {
public static void main(String[] args) {
	Set set=new TreeSet();
	
	System.out.println(set.add(new Lec001(1)));
	System.out.println(set.add(new Lec001(2)));
	System.out.println(set.add(new Lec001(3)));
	System.out.println(set.add(new Lec001(4)));
	System.out.println(set.add(new Lec001(5)));
	System.out.println(set.add(new Lec001(6)));
	//System.out.println(set.remove(5));
	
	Object[] arr=set.toArray();
	System.out.println("["+((Lec001)(arr[0])).me+", "
			+((Lec001)arr[1]).me+", "
			+((Lec001)(arr[2])).me+", "
			+((Lec001)(arr[3])).me+", "
			+((Lec001)(arr[4])).me+", "
			+((Lec001)(arr[5])).me+"]");
	
	
}
}
