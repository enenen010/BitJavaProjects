package com.bit;

public class Quest02 {

	public static void main(String[] args) {
		/*
		 * 주민번호체크(ver 0.1.0) 주민번호>999933-239393 >테스트케이스 복붙 당신은 00살 여성입니다. >아웃풋 전부활용하자
		 * 
		 * 입력확인 바랍니다(000000-0000000)
		 * 
		 * 입력확인 바랍니다(앞자리6개 뒷자리7개입니다)
		 * 
		 * 입력확인 바랍니다(숫자를 입력바랍니다)
		 * 
		 */
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("주민번호 적거라(000000-0000000)>>");
		String inputMsg = sc.nextLine();
		
		
		char[] numHangleArr = new char[] {'영','일','이','삼','사','오','육','칠','팔','구'};
		
		for(int i=0;i<numHangleArr.length;i++) {
			inputMsg = inputMsg.replace(numHangleArr[i], (char)('0'+i));
		}
		

		String[] arr1 = inputMsg.split("-");
		if (inputMsg.indexOf('-') != 6) {
			System.out.println("입력확인 바랍니다(000000-0000000)");
		} else {
			if (arr1[0].length() != 6 && arr1[1].length() != 7) {
				System.out.println("입력확인 바랍니다(앞자리6개 뒷자리7개입니다)");
			}else {
				
				
				boolean notAllnumber = false; //주민번호는 영어가 절대 안들아간다. 
				for(int i=0; i<'A'-'z';i++) {
					if(inputMsg.indexOf(i+'A')==-1) {
						notAllnumber = true;
					}
				}
				if(notAllnumber) {
					System.out.println("입력확인 바랍니다(숫자를 입력바랍니다)");
				}else {
					int age = 2000 + ((inputMsg.charAt(0)-'0')*10+inputMsg.charAt(1)-'0');

					String gender = "";
					if (inputMsg.charAt(7) % 2 == 0) {
						gender = "여";
					} else {
						gender = "남";
					}
					if (inputMsg.charAt(7) > '2') {
						age -= 100;
					}
					System.out.println(inputMsg);
					System.out.println("당신은" + (2022-age) + "살 " + gender + "성입니다.");
				}
			}
		}

	}

}
