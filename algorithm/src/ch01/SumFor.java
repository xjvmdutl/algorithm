package ch01;

import java.util.Scanner;

public class SumFor {

	public static void main(String[] args) {
		// 1~n까지 정수 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = sc.nextInt();
		int sum =0;//합
		
		for(int i=1;i<=n;++i) {
			sum+=i;//sum에 i를 더한다
		}
		
		System.out.println("1부터 "+n+ "까지의 합은 "+sum+"입니다");
		
		test1(n);
		test2(n);
		sumof(2,5);
		//for문 자세히 알기 : 1) 초기화 제어식 업데이트 부분은 생략이 가능하지만 세미콜론 생략x 2) for문 초기화 부분에서 사용한 변수는 for문안에서만 사용 가능하다.
		//따라서 같은 함수의 하나이상의 for문에서 같은이름의 변수를 사용하려면 for문마다 변수를 선언하면 된다.
		
	}
	//연습문제7 : n이 7일경우 1+2+3+4+5+6+7=28로 출력하는 프로그램 작성
	public static void test1(int n) {
		int sum = 0;
		for(int i=1;i<=n;++i) {
			System.out.print(i);
			sum+=i;
			if(i==n) {
				System.out.println(" = "+ sum);
				break;
			}
			System.out.print(" + ");
		}
	}
	//연습문제8 : 1~10까지의 합은 (1+10)*5와 같은 방법으로 구할수 있습니다 이 방법을 이용하여 1~n까지의 합을 구하는 프로그램 작성
	public static void test2(int n) {
		int sum = 0;
		if(n%2==0) {
			sum = (1+n)*(n/2);
		}else {
			sum = (1+n)*(n/2)+n/2+1;
		}
		System.out.println("1부터 "+n+ "까지의 합은 "+sum+"입니다");
	}
	//연습문제9 : 1~10까지의 합은 (1+10)*5와 같은 방법으로 구할수 있습니다 이 방법을 이용하여 1~n까지의 합을 구하는 프로그램 작성
	public static void sumof(int a,int b) {
		int sum = 0;
		for(int i=a;i<=b;++i) {
			sum+=i;
		}
		System.out.println(a+"부터 "+b+ "까지의 합은 "+sum+"입니다");
	}
}
