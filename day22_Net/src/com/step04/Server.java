package com.step04;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket serve = null;
		List<PrintWriter> list = new ArrayList<PrintWriter>();

		try {
			serve = new ServerSocket(8080);
			while (true) {
				Socket sock = serve.accept();
				Thread thr = new Thread(() -> {

					OutputStream os = null;
					InputStream is = null;
					InputStreamReader isr = null;
					OutputStreamWriter osw = null;
					BufferedReader br = null;
					PrintWriter pw = null;
					InetAddress addr = null;

					try {
						addr = sock.getInetAddress();
						os = sock.getOutputStream();
						is = sock.getInputStream();
						isr = new InputStreamReader(is);
						osw = new OutputStreamWriter(os);
						br = new BufferedReader(isr);
						pw = new PrintWriter(osw);
						
						String msg = null;
//							나만의 것
//							while((msg=br.readLine())!=null) {
//								msg+=addr.getHostAddress();
//								pw.println(msg);
//								pw.flush();
//								System.out.println(msg);
//							}
						list.add(pw);
//							모두의것
							while ((msg = br.readLine()) != null) {
								msg += "["+addr.getHostAddress()+"]"+msg;
								
								for(int i=0;i<list.size();i++) {
									PrintWriter w=list.get(i);
									w.println(msg);
									w.flush();
								}
								
								pw.println(msg);
								
								pw.flush();
								System.out.println(msg);
							}
						if (pw != null)pw.close();
						if (br != null)br.close();
						if (osw != null)osw.close();
						if (isr != null)isr.close();
						if (os != null)os.close();
						if (is != null)is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				thr.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
