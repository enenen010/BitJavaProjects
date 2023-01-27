import java.util.Scanner;

class Ex07
{
public static void main(String[] args)
{
	Scanner in = new Scanner(System.in); // Scanner 객체 생성
	String flag1= " ";	
	int allsum = 0;

	System.out.println("영수증 이름을 입력하시오");	
	String name = in.nextLine();
	String massge="\n---------------------------------------------";
	massge += "\n"+name+" 영수증";
	massge +="\n---------------------------------------------";
	massge +="품목\t\t정가\t수량\t금액";
	massge +="\n---------------------------------------------";

	while(!flag1.equals("y")){

		System.out.println("품목 정가 수량, 공백으로 구분하여 입력하시오");
		String values = in.next();
		String[] strArr = new String[3];
		strArr = values.split(" ");

		int price = Integer.parseInt(strArr[1]);
		int number = Integer.parseInt(strArr[2]);
		int sum1 = price*number;
		allsum += sum1;

		massge +="\n"+strArr[0]+"\t\t"+price+"\t"+number+"\t"+sum1;

		System.out.println("그만입력하시겠습니까? 맞으면 y 아니면 아무키");
		String flag0 = in.next();
		flag1 = flag0;
	}
	massge +="\n---------------------------------------------";
	massge +="합계:\t\t\t\t"+allsum;
	System.out.println(massge);	
}
}