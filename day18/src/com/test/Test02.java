package com.test;

import java.io.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		
		System.out.println(Character.SIZE/Byte.SIZE);
		InputStream is;
		DataInputStream dis;
		BufferedInputStream bis;
		File f=new File("E:\\JAVA\\test\\intest1.txt");
		byte[] buf=new byte[4];
		
		
		if(f.exists()) {
			try {
				is=new FileInputStream(f);
				dis=new DataInputStream(is);
//				byte su=dis.readByte();
				//String su=dis.read;
				
				bis=new BufferedInputStream(is);
				int su2=bis.read(buf);
				int su3=buf[0];
				System.out.println(su3);
				
				
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			
			
		byte[] arr;
		
		
		
	}
}
