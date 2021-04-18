package ch02;

import java.util.Scanner;

public class MaxOfArray {

	public static void main(String[] args) {
		//배열 요소의 최댓값 구하기
		//요소 3개이면 if문을2개 , 4개이면 if를 3개
		//a[0]을 max변수에 대입한뒤 if문을 실행하는 과정에서 필요에 따라 max값을 새로 대입한다. 
		//요소가 n개이면 if문은 n-1개이다.
		//따라서 max값을 구하는 공식은 int max = a[i]; for(int i=1;i<n;++i) if(a[i]>max)) max=a[i]; 이렇게 작성할수 있다.
		// 배열을 첫번째 요소부터 마지막요소까지 차례로 살펴본다 => 주사(스켄)
		Scanner sc = new Scanner(System.in);
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = sc.nextInt();//사람수 입력받음
		int[] height = new int[num];//요소수가 num인 배열 생성
		for(int i=0;i<num;++i) {
			System.out.print("height["+i+"] : ");
			height[i] = sc.nextInt();
		}
		System.out.println("최댓값은 "+maxOf(height)+"입니다.");
	}
	public static int maxOf(int[] height) {//배열 height요소의 최댓값을 구하는 메소드,배열 본체에 대한 참조를 전달한다.
		//접근 제한자: 맴버에 대한 접근을 제한한다.
		//public : 모든 접근 허용
		//protected : 같은 패키지의 객체 , 상속관계의 객체 허용
		//default : 같은 패키지의 객체 허용
		//private : 현재의 객체 안에서만 허용
		//접근 제한자 사용
		//클래스 : public, default
		//생성자 : public, protected,default,private
		//멤버변수 : public, protected,default,private
		//멤버 메서드 public, protected,default,private
		//지역변수 : 사용 x
		
		int max = height[0];
		for(int i=0;i<height.length;++i)
			if(height[i]>max)
				max=height[i];
		return max;
	}

}
