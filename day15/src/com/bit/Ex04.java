package com.bit;

import com.bit.Outter02.Inner02;

class Outter04{
	static int su1=1111;
	int su2=2222;
	
	Outter04(){}
	
	//Outter에서 Inner의 접근은 애초에 불가능
	//지역변수 같은 포지션 메서드가 실행되어야 존재
	static void func01() {
		class Loc01{
			//static int su3=3333;//메서드가 있어야 존재하므로 static은 불가
			final static int su3=3333;
			int su4=4444;
//			static void func01() {};
			void func02() {
				System.out.println(su1);
				func01();
				Outter04 outt=new Outter04();
				System.out.println(outt.su2);
				outt.func02();//outt안붙이면 재귀
			};
			
		}
	}
	void func02() {
		int su5=5555;//jdk 1.8이상에서는 생략가능 그래서 안적어도 됨(final이긴 함)
		class Loc02{
			//static int su3=3333;//메서드가 있어야 존재하므로 static은 불가
			final static int su3=3333;
			int su4=4444;
//			static void func01() {};
			void func02() {
				Outter04 outt=new Outter04();
				System.out.println(su1);
				func01();
				System.out.println(su2);
				func02();
				
				//System.out.println(su5++); su5는 암묵적 final  
			}
		}
		System.out.println(su5);
		System.out.println(Loc02.su3);
	}
}
public class Ex04 {

}
