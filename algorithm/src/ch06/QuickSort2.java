package ch06;

import java.util.Scanner;

import ch04.IntStack;
//요소가 1개가 남을때 동안 계속 그룹으로 나누고 정렬한다.
//pr이 a[0]보다 오른쪽에 있으면 (left < pr) 왼쪽그룹으로 나눈다
//pl이 a[8]보다 왼쪽에 있으면 (right > pl) 오른쪽그룹으로 나눈다
//가운데 그룹은 분할 대상에서 제외
public class QuickSort2 {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	// 단순삽입정렬
	static void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int tmp = a[i];
			int j;
			for (j = i; j > left && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
	//연습문제 13 : 요소수가 9개 이하일 경우 단순 삽입 정렬로 
	static void quickSort(int[] a, int left,int right) {
		
		if (right - left < 9)
			insertionSort(a, left, right);
		else {
			int pl = left; // 왼쪽 커서
			int pr = right; // 오른쪽 커서
			int x = a[(pl + pr) / 2]; // 피벗 (중앙의 요소)

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			if (pr - left < right - pl) {
				int temp;
				temp = left;
				left = pl;
				pl = temp;
				temp = right;
				right = pr;
				pr = temp;
			}
			if (left < pr)
				quickSort(a, left, pr);
			if (pl < right)
				quickSort(a, pl, right);
		}
	}

	static void romoveQuickSort(int[] a, int left,int right) {
		
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);

		lstack.push(left);
		rstack.push(right);

		while (!lstack.isEmpty()) {
			int pl = left = lstack.pop(); // 왼쪽 커서
			int pr = right = rstack.pop(); // 오른쪽 커서

			if (right - left < 9)
				insertionSort(a, left, right);
			else {
				int x = a[(left + right) / 2]; // 피벗은 중앙의 요소
				do {
					while (a[pl] < x)
						pl++;
					while (a[pr] > x)
						pr--;
					if (pl <= pr)
						swap(a, pl++, pr--);
				} while (pl <= pr);

				if (pr - left < right - pl) {
					int temp;
					temp = left;
					left = pl;
					pl = temp;
					temp = right;
					right = pr;
					pr = temp;
				}
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			}
		}
	}
	static void quickSort(int[] a, int n) {
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
