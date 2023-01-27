package com.step06;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		List<PrintWriter> list = new ArrayList<PrintWriter>(); // 담아줄 그릇 나만보는걸 다른사람들한테 돌려주는 작업을 해야함
		ServerSocket serv = null;
		try {
			serv=new ServerSocket(8080);// 포트번호를 열어줄것임
			while(true) {//반복해줌
				
				Socket sock=serv.accept();//flush
				Socket sock2=serv.accept();//flush
				
				Thread thr = new Thread(new Runnable() {
					
					@Override
					public void run() {
						InputStream is = null;
						OutputStream os = null;
						InputStreamReader isr=null;
						OutputStreamWriter osw=null;
						BufferedReader br = null;
						PrintWriter pw=null;
						InetAddress addr = null;
						
						try {
							addr=sock.getInetAddress();
							is=sock.getInputStream();
							os=sock.getOutputStream();
							isr=new InputStreamReader(is);
							osw=new OutputStreamWriter(os);
							br=new BufferedReader(isr);
							pw=new PrintWriter(osw);
							list.add(pw);
							
							String msg=null;
							while((msg=br.readLine())!=null) {//flush까지 기다림
								msg=br.readLine();
								msg="["+addr.getHostAddress()+"]"+msg;
								for(int i=0; i<list.size(); i++) {
									PrintWriter w= list.get(i);
									w.println(msg);//여기서 하니 나만볼 수 있었음
									w.flush();
								}
								System.out.println(msg);// 여기에서는 콘솔에 모두의 채팅을 보여줌
							}
							
							
						} catch (IOException e) {
							e.printStackTrace();
						}finally {
							try {
								if(osw!=null)osw.close();
								if(isr!=null)isr.close();
								if(br!=null)br.close();
								if(pw!=null)pw.close();
								if(os!=null)os.close();
								if(is!=null)is.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				});
				thr.start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
		
	}
}