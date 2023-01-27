package com.bit;


//2번. 객체==========================================
class LotoMachine{
	private int maxBall;
	private LotoBall[] ballSet;
	
	public LotoMachine(){//기본
		reset(45);
	}
	
	public LotoMachine(int n){//혹시45말고 하라그러면
		reset(n);
	}
	
	public LotoBall pop() {//공꺼내기
		int rotoNumber =(int)(Math.random()*maxBall+1);
		
		LotoBall temp = ballSet[rotoNumber];
		ballSet[rotoNumber]=ballSet[maxBall-1];
		ballSet[maxBall-1]=temp;
		maxBall--;
		return temp;
	}
	
	public void reset(int n) {
		maxBall=n;
		ballSet=new LotoBall[n];
		for(int i=0;i<ballSet.length;i++) {
			LotoBall ball = new LotoBall(i+1);
			ballSet[i]=ball;
		}
	}
	
}

class LotoBall{
	private int ballNumber;
	static int colorInterval=10;
	static int[][] colorBundle
	= {{255,255,0},{0,0,255},{255,0,0},{128,128,128},{0,255,0}};
	
	public LotoBall(int ballNumber) {
		this.ballNumber=ballNumber;
	}
	
	public int getNumber() {
		return this.ballNumber;
	}
	
	public int[] getColor() {
		int idx=(ballNumber-1)/colorInterval;
		return colorBundle[idx];
	}
}



public class Quest02 {
	
	//1번. 기능============================================
	static int[] RotoArrMake() {
		int[] rotos = new int[7];
		
		for(int i=0;i<7;i++) {
			int rotoNumber=(int)(Math.random()*45+1);
			
			for(int j=0;j<=i;j++) {
				if(rotoNumber==rotos[j]) i--; break;
			}
			rotos[i]=rotoNumber;
		}
		return rotos;
	}
	
	static void Sort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	//============================================
	static void Sort(LotoBall[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i].getNumber()>arr[j].getNumber()) {
					LotoBall temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * 로또번호생성기
		 * 매주 토요일 MBC - pm 8시 40분
		 * 1~45  6개  순서
		 * 객체 아니면 기능적으로 접근
		 * */
		
		//1번. 기능============================================
		int[] rotos = RotoArrMake();
		Sort(rotos);
		System.out.println("로또1: "+rotos[0]+", "+rotos[1]+", "+rotos[2]+", "
		+rotos[3]+", "+rotos[4]+", "+rotos[5]);
		
		//2번. 객체============================================
		LotoBall[] rotos2 = new LotoBall[6];
		LotoMachine loto=new LotoMachine();
		for(int i=0;i<rotos2.length;i++) {
			rotos2[i]=loto.pop();
		}
		Sort(rotos2);
		System.out.print("로또2: ");
		for(int i=0;i<rotos2.length;i++) {
			int[] color=rotos2[i].getColor();
			System.out.print(rotos2[i].getNumber()+" 색("+color[0]+","+color[1]+","+color[2]+")");
			if(i!=rotos2.length-1) {
				System.out.print(", ");
			}
		}
	}
}
