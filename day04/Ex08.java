class Ex08{
public static void main(String[] args){

	int win=0;
	int fail=0;
	int drow=0;

	String manuMessage = "\n가위,바위,보 게임(ver 0.1.0)\n 게임을 시작합니다.";
	System.out.println(manuMessage);

	boolean endflag=true;
	while(endflag){

	//입력받기 위한 준비
	java.util.Scanner sc=new java.util.Scanner(System.in);
	System.out.print("\n1.가위 2.바위 3.보 0.종료 ?");
	//숫자입력받음
	int userFlag=sc.nextInt();
	
	//랜던값
	int comFlag;
	comFlag= ((int) (Math.random()*100) % 3)+1;
	
	if(userFlag == 0){
		System.out.println("\n"+win+"승"+drow+"무"+fail+"패");
		System.out.println("\n이용해주셔서 감사합니다.");
		endflag=false;
	}else{
		String message2 = "\ncom: "+RSP(comFlag)+"\nyou: "+RSP(userFlag);
		System.out.println(message2); 
	if(userFlag == 1){
		if(comFlag==1){
			System.out.println("\n비겼습니다.");
			drow++;
			}
		if(comFlag==2){
			System.out.println("\n졌습니다.");
			fail++;
			}
		if(comFlag==3){
			System.out.println("\n이겼습니다.");
			win++;
			}	
	}else if(userFlag == 2){
		if(comFlag==1){
			System.out.println("\n이겼습니다.");
			win++;
			}
		if(comFlag==2){
			System.out.println("\n비겼습니다.");
			drow++;
			}
		if(comFlag==3){
			System.out.println("\n졌습니다.");
			fail++;
			}
	}else if(userFlag == 3){
		if(comFlag==1){
			System.out.println("\n졌습니다.");
			fail++;
			}
		if(comFlag==2){
			System.out.println("\n이겼습니다.");
			win++;
			}
		if(comFlag==3){
			System.out.println("\n비겼습니다.");
			drow++;
			}
	}else{System.out.println("\n잘못된입력입니다.");}
	}
	}
	
}
public static String RSP(int num){
	switch(num){
		case 1: return "가위";
		case 2: return "바위";
		case 3: return "보";
		default: return " ";
	}
}
}