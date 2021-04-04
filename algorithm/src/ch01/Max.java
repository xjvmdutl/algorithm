package ch01;

import java.util.Scanner;

public class Max {
	
	public static void main(String[] args) {
		//세값을 최댓값을  구한다.
		Scanner sc = new Scanner(System.in);//키보드와 연결된 표준 입력스트림
		System.out.println("세 정수의 최댓값을 구합니다.");
		System.out.print("a의 값 : "); int a = sc.nextInt();//-2147483648 ~ 2147483648 까지
		System.out.print("b의 값 : "); int b = sc.nextInt();
		System.out.print("c의 값 : "); int c = sc.nextInt();
		int max = a;
		if(b> max) max = b;
		if(c> max) max = c;
		//a,b,c최댓값을 구하여 max 에 대입
		//여러 문장이 순차적으로 실행되는 구조를 순차적 구조라고 한다.
		//()안에 있는 식의 평가결과에 따라 프로그램의 실행 흐름을 변경하는 if문을 선택구조라고 한다.
		//if문에 의한 프로그램 흐름의 분기를 쌍기 선택이라고 한다.
		//->:대입 ,<>:조건 (yes,no)
		System.out.println("최댓값은 "+ max +" 입니다.");
		//프로그램으로 변경
		System.out.println("max3(3,2,1) = "+max3(3,2,1));
		System.out.println("max3(3,2,2) = "+max3(3,2,2));
		System.out.println("max3(3,1,2) = "+max3(3,1,2));
		System.out.println("max3(3,2,3) = "+max3(3,2,3));
		System.out.println("max3(2,1,3) = "+max3(2,1,3));
		System.out.println("max3(3,2,2) = "+max3(3,2,2));
		System.out.println("max3(3,3,3) = "+max3(3,3,3));
		System.out.println("max3(2,2,3) = "+max3(2,2,3));
		System.out.println("max3(2,3,1) = "+max3(2,3,1));
		System.out.println("max3(2,3,2) = "+max3(2,3,2));
		System.out.println("max3(1,3,2) = "+max3(1,3,2));
		System.out.println("max3(2,3,3) = "+max3(2,3,3));
		System.out.println("max3(1,2,3) = "+max3(1,2,3));
		
		//연습문제 테스트1
		System.out.println("max4(2,3,19,3) = "+max4(2,3,19,3));
		
		//연습문제 테스트2
		System.out.println("min3(2,3,1) = "+min3(2,3,1));
		//연습문제 테스트3
		System.out.println("min4(2,3,19,3) = "+min4(2,3,19,3));
		
		
	}	
	static int max3(int a, int b,int c) {//메소드를 정의할때 메소드에 전달되는 값을 저장하기 위해 변수를 선언하는데 이를 매개변수,형식매개변수라 한다.
										 //형식매개변수를 가인수라 하고 메소드를 호출할 때 사용하는 매개변수의 값을 실인수라고 한다.(정의할때 매개변수,호출할떄 실인수)
		int max = a;
		if(b>max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;//구한 최댓갑을 호출한 곳으로 반환
	}
	//return void = 반환형 x
	//연습문제 1 : 네값의 최댓값을 구하는 max4작성
	static int max4(int a,int b,int c,int d) {
		int max =a;
		if(b>max) max =b;
		if(c>max) max =c;
		if(d>max) max =d;
		return max;
	}
	//연습문제 2 : 세 값을 최솟값을 구하는 min3 작성
	static int min3(int a, int b,int c) {
		int min = a;
		if(min>b) min = b;
		if(min>c) min = c;
		return min;
	}
	//연습문제 3 : 네 값을 최솟값을 구하는 min4 작성
	static int min4(int a, int b,int c,int d) {
		int min = a;
		if(min>b) min = b;
		if(min>c) min = c;
		if(min>d) min = d;
		return min;
	}
}
