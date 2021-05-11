package ch06;

import java.util.Scanner;
public class ShellSort2 {
	//셸 정렬
	static void shellSort2(int[] a,int n) {
		int h;
		int count = 0;//연습문제 9 : 요소의 이동 횟수를 계산
		for(h=1; h<n/9;h=h*3+1)//h의 초깃값을 구한다 1부터 시작하여 값을 3배하고 1을 더하면서 배열을 요소수 n을 9로나눈값을 넘지 안도록 설정
			;
		for(;h>0;h/=3) {//h값이 1일될떄까지 h를 3으로 나눈다. (h값이 서로 배수가 되지 않게하기 위해)
			//효율적으로 동작하지 않는다 : 요소값이 섞이지 않으면 다시 합쳣을때 처음단계랑 동일한 상태가 되기때문
			//h값이 1,4,13,40... 이렇게 바뀌도록 짜야한다(n*3+1)
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
		System.out.println("셸 정렬(버젼2)");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shellSort2(x, nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
