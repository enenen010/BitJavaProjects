package com.step06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

import javax.swing.JButton;

public class Client extends Frame implements ActionListener{
	
	JTextField tf = new JTextField();
	static JTextArea ta = new JTextArea();
	static PrintWriter pw=null;
	static PrintWriter pw2=null;
	GridBagLayout gbl;
	
	public void gbinsert(Component c, int x, int y, int w, int h,int weight){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx=weight;
        gbc.weighty=weight;
        gbl.setConstraints(c,gbc);
        this.add(c);
    }
	
	public Client() {
		
		Panel gamePanel=new Panel();
		gamePanel.setLayout(new GridLayout(4,3));
		for (int i = 0; i < 12; i++) {
			gamePanel.add(new JButton("테스트"+i));
		}
		
		Panel msgPanel=new Panel();
		tf.addActionListener(this);
		ta.setLineWrap(true);
		ta.setColumns(1);
		msgPanel.setLayout(new BorderLayout());
		msgPanel.add(new JScrollPane(ta),BorderLayout.CENTER);
		msgPanel.add(tf,BorderLayout.SOUTH);
		
		
		gbl=new GridBagLayout();
		setLayout(gbl);
		gbinsert(new Label("1"),0,0,1,1,0);
		gbinsert(new Label("2"),1,0,1,1,0);
		gbinsert(new Label("3"),2,0,1,1,0);
		
		msgPanel.setSize(100, 700);
		gbinsert(gamePanel,0,1,2,1,1);
		gbinsert(msgPanel,2,1,1,1,1);
		
		setBounds(100,100,800,700);
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
		
		Socket sock2=null;
		InputStream is2=null;
		OutputStream os2=null;
		InputStreamReader isr2=null;
		OutputStreamWriter osw2=null;
		BufferedReader br2=null;
		
		try {
			sock=new Socket(url,port);//생성을위해 url:port의 프로세스를 TCP방식으로 소통
			is=sock.getInputStream();
			os=sock.getOutputStream();
			isr=new InputStreamReader(is);
			osw=new OutputStreamWriter(os);
			br=new BufferedReader(isr);
			pw=new PrintWriter(osw);
			
			sock2=new Socket(url,port);//생성을위해 url:port의 프로세스를 TCP방식으로 소통
			is2=sock.getInputStream();
			os2=sock.getOutputStream();
			isr2=new InputStreamReader(is);
			osw2=new OutputStreamWriter(os);
			br2=new BufferedReader(isr);
			pw2=new PrintWriter(osw);
			
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
