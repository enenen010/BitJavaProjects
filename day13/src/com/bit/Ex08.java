package com.bit;

import java.util.LinkedList;

public class Ex08 {
public static void main(String[] args) {
	//스택 큐 동시에
	java.util.Deque que; //Deque자리에 ArrayQueue(Deque상속)
	                      
	que=new LinkedList();
	
	//넣고 양쪽에서 넣고 뺄수 있음 반대쪽에서 빼면큐,내쪽빼면 스택
	//큐를 상속 -> 기능 추가
	//앞(입,출,봄),뒤(입,출,봄) * 2(익셉션,값)
	
	que.offerFirst(1111);
	que.offerFirst(2222);
	que.offerFirst(3333);
	//queue
	System.out.println(que.pollLast());
	//stack
	System.out.println(que.pollFirst());
	
	que.offerLast(1111);
	//stack
	System.out.println(que.pollLast());
	//queue
	System.out.println(que.pollFirst());
}
}
