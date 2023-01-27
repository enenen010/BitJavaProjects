package com.bit;
import java.awt.*;
import java.awt.event.ActionListener;
public class Ex15 extends Frame implements ActionListener{
public Ex15() {
	Panel p=new Panel();
	Label la=new Label("label");
	Button btn=new Button("btn");
	TextField tf=new TextField();
	TextArea ta=new TextArea();
    Choice cho=new Choice();
    List list=new List();
    list.addItem("1");
    list.addItem("2");
    list.addItem("3");
    Checkbox ch1=new Checkbox();
    Checkbox ch2=new Checkbox();
    Checkbox ch3=new Checkbox();
    MenuBar mb=new MenuBar();
    Menu m=new Menu("메뉴");//안됨: 자기위에 아이템누르면 됨
    MenuItem mi=new MenuItem("항목");//클릭
    setMenuBar(mb);
    
    p.add(p);//안됨
    p.add(la);//안됨
    p.add(btn);//클릭
    p.add(tf);//입력하고 엔터
    p.add(ta);
    p.add(cho);
    p.add(list);//선택하고 엔터
    p.add(ch1);//
    p.add(ch2);
    p.add(ch3);
	//this 윈도우 안됨
    
    //일반적으로 버튼에 클릭이벤트 대신 이거 붙임
    
    add(p);
    setBounds(100, 100, 500, 500);
}
public static void main(String[] args) {
	new Ex15().setVisible(true);
}
}
