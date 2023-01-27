class Ex03
{
public static void main(String[] args)
{
	double su1;
	su1=3.14;
	System.out.println(su1);
	float su2;
	//su2=3.14;   
	su2=(float)3.14;
	su2=3.14F;  //f
	System.out.println(su2);
	su2=3.0000000000001F;
	su1=3.0000000000001;
	System.out.println(su2);
	System.out.println(su1);

	su1=1234;
	su2=1234;
	su1=1234L;
	su2=1234L;   //됨 표현범위자체가 넓어서?
}
}