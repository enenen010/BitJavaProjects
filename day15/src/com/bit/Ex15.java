package com.bit;
import java.util.*;

public class Ex15 {
public static void main(String[] args) {
	Random ran=new Random();
	
	
	System.out.println(ran.nextInt());
	System.out.println(ran.nextDouble());
	
	System.out.println(ran.nextInt(45));//범위제약
	
	//뭔가 일정한 느낌->비슷한 시간이라면 비슷한 인풋
	System.out.println(ran.nextInt());
	System.out.println(ran.nextInt());
	
	//좀 나아진 느낌
	ran=new Random(435343);//이숫자 이용해서 좀더 복잡하게
	System.out.println(ran.nextInt());
	System.out.println(ran.nextInt());
}
}
