package com.bit;

public class Quest02 {

	public static void main(String[] args) {
		/*
		 * 주민번호체크(ver 0.1.0)
		 * 주민번호>999933-239393            >테스트케이스                              복붙
		 * 당신은 00살 여성입니다.               >아웃풋        전부활용하자              코딩시
		 * 
		 * >2187219871239 (-없으면)
		 * 입력확인 바랍니다(000000-0000000)
		 * 
		 * 입력확인 바랍니다(앞자리6개 뒷자리7개입니다)
		 * 
		 * 입력확인 바랍니다(숫자를 입력바랍니다)
		 * 
		 * 
		 * =============================
		 * 
		 * => 이 아웃풋을 이용해서 결과를 먼저만든다   => 아웃풋에서부터 다가가서 엮는다
		 * 
		 * 주민번호체크(ver 0.1.0)
		 * System.out.print("문자열 입력받겠습니다");
		 * 
		 * 
		 * 주민번호>999933-239393
		 * <입력받은 문자열이 문자 배열로 나뉠거라는 것은 알고있다>   =>컴퓨터는 계산기다 계산 어렵다 싶으면 때려라
		 * 
		 * 
		 * 
		 * => 프로그램은 무조건 요구사항과 같이 만들어야한다.  바이트 3정도면 영어숫자는아니니까 한글로치자 이런타협안됨   무조건 한글만나오도록 if문
		 * 
		 * 아웃풋을 읽고 그대로 코드로 변역하는 느낌
		 * 
		 * 
		 * 
		 * 당신은 00살 여성입니다.
		 * System.out.print("당신은 00살 여성입니다.");
		 * if(arr1[7]%2!=0){gender="남"}
		 * else if(arr1[7]%2!=0){gender="여"}   
		 * int age= 2022-(1900+(a[0]-'0')*10+(a[1]-'0');      //어차피 사칙연산은 int 된다.
		 * 추가작성필요
		 * 
		 * >2187219871239 (-없으면)
		 * 입력확인 바랍니다(000000-0000000)
		 * System.out.print("입력확인 바랍니다(000000-0000000)");
		 * 추가작성필요
		 * 
		 * 
		 * 입력확인 바랍니다(앞자리6개 뒷자리7개입니다)
		 * System.out.print("입력확인 바랍니다(앞자리6개 뒷자리7개입니다)");
		 * 추가작성필요
		 * 
		 * 
		 * 입력확인 바랍니다(숫자를 입력바랍니다)
		 * System.out.print("입력확인 바랍니다(숫자를 입력바랍니다)");
		 * 추가작성필요
		 * */
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String test1 = "0";
		byte[] arr1 = test1.getBytes();
		
		System.out.println(arr1.length);
		//=======
		boolean boo1 = true;
		while(boo1){
			System.out.print("문자열 입력받겠습니다");
			String msg=sc.nextLine();
			
			char[] arr01 = msg.toCharArray();
			
			String sx = "남성";
			boolean notflag45= false;
			boolean notnumval= false;
			boolean allisnumber= true;
			for(int i=0; i<arr01.length; i++) {
				if(arr01[i]=='-') {
					notflag45=true;
					if(i==6&&arr01.length==14) {
						notnumval=true;
					}
				}
				if(i==7) {
					if(arr01[i]=='2') { sx = "여성";}
				}
				boolean isnumber= false;
				for(int j=0;j<11;j++) {
					int anum= '0'+j;
					if(arr01[i]==anum || arr01[i]=='-') {isnumber=true;}
				}
				allisnumber = isnumber && allisnumber;
			}
			
			
			if(!notflag45) {
				System.out.println("입력확인 바랍니다(000000-0000000)");
			}else if(!notnumval) {
				System.out.println("입력확인 바랍니다(앞자리6개 뒷자리7개입니다)");
			}else if(!allisnumber) {
				System.out.println("입력확인 바랍니다(숫자를 입력바랍니다)");
			}else{
				int as=((int)(arr01[0]-'0'+1)*10)+((int)(arr01[1]-'0'+1));
				if(as>22) {
					as+=1900;
				}else {
					as+=2000;
				}
				System.out.println("당신은 "+(2022-as)+"살 "+sx+"입니다.");
			}
			
			java.util.Scanner sc2 = new java.util.Scanner(System.in);
			System.out.print("계속 하시겠습니까? 아니오=0 예=아무키");
			int msg2=sc2.nextInt();
			if(msg2==0) {boo1=false;}
		}
		
	}

}
