package com.bit;

import java.io.*;

public class Ex01 {
	// Ex01, Ex02 만 있으면 사실 IO의 모든 퍼포먼스가 가능
	// 이 뒤에 나오는 기능은 성능이나, 편의성을 위해 나옴
	// 불편하면 안쓰면된다 이걸 일단 마스터 -> 걸어도 서울은 갈수있다 늦는다고 생각하면 뛰는거 일단 걷자
	// IO는 클래스가 많아서 고르기 힘들어요ㅠㅠ -> 다 Ex01,02로 만들었다 일단 이거 나머진 정수기필터 바이트 걸러주는거
	public static void main(String[] args) {
		String msg = "abcdefghi jklmn";
		File f = new File("Lec01.bin");

		OutputStream os;

		if (f.exists())
			try {
				f.createNewFile();
				os = new FileOutputStream(f);

				for (int i = 0; i < msg.length(); i++) {
					os.write(msg.charAt(i));
				}

				os.close();
				System.out.println("작성완료");
			} catch (IOException e) {
				e.printStackTrace();
			}

		// 실패
//		String msg="abcd n";
//		byte[] buf=new byte[2];
//		File f=new File("Lec01.bin
//
//		Output
//
//				if(f.)f.create
//
//				os=new fileoutput
//
//				for(int i=0; msg.leng;i+=2) {
//					buf[i]=(byte)msg.charAt(i);
//				}
//				os.write(msg.charAt(i)
//
//				os.close
//				syso 작성완료
	}
}
