package com.bit;

public class Quest01 {
	
	static Integer[] dp;
	static int[][] arr;

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int inputLength=sc.nextInt();
		arr=new int[inputLength][2];
		dp=new Integer[inputLength];
		
		dp[0]=0;
		
		for(int i=0;i<inputLength;i++) {
			String[] str1 = sc.nextLine().split(" ");
			arr[i][0]=Integer.parseInt(str1[0]);
			arr[i][1]=Integer.parseInt(str1[1]);
		}
	}
	
	public static int[] elLine(int n) {
		
		dp[n]=Math.min();
		
		
		
		
		return null;
		
	}

}
