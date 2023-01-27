package com.test;
import java.util.*;
import java.io.*;

class DataTamplet{
	private List Data=new ArrayList<int[]>();
	private String[] cols;
	
	
	public void FileWrite(File f) throws IOException {
		OutputStream os;
		BufferedOutputStream bos;
		
		if(!f.exists())f.createNewFile();
		
		os=new FileOutputStream(f);
		bos=new BufferedOutputStream(os);
		
		for(int i=0;i<Data.size();i++) {
			
		}
	}
	
	public int Size() {
		return Data.size();
	}
	
	public void SetCols(String[] cols) {
		this.cols=cols;
	}
	public String[] GetCols() {
		return cols.clone();
	}
	
	public void Add(int[] row) {
		Data.add(row);
	}
	
	public int[] get(int i) {
		return (int[]) Data.get(i);
	}
}

public class Test03 {

	public static void main(String[] args) {
		/*
		 * 학생성적관리프로그램(ver 0.5.0) 
		 * 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> 
		 * 국어 영어 수학
		 */
		DataTamplet Data = new DataTamplet();
		
		System.out.println("학생성적관리프로그램(ver 0.5.0) ");
		Scanner sc;
		while(true) {
			System.out.println("1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> ");
			sc=new Scanner(System.in);
			int input=sc.nextInt();
			if(input==0)break;
			else if(input==1) {//리스트
					System.out.println("학번\t국어\t영어\t수학");
					System.out.println("=========================");
					for(int i=0;i<Data.Size();i++) {
					System.out.println(
							Data.get(i)[0]+"\t"
							+Data.get(i)[1]+"\t"
							+Data.get(i)[2]+"\t"
							+Data.get(i)[3]);
					}
					System.out.println("=========================");
			}else if(input==2) {//입력
				if(Data.Size()==0) {
					String[] temp={"학번","국어","영어","수학"};
					Data.SetCols(temp);
				}
				String[] Cols=Data.GetCols();
				
				int[] temp=new int[Cols.length];
				for(int i=0;i<Cols.length;i++) {
					System.out.print(Cols[i]+">");
					temp[i]=sc.nextInt();
				}
				Data.Add(temp);
			}else if(input==3) {
				
			}else if(input==4) {
				
			}else if(input==5) {
				
			}else {
				System.out.println("잘못된 메뉴입니다.");
			}
			
			
		}
		
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
	}
}
