package ch02;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		//소수 구하기 : 자신과 1이외의 어떤 정수로도 나누어 지지 않는 정수(2~n-1까지 어떤 정수로도 나누어 떨어지지 않는다)
		int count =0;
		for(int n=2;n<=1000;++n) {
			int i;//나눗셈의 횟수
			for(i=2;i<n;++i) {
				count++;
				if(n%i ==0)//나누어 떨어지면 소수가 아니다
					break;//더이상 반복 x
			}
			if(n==i) {//마지막까지 나누어 떨어지지 않음
				System.out.println(n);
			}
		}
		System.out.println("나눗셈을 수행한 횟수 : "+count);//불필요한 나눗셈을 하고 있는걸 확인할수있다. 
		
		
	}

}
