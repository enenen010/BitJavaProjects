package com.bit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Ex18 {
	public static void main(String[] args) {
//		File target = new File("Lec16.bin");
//		File result = new File("Lec18.bin");
		
		File target = new File("logo.jpg");
		File result = new File("copy.jpg");
		//이거 메모장으로 처리하면 바이너리데이터를 억지로
		//문자로 치환하는 프로그램이기에 문자로표현하는거임
		
		//단점:느림, 장점:느린것만 감수하면 모든걸 다할수있음

		InputStream is;
		OutputStream os;
		
		//파일이란게 어차피 저장공간임 덮어쓰기는 어디까지쓰고 
		//그 공간까지를 파일로 지정을 하는거니까 그렇게 보일뿐
		
		//한글제어 좀 골치아픔 1~3바이트 문자 섞여있음 
		//-> 바이트배열에 쌓아놨다가 문자열로 치환!!!!
		try {
			if (!result.exists()) {
				result.createNewFile();
				is = new FileInputStream(target);
				os = new FileOutputStream(result);
				while (true) {
					int su = is.read();
					if (su == -1)
						break;
					os.write(su);
				}
				is.close();
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Queue que=new LinkedList();
		

	}
}
