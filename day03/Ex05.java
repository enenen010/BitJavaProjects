class Ex05
{
public static void main(String[] args)
{

	//제어문(조건문,반복문)
	//조건문
	
	// if문
	//if(boolean){}else if(boolean){}else{}
	
	//상황1
	int a=5;
	int input;
	a--;
	if(a<=5){ input=1234; }
	System.out.println(input);  //오류: else가 없기 때문에 맞더라도 input이 정해지지 않았다.

	/*switch문
	switch(값){
	case 값: break;
	...
	default:   else같은거
	#값에는 연산을 넣을 수 없다. 
	#모든 값들의 타입이 일치해야 한다 하나는 1 하나는 1.0 이거 안돼. 자료형다르면 비교자체를 못함
	#보통 비교연산자 비교하면 레퍼런스(주소값) 비교 메모리위치가 같으면 같은거
	  switch의 좋은점은 value값 비교를 해준다는거
	*/

}
}
	
	
	
	
	
	
	
	
	
	
	
	
	