package ch02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		//int num = sc.nextInt();
		//연습문제 1 : 사람의 수도 난수로 생성
		int num = rand.nextInt(10)+1;//1~10까지 난수로 생성
		System.out.println(num);
		//nextBoolean() : true,false
		//nextInt() : -2147483648 ~ 2147483647
		//nextInt(n) : 0~n-1
		//nextLong() : -9223372036854775808 ~ 9223372036854775807
		//nextDouble : 0.0이상 1.0미만
		//nextFloat : 0.0이상 1.0미만
		//java.lang.Math클래스에서도 난수를 생성하는 함수 제공
		
		int[] height = new int[num];
		
		System.out.println("키 값은 아래와 같습니다.");
		for(int i=0;i<height.length;++i) {
			height[i]= 100+rand.nextInt(90);//요소의 값을 난수로 결정
			//nextInt(n)이 반환하는 값은 0~n-1까지의 난수이다.
			System.out.println("height["+i+"] : "+ height[i]);
		}
		System.out.println("최댓값은 "+maxOf(height) + "입니다.");
		
	}
	public static int maxOf(int[] height) {
		int max = height[0];
		for(int i=1;i<height.length;++i)
			if(max < height[i])
				max=height[i];
		return max;
	}
	
}
