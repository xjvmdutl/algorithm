package ch01;

import java.util.Scanner;

public class SumWhile {

	public static void main(String[] args) {
		// 1~n까지 정수 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = sc.nextInt();
		int sum =0;//합
		int i=1;
		while(i<=n) {//i가 n이하면 반복
			sum+=i;//sum에 i더한다
			
			i++;//i값 증가
		}
		System.out.println(i);//연습문제 while문이 종료될떄 변수 i값이 n+1이 됨을 확이하세요(변수 i값을 출력하도록)
		System.out.println("1부터 "+n+ "까지의 합은 "+sum+"입니다");

	}


}
