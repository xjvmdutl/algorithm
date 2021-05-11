package ch06;

import java.util.Scanner;

//퀵 정렬 : 정렬속도가 매우 빠르다. 피벗(정렬을 기준)에 따라 그룹을 나누고 다시 피벗을 설정해나가는 과정을 반복하며 모든 그룹이 1명이 되면 정렬을 마친다.
//배열 을 두 그룹으로 나누기 : 그룹으로 나누기 위한 조건 
//1. a[pl] >= x 성립하는 요소를 찾을때까지  pl을 오르쪽 스캔
//2. a[pr] <= x 가 성립하는 요소를 찾을 때까지 pr을 왼쪽 스캔
// 찾을 경우 : a[pl] <-> a[pr] 요소 swap
// pr과 pl이 교차하게 될때까지 진행
// pl과 pr이 동일요소에 있을경우 교환해준다(의미 없는 동작이지만 교환하지 않는다면 요소를 교환하기 전에 pl, pr이 동일요소위에 있는지를 매번 검사해야된다)
public class Partition {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	//배열을 나눈다.
	static void partition(int[] a, int n) {
		int pl = 0;//왼쪽 커서
		int pr = n-1;//오른쪽 커서
		int x = a[n/2];//피벗
		do {
			while(a[pl]<x)pl++;
			while(a[pr]>x)pr--;
			if(pl <=pr)
				swap(a,pl++,pr--);
		}while(pl <= pr);
		System.out.println("피벗의 값은 "+x+"입니다");
		
		System.out.println("피벗 이하의 그룹");//a[0] ~ a[pl-1]
		for(int i=0;i<=pl-1;++i)
			System.out.print(a[i]+" ");
		System.out.println();
		
		if(pl>pr+1) {
			System.out.println("피벗과 일치하는 그룹");//a[pr+1] ~ a[pl-1]
			for(int i=pr+1;i<=pl-1;++i)
				System.out.print(a[i]+" ");
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹");//a[pr+1] ~ a[n-1]
		for(int i=pr+1;i<n;++i)
			System.out.print(a[i]+" ");
		System.out.println();
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("퀵 정렬 배열 나누기(step1)");
		System.out.print("요솟수 : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		partition(x,nx);
		
	}

}
