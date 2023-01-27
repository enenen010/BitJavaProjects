package com.bit;
import java.io.*;
public class Ex07 {
public static void main(String[] args) {
	File f=new File("lec06.bin");
	InputStream is=null;
	DataInputStream dis=null;
	try {
//		#주의사항 순세대로 읽어야함=>각각 자료형 안맞으면 안되니까
//		(바이트 끊어읽기도 첫단추잘못꿰면)
		if(f.exists()) {
			is=new FileInputStream(f);
			dis=new DataInputStream(is);
			int su1=dis.read();
			int su2=dis.readInt();
			double su3=dis.readDouble();
			char su4=dis.readChar();
			Boolean su5=dis.readBoolean();
			String msg=dis.readUTF();
			System.out.println(su1);
			System.out.println(su2);
			System.out.println(su3);
			System.out.println(su4);
			System.out.println(su5);
			System.out.println(msg);
		}
		if(dis!=null)dis.close();
		if(is!=null)is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
