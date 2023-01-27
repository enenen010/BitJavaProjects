package com.bit;

public class test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object a= "문자열";
		Object[] b= new Object[] {a,"새로운"};
		//System.out.println((int)a);
		//String[] c= (String[])b;
		//System.out.println(c);
		
		
		JumpAdd(b,1,"좋구나");
		//System.out.println((String)b[2]);
		
		
		int[] temp=new int[1];
		int[] arr=new int[0];
		System.arraycopy(arr, 0, temp, 0, 1); 
		
	}
	
	private static void JumpAdd(Object[] arr1,int jumpNum,Object val) {
		Object[] temp=new Object[arr1.length+jumpNum];
		System.arraycopy(arr1, 0, temp, 0,arr1.length-1);
		temp[arr1.length]=val;
		arr1=temp;
	}

}
