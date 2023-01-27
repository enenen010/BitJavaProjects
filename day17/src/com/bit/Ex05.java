package com.bit;
import java.io.*;
public class Ex05 {
public static void main(String[] args) {
	/*
	 * 데코레이션 패턴
	 * 같은 입력, 같은 출력인데 과정을 편하게 오버라이드
	 */
	File target=new File("target.jpg");
	File copy=new File("target.jpg");
	byte[] buf=new byte[2];
	InputStream is;
	OutputStream os;
	
	//버퍼배열(메모리)가 아닌 캐시메모리에 담음 덤으로 더 쉽게
	//
	BufferedInputStream bis;
	BufferedOutputStream bos;
	// 버퍼에 담아 씀 
	// 
	
	if(!copy.exists())
		try {
			if(!copy.exists()) copy.createNewFile();
			is=new FileInputStream(target);
			os=new FileOutputStream(copy);
			bis=new BufferedInputStream(is);
			bos=new BufferedOutputStream(os);
			while(true) {
				int su=bis.read(buf);
				if(su==-1)break;
				bos.write(buf);
			}
			
			//다옮겼다 시작해라는 뜻
			if(bos!=null)bos.close();
			if(bis!=null)bis.close();
			if(os!=null)os.close();
			if(is!=null)is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("복사대상이 없습니다");
			return;
		}
	
}
}
