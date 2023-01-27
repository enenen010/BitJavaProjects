class Ex04
{
public static void main(String[] args){ 
	//#1
	String massge1="\n#1\n";
	String massge2="\n";

	int i=0;
	while(i++<9){
		int j=0;
		while(j++<9){
			massge2 +=j+"x"+i+"="+(j*i)+"\t";
		}
		massge1 +=i+"단"+"\t";
		massge2 +="\n";
	}
	System.out.println(massge1+"\n----------------------------------------------------\n"+massge2);

	//#2
	i=0;
	int sum=0;
	while(i++<50){
		sum+=i;
	}
	System.out.println("\n#2 "+sum);


	//#3
	i=1;
	sum=0;
	while(i<=9){
		sum+=i;
		i+=2;
	}
	System.out.println("\n#3 "+sum);

	//#4
	i=3;
	massge1="#4 ";
	while(i<=50){
		massge1 += i+", ";
		i+=3;
	}
	System.out.println("\n"+massge1);

	//#5
	i=2;
	massge1="#5 ";
	while(i<=10){
		massge1 += i+", ";
		i+=2;
	}
	System.out.println("\n"+massge1);

}
}
