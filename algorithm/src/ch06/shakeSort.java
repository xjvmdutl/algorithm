package ch06;

import java.util.Scanner;

public class shakeSort {
	//버블 정렬 개선 : 가장 높은수가 맨 앞에 있게되면 각각의 패스마다 맨앞 요소가 한칸씩 가기 때문에 시간이 오래걸린다.
	//				홀수 번째 패스는 가장 작은 요소를 맨앞으로 짝수번째 패스는 가장 큰 요소를 맨뒤로 옮기는 방식
	//				양방향 버블 정렬
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	//양방향버블 정렬 : 연습문제 5
	static void shakeSort(int[] a,int n) {
		int left = 0;
		int right = n - 1;
		int last = right;
		while (left < right) {
			for (int j = right; j > left; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			left = last;

			for (int j = left; j < right; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					last = j;
				}
			}
			right = last;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("양방향버블 정렬(버전 4)");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shakeSort(x, nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
}
