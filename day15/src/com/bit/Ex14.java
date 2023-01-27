package com.bit;
import java.util.*;
public class Ex14 {
public static void main(String[] args) {
	//왜 Scanner 이름일까?
	//System.in
	java.io.InputStream inn=System.in;
	Scanner sc;
	//sc=new Scanner(inn);
	sc=new Scanner("abcd\nefg\nhij\nk");
	//생성자에 소스를 넣어주면 들어온걸 스캐닝 해주는거
	//거기다 system.in 
	
	
	//특정 문자를 기준으로 한개씩 읽음 next...은 특정 문자 기준이 다름
	System.out.println(sc.nextLine());//개행만을 기준
	//사실 IO랑 상관없이 소스 넣었을때 스캐닝 해주는 거
	//IO에서 쉽게쓸라고 얘를 활용하는거뿐
	
	//기준은 같으나 읽는게 다른 둘...
	sc=new Scanner("12 34\n56");//int아니면 Exception
	System.out.println(sc.nextInt());//개행,탭,공백등으로 int값 하나를 구분
	
	sc=new Scanner("abcde");//char아니면 Exception
	System.out.println(sc.nextInt());//개행,탭,공백등으로 char값 하나를 구분
	//더 없는데 next하면 Exception
	
	//기본
	sc.next();
	sc.hasNext();//다음값이 있니?
	
	//활용-> 편할라고
	sc.nextInt();//읽은걸 parseInt하면 이거
	sc.nextLine();//개행할 때까지 읽으면
	sc.nextDouble();//읽은걸 parseDouble하면 이거
	sc.hasNextInt();//다음값 검사를 int기준으로
	//등등
}
}
