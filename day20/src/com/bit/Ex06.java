package com.bit;

import java.io.*;

public class Ex06 {
public static void main(String[] args) {
	File f=new File("");
	
	
	Reader fr=null;
	
	BufferedReader br=null;
	try {
		fr=new FileReader(f);
		br=new BufferedReader(fr);
		int su=-1;
		
//		while ((su=br.read())!=-1) {
//			System.out.println((char)su);
//		}
		
		//개행문자 전까지 읽어온다!!
//		System.out.println(br.readLine());
		
		String msg=null;
		while((msg=br.readLine())!=null) {
			System.out.println(msg);
		}
		
		if(br!=null)br.close();
		if(fr!=null)fr.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
