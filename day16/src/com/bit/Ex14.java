package com.bit;
import java.io.*;

public class Ex14 {
public static void main(String[] args) {
	File f=new File("test02");
	if(f.exists()) {
		System.out.println("존재함");
	}else {
		boolean boo=f.mkdir();
		if(boo)f.mkdirs();
	}
}
}
