package ch01;

import java.util.Scanner;

public class Dights {
	public static void main(String[] args) {
		//구조적 프로그래밍 : 하나의 입구와 하나의 출구를 가진 구성요소만을 계층적으로 배치하여 프로그램을 구성하는것을 구조적 프로그래밍이라고 한다.
		Scanner sc = new Scanner(System.in);
		int no;
		System.out.println("2자리의 정수를 입력하세요.");
		do {
			System.out.print("입력 : ");
			no=sc.nextInt();
		}while(no<10 || no> 99);//논리합연산자//!(no>=10 && no<=99) 와 같다
		//단축평가 : 논리 연산의 식 전체를 평가한 결과가 왼쪽 피연산자의 평가 결과만으로 정확해 지는 경우 오른쪽 피 연산자의 평가를 수행하지 x
		System.out.println("변수 no의 값은 "+no+"가(이) 되었습니다.");
		
		//드모르간의 법칙 : 각 조건을 부정하고 논리곱을 논리합으로, 논리합을 논리 곱으로 바꾸고 다시 전체를 부정하면 원래의 조건과 같다.
		//x && y 와 !(!x||!y)는 같다.
		//x||y 와 !(!x&&!Y)는 같다.
		
	}
}
