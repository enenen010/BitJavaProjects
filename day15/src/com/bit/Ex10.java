package com.bit;
import java.util.*;
public class Ex10 {
public static void main(String[] args) {
	//오래됐음 = 제약많음 ->못없앰 너무많이써서
	Date dat;
	dat=new Date();
	dat=new Date(2002-1900,5-1,1);
	dat=new Date(102017800000000L);
	System.out.println(dat);
	
	
	dat.setYear(2002-1900);
	dat.setMonth(5-1);
	
	System.out.println(dat.getTime());
	//1900년기준 (1970 1월1일이 아니라) 
	System.out.println(dat.getYear()+1900);
	System.out.println(dat.getMonth()+1);
	System.out.println(dat.getDate());
	System.out.println(dat.getHours());
	System.out.println(dat.getMinutes());
	System.out.println(dat.getSeconds());
}
}
