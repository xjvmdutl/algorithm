package ch01;

import java.util.Scanner;

public class SumForPos {

	public static void main(String[] args) {
		// 1~n까지 정수 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		int n;
		do {//루프 본문을 한번 돌고 계속 반복할 것인지 판단하는 사후 판단 반복문
			System.out.print("n의 값 : ");
			n = sc.nextInt();
		}while(n<=0);//0보다 클떄까지 반복
		// 사후/사전 판단 반복문을 차이 : 사전은 한번도 실행 안될수도 있지만 사후는 반드시 한번은 실행된다.
		int sum =0;//합
	
		for(int i=1;i<=n;++i) {
			sum+=i;//sum에 i를 더한다
		}
		
		System.out.println("1부터 "+n+ "까지의 합은 "+sum+"입니다");
		
		test1();
		test2();
	}
	public static void test1() {//연습문제 10: 두 변수 a,b에 정수를 입력하고 b-a를 출력하는 프로그램작성(단 b는 a보다 커야된다,작으면 다시입력
		Scanner sc = new Scanner(System.in);
		System.out.println("b-a의 값을 구합니다.");
		int b;
		System.out.print("a의 값 : ");
		int a = sc.nextInt();
		do {//루프 본문을 한번 돌고 계속 반복할 것인지 판단하는 사후 판단 반복문
			System.out.print("b의 값 : ");
			b = sc.nextInt();
			if(b<=a) System.out.println("a보다 큰값을 입력하세요");
		}while(b<=a);//a보다 클떄까지 반복
		System.out.println("b-a는 "+(b-a)+"입니다");
	}
	public static void test2() {//연습문제 11: 양의 정수를 입력하고 자릿수를 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.println("자릿수를 구합니다");
		int num;
		int count = 0;
		do {//루프 본문을 한번 돌고 계속 반복할 것인지 판단하는 사후 판단 반복문
			System.out.print("num의 값 : ");
			num = sc.nextInt();
		}while(num<=0);//0보다 클떄까지 반복
		do {
			num/=10;
			count++;
		}while(num>0);
		System.out.println("그수는 "+count + "자리입니다");
	}
}
