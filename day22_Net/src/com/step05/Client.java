package com.step05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client extends Frame implements ActionListener{
	
	TextField tf = new TextField();
	static TextArea ta = new TextArea();
	static PrintWriter pw=null;
	
	public Client() {
		tf.addActionListener(this);
		setLayout(new BorderLayout());
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		setBounds(100,100,300,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 텍스트필드의 입력이벤트
		String msg=tf.getText();
		pw.println(msg);
		if(msg.equals("발사"))pw.flush();
		tf.setText("");
		tf.setText("");
	}
	
	public static void main(String[] args) {
		Client client = new Client();
//		String url="192.168.240.210";
		String url="127.0.0.1";
		int port=8080;
		Socket sock=null;
		InputStream is=null;
		OutputStream os=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		Scanner sc = new Scanner(System.in);
		
		try {
			sock=new Socket(url,port);//생성을위해 url:port의 프로세스를 TCP방식으로 소통
			is=sock.getInputStream();
			os=sock.getOutputStream();
			isr=new InputStreamReader(is);
			osw=new OutputStreamWriter(os);
			br=new BufferedReader(isr);
			pw=new PrintWriter(osw);
			String msg=null;
			while(true) {
				msg=br.readLine();
				if(msg.equals("exit"))break;
				ta.append(msg+"\n");
			} // 클라이언트의 작동을 끝내면 서버도 같이 꺼진다 서버에서 다음읽어올게 없으면 다음으로 넘어간다고 되어있기 때문이다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(os!=null)os.close();
				if(is!=null)is.close();
				if(sock!=null)sock.close();
				if(isr!=null)isr.close();
				if(osw!=null)osw.close();
				if(br!=null)br.close();
				if(pw!=null)pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
