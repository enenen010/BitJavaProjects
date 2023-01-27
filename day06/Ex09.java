package com.bit;

class Ex09{
	public static void main(Stirng[] args){
    	//변수
        System.out.println(Ex10.su1);
        System.out.println(Ex10.su2);
        System.out.println(Ex10.su3);
    }
}

/*
접근제한자(class, 생성자, 전역변수, 메서드)
public
default
private
*/

class Ex10{
	public static int su1=1111;		//public
    static int su2=2222;			//default
    private static int su3=3333;	//private
    
    public static void func01(){	//public
    	
    }
    static void func02(){			//default
    	
    }
    private static void func03(){	//private
    	
    }
}