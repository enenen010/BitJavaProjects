package com.bit;

public class Ex07 {
public static void main(String[] args) {
	java.util.Stack stack;
	stack=new Stack();
	stack.push(1111);
	stack.push(2222);
	stack.push(3333);
	stack.push(4444);
	stack.push(5555);
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());//넘어가면 익셉션
	System.out.println(stack.pop());
	stack.peek();//보다
	
	//비었는지 아닌지
	//값 검색해서 위치(인덱스)까지는 알려줌
	//없으면 -1리턴
}
}
