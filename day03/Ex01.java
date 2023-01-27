class Ex01
{
public static void main(String[] args){
	int a;
	a=1234;
	a=0b00011;
	a=010;
	a=0xb;
	System.out.println(a);
	long b;
	b=1234111111111111L;         //L int
	b=a;
	//a=b;                       //error: overflow a
	int c=(int)b;
	System.out.println(b);
	System.out.println(c);
	byte d=127;
	d=-128;
	d=(byte)129;
	System.out.println(d);
}
}