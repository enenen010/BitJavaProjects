package com.bit;

import java.io.*;
import java.util.*;

public class Ex10 {
public static void main(String[] args) {
	InputStream is=null;
	ObjectInputStream ois=null;
	try {
		is=new FileInputStream("data09.bin");
		ois=new ObjectInputStream(is);
		int su1=ois.readInt();
		double su2=ois.readDouble();
		boolean boo=ois.readBoolean();
		String msg=ois.readUTF();
		
		int[] arr1=(int[])ois.readObject();
		Vector arr2=(Vector) ois.readObject();
		ArrayList arr3=(ArrayList) ois.readObject();
		HashSet arr4=(HashSet)ois.readObject();
		System.out.println(su1);
		System.out.println(su2);
		System.out.println(boo);
		System.out.println(msg);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2.toArray()));
		System.out.println(Arrays.toString(arr3.toArray()));
		System.out.println(Arrays.toString(arr4.toArray()));
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
