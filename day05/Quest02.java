class Quest02{

static int a=1;
int b=1;

public static void main(String[] args){

	Quest02 q02 = new Quest02();
	//System.out.println(q02);
	//Quest03 q03 = new Quest03(555);
	//System.out.println(q03.a);
	q02.aaa(q02);
	
}

public void aaa(Quest02 q){
	System.out.println(q==this);
}
}


