class Ex05{

public static int su1;
public int su2=2222;

public static void main(String[] args){  //여기서부터 작업진행 가능
    Ex05 me;
    //me=new Ex05();    //아래꺼빼고 이거면 정상적으로 실행
    for(int i=0; i<5; i++){
    me=new Ex05();   //위에꺼없이 이거면 계속 2223에서 고정 non-static은 계속 복사됨
    me.su2++;
    me.func01();
    }


}
public void func01()
{
	System.out.println("static su1= "+su1);  	//static su1
    su1++;
    System.out.println("non-static= "+su2);                    //non-static su2
}
}