package com.bit;
//다중상속은 자바에서 의미를 두고 막았지만 사실 실패

/*
 * 상속하는 이유
 * 1. 코드의 재사용(상위기능의 재사용) = 간단하게 시작해 복잡하게
 * 2. 추상화 : 한 클래스를 사용할 때 부모클래스 기능까지 자동으로 사용된다는 것은
 *           클래스간의 관계성을 코드로 나타낼 수 있다는 뜻임
 *           
 * 
 */

class Lec04{
	public void func01() {
		System.out.println("Lec04 func01 기능 실행");
		
	}
}

public class Ex04 extends Lec04{

	      
	public String toString() {
		return "나야나";
	}
	
	//기능은 없음, 다다른데 @Override는 컴파일러가 해석을 함   
	//@Override는 오버라이드 문법 안지킬시 강제로실패시킴
	//메서드가 등장하고 나중에 등장한 기능들은 기존 문법과 맞지않는 경우가 발생
	//Override가 대표적, 부모에게서 상속된 메서드를 오버라이드 할때
	//부모에게 없는 오버로드를 하거나 없던 static이 붙는 등 
	//메서드의 문법에 추가해야 되는 경우가 생김, 이걸 바꿀수는 없었음
	//그래서 부랴부랴 추가한 기능.
	@Override   
	public void func01(int a) { //부모꺼 오버로드
		System.out.println(a);
		
	}
	public static void main(String[] args) {
		// 오버라이드: 전역변수보다 지역변수가 우선되듯이 같은 메서드면 부모보다 자식것이 우선되는거 
		// 제약사항: 접근제한자는 같거나 보다 열리는 방향으로만 허용
		
		// 
		Ex04 me=new Ex04();
		Ex04 you=new Ex04();
		
		System.out.println(me==you);
		System.out.println(me.equals(you));
		
		me.func01(1);
		
		//value값이 없는 객체가 더 많다
		//me.equals() 기능을 안만들어놈 => String등에만 만들어놈  =>우리도 오버라이딩!
		//참조변수는 원래 값비교란것이 불가, Object.equals()는 기본적인 참조변수에 어떤기준을 가지고 비교를 한다
		//기준? 값!!  문자열=문자-기준 compareTo 등으로 비교해 반환한다.
	}

}
