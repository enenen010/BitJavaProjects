package com.bit;

import java.util.Calendar;

public class Ex07 {
public static void main(String[] args) {
	Calendar cal=Calendar.getInstance();
	
	//날짜계산을 직접 만드는 것은  어려우므로 아래와 같은 것을 잘 활용 할 것
	System.out.println(cal.get(Calendar.DAY_OF_MONTH));//1월중 몇일째 29 30 31
	System.out.println(cal.get(Calendar.DAY_OF_YEAR));//1년중 몇일째 최대 365
	System.out.println(cal.get(Calendar.WEEK_OF_MONTH));//월중 몇주
	System.out.println(cal.get(Calendar.WEEK_OF_YEAR));//년중 몇주
	
	//각 월을 뜻하는 상수도 있음 사용하면 헷갈리지 않음
}
}
