class test01{
	test011 t011;    //test011,test01 앞에 static이 없기때문에 메모리에 없는 상태이므로 
	static test01 t01;        //그럼 인스턴스를 찍어내기위한 non-static은 어디에 존재하는가
                                                    //클래스가 메모리에 올라올때
	int a=1;
	static int b=1;
	
	public static void main(String[] args){
		func01();
		//t01.func02();     //오류
		test011.func03();
		//t011.func04();   //오류
	}
	
	public static void func01(){
		System.out.println("01 스태틱 소환");
		System.out.println(t01);
		System.out.println(b);
		System.out.println(test01);
	} 
	public void func02(){
		System.out.println("02 논스태틱 소환");
	} 
}


class test011{
	public static void func03(){
		System.out.println("03 스태틱 소환");
	} 
	public void func04(){
		System.out.println("04 논스태틱 소환");
	} 
}

/*
클래스랑 static은 관련없다 => 
static영역에는 프로그램 시작전에 올려둘 데이터(필드,메서드 등) 목록을 런타임 전에 올려두는 JVM 메모리 공간이다.
클래스로더는 프로그램 실행후(런타임)에 호출되는 클래스를 검색해 클래스영역에 로드하는 것이기에 static영역과는 다르다
static영역이 클래스영역에 포함되어 있지만 엄연히 기능이 구분되어있음
static영역 != 클래스영역 아예 다른애였음 

JVM은 stack에서만 일한다 나머지 힙, 메소드영역은 저장소

클래스영역, 메서드영역, static영역 = 이름이 많다, 얘네들이 다 올라오기 때문이다.

static -> static		[클래스명.]변수명;   
static -> non-static		참조변수.변수명;    static에서 non-static호출 => non-static은 호출시 참조변수 필요
non-static -> static		[클래스명.]변수명;
non-static -> non-static	[참조변수.]변수명;

주소값대신 클래스@해시값으로 비교만 가능하도록함(주소는모름)
*/