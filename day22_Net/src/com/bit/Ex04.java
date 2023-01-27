package com.bit;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex04 {
	public static void main(String[] args) {
		URL url=null;
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
//		Writer fw=null;
//		PrintWriter pw=null;
		OutputStream os=null;
		try {
			url=new URL("https://www.7-zip.org/a/7z2201-x64.exe");
			URLConnection conn=url.openConnection();
			is=conn.getInputStream();
//			isr=new InputStreamReader(is);
//			br=new BufferedReader(isr);
			
//			fw=new FileWriter();
//			pw=new PrintWriter(fw);
			
			os=new FileOutputStream("7zip.exe");
			//String msg=null;
			int su=-1;
			while((su=is.read())!=-1) {
				//pw.println(msg);
				os.write(su);
			}
			//System.out.println(msg);
			
			
//			if(pw!=null)pw.close();
//			if(fw!=null)fw.close();
			if(br!=null)br.close();
			if(isr!=null)isr.close();
			if(is!=null)is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
