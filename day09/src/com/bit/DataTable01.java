package com.bit;

public class DataTable01 {
	//현재 요소수
	private int maxRow=10;
	private int maxCol=100;
	
	private int colCount=0;
	private int rowCount=0;
	
	
	private String[] columnName=new String[maxCol];
	//수정이나 삭제작업시 1개배열로는 4개3개씩 띄워서 작업하기 힘든 일이므로
	//그냥 객체하나 row로 쳐서 이차원배열사용
	private Object[][] datable=new Object[maxCol][maxRow];  
	
	
	public DataTable01() {}
	
	public DataTable01(String[] columnName, Object[][] datable) {
		this.columnName=columnName;
		this.datable=datable;
		this.colCount=columnName.length;
		this.rowCount=datable.length;
	}
	
	
	public void rowAdd(Object[] newRow) {
		
	}
	
	
	
	private void JumpAdd(String[] arr1,int jumpNum,String val) {
		String[] temp=new String[arr1.length+jumpNum];
		System.arraycopy(arr1, 0, temp, 0,arr1.length-1);
		temp[arr1.length]=val;
	}
	
	private void JumpAdd(Object[] arr1,int jumpNum,Object val) {
		Object[] temp=new Object[arr1.length+jumpNum];
		System.arraycopy(arr1, 0, temp, 0,arr1.length-1);
		temp[arr1.length]=val;
	}

}

