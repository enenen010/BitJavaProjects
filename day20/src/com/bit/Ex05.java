package com.bit;

import java.io.*;

public class Ex05 {
public static void main(String[] args) {
//	파일은 변수같은 존재다 어디부터 어디까지가 101010이다라는 거에 이름붙인것뿐
	File f=new File("test04.txt");
	
	Writer fw=null;
	BufferedWriter bw=null;
	try {
		fw=new FileWriter(f);
		bw=new BufferedWriter(fw);
		bw.write("문자열1");
		
		//어차피문자열이라 개행기능 운영체제마다 다른데 알아서!!
//		bw.write("\r\n"); 윈도우
//		bw.write("\n");   그이외
		bw.newLine();
		
		
//		bw.flush(); 현재 버퍼에 담긴 데이터 한번에 출력, 
//		모든 close는 flush가 있어서 이때 밀어낸다.
		
//		flush는 그럼 언제? 통신할때 적당할때 밀어내야 상대방이 볼 수 있다
//		통신은 close안되고 연결되어있는 상태에서 데이터를 밀어야함
//		너무 자주 밀어내면 버퍼의 의미가 없다(애초에 반복 줄일려고 쓰는거)
//		너무 적게 밀어내면 상대방이 원할 때 볼 수 없다.
		
		bw.write("문자열2");
		
		
		if(bw!=null)bw.close();
		if(fw!=null)fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
