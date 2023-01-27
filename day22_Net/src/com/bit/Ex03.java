package com.bit;

import java.net.*;

public class Ex03 {
public static void main(String[] args) {
	//url vs uri
	// 프로토콜://도메인:포트번호/경로/../경로?쿼리스트링#앵커[ref]
	
	//웹 기본 http프로토콜, 우리나라 개인정보다루는데서만 https 법규지정 했는데
	//성능 별 차이 없고 여러개쓰기 뭐해서 https 쓰게됨
	//https 인증서 받아서 하는 개념>가끔 인증되지 않은 사이트입니다 돈안내서 인증풀린거
	java.net.URL url=null;
	
	try {
		url=new URL("https://getbootstrap.com/docs/3.4/components/");
		System.out.println("Protocol:"+url.getProtocol());
		System.out.println("Host:"+url.getHost());
		
//		프로토콜 별로 사용하는 디폴트 포트 정해져 있음 http,https,ftp
//	 	이프로토콜 쓰면서 다른 포트를 쓰고싶을땐 포트 명시적, 안쓰면 자동 디폴트
		System.out.println("Port:"+url.getPort());
		System.out.println("DefaultPort:"+url.getDefaultPort());
		
		System.out.println("Path:"+url.getPath());
		
//		사용자 측에서 서버(페이지)에게 전달하는 정보(클라이언트->서버)
		System.out.println("Query:"+url.getQuery());
		
//		현재 페이지 내에서 찾는 특정한 정보를 서버에 전달하는 정보(//) ex>Top하면맨위로감
		System.out.println("Ref:"+url.getRef());
		
		System.out.println("File:"+url.getFile());
//		System.out.println(""+url);
//		System.out.println(""+url);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}
}
