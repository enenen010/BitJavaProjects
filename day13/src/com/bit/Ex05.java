package com.bit;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex05 {
	public static void main(String[] args) {
		//Array, LinkedList 의 기능이 같을 수 있는이유 List인터페이스를 상속해서
		LinkedList list = new LinkedList(1); // 해도 버퍼는 알아서
		System.out.println(list.add(1111));
		list.add(1111);
		list.add(1111);
		list.add(1111);
		ArrayList list2 = new ArrayList();
		list.add(1111);
		list.add(1111);
		list.add(1111);
		}
}
