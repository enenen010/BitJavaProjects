package com.bit;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test03 {
	
	static String[] Cols= {"학번","국어","영어","수학"};
	static List<int[]> stuList=new ArrayList<int[]>();
	
	
	public static void FileWrite(File f) throws IOException {

		OutputStream os;
		BufferedOutputStream bos;
		DataOutputStream dos;
		byte[] buf=new byte[5];
		if (!f.exists())f.createNewFile();
		// FileWriter fw = new FileWriter();
		os = new FileOutputStream(f);
		bos = new BufferedOutputStream(os);
		
		for (int i = 0; i < stuList.size(); i++) {
			String data = "";
			for (int j = 0; j < stuList.get(i).length; j++) {
				data += stuList.get(i)[j] + " ";
			}
			data += "\n";
			bos.write(data.getBytes());
		}
		bos.close();
		os.close();
	}
	

	public static void FileRead(File f) throws IOException {
		
		
//		InputStream is;
//		DataInputStream dis;
//		is=new FileInputStream(f);
//		dis=new DataInputStream(is);
//		
//		
//		while(true) {
//			
//			String line = dis.readUTF();
//			stuList.add(line.split(" "));
//			
//			
//		}
//		if(dis!=null)dis.close();
//		if(is!=null)is.close();
		
		
		Scanner sc=new Scanner(f);
		
		while (sc.hasNext()) {
			String line = sc.nextLine();
			stuList.add(line.split(" "));
		}
		sc.close();
	}
public static void main(String[] args) {
	
	File f=new File("E:\\JAVA\\test\\out2.txt");
	
	
}
}
