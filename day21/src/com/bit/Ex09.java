package com.bit;

import java.io.*;
import java.util.*;

public class Ex09 {
public static void main(String[] args) {
	// Object stream
	OutputStream os = null;
	ObjectOutputStream oos = null;
	try {
		os = new FileOutputStream("data09.bin");
		oos = new ObjectOutputStream(os);
		oos.writeInt(1234);
		oos.writeDouble(3.14);
		oos.writeBoolean(true);
		oos.writeUTF("문자열");
		int[] arr1 = { 1, 2, 3, 4, 5 };
		oos.writeObject(arr1);
		Vector arr2 = new Vector();
		arr2.add(1234);
		arr2.add(3.14);
		arr2.add(true);
		arr2.add('A');
		arr2.add("여기까지");
		oos.writeObject(arr2);
		ArrayList arr3 = new ArrayList();
		arr3.add(43212);
		arr3.add(3.14);
		arr3.add(true);
		arr3.add(43212);
		HashSet arr4=new HashSet();
		arr4.add(1234);
		
		if (oos != null)
			oos.close();
		if (os != null)
			os.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
