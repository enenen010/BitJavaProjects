package com.bit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quest02 {
	
	static int W[]; //무게
	static int V[]; //가치
	
	static int[][] dp;
	
	public static int Backpack(int n, int k) {
		
		dp[][]=
		
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		

		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			W[i]=Integer.parseInt(st.nextToken());
			V[i]=Integer.parseInt(st.nextToken());
		}
		
		
		
		
		
//		for(int i=1; i<=N;i++) {
//			for(int j=1;j<=K;j++) {
//				if(W[i]>j) {
//					dp[i][j]=dp[i-1][j];
//				}else {
//					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]); 
//				}
//			}
//		}
//		System.out.print(dp[N][K]);
	}

}
