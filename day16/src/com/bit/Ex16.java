package com.bit;
import java.io.*;

public class Ex16 {
public static void main(String[] args) {
	
	//문자열
	String msg="한";
	byte[] 
	
	
	
	File f=new File("Lec16.bin");
	//스트림은 단방향 채널 일방적
	
	
	OutputStream os;
	//덮어쓰기, 이어쓰기 아님
	try {
		if(f.exists())f.createNewFile();
		os=new FileOutputStream(f);
		os.write(65); //-> 'A'
		os.write(66); //-> 'B'
		//메모장 기능이 바이너리데이터 문자로 표현하는거라 A,a로 나옴
		//우린 바이너리 데이터를 적었으니까
		//어차피 뭘적어도 숫자로 저장된다 나중에 뭘로 읽을지(utf8등)생각하며 결정
		
		os.close();//스트림은 통로 다쓰면 닫아야함
		System.out.println("작성완료");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {}
}
}
