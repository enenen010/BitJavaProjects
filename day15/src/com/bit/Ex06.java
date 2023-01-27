package com.bit;

import java.util.*;

public class Ex06 {
	public static void main(String[] args) {
		// 날짜
		long time = System.currentTimeMillis();// 계산빡셈
		// 날짜와 관련해선 전산은 정확할수 없음 -> 하나더껴있는 자바는 더 그럼 ->매버전마다 날짜 기능 새로 생김
		// 이건 기본적인거

		// 캘린더 : 추상클래스->객체생성안됨->인스턴스받는형식(get Instence()받음)
		Calendar cal;
		cal = Calendar.getInstance();
		System.out.println(cal.get(0));// 1
		System.out.println(cal.get(1));// 2022
		System.out.println(cal.get(2));// 11
		System.out.println(cal.get(3));// 53
		System.out.println(cal.get(4));// 5
		System.out.println(cal.get(5));// 26
		System.out.println("============================================");

		// API문서보면 위에꺼 상수로해서 가시성
		cal = Calendar.getInstance();//받을때마다 바뀜
		System.out.println(cal.get(Calendar.YEAR));// 2022
		// MONTH 1~12 0~11
		System.out.println(cal.get(Calendar.MONTH + 1));// 11
		System.out.println(cal.get(Calendar.DATE));// 26
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		
		
		switch (cal.get(cal.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일");
			break;
		}
		
		switch (cal.get(cal.AM_PM)) {
		case Calendar.AM:
			System.out.println("오전");
			break;
		case Calendar.PM:
			System.out.println("오후");
			break;
		}
		
		
		//중복되는 상수가 많음
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		
		System.out.println(cal.get(Calendar.AM_PM)*12
				+cal.get(Calendar.HOUR));

	}
}
