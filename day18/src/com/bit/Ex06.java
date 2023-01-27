package com.bit;
import java.awt.*;

public class Ex06{
public static void main(String[] args) throws InterruptedException {
	Frame f=new Frame("1");
	f.setBounds(100,100,400,400);
	f.setVisible(true);
	
	Frame f2=new Frame("2");
	f2.setBounds(500,100,400,400);
	f2.setVisible(true);
	Thread.sleep(3000);
	f2.setVisible(false);//안보이는거
	f2.dispose();        //종료
	//종료? main은 여기서 끝남 그럼어떻게 돔
	//프레임 각각이 별도의 무한루프 쓰레드인 거임
	//dispose: main return
	
	//종속된 창 만들기 : 쓰레드를 공유
	Dialog dia=new Dialog(f);//반드시 들어감 부모창
	dia.setBounds(100, 100, 100, 100);
	dia.setVisible(true);
	//Thread.sleep(3000);
	//f.dispose();        //같이 죽음
	
	
	//많이써서 제공 Dialog를 상속한?
	//FileDialog dia2=new FileDialog(f);//반드시 들어감 부모창
//	                                           FileDialog.SAVE //생긴것만다름
	FileDialog dia2=new FileDialog(f,"팝업창이다",FileDialog.LOAD);//반드시 들어감 부모창
	dia2.setTitle("파일창이다");
	dia2.setBounds(100, 100, 100, 100);//위치,사이즈 줘도 안먹음->운영체제요청
	dia2.setVisible(true);
	//이벤트 이미 다 달려있음 운영체제 꺼라서(우리가 못고침 그냥 입출력 받는 용도)
	System.out.println("이제야 나왔군..");//쓰레드공유해 얘 무한루프라 꺼야나옴
	//옆, 밑에다 받는 코드 적으면 되겠구나!
	String fileName=dia2.getFile();  //요고두개받으면 파일명,경로 나옴(IO로가자..)
	String parent=dia2.getDirectory();
	String name=dia2.getName();//쓰레드명임
	String title=dia2.getTitle();//창이름
}
}
