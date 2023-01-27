package com.bit;

import java.io.*;

public class Ex04 {
	public static void main(String[] args) {
		//Ex04,05 성능적인 기능
		File f = new File("lec03.bin");

		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			is = new FileInputStream(f);
			bis = new BufferedInputStream(is);
			while(true) {
				int su=bis.read();
				if(su==-1)break;
				System.out.println((char)su);
			}
			//Io는 반드시 close 필수
			if (bis != null)bis.close();
			if (is != null)is.close();
			System.out.println("끝");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
