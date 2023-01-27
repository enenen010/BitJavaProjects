package com.bit;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Ex11 {
	public static void main(String[] args) {
		String path;
		String modifiedDay;
		String fileType;
		String size;
		String filename;
		
		path=".";
		if(args.length>0) {
			path=args[0];
		}
		
		File file=new File(path); 
		String[] arr = file.list();
		
		for(int i=0;i<arr.length;i++) {
			if (file.exists()) {
				File file2 = new File(arr[i]);
				//System.out.println(file2.getPath());
				
				//변경일자
				SimpleDateFormat sdf;
				sdf=new SimpleDateFormat();
				sdf.applyPattern("yyyy-MM-dd a hh:mm");
				Date d=new Date(file.lastModified());
				modifiedDay=sdf.format(d);
				
				//파일타입, 파일크기
				if(file2.isDirectory()) {
					fileType="<DIR>";
					size="";
				}else {
					size=Long.toString(file2.length());
					fileType="";
				}
				
				//파일이름
				filename=file2.getName();
				
//				System.out.println("변경일자\t[파일디렉]\t크기\t이름");
				System.out.println(modifiedDay+"\t"
						+fileType+"\t"
						+size+"\t"
						+filename);
			}
		}
		
	}
}
