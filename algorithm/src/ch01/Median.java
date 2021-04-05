package ch01;

import java.util.Scanner;

public class Median {

	public static void main(String[] args) {
		//세값을 중앙값
		Scanner sc = new Scanner(System.in);
		//3가지 값들을 조합은 13가지가 있다 (조합을 나열한 모양이 나무형태이므로 결정트리라고 한다)
		System.out.println("세 정수의 중앙값을 구한다.");
		System.out.print("a의 값 : ");int a = sc.nextInt();
		System.out.print("b의 값 : ");int b = sc.nextInt();
		System.out.print("c의 값 : ");int c = sc.nextInt();
		System.out.println("중앙값은 "+med3(a, b, c)+"입니다");
	}
	static int med3(int a,int b,int c) {//연습문제 4
		if(a>b) {
			if(b>=c) {
				return b;
			}else if(a<=c) {
				return a;
			}else {
				return c;
			}
		}else if(a>=c) {
			return a;
		}else if(b<=c) {
			return b;
		}else {
			return c;
		}
	}
	/*
	static int med3(int a,int b,int c) {//연습문제 5(효율 다운)
		if((b>=a &&c<=a) || (b<=a && c>=a)){
			return a;
		}else if((a>b && c<b) || (a<b && c>b)){
			return b;
		}else{
			return c;
		}
		//호율이 떨어지는 이유는 하나의 if문에서 여러개의 조건을 계산하기 떄문에
	}
	*/
	
}
