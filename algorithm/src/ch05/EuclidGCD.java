package ch05;

import java.util.Scanner;
//두 정수의 최대공약수를 재귀로 구하는 방식 : 두 정수가 주어질 경우 큰값을 작은 값으로 나누었을때 나누어 떨어지는 가장 작은 값 = 최대 공약수
//									나누어 지지 않으면 작은값에 대해 나누어 떨어질때까지 같은 과정을 재귀적으로 반복
//									따라서 최대 공약수는 gcd(x,y)에서 y가 0이면 x이고 y가 0이 아니면 gcd(y,x%y)로 구한다
//ex) 직사각형생각 : 두수를 한변이 x,y인 직사각형으로 생각을 하면 짧은변의 길이의 정사각형과 짧은변의 크기보다 작은 직사각형(x%y,22,8일경우 22를 8로나눈 나머지)가 나오게 되는데
//	이를 정사각형들만을 집합으로 구성 될때까지 (x%y == 0) 재귀함수를 돌려준다 = gcd(y,x%y)
					
public class EuclidGCD {
	static int gcd(int x,int y) {
		if(y==0)
			return x;
		else
			return gcd(y,x%y);
	}
	//연습문제 2 : 재귀를 사용하지 않고 최대공약수 구하기
	static int notGcd(int x,int y) {
		int num = 1;
		while(num!=0) {
			//리턴할 변수
			num = x%y;
			x = y;
			y = num;
		}
		return x;
	}
	//연습문제 3 : 배열 a의 모든요소의 최대공약수를 구하는 메소드를 작성
	static int gcdArray(int[] a) {
		int x =a[0];
		for(int i=1;i<a.length;++i) {
			x = gcd(x,a[i]);
		}
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수의 최대공약수를 구합니다.");
		
		System.out.print("정수를 입력하세요 : "); 
		int x  = sc.nextInt();
		
		System.out.print("정수를 입력하세요 : "); 
		int y  = sc.nextInt();
		
		
		System.out.println("최대 공약수는 "+gcd(x,y)+"입니다");
		System.out.println("최대 공약수는 "+notGcd(x,y)+"입니다");
		
		System.out.println("배열 요소의 최대공약수를 구합니다.");
		
		int size  = 1;
		
		do {
			System.out.print("배열 크기를 입력하세요 : "); 
			size = sc.nextInt();
		}while(size<2);
		int[] a = new int[size];
		int z;
		for(int i=0;i<size;++i) {
			do {
				System.out.print("정수를 입력하세요 : "); 
				z = sc.nextInt();
			}while(z<=0);
			a[i] = z;
		}
		
		System.out.println("최대 공약수는 "+gcdArray(a) +"입니다");
	}
}
