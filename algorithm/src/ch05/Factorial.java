package ch05;

import java.util.Scanner;

//팩토리얼을 재귀적으로 구현
public class Factorial {
	// 양의 정수 n의 팩토리얼을 반환합니다
	static int factorial(int n) {
		if(n>0)
			return n*factorial(n-1);//재귀 호출(자기 자신과 똑같은 메소드를 호출)
		else
			return 1;
	}
	
	//연습문제 1 : 재귀를 사용하지 않은 팩토리얼
	static int notFactorial(int n) {
		int num=1;//리턴할 변수
		for(int i = 1;i<=n;++i)
			num *= i;
		return num;
		
	}
	
	//직접재귀 : 자신과 같은 메소드를 호출
	//간접재귀 : a -> b -> a 호출하는 구조
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int x  = sc.nextInt();
		System.out.println(x+"의 팩토리얼은 "+factorial(x)+"입니다");
		System.out.println(x+"의 팩토리얼은 "+notFactorial(x)+"입니다");
	}
	
	
}
