
package com.bit;

import java.util.*;
import java.io.*;

public class Quest03 {

	static List<String[]> stuList = new ArrayList<String[]>();
	static File stuFile=new File("E:\\JAVA\\test\\out.txt");
	
	public static void FileWrite(File f) throws IOException {

		OutputStream os;
		BufferedOutputStream bos;
		byte[] buf=new byte[5];
		if (!f.exists())f.createNewFile();
		// FileWriter fw = new FileWriter();
		os = new FileOutputStream(f);
		bos = new BufferedOutputStream(os);
		
		for (int i = 0; i < stuList.size(); i++) {
			String data = "";
			for (int j = 0; j < stuList.get(i).length; j++) {
				data += stuList.get(i)[j] + " ";
			}
			data += "\n";
			bos.write(data.getBytes());
		}
		bos.close();
		os.close();
	}
	

	public static void FileRead(File f) throws IOException {
		
		Scanner sc=new Scanner(f);
		
		stuList.clear();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			stuList.add(line.split(" "));
		}
		sc.close();
	}
	
	public static int ScanToInt(Scanner sc) {
		int temp=-1;
		try {
			temp = sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요");
			sc=new Scanner(System.in);
		}
		return temp;
	}

	public static void DataLoad() {
		try {
			FileRead(stuFile);
		} catch (IOException e) {
			System.out.println("정보를 읽어오지 못하였습니다.");
		}
	}

	public static void DataSave() {
		try {
			FileWrite(stuFile);
		} catch (IOException e) {
			System.out.println("저장이 실패하였습니다.");
		}
	}
	
	public static boolean HundredOver(int num) {
		boolean over=true;
		if(0<=num&&num<=100)over=false;
		return over;
	}

	public static char Rank(int score) {
		char rank;
		switch (score) {
		case 10:
		case 9:
			rank = 'A';
			break;
		case 8:
			rank = 'B';
			break;
		case 7:
			rank = 'C';
			break;
		case 6:
			rank = 'D';
			break;
		default:
			rank = 'F';
			break;
		}
		return rank;
	}
	
	public static int IdToIdx(int id) {
		int keyIdx=-1;
		//본인 인덱스 구하기
		for(int i=1;i<stuList.size();i++) {
		int Idx=Integer.parseInt(stuList.get(i)[0]) ;
		if(Idx==id) keyIdx=i;
		}
		return keyIdx;
	}
	
	public static String MySoreMesssge(int keyIdx) {
		String msg="";
		msg+="====================================================\n";
		//내 학번 출력
		msg+=(stuList.get(0)[0]+":\t"+stuList.get(keyIdx)[0])+"\n";
		msg+="====================================================\n";
		//본인 과목별 점수
		for(int i=1; i<stuList.get(keyIdx).length;i++) {
			msg+=(stuList.get(0)[i]+":\t"+stuList.get(keyIdx)[i])+"\n";
		 }
		msg+="====================================================\n";
		return msg;
	}

	public static void main(String[] args) {
		/*
		 * 학생성적관리프로그램(ver 0.5.0) 1.리스트 2.입력 3.수정 4.삭제 5.상세보기 0.종료> 국어 영어 수학
		 */
		int input;//입력값 변수
		int keyIdx;//List 인덱스 변수
		int menu;//메뉴값
		
		
		

		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		while (true) {
			DataLoad();// 반복시 DB 로드
			Scanner sc = new Scanner(System.in);
			System.out.println("1.리스트 2.보기 3.입력 4.수정 5.삭제 0.종료> ");
			menu=ScanToInt(sc);
			
			if (menu == 0) {
				System.out.println("이용해주셔서 감사합니다.");
				break;
			} else if (menu == 1) {// 리스트
				for (int i = 0; i < stuList.get(0).length; i++) {
					System.out.print(stuList.get(0)[i] + "\t");
				}
				System.out.println();
				System.out.println("====================================================");
				for (int i = 1; i < stuList.size(); i++) {
					for (int j = 0; j < stuList.get(0).length; j++) {
						System.out.print(stuList.get(i)[j] + "\t");
					}
					System.out.println();
				}
				System.out.println("====================================================");
			} else if (menu == 2) {// 보기
				System.out.print("상세보기 학번을 입력하시오>");
				input=ScanToInt(sc);
				keyIdx=-1;//개인인덱스번호
				
				int allSum=0;//전체학번 합계
				int personalSum=0;//개인학번 합계
				
				for(int i=1;i<stuList.size();i++) {
					
					//본인 인덱스 구하기
					int Idx=Integer.parseInt(stuList.get(i)[0]) ;
					if(Idx==input) keyIdx=i;
					
					//전체합계
					for(int j=1;j<stuList.get(0).length;j++) {
						int su=Integer.parseInt(stuList.get(i)[j]);
						allSum+=su;
						
						//본인일때만 개인합계
						if(Idx==input)personalSum+=su;
					}
				}
				
				//본인이 없으면
				if(keyIdx==-1) {
					System.out.println("없는 학번입니다.");
					continue;
				}
				
				//--출력시작--
				System.out.println(MySoreMesssge(keyIdx));
				//평균/전체평균 학점
				System.out.println(
						"평균/전체평균: "
						+(personalSum*100/stuList.get(keyIdx).length/100.0)+"/"
						+(allSum*100/stuList.get(keyIdx).length/(stuList.size()-1)/100.0)+"\t"
						+"학점: "+Rank(((personalSum)/stuList.get(0).length)/10));
				System.out.println("====================================================");

			} else if (menu == 3) {// 입력
				try {
					stuList.get(0);
				} catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("저장된 데이터가 없습니다 기본 데이터로 진행합니다.");
					String[] colunm = { "학번", "국어", "영어", "수학" };
					stuList.add(colunm);
				}
				String[] temp = new String[stuList.get(0).length];
				sc = new Scanner(System.in);
				
				
				System.out.print(stuList.get(0)[0] + ">");
				input=ScanToInt(sc);
				keyIdx=IdToIdx(input);
				if(keyIdx!=-1) {
					System.out.println("중복된 학번입니다.");
					continue;
				}
				if(HundredOver(input)) {
					System.out.println("0이상 100이하의 숫자만 가능합니다");
					continue;
				}
				temp[0] = Integer.toString(input);
				
				for (int i = 1; i < stuList.get(0).length; i++) {
					System.out.print(stuList.get(0)[i] + ">");
					while(true) {
						input = sc.nextInt();
						if(HundredOver(input)) {
							System.out.println("0이상 100이하의 숫자만 가능합니다");
							continue;
						}
						temp[i]=Integer.toString(input);
						break;
					}
				}
				stuList.add(temp);

			} else if (menu == 4) {// 수정
				
				
				System.out.print("수정할 학번을 입력하시오>");
				input=sc.nextInt();
				keyIdx=IdToIdx(input);
				System.out.println(MySoreMesssge(keyIdx));
				
				while(true) {
					System.out.print("수정할 과목을 입력하시오>");
					sc=new Scanner(System.in);
					String instr=sc.next();
					int SubjectIdx=-1;
					for (int i = 0; i < stuList.get(0).length; i++) {
						if(stuList.get(0)[i].equals(instr)) SubjectIdx=i;//과목검사
					}
					if(SubjectIdx!=-1) {//과목이 존재하면
						while(true) {
							System.out.print(instr+">");
							sc=new Scanner(System.in);
							input=ScanToInt(sc);
							if(input==-1)continue;
							if(HundredOver(input)) {
								System.out.println("0이상 100이하의 숫자만 가능합니다");
								continue;
							}
							break;
						}
						String[] temp=stuList.get(keyIdx);
						temp[SubjectIdx]=Integer.toString(input);
						stuList.set(keyIdx, temp);
						break;
					}else {//과목이 없으면
						System.out.println("과목을 다시 확인하세요");
						continue;
					}//SubjectIdx
				}
				
				DataSave();
				
			} else if (menu == 5) {// 삭제
				System.out.print("삭제할 학번을 입력하시오>");
				input=sc.nextInt();
				keyIdx=IdToIdx(input);
				if(keyIdx==-1)continue;
				System.out.println(MySoreMesssge(keyIdx));
				
				stuList.remove(keyIdx);
				DataSave();
			}else {
				System.out.println("메뉴를 다시 확인하세요");
				continue;
			}
			
		}
	}
}






