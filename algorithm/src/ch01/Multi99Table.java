package ch01;

import java.util.Scanner;

public class Multi99Table {

	public static void main(String[] args) {
		//반복문안 반복문 : 이중 루프
		System.out.println("  ----------곱셈표-----------");
		for(int i=1;i<=9;++i) {
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",i*j);
			}
			System.out.println();
		}
		System.out.println();
		Test1();
		Test2();
		Test3();
	}
	public static void Test1() {//연습문제 12: 위쪽과 왼쪽에 곱하는 수가 있는 곱셈표 작성 
								//1 2 3 4 5 6 7 8 9
								//2
								//3
								//...
								//9
		System.out.print("   |");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.println("---+--------------------------");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d|",i);
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",j*i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void Test2() {//연습문제 13 : 곱셈이 아니라 덧셈을 출력하는 프로그램을 작성
		System.out.print("   |");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.println("---+--------------------------");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d|",i);
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",j+i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void Test3() {//연습문제 14 : 입력한 수를 한변으로 하는 정사각형을 * 기호로 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수 : ");
		int n = sc.nextInt();
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n;++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

