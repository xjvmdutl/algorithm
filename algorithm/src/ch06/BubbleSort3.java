package ch06;

import java.util.Scanner;

public class BubbleSort3 {
	//버블 정렬 개선 : 어느 시점 이후에 교환이 더이상 수행되지 않는다면 그 앞쪽 요소는 이미 정렬을 마친 상태이다.따라서 다음 비교부터는 교환을 한 마지막 인덱스 까지만 패스를 실행하면된다. 
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
		//연습문제 4 : 비교 교환과정을 자세히 출력하면서 비교하는 두 요소 사이 교환을 수행하면 + 않으면 -를 출력하고 정렬을 마치면 비교횟수와 교환횟수를 출력
		int count1 = 0;
		int count2 = 0;
		int passCount = 0; 
		
		int k = 0; //a[k]보다 앞쪽 요소는 정렬을 마친 상태이다.
		//0으로 초기화 하는 이유는 첫 패스에선 모든 요소를 검사해야되기 때문
		while(k < n-1) {
			System.out.println("패스 "+(++passCount));
			
			int last = n-1;//각 패스에서 마지막으로 교환한 두요소 가운데 오른쪽 요소의 인덱스를 저장하기 위한 변수
			for(int j=n-1; j>k;j--) {// j는 마지막 요소부터 k번째 까지
				count1++;
				if(a[j-1] > a[j]) {
					print(a,j,true);
					count2++;
					swap(a, j-1, j);
					last = j;//교환이 수행될때마다 오른쪽 요소의 인덱스를 last에 저장
				}else {
					print(a,j,false);
				}
			}
			print(a,-1,false);
			k = last;// 하나의 패스를 마쳣을때 last 값을 k에 대입하여 다음 수행할 패스 범위 제한
		}
		System.out.println("비교를 "+count1+"회 했습니다.");
		System.out.println("교환을 "+count2+"회 했습니다.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("버블 정렬(버전 3)");
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
