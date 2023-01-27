package com.bit;
import java.io.*;
import java.sql.Connection;
import java.util.*;

public class test02 {

	public static void main(String[] args) {
//		char ch1 = 'A'; //일반 로마자 형식
//		char ch2 = 65; //삽잔수 형식
//		char ch3 = 0x41; //16진수 형식
//		char ch4 = 0b0000000001000001; //2진수 형식
		
		
		
		
		OutputStream out;
		
		
		
		
		File f=new File("test01.txt");
		OutputStream os;
		BufferedOutputStream bos;
		DataOutputStream dos;
		InputStream is;
		BufferedInputStream bis;
		DataInputStream dis;
		
		
		
		
		
		int a= 0b100101100;
		byte[] b= { 0b00110000, 0b00110001  };
		
		int c=300;
		String str="가나\n니가\n니가로라";
		//		    101100
		//int b= 178;
		
		try {
			if(!f.exists()) f.createNewFile();
			os=new FileOutputStream(f);
			bos=new BufferedOutputStream(os);
			dos=new DataOutputStream(bos);
			
//			bos.write(a);
			dos.writeInt(c);
			dos.writeChar('뷁');

			if(dos!=null)dos.close();
			if(bos!=null)bos.close();
			if(os!=null)os.close();
			
			
			if(f.exists()) {
				is=new FileInputStream(f);
				bis=new BufferedInputStream(is);
				dis=new DataInputStream(bis);
				
				
				
				System.out.println(dis.readInt());
				System.out.println(dis.readChar());
				
				if(dis!=null)dis.close();
				if(bis!=null)bis.close();
				if(is!=null)is.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		//InputStream is = new FileInputStream(f);
		
		
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("국어", 11);
		map.put("영어", 22);
		map.put("수학", 33);
		map.put("사회", 44);
		map.put("과학", 55);
		HashMap<String, Object> map2=new HashMap<String, Object>();
		map2.put("국어", 12);
		map2.put("영어", 23);
		map2.put("수학", 34);
		map2.put("사회", 45);
		map2.put("과학", 56);
		HashMap<String, Object> map3=new HashMap<String, Object>();
		map3.put("국어", 13);
		map3.put("영어", 24);
		map3.put("수학", 35);
		map3.put("사회", 46);
		map3.put("과학", 57);
		
		
		
		Map<String,HashMap<String, ?>> mapTable
		= new HashMap<String, HashMap<String,?>>();
		
		mapTable.put("1", map);
		mapTable.put("2", map2);
		mapTable.put("3", map3);
		
		
		
		Iterator ite=mapTable.keySet().iterator();
		
//		while(ite.hasNext()) {
//			String key=(String)ite.next();
////			System.out.println(key+", "+map.get(key));
//			System.out.println(
//					key+"\t"
//					+(int)mapTable.get(key).get("국어")+"\t"
//					+mapTable.get(key).get("영어")+"\t"
//					+mapTable.get(key).get("수학")+"\t"
//					+mapTable.get(key).get("사회")+"\t"
//					+mapTable.get(key).get("과학")+"\t"
//					);
//			//(Integer)mapTable.get(key).get("국어")
//			
//		}
		
	}
}
