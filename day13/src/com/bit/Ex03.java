package com.bit;
class Node{
	int val;//담을 값
	Node nxt;//자기자신을 담을수 있는 참조변수
}

class Arr2{
	Node first;
	int cnt=0;
	
	int get(int idx) {
		//start.val;
		//start.nxt.val;
		//start.nxt.nxt.val;
		Node temp=first;
		for(int i=0; i<idx; i++) {
			temp=temp.nxt;
		}
		return temp.val;
	}
	
	void Add(int su){
		
		cnt++;
		Node node=new Node();
		node.val=su;
		if(cnt==1) {
			first=node;
		}else {
			Node temp=first;
			while(true) {
				if(temp.nxt==null)break;
			}
			temp.nxt=node;
		}
		
		
		
//		//1.
//		Node node = new Node();
//		node.val = su;
//		first = node;
//
//		// 2.
//		Node node = new Node();
//		node.val = su;
//		first.nxt = node;
//
//		Node node = new Node();
//		node.val = su;
//		first.nxt.nxt = node;
	}
}

public class Ex03 {

	public static void main(String[] args) {
		Arr2 arr=new Arr2();
		arr.Add(1111);
		arr.Add(1111);
		arr.Add(1111);
		arr.Add(1111);
		
		for(int i=0; i<arr.cnt;i++) {
			System.out.println( arr.get(i));
		}
	}

}
