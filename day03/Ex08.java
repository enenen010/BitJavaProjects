import java.util.Scanner;

class Ex08
{
public static void main(String[] args)
{
	Scanner in = new Scanner(System.in); // Scanner 객체 생성

	System.out.println("성적을 입력해주세요(국어 영어 수학 공백구분)");	
	String values = in.nextLine();
	String[] strArr = values.split(" ");

	int g = Integer.parseInt(strArr[0]);
	int y = Integer.parseInt(strArr[1]);
	int s = Integer.parseInt(strArr[2]);

	char rank = ' ';

	switch((g+y+s)/3/10)
	{
	case 10 : case 9 : rank = 'A';
		break;
	case 8 : rank = 'B';
		break;
	case 7 : rank = 'C';
		break;
	case 6 : rank = 'D';
		break;
	default: rank = 'F';
		break;
	}

	String massge="\n학생성적관리프로그램(ver 0.1.0)";
	massge +="\n---------------------------------------------";
	massge +="\n국어: "+g+", 영어: "+y+", 수학: "+s;
	massge +="\n---------------------------------------------";
	massge +="\n합계: "+(g+y+s)+", 평균: "+((g+y+s)*1000000/3/1000000.0)+" (소수점둘째자리까지)";
	massge +="\n---------------------------------------------";
	massge += "\n학점: "+rank+"\n\n";

	massge += "\n학점은\tA 90이상~100\n";
	massge += "\tB 80이상~90미만\n";
	massge += "\tC 70이상~80미만\n";
	massge += "\tD 60이상~70미만\n";
	massge += "\tF 60미만\n";
	System.out.println(massge);	

}
}