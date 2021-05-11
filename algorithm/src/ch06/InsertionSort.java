package ch06;

import java.util.Scanner;

//단순삽입 정렬 : 선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 삽입하는 작업을 반복
// 			   아직 정렬되지 않은 첫번째 요소를 정렬된 부분의 알맞은 위치에 삽입
//			   -> 알맞은 위치에 삽입하기위해 왼쪽에 이웃한 요소가 선택한 요소보다 크면 그값을 대입하고 앞으로 이동하면서 이작업을반복
//				= 선택한 값 이하의 요소를 만나면 해당 위치에 삽입할 값을 대입
//			   1. 정렬된 열의 왼쪽끝에 도달합니다. => j가 0보다 크다
//			   2. tmp보다 작거나 같은 key를 갖는 항목a[j]를 발견합니다. => a[j-1]값이 tmp보다 크다
//			   1.2.조건중 하나를만족할때까지(=>두조건이 모두 성립할때까지) 반복한다.
public class InsertionSort {
	//단순 삽입 정렬
	static void insertionSort(int[] a,int n) {
	
		for(int i=1;i<n;++i) {
			int j;
			int tmp = a[i];
			for(j=i ; j>0 && a[j-1] > tmp;j--) {
				a[j] = a[j-1];
			}
			a[j] = tmp;
			//안정적인 정렬
			// 요소의 비교횟수와 교환횟수 = n^2/2 회
		}
	}
	// 연습문제 7 : 단순삽입정렬(보초법：배열의 머리요소는 비어있습니다.)
	static void insertionSortBacket(int[] a,int n) {
		for(int i=2;i<n;++i) {
			int j = i;
			int tmp = a[i];
			a[0] = a[i];
			for(; a[j-1] > tmp;j--) {
				a[j] = a[j-1];
			}
			if(j>0)
				a[j] = tmp;
		}
	}
	// 연습문제 8 : 이진삽입정렬(정렬된 앞부분에서 요소를 찾을때 이진 탐색을 이용한다)
	static void insertionBinarySort(int[] a,int n) {
		for(int i=1;i<n;++i) {
			int tmp = a[i];
			int left =0;
			int right = i-1;
			int ptr;
			do {
				ptr = (left+right)/2;
				if(a[ptr] == tmp)//검색 성공
					break;
				else if(a[ptr] < tmp)
					left = ptr+1;
				else
					right = ptr-1;
			}while(left <= right);
			int pd = (left <= right) ? ptr + 1 : right + 1;

			for (int j = i; j > pd; j--)
				a[j] = a[j - 1];
			a[pd] = tmp;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수 : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		/*
		int nx = sc.nextInt();
		int[] x = new int[nx + 1]; // 1개 여분으로 생성

		for (int i = 1; i <= nx; i++) { // x[1]~x[nx]에 읽어 들임
			System.out.print("x[" + i + "]：");
			x[i] = sc.nextInt();
		}
	 */
		//insertionSort(x, nx);
		//insertionSortBacket(x,nx+1);
		insertionBinarySort(x,nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<x.length;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
