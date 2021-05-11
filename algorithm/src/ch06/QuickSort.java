package ch06;

import java.util.Scanner;

import ch04.IntStack;
//요소가 1개가 남을때 동안 계속 그룹으로 나누고 정렬한다.
//pr이 a[0]보다 오른쪽에 있으면 (left < pr) 왼쪽그룹으로 나눈다
//pl이 a[8]보다 왼쪽에 있으면 (right > pl) 오른쪽그룹으로 나눈다
//가운데 그룹은 분할 대상에서 제외
public class QuickSort {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	static void quickSort(int[] a, int left,int right) {
		
		int pl = left;//왼쪽 커서
		int pr =right;//오른쪽 커서
		int x = a[(pl+pr)/2];//피벗
		//분활 과정 추가
		System.out.printf("a[%d]~a[%d]:{",left,right);
		for(int i=left;i<right;++i) 
			System.out.printf("%d , ",a[i]);
		System.out.printf("%d}\n",a[right]);
		
		do {
			while(a[pl]<x)pl++;
			while(a[pr]>x)pr--;
			if(pl <=pr)
				swap(a,pl++,pr--);
		}while(pl <= pr);
		//left < pr, pl< right는 모두 그룹이 1개인 경우 성립하지 않는 조건이다
		/*
		if(left < pr) quickSort(a, left, pr);
		if(pl < right) quickSort(a, pl, right);
		*/
		//연습문제 12 : 요소의 갯수가 적은 그룹부터 먼저 나누는 메소드로 수정
		if((pr - left) > (right - pl) ) {//왼쪽이 클경우
			if(left < pr) quickSort(a, left, pr);
			if(pl < right) quickSort(a, pl, right);
		}else {
			if(pl < right) quickSort(a, pl, right);
			if(left < pr) quickSort(a, left, pr);
		}
		
		
	}
	//비 재귀적 버젼
	/*
	static void romoveQuickSort(int[] a, int left,int right) {
		IntStack lstack = new IntStack(right-left+1);//나눌 범위에 왼쪽 끝요소의 인덱스를 저장
		IntStack rstack = new IntStack(right-left+1);//나눌 범위에 오른쪽 끝요소의 인덱스를 저장
		//스택을 크기는 나눌 배열을 요솟수
		lstack.push(left);
		rstack.push(right);
		//연습문제 11 : push,pop,분할과정을 출력
		System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();
		while(!lstack.isEmpty()) {//스택이 빌때까지 동작
			int pl = left = lstack.pop();//왼쪽 스택에서 팝한값을 left저장
			int pr = right = rstack.pop();//오른쪽스택에서 팝한값을 right저장
			int x = a[(left+right)/2];//피벗
			System.out.printf("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n", left, right);
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl <=pr)
					swap(a,pl++,pr--);
			}while(pl <= pr);
			if(left < pr) {//그룹이 2개로 나누어 지면 left와 pr값 push
				lstack.push(left);
				rstack.push(pr);
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, pr);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
			if(pl < right) {//그룹이 2개로 나누어 지면 pl요소와 right값  push
				lstack.push(pl);
				rstack.push(right);		
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", pl, right);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
		}
	}
	*/
	static void romoveQuickSort(int[] a, int left,int right) {
		//스택의 용량 : 왼쪽 그룹과 오른쪽 그룹을 요소의 갯수를 비교하여 많고 적음에 따라 데이터 수를 조절가능
		//ex ) 6 5 4 2 7 3 1 8 :정렬할 경우 피봇 = 2
		// 1 2  / 4 5 7 3 6 8 
		//1. 요소의 갯수가 많은 그룹부터 푸쉬 : 스택에 최대 갯수 = 2 
		//2. 요소의 갯수가 적은 그룹부터 푸쉬 : 스택에 최대 갯수 = 4
		// 즉 요소의 갯수가 많은 그룹을 나누기 보다 요소의 갯수가 적은 그룹부터 먼저 분할해야지 스택에 동시에 쌓이는 데이터 수가 줄어든다.
	
		
		IntStack lstack = new IntStack(right-left+1);
		IntStack rstack = new IntStack(right-left+1);
		lstack.push(left);
		rstack.push(right);
		System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();
		while(!lstack.isEmpty()) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left+right)/2];
			System.out.printf("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n", left, right);
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl <=pr)
					swap(a,pl++,pr--);
			}while(pl <= pr);
			//연습문제 12 : 요소의 갯수가 적은 그룹부터 먼저 나누는 메소드로 수정
			if((pr - left) > (right - pl) ) {//왼쪽이 클경우
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
					System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, pr);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);		
					System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", pl, right);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
			}else {
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);		
					System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", pl, right);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
					System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, pr);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
			}
			
		}
	}
	
	//연습문제 10 : quickSort(int[] a,int n)으로 동작하는 메소드를 구현
	// 퀵정렬(n … 요솟수)
	static void quickSort(int[] a, int n) {
		//quickSort(a, 0, n - 1);
		romoveQuickSort(a,0,n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("퀵 정렬 비재귀함수");
		//System.out.println("퀵 정렬 재귀함수");
		System.out.print("요솟수 : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		quickSort(x,nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"] = "+ x[i]);
	}

}
