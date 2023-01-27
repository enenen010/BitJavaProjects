class Quest01{
	public static void main(String[] args){
    	
	java.util.Scanner sc=new java.util.Scanner(System.in);
        
        System.out.print("첫 값입력: ");
        int a1 = sc.nextInt();
        System.out.print("둘째 값입력: ");
        int a2 = sc.nextInt();
        System.out.print("1.+, 2.-, 3.x, 4./: ");
        int flag = sc.nextInt();
        
        Calculator cal = new Calculator();
        System.out.println(a1+" "+cal.calFlag+" "+a2+" = "+(cal.Calculation(a1,a2,flag)));
        
    }
}

class Calculator{
    char calFlag='c';
    
    public String Calculation(int a, int b, int flag){
    	switch(flag){
        	case 1:
            	calFlag='+';
            	return a + b+"\n";
            case 2: 
            	calFlag='-';
                return a - b+"\n";
            case 3: 
            	calFlag='x';
                return a * b+"\n";
            case 4: 
            	calFlag='/';
                return (a*1.0)/b+"\n";
        }
        System.out.println("입력값이 잘못되었습니다.");
        return "error"+"\n";
    }
}

/*순서가 아닌 공통점을 고려 (절차지향과의 차이)

계산기 숫자2개를 입력받고 1234에 따라 더하기,빼기,곱하기,나누기를 진행하는 계산기.

절차지향
1.숫자를 입력받는다
......

객체지향
- 고려할 객체= 계산기
- 계산기의 속성 = 첫번째 입력값, 두번째 입력값, 사칙연산플래그
- 계산기의 기능 = 플래그에 따른 사칙연산.

*/