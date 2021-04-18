package ch01;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// 이중루프를 응용하면 기호를 늘어놓아 삼각형이나 사각형 모양으로 출력 가능
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		do {
			System.out.print("몇 단 삼각형입니까?: ");
			n=sc.nextInt();
		}while(n<=0);
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
		
		spira(n);
		npira(n);
	}
	public static void triangleLB(int n) {//연습문제15: 직각삼각형을 출력하는 부분을 아래와 같은 형식을 메소드로 작성
		//왼쪽 아래가 직각인 이등변 삼각형
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleLU(int n) {//연습문제15: 직각삼각형을 출력하는 부분을 아래와 같은 형식을 메소드로 작성
		//오른쪽 위가 직각인 이등변 삼각형
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n-i+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleRU(int n) {//연습문제15: 직각삼각형을 출력하는 부분을 아래와 같은 형식을 메소드로 작성
		//왼쪽 아래가 직각인 이등변 삼각형
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i-1;++j) {
				System.out.print(" ");
			}
			for(int j=1;j<=n-i+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleRB(int n) {//연습문제15: 직각삼각형을 출력하는 부분을 아래와 같은 형식을 메소드로 작성
		//왼쪽 아래가 직각인 이등변 삼각형
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	
	public static void spira(int n) {//연습문제16:n단의 피라미드리 출력
		//i행에 (i-1)*2+1개
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=(i-1)*2+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void npira(int n) {//연습문제17:n단의 숫자 피라미드리 출력
		//i행에 i%10값->10이상값 넣을시 모양 깨짐
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=(i-1)*2+1;++j) {
				System.out.print(i%10);
			}	
			System.out.println();
		}
		System.out.println();
	}

}
