package ch06;

import java.util.Scanner;

//단순 삽입 정렬의 특징 : 정렬을 마쳣거나 마친 상태에 가까울수록 정렬 속도가 빨라짐 (장점) , 삽입할 위치가 멀리 떨어져 있으면 이동횟수가 많아짐(단점)
//쉘 정렬 : 단순 삽입 정렬 장점을 살리고 단점을 보완 
//		  정렬할 배열의 요소를 그룹으로 나눠 각그룹별로 단순 삽입 정렬을 수행하고 그 그룹을 합치면서 정렬을 반복
//4정렬 : 4칸 만큼 떨어진 요소를 모아 그룹으로 나누어 정렬
//2정렬 : 2칸 만큼 떨어진 요소를 모아 그룹으로 나누어 정렬
//1정렬 : 1칸 만큼 떨어진 요소를 모아 그룹으로 나누어 정렬 
//순서대로 진행하며 정렬을 진행
public class ShellSort {
	//셸 정렬
	static void shellSort(int[] a,int n) {
		int count = 0;
		for(int h=n/2;h>0;h/=2) {//4->2->1정렬
			for(int i=h;i<n;++i) {
				int j;
				int tmp = a[i];
				for(j=i-h;j>=0 && a[j]>tmp; j-=h) {
					count++;
					a[j+h]=a[j];
				}
				a[j+h] = tmp;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("셸 정렬");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shellSort(x, nx);
		//bubbleSortReverse(x,nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
