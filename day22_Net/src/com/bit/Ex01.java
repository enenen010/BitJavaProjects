package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01 {
public static void main(String[] args) {
	java.net.InetAddress addr1=null;
	
	try {
		//국내 DNS는 3대통신사
		//해외는 구글 등
		addr1=InetAddress.getByName("naver.com");
		
		System.out.println(addr1.getHostName());//도메인
		System.out.println(addr1.getHostAddress());//IP
		byte[] arr1= {(byte)223,(byte)130,(byte)195,(byte)95};//IP1칸당 1바이트
		byte[] arr2= {127,0,0,1};//IP1칸당 1바이트
		String arr3= "localhost";//IP1칸당 1바이트		
		addr1=InetAddress.getByName("127.0.0.1");
		//IPv4:우리가 알고있는거 1바트 4개 체계
		
		
		System.out.println(Arrays.toString(addr1.getAddress()));
		System.out.println(addr1.getHostAddress());
		
		
		//각 컴퓨터의 hosts파일에 마킹되어있으면 굳이 DNS안찾고 여기서 찾아감
		//자주 찾는 사이트
		//hosts파일 위변조 공격=>피싱사이트(이젠 잘안통함), 개인 PC
		
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
}
}
