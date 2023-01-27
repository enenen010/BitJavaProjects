package com.bit;

import java.util.StringTokenizer;

public class Ex16 {
public static void main(String[] args) {
	String target="java,web,,framework";
	
	
	//빈문자열도 값으로봄                     -> ,,이면 추가  ""o
	String[] arr1=target.split(",");
	for(int i=0;i<arr1.length;i++) {
		System.out.println(arr1[i]);//i=4개
	}
	
	
	//빈문자열을 값으로 안봄(알아서제외) -> ,,추가 배열 없음  ""x
	StringTokenizer stk;
	stk=new StringTokenizer(target,",");//디폴트: " ","\t","\n"
	//자바최초부터제공되는건 벡터밖에 없었으니까
	while(stk.hasMoreTokens()) {
		System.out.println(stk.nextToken());//i=3개
	}
	
	//알아서 골라쓰자
	
}
}
