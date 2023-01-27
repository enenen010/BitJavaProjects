package com.step04;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Frame implements ActionListener{
	static TextArea ta=new TextArea();
	TextField tf=new TextField();
	static PrintWriter pr=null;
	static BufferedReader br=null;
	
	public Client() {
		setLayout(new BorderLayout());
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
	}
	
public static void main(String[] args) {
	new Client();

	String url="127.0.0.1";
	int port1=8080;
	Socket sock=null;
	//버퍼없이 바로전송
	OutputStream os=null;
	InputStream is=null;
	
	//버퍼를 사용
	InputStreamReader isr=null;
	OutputStreamWriter osw=null;
	Scanner sc=new Scanner(System.in);
	
	try {
		sock=new Socket(url,port1);
		
		is=sock.getInputStream();
		os=sock.getOutputStream();
		isr=new InputStreamReader(is);
		osw=new OutputStreamWriter(os);
		br=new BufferedReader(isr);
		pr=new PrintWriter(osw);
		
		
		String msg=null;
		while(true) {
			System.out.print(">");
			msg=sc.nextLine();
			if(msg.equals("end"))break;
			pr.println(msg);
			pr.flush();//버퍼를 쓴다는 건 close때 한번에 나간다는거
			msg=br.readLine();
			ta.append(msg+"\n");
		}
	
		
		
		if(pr!=null)pr.close();
		if(br!=null)br.close();
		if(osw!=null)osw.close();
		if(isr!=null)isr.close();
		if(os!=null)os.close();
		if(is!=null)is.close();
		if(sock!=null)sock.close();
	} catch (IOException e) {//통신도IO
		e.printStackTrace();
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	String msg=tf.getText();
	pr.println(msg);
	pr.flush();
	tf.setText("");
	tf.setText("");
}
}
