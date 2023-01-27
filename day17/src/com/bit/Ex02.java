package com.bit;

import java.io.*;

public class Ex02 {
	public static void main(String[] args) {
		//버퍼 안들어 갔을때가 기본 
		//버퍼넣어서 뒤의 모든 필터가 만들어짐
//		File f = new File("Lec01.bin");
//		InputStream is;
//		
//		try {
//			if (f.exists()) {
//				is = new FileInputStream(f);
//				while (true) {
//					int su = is.read();
//					if (su == -1)
//						break;
//					System.out.print((char) su);
//				}
//				if (is != null)
//					is.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
		
//		File f = new File("Lec01.bin");
//		InputStream is;
//		byte[] buf=new byte[2];
//		try {
//			if (f.exists()) {
//				is = new FileInputStream(f);
//				while (true) {
//					int su = is.read(buf);//2개씩읽을때 공백있으면 이전값
//					if (su == -1)break;
////					for(int i=0;i<buf.length;i++)
//					for(int i=0;i<su;i++)
//					System.out.print((char)buf[i]);
//				}
//				if (is != null)
//					is.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
		
		//예전 빨리 복사해주는 프로그램
		//윈도우 기본버퍼로 하면 느리니까 큰 버퍼로 만들어 쓴다.
		File f = new File("Lec01.bin");
		File copy = new File("Lec01.bin");
		InputStream is;
		OutputStream os;
		byte[] buf=new byte[2];//요게 1이면 InputStream,OutputStream 기본
		try {
			if (f.exists()) {
				is = new FileInputStream(f);
				if(!copy.exists())copy.createNewFile();
				os = new FileOutputStream(copy);
				while (true) {
					int su = is.read(buf);//2개씩읽을때 공백있으면 이전값
					if (su == -1)break;
					os.write(buf,0,su);
				}
				if (is != null)is.close();
				if (os != null)os.close();
				System.out.println("복사완료!");
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
