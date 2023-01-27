package com.bit;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class Ex02 {
public static void main(String[] args) {
	InetAddress[] inets=null;
	try {
		//www없으면 국내에서 사용하는 도메인
		//중국에서 외국사이트 못들어가게 막을때 www못붙이게함
		inets=InetAddress.getAllByName("stackoverflow.com");
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
	
	for (int i = 0; i < inets.length; i++) {
		System.out.println(inets[i]);
	}
}
}
