package com.bit;
import java.io.*;
public class Ex17 {
public static void main(String[] args) {
	File f=new File("Lec16.bin");
	InputStream is;
	
	//바이트스트림이라 바이트형으로 65를 적어넣은거임
	//'가' 넣으면  바이트로 짤려서 3번 읽힘
	
	if(f.exists()) {
		try {
			is=new FileInputStream(f);
			int su=is.read();
//			System.out.println(su);
//			su=is.read();
//			System.out.println(su);
//			su=is.read();      //끝을 알리는 -1
//			System.out.println(su);
			while(true) {
				su=is.read();
				if(su==-1) break;
			}
			
			is.close();
			System.out.println(f.getCanonicalPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		}
		
	}
}
}
