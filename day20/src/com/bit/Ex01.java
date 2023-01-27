package com.bit;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex01 extends Frame implements ActionListener, TextListener{
	TextArea ta=new TextArea();

	public Ex01() {
		setTitle("제목없음");
		MenuBar mb=new MenuBar();
		Menu mn1=new Menu("File");
		MenuItem mi1=new MenuItem("New");
		MenuItem mi2=new MenuItem("Open");
		MenuItem mi3=new MenuItem("Save");
		MenuItem mi4=new MenuItem("Exit");
		MenuItem mi5=new MenuItem("About");
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mn1.add(mi1);
		mn1.addSeparator();
		mn1.add(mi2);
		mn1.add(mi3);
		mn1.addSeparator();
		mn1.add(mi4);
		mb.add(mn1);

		Menu mn2=new Menu("Help");
		mn2.add(mi5);
		mb.add(mn2);
		setMenuBar(mb);
		ta.addTextListener(this);
		add(ta);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setBounds(100-1920,100,500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Ex01 me=new Ex01();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MenuItem mi=(MenuItem)e.getSource();
		if(mi.getLabel().equals("Exit")) {
			dispose();
		}
		if(mi.getLabel().equals("About")) {
			Dialog dia=new Dialog(this,"About");
			WindowAdapter win=new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dia.dispose();
				}
			};
			dia.addWindowListener(win);
			dia.setLayout(new GridLayout(3,1));
			Panel p1=new Panel();
			Panel p2=new Panel();
			Panel p3=new Panel();
			Label la=new Label("Welcome");
			la.setFont(new Font(Font.SANS_SERIF,Font.BOLD,26));
			p1.add(la);
			p2.add(new Label("2023-01-02"));
			Button btn=new Button("Close");
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dia.dispose();
				}
			});
			p3.add(btn);
			dia.add(p1);
			dia.add(p2);
			dia.add(p3);
			dia.setBounds(200-1920, 200, 300, 150);
			dia.setVisible(true);
		}
		if(mi.getLabel().equals("Save")) {
			FileDialog fd=new FileDialog(this,"save as ...",FileDialog.SAVE);
			fd.setVisible(true);//하는순간 포커스가 여기로가서 멈춤
			String path=fd.getDirectory();
			String fname=fd.getFile();
			File f=new File(path+fname);
			if(f.exists()) {
				//사용자 확인후 덮어 쓸것인지 확인
				//이미 파일다이얼로그에 있는 기능(의미는없지만 의의는 있다.
				return;
			}else {
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				OutputStream os=null;
				try {
					os=new FileOutputStream(f);
					os.write(ta.getText().getBytes());
					if(os!=null)os.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		if(mi.getLabel().equals("Open")) {
			FileDialog fd=new FileDialog(this
					,"open as..",FileDialog.LOAD);
			fd.setVisible(true);
			String path=fd.getDirectory();
			String fname=fd.getFile();
			File f=new File(path+fname);
			if(!f.exists()) {
				return;
			}
			//기존 필터클래스는 편의기능을 제공한다면
			//필터클래스는 
			InputStream is=null;
			List<Byte> list=new ArrayList<>();
			try {
				is=new FileInputStream(f);
				int su;
				while((su=is.read())==-1){
					
				}
				if(is!=null)is.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			byte[] byt=new byte[list.size()];
			String msg="";
			ta.setText("");
			ta.setText(msg);
			this.setTitle(fname);
			
		}
		if(mi.getLabel().equals("New")) {
			setTitle("제목없음");
			ta.setText("");
			ta.setText("");
			
		}
		
	}

	@Override
	public void textValueChanged(TextEvent e) {
		change=true;
	}

}