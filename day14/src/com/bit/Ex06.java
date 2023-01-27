package com.bit;

class Lec06 {
	private Lec06() {
	}// 객체 생성불가

//	public Lec06 newInstanse() {	
//	}

	//싱글톤
//  private static Lec06 me=new Lec06();//객체 돌려막기->싱글톤
//	public static Lec06 newInstanse() {//객체를 생성자론 못만들때 이렇게 만드는 방법
//		Lec06 me=new Lec06();
//		return me;
//	}

	
	//1.
//	public static <T> T newInstanse() {
//		T me = new T();//얘가 디폴트 생성자가 없을수도 있는데?
//		return me;
//	}
	
	//2.
	public static <T> T newInstanse(T t) {
		T me = t;//얘가 디폴트 생성자가 없을수도 있는데?
		return me;
	}
}

class Lec66{//  T결정     Box는T
	public static <T> Box<T> newInstanse(T t) {
		Box<T> box=new Box<T>();
		box.setSu(t);
		return box;
	}
}

public class Ex06 {
	public static void main(String[] args) {
                              //↓생략
      //Box<String>box=Lec66.<String>newInstanse("abcd");
		Box<String>box=Lec66.newInstanse("abcd");
		Stirng msg=box.getSu();
		System.out.println(msg);
		
		int[] a= {1,2,3};
		int[] b;
//		b= {1,2,3}; //에러 이게 int인지 모른다
		b= new int[] {1,2,3};

	}
}
