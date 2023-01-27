package com.bit;
import java.util.*;
import java.io.*;
public class Ex20 {
public static void main(String[] args) throws FileNotFoundException {
	File f=new File("");
//	InputStream is=new FileInputStream(f);  //System.in;	
//	Scanner sc=new Scanner(is);
	Scanner sc=new Scanner(f);//오버로드의 위대함;;
	
	while(sc.hasNext()) {
		String msg=sc.next();//공백기준
		System.out.println(msg);
	}
	
//	String msg=sc.next();//공백기준
//	System.out.println(msg);
//	msg=sc.next();//공백기준
//	System.out.println(msg);
	
	
	
}
}
