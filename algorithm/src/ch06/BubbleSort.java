package ch06;

import java.util.Scanner;

public class BubbleSort {
	//오름차순 : 키값이 작은 데이터를 앞쪽에 , 내림차순 : 키값이 높은 데이터를 앞쪽에
	//내부 정렬과 외부 정렬 : 하나의 배열에서 작업할수 있는경우 = 내부 정렬 , 작업할수 없는경우 = 외부 정렬
	//정렬 알고리즘의 핵심 : 교환, 선택, 삽입
	//버블 정렬 : 이웃된 요소를 비교하고 교환하는 작업을 첫번째 요소까지 계속 진행(n-1회 진행) 가장 작은 요소가 맨 앞으로 이동하게 된다 
	// 	       이러한 과정을 패스( 비교 - > 교환) 이라고 한다.
	//		   이러한 패스 과정을 계속 진행 = n-1회 , n-2회 .... 
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void print(int[] a,int idx,boolean isChk) {
		for(int i=0;i<a.length;++i) {
			if(i == idx) {
				if(isChk) 
					System.out.print("+");
				else
					System.out.print("-");
			}
			System.out.printf("%d  ",a[i]);
		}
		System.out.println();
	}
	//버블 정렬
	static void bubbleSort(int[] a,int n) {
		//연습문제 2 : 비교 교환과정을 자세히 출력하면서 비교하는 두 요소 사이 교환을 수행하면 + 않으면 -를 출력하고 정렬을 마치면 비교횟수와 교환횟수를 출력
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<n;++i) {
			System.out.println("패스 "+(i+1));
			for(int j=n-1;j>i;j--) {
				count1++;
				if(a[j-1] > a[j]) {
					count2++;
					print(a,j,true);
					swap(a, j-1, j);
				}else {
					print(a,j,false);
				}
				
			}
			print(a,-1,false);
		}
		System.out.println("비교를 "+count1+"회 했습니다.");
		System.out.println("교환을 "+count2+"회 했습니다.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("버블 정렬(버전 1)");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, nx);
		//bubbleSortReverse(x,nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
	//연습문제 1: 버블정렬을 패스를 왼쪽부터 가장 큰값의 요소 끝으로 이동
	static void bubbleSortReverse(int[] a, int n) {
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n-i-1;++j) {				
				if(a[j] > a[j+1]) {
					swap(a,j,j+1);
				}
			}
		}
	}
}
