package com.bit;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex06 {
public static void main(String[] args) {
	java.util.List list;
	list=new ArrayList();
	list=new LinkedList();
	java.util.Queue que;
	que=new LinkedList(); //넣을수있고 뺄수있지만 중간에서 나오면 안되는 기능필요
	                         //-> ArrayList 불가, Link
	//익셉션던짐    특정한값던짐 : 원래 특정한값(에러싫어서)쓰다가 익셉션 객체 쓸일 생겨서 만듬
	//3개의 기능 2개(익셉션,값)씩 총 6개 기능
	que.offer(1111);
	que.offer(1111);
	que.offer(1111);
	que.offer(1111);
	System.out.println(que.poll());//뺌//없으면 null(특정한값)
	System.out.println(que.poll());
	System.out.println(que.poll());
	System.out.println(que.peek());//그냥 봄(값 안빠짐)
	
	while(que.peek()!=null) {
		System.out.println(que.peek());
		que.poll();
	}
	
	int cnt=0;
	while(que.peek()!=null) {
		System.out.println(++cnt);
		System.out.println(que.poll());
		System.out.println(que.poll());
		System.out.println(que.poll());
	}
	
	
	//Que인터페이스 사용 웹접속  => Que를 상속받았다? peek,poll,offer(+3)는 무조건 있다
	//사용자 동시처리못함 한명하는동안 나머진 기다려야됨 
	//->Queue 선입선출(먼저들어온애 처리할때까지 기다려->처리하고뺌)
	
	/*서비스 라는 것은 모든것을 할 수 있는 컴퓨터의 기능에서 "제한"을 하여 제공하는 것이다
	 * 
	 * 인터페이스: 자식에 어떤기능이 추가됐든 인터페이스를 통해서는 인터페이스에 있는 기능만
	 * 사용가능하므로 입출력 제한 소통이 가능!!!
	 */
}
}
