package ch06;

import java.util.Scanner;

public class BubbleSort2 {
	//버블 정렬 개선 : 어떤 패스에서 요소의 교환 횟수가 0이면 더이상 정렬할 요소가 없다는 뜻이기 때문에 정렬을 멈추어도 된다.
	
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
		//연습문제 3 : 비교 교환과정을 자세히 출력하면서 비교하는 두 요소 사이 교환을 수행하면 + 않으면 -를 출력하고 정렬을 마치면 비교횟수와 교환횟수를 출력
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<n;++i) {
			System.out.println("패스 "+(i+1));
			int exchg = 0;
			for(int j=n-1;j>i;j--) {
				count1++;
				if(a[j-1] > a[j]) {
					count2++;//교환 횟수
					print(a,j,true);
					swap(a, j-1, j);
					exchg++;
				}else {
					print(a,j,false);
				}
			}
			print(a,-1,false);
			if(exchg == 0)//교환이 이루어 지지 않을경우 
				break;
			
		}
		System.out.println("비교를 "+count1+"회 했습니다.");
		System.out.println("교환을 "+count2+"회 했습니다.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("버블 정렬(버전 2)");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
}
