package com.bit;

import java.io.File;
import java.io.IOException;

public class Ex15 {
public static void main(String[] args) {
	//온라인에서 여러가지 설치하는 등 임시로 사용할 공간이 필요
	//이공간은 일정크기 일정시점이 되면 자동으로 비워줌
	
//	File file=new File("abcdefg.txt");
	File file=new File("Lec01.txt");
	try {
		//             프리픽스[랜덤값].서브픽스
		File file2=file.createTempFile("bit", "test");
		System.out.println(file2.getCanonicalPath());
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
