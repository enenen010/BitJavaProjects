package com.bit;

public class Ex07 {

	public static void main(String[] args) {
		boolean boo1=true;
		Boolean boo2=new Boolean(true);
		Boolean boo3=new Boolean("true");
		Boolean boo4=new Boolean("TRUE");
		Boolean boo5=new Boolean(Boolean.TRUE);
		
		boolean boo6=Boolean.getBoolean("true");
		System.out.println(boo4.compareTo(boo3));//0-1=-1,1-0=1,0-0=0
		System.out.println(boo4);
	}
}
