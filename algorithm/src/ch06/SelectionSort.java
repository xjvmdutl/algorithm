package ch06;
//단순 선택 정렬 : 가장 작은 요소부터 선택해 알맞은 위치로 옮겨서 순서대로 정렬하는 알고리즘
//교환 과정 1. 아직 정렬하지 않은 부분에서 가장작은 키의 값을 선택
//		  2. 가장 작은 키 값과 정렬하지 않은 부분을 첫번째 요소랑 교환
//이과정을 n-1회 반복

import java.util.Scanner;

public class SelectionSort {
	
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void print(int[] a,int idx1,int idx2) {
		for(int i=0;i<a.length;++i) {
			if(i == idx1) {
				System.out.print("+  ");
			}else if(i==idx2){
				System.out.print("*  ");
			}else {
				System.out.print("   ");
			}
		}
		System.out.println();
		for(int i=0;i<a.length;++i) {
			System.out.printf("%d  ",a[i]);
		}
		System.out.println();
	}
	static void selectionSort(int[] a,int n) {
		for(int i=0;i<n-1;++i) {
			//연습문제6 : 요소의 교환과정을 자세하게 출력할수 있도록 수정 ( 정렬하지 않은 부분을 첫번째 요소위에 *, 정렬하지 않은 부분의 가장작은 값의 요소위에는 +를)
			int min = i; //아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스 기록
			for(int j=i+1;j<n;++j) {
				if(a[j] < a[min])
					min = j;//가장 작은 요소의 인덱스값 저장
			}
			print(a,min,i);
			//서로 떨어져 있는 요소를 교환하는 것 이기 때문에 안정적이지 않다(같은 요소가 2개 있을때 두 요소의 순서가 뒤바뀐다)
			swap(a,i,min);//아직 정렬되지 않은 부분의 첫부분과 가장 작은 요소를 교환
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("셀렉션 정렬");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		selectionSort(x, nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
