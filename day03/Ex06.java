class Ex06
{
public static void main(String[] args)
{

	//문자열
	char ch1='A';
	String st1="문자열";
	System.out.println(ch1);
	System.out.println(sh1);
	String s2="문자";
	String s3="열";
	String s4=s2+s3+3;   //문자열의 편의성을 위해 자바에서 만든 기능 *이런거 안되
                                         뭐든지 문자열과 연산하면 무조건 문자열이 된다 true써도
	String s5=2000+22+"년"; //2022년 됨
	          //"년"+2000+22  //년200022 됨    자바가 문자열 위해 따로 만든 기능이기 때문
	          //"년"+2000*22  //년곱해진값 됨   우선순위 때문에 ()도 마찬가지

	System.out.println(sh1==sh2); //안정확함 주소를 비교함   
                                                 //swith문을 사용했을때 자동으로 equals비교라 문자열도ok
}
}