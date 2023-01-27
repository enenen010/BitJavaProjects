package com.bit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex09 {
public static void main(String[] args) {
	try(
			//Closeble인터페이스를 상속받는 인터페이스만 ()안에 들어옴
			//선언이 반드시 이 안에서 이루어져야함 그 참조변수를 얘가 써야해서
			//여기서 선언된것만 자동으로 close 1.8이상이라 웹에서 잘 안씀
			Reader fr=new FileReader("");
			BufferedReader br=new BufferedReader(fr);
		){
			//나머지 작업 여기서
			String msg=null;
			while((msg=br.readLine())!=null) {
				 System.out.println(msg);
			}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
