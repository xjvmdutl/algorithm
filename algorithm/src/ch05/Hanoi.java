package ch05;

import java.util.Scanner;

import ch04.IntStack;

public class Hanoi {
	//하노이의 탑 : 작은원반이 위에 큰 원반이 아래에 위치할수 있도록 원반을 3개 기둥사이에서 옮기는 문제
	//모든 원반은 크기가 다르고 처음에는 모든 원반이 규칙에 맞게 첫번째 기둥에 쌓여 있다. 이상태에서 모든 원반을 세번째 기둥으로 옮기는 최소 횟수 구하기(큰 원반을 작은 원반위에 둘수 없다)
	//원반을 최소한으로 옮기기 위해서는 1,2 원반을 중간기둥에 넣고 마지막 원반을 마지막 기둥으로 옮겨야 된다.
	//원반 2개를 옮기는 과정 = 1번 원반을 중간기둥으로 넣고 2번원반을 마지막 기둥으로 넣은뒤 다시 1번 원반을 위로 올린다.
	//규칙 : 마지막 원반을 제외한 원반을 그룹으로 묶어 남아있는 기둥에 넣고 마지막 원반을 목표 기둥에 넣은뒤 그룹 원반을 위로 올린다.

	//no개의 원반을 x번 기둥에서 y번 기둥으로 옮긴다.
	static final String[] name = {"A","B","C"};//연습문제 : 숫자가 아닌 문자열로 기둥 이름을 출력
	static void move(int no, int x, int y) {
		if(no > 1) {
			move(no-1,x,6-x-y);//중간기둥으로 옮긴다.//기둥 번호의 합이(1+2+3)이므로 시작 기둥,목표기둥이 어느기둥이든지 중간 기둥은 6-x-y 로 구할수가 있다
		}
		System.out.println("원반["+no+"]을 "+name[x-1]+"기둥에서 "+name[y-1]+" 기둥으로 옮김");
		if(no >1) {
			move(no-1,6-x-y,y);
		}
		
	}
	static void RemoveMove(int no, int x, int y) {
		int[] xstk = new int[100];
		int[] ystk = new int[100];
		int[] sstk = new int[100]; // 스택
		int ptr = 0; // 스택 포인터
		int sw = 0;
		while(true) {
			if (sw == 0 && no > 1) {
				xstk[ptr] = x; // x의 값을 푸시
				ystk[ptr] = y; // y의 값을 푸시
				sstk[ptr] = sw; // sw의 값을 푸시
				ptr++;
				no = no - 1;
				y = 6 - x - y;
				continue;
			}
			System.out.println("원반["+no+"]을 "+x+"기둥에서 "+y+" 기둥으로 옮김");
			
			if (sw == 1 && no > 1) {
				xstk[ptr] = x; // x의 값을 푸시
				ystk[ptr] = y; // y의 값을 푸시
				sstk[ptr] = sw; // sw의 값을 푸시
				ptr++;
				no = no - 1;
				x = 6 - x - y;
				if (++sw == 2)
					sw = 0;
				continue;
			}
			do {
				if (ptr-- == 0) // 스택이 텅 빔
					return;
				x = xstk[ptr]; // 값을 저장하고 있는 x를 팝
				y = ystk[ptr]; // 값을 저장하고 있는 y를 팝
				sw = sstk[ptr] + 1; // 값을 저장하고 있는 sw를 팝
				no++;
			} while (sw == 2);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반 갯수 : ");
		
		int n = sc.nextInt();
		//move(n,1,3);//n개의 원반을 1->3번으로
		RemoveMove(n,1,3);
	}

}
