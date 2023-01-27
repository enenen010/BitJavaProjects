class Quest01{
	public static void main(String[] args){
//01. A~Z까지 출력하시오
//02. A(a)~Z(z)까지 출력하시오
		String qm1="\n";
        String qm2="\n";
        for(int i=0; i<'Z'-'A'+1;i++){
        	qm1+=((char)(65+i))+", ";
            qm2+=((char)(65+i))+"("+((char)(97+i))+")"+", ";
        }
        System.out.print(qm1);
        System.out.print(qm2);


/*03. 다음을 출력하시오
1 2 3
4 5 6
7 8 9
*/
/*04. 다음을 출력하시오
1 2 3
2 3 4
3 4 5
*/
/*05. 다음을 출력하시오
■ ■ ■
■ ■ ■
■ ■ ■
*/
	String qm3="\n";
    String qm4="\n";
    String qm5="\n";
    int q4num = 0;
    
	for(int i=1; i<10; i++){
    	qm3+=i+" ";
        qm4+=q4num+" ";
        qm5+="■ ";
    	if(i%3 == 0){
        	qm3+="\n";
            qm4+="\n";
            q4num-=2;
            qm5+="\n";
        }
    	q4num++;
    }
    System.out.print(qm3);
    System.out.print(qm4);
    System.out.print(qm5);
    }
}

