package com.bit;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class test01 extends Frame implements ActionListener,TextListener{
	
	//공용 컨트롤 정의
	MenuItem mi11=new MenuItem("새로만들기");
	MenuItem mi12=new MenuItem("열기");
	MenuItem mi13=new MenuItem("저장");
	MenuItem mi14=new MenuItem("종료");
	MenuItem mi2=new MenuItem("정보");
	TextArea ta=new TextArea();
	Button btnNew;
	Button btnExit;
	Dialog dia;
	
	//변수정의
	boolean loadOn;//불러오기를 했는가
	String beforeText;//수정전문자열
	String name;//불러온파일명
	String path;//경로
	
	//초기값 세팅
	public void init() {
		beforeText="";
		name=null;
		path=null;
		setTitle("제목 없음");
		ta.setText("");
		loadOn=false;
	}
	
	//생성자
	public test01() {
		
		init();
		MenuBar mb=new MenuBar();
		
		Menu m1=new Menu("파일");
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		mi14.addActionListener(this);

		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.add(mi14);
		mb.add(m1);
		
		Menu m2=new Menu("도움말");
		mi2.addActionListener(this);
		
		m2.add(mi2);
		mb.add(m2);
		
		setMenuBar(mb);
		
		ta.addTextListener(this);
		add(ta);
		
		setBounds(100,100,400,400);
	}

public static void main(String[] args) {
	new test01().setVisible(true);
}

//파일 저장
public void FileWrite(File f) {
	OutputStream os;
	BufferedOutputStream bos;
	
	try {
		if(!f.exists())f.createNewFile();
		System.out.println("ddddddd");
		os=new FileOutputStream(f);
		bos=new BufferedOutputStream(os);
		
		String msg=this.ta.getText();
		
		bos.write(msg.getBytes());
		if(bos!=null)bos.close();
		if(os!=null)os.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

//파일 읽음
public void FileRead(File f) {
	InputStream is;
	BufferedInputStream bis;
	System.out.println(f.getPath());
	if(f.exists()) {
		try {
			is=new FileInputStream(f);
			bis=new BufferedInputStream(is);
			int input;
			ArrayList<Byte> arr1=new ArrayList<Byte>();
			while((input=bis.read())!=-1) {
				arr1.add((byte)input);
			}
			Byte[] arr2=arr1.toArray(new Byte[arr1.size()]);
			byte[] arr3=new byte[arr2.length];
			
			for(int i=0;i<arr3.length;i++) {
				arr3[i]=arr2[i];
			}
			ta.setText(new String(arr3));
			
			if(is!=null)bis.close();
			if(is!=null)is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//수정파일있을때 저장용 다이얼로그
public void ChangedSave() {
	dia=new Dialog(this);
	dia.setTitle("메모장");
	dia.setLayout(new BorderLayout());
	Label la=new Label("변경 내용을 "+this.getTitle()+"에 저장하시겠습니까?");
	dia.add(la,BorderLayout.CENTER);
	Panel p=new Panel();
	p.setLayout(new FlowLayout());
	btnNew=new Button("저장");
	btnExit=new Button("저장안함");
	btnNew.addActionListener(this);
	btnExit.addActionListener(this);
	p.add(btnNew);
	p.add(btnExit);
	dia.add(p,BorderLayout.SOUTH);
	dia.setBounds(100, 100, 300, 100);
	dia.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==this.mi11) {//새로만들기
		if(this.getTitle().startsWith("*")) {
			ChangedSave();
			init();
		}else {
			init();
		}
		
	}else if(e.getSource()==this.mi12) {//열기
		FileDialog fdia=new FileDialog(this,"열기", FileDialog.LOAD);
		fdia.setVisible(true);
		name=fdia.getFile();
		path=fdia.getDirectory();
		File f=new File(path+name);
		if(name!=null) {
			FileRead(f);
			beforeText=this.ta.getText();
			setTitle(name);
			loadOn=true;
		}
		
	}else if(e.getSource()==this.mi13) {//저장
		if(loadOn) {
			File f=new File(path+name);
			FileWrite(f);
			beforeText=this.ta.getText();
			setTitle(name);
		}else {
			ChangedSave();
		}
	}else if(e.getSource()==this.mi14) {//종료
		this.dispose();
	}else if(e.getSource()==this.mi2) {//정보
		///ta.setText(((MenuItem)e.getSource()).getName());
	}else if(e.getSource()==this.btnNew) {//버튼저장
		FileDialog fdia=new FileDialog(this,"새로만들기", FileDialog.SAVE);
		fdia.setVisible(true);
		name=fdia.getFile();
		path=fdia.getDirectory();
		String fileType="";
		if(name.indexOf('.')==-1)fileType=".txt";
		File f=new File(path+name+fileType);
		if(name!=null) {
			FileWrite(f);
			this.setTitle(name);
			loadOn=true;
		}
		dia.setVisible(false);
	}else if(e.getSource()==this.btnExit) {//버튼저장안함
		dia.setVisible(false);
	}
}

@Override
public void textValueChanged(TextEvent e) {
	TextArea ta1=((TextArea)e.getSource());
	System.out.println("dsfsdf");
	if(!ta1.getText().equals(beforeText)) {
		if(name!=null)setTitle("*"+name);
		else setTitle("*"+"제목 없음");
	}else {
		if(name!=null)setTitle(name);
		else setTitle("제목 없음");
	}
}
}
