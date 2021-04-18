package ch02;

import java.util.Scanner;

public class CardConvRev {

	public static void main(String[] args) {
		//기수 변환 : 10진수의 수를 n진수로 변환하려면 정수를 n으로 나머지를 구하고 동시에 그몫에 대해 나눗셈을 반복한다.
		//몫이 0이 될때까지 반복한뒤 나머지를 거꾸로 늘어놓은 숫자를 출력한다.
		//0x = 16진수 표기, 0 = 8진수 표기
		Scanner sc = new Scanner(System.in);
		int no; //변환하는 기수
		int cd; //기수
		int dno; //변환후의 자릿수
		int retry; //다시한번?
		char[] cno = new char[32];//변환후 각 자리의 숫자를 넣어두는 문자의 배열
		System.out.println("10진수를 기수 변환 합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 :");
				no = sc.nextInt();
			}while(no <0);
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) :");
				cd = sc.nextInt();
			}while(cd <2 || cd >36);
			dno = DetailCardConvR(no,cd,cno);//no를 cd진수로 변환
			System.out.print(cd + "진수로는 ");
			for(int i=dno-1;i>=0;i--) {//윗자리부터 차례로 출력
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			/*
				cno = new char[32];
				dno = cardConv(no,cd,cno);//no를 cd진수로 변환
				System.out.print(cd + "진수로는 ");
				for(int i=0;i<dno;i++) {//윗자리부터 차례로 출력
					System.out.print(cno[i]);
				}
				System.out.println("입니다.");
			*/
			
			System.out.println("한 번 더 할까요? (1.예/0.아니요) : ");
			retry = sc.nextInt();
		}while(retry == 1);
	}
	public static int cardConvR(int x,int r,char[] d) {//정수 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환
		int dights = 0; //변환 후 자리수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//문자열에서 임의을 문자를 엑세스
		do {
			d[dights++] = dchar.charAt(x%r);//r로 나눈 나머지를 저장
			x /= r;
		}while(x != 0);
		return dights;
	}
	//연습문제 6 : 배열의 앞쪽에 아랫자리가 아니라 윗자리를 넣어두는 메소드 작성
	public static int cardConv(int x,int r,char[] d) {
		int dights = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[dights++] = dchar.charAt(x%r);//r로 나눈 나머지를 저장
			x /= r;
		}while(x != 0);
		for(int i =0;i<dights/2;++i) {
			swap(d,i,dights-1-i);
		}
		return dights;		
	}
	public static void swap(char[] d,int idx1,int idx2) {
		char tmp = d[idx1];
		d[idx1] = d[idx2];
		d[idx2] = tmp;
	}
	//연습문제 7 : 기수 변환 과정을 자세히 나타내는 프로그램 작성
	public static int DetailCardConvR(int x,int r,char[] d) {
		int dights = 0; //변환 후 자리수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//문자열에서 임의을 문자를 엑세스
		
		do {
			
			System.out.println(r+"|       "+x + "  ......"+dchar.charAt(x%r));
			System.out.println(" + -------------");
			
			d[dights++] = dchar.charAt(x%r);//r로 나눈 나머지를 저장
			x /= r;
			if(x == 0) {
				System.out.println("         "+x + "  ......"+d[dights-1]);
			}
		}while(x != 0);
		return dights;
	}
	
}
