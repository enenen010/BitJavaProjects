package com.bit;

public class Quest01 {

	public static void main(String[] args) {
		/*
		 * 주민번호체크(ver 0.1.0)
		 * 주민번호>999933-239393          
		 * 당신은 00살 여성입니다.               
		 * 
		 * >2187219871239 (-없으면)
		 * 입력확인 바랍니다(000000-0000000)
		 * 
		 * 입력확인 바랍니다(앞자리6개 뒷자리7개입니다)
		 * 
		 * 입력확인 바랍니다(숫자를 입력바랍니다)
		 * 
		 */
		
		System.out.println("주민번호체크(ver 0.1.0)");
		
		
		while(true) {
			
			System.out.print("주민번호>");
			java.util.Scanner sc = new java.util.Scanner(System.in);
			String input = sc.nextLine();
			
			if(input.length()<6 || input.charAt(6)!='-') {
				System.out.println("입력확인 바랍니다(000000-0000000)");
				continue;
			}
			
			String[] str = input.split("-");
			if(str[0].length()!=6 || str[1].length()!=7 || str.length!=2) {
				System.out.println("입력확인 바랍니다(앞자리6개 뒷자리7개입니다)");
				continue;
			}
			
			
			boolean boo=false;
			for(int i=0;i<input.length();i++) {
				if(i!=6) {
					int flag="0123456789".indexOf(input.charAt(i));
					if(flag==-1) {
						boo=true;
						break;
					}
				}
			}
			 
			if(boo) {
				System.out.println("입력확인 바랍니다(숫자를 입력바랍니다)");
				continue;
			}
			
			int age= 2000 + Integer.parseInt(input.substring(0,2));
			if(input.charAt(7)<'3') age-=100;
			age= 2022-age;
			
			String gender="남성";
			if(input.charAt(7)=='2'||input.charAt(7)=='4') {
				gender="여성";
			}
			System.out.println("당신은 "+age+"살 "+gender+"입니다.");
			
		}

	}

}
