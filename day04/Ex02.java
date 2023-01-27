class Ex02
{
public static void main(String[] args){ 
	String massge1="\n";
	String massge2="\n";
	for(int i=1; i<=9; i++){
		for(int j=1; j<=9; j++){
			massge2 +=j+"x"+i+"="+(j*i)+"\t";
		}
		massge1 +=i+"단"+"\t";
		massge2 +="\n";
	}
	System.out.println(massge1+"\n----------------------------------------------------\n"+massge2);
}
}
