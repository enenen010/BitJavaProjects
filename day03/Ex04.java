class Ex04
{
public static void main(String[] args){
	int a,b;
	a=5;
	b=2;
	a=(+a);
	b=(-b);
	a=+a;
	b=-b;
	a++;
	b++;
	System.out.println(a*b);  //좌우양측 자료형이 동일해야 정확한 연산 가능(자동으로하면 정확도ㄷㄷ)
	System.out.println(a/b);
	System.out.println(a%b);
	System.out.println(a+b);
	System.out.println(a-b);
	System.out.println(a>b);   //좌우양측 자료형이 동일해야 정확한 비교 가능(자동으로하면 정확도ㄷㄷ)
	System.out.println(a>=b); //문자도 숫자라 비교가능
	System.out.println(a<b);
	System.out.println(a<=b);
	System.out.println(a==b);
	System.out.println(a!=b);

	boolean boo1=true;
	boolean boo2=false;
	System.out.println(boo1);
	System.out.println(boo2);
	System.out.println(!boo1);
	System.out.println(boo1&&boo2); //true나오면 더안해
	System.out.println(boo1||boo2);  //false나오면 더안해

	int x,y,z;
	x=3;
	x+=1;
	System.out.println(x);
	x-=1;
	System.out.println(x);
	x*=1;
	System.out.println(x);
	x/=1;
	System.out.println(x);
	x-=x+y  //x-(x+y)
	System.out.println(x);

	//byte m=2;
	//m=m+1;
	//System.out.println(m);  //불가
	byte n=2;
	n++;
	n+=2;
	System.out.println(n);    //가능
}
}