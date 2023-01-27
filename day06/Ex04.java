class Lec04{
	final int SU1=1111;
	final static int SU2=2222;
	
	public Lec04(int num){
    	System.out.println("객체 생성");
	SU1=num;
	SU2=num;
    } 
}

class Ex04{
	
	Lec04 you;
    you=new Lec03();

}