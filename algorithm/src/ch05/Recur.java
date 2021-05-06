package ch05;

import java.util.Scanner;

import ch04.IntStack;

public class Recur {
	//재귀함수 이해하기
	static void recur(int n) {//하양식 분석 의 예
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
		// 가장 위쪽에 위치한 상자의 메소드 호출부터 시작해 계단식으로 자세히 조사하는 분석 기법 : 하양식 분석
		//아래쪽부터 쌓아 올라가며 분석하는기법 : 상향식 분석

		
	}
	//재귀를 없애기
	//1)꼬리 재귀 없애기 : recur(n-2)는 n을 n-2값으로 업데이트 하고 메소드의 시작지점으로 돌아간다.
	static void removeRecur(int n) {
		//2)재귀 없애기 : 변수 n이 출력되기 전에 recur(n-1)을 수행해야되기 때문에 없애기 힘들다.
		//처리가 되지 않았다면 변수 n값을 저장해야 한다.
		//(스택을 사용하여 해결)
		IntStack s = new IntStack(n);
		/*
		while(n>0) {
			recur(n-1);
			System.out.println(n);
			n = n-2;
		}
		*/
		//진행 과정 4값을 스택에 푸시 -> n값을 하나 감소(3) -> while문 초기로 돌아간다.
		//4321 값을 stack에 push후 스택이 비어있지 않음으로 2번째 if문 실행 
		//스택에서 팝한 1값을 n에 대입 -> 출력 -> n을 n-2로 업데이트 -> while문 처음으로 돌아간다.
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(!s.isEmpty()) {
				n = s.pop();
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
		}
		
	}
	static void recur2(int n) {
		if(n>0) {
			recur2(n-2);
			System.out.println(n);
			recur2(n-1);
		}
	}
	static void recur3(int n) {//연습문제 5 : 해당 메소드를 비 재귀로 구하세요
		if(n>0) {
			recur3(n-1);
			recur3(n-2);
			System.out.println(n);
		}
	}
	static void RemoveRecur3(int n) {//잘 이해가 되지 않는다...
		int[] nstk = new int[100];
		int[] sstk = new int[100];
		int ptr = -1;
		int sw = 0;

		while (true) {
			if (n > 0) {
				ptr++;
				nstk[ptr] = n;
				sstk[ptr] = sw;

				if (sw == 0)
					n = n - 1;
				else if (sw == 1) {
					n = n - 2;
					sw = 0;
				}
				continue;
			}
			do {
				n = nstk[ptr];
				sw = sstk[ptr--] + 1;

				if (sw == 2) {
					System.out.println(n);
					if (ptr < 0)
						return;
				}
			} while (sw == 2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세여 : ");
		int x = sc.nextInt();
		System.out.println("----recur-----");
		recur(x);
		System.out.println("----recur2-----");
		recur2(x);
		System.out.println("----removeRecur-----");
		removeRecur(x);
		System.out.println("----recur3-----");
		recur3(x);
		System.out.println("----RemoveRecur3-----");
		RemoveRecur3(x);
	}

}
