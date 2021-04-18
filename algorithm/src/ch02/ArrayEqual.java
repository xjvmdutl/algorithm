package ch02;

import java.util.Scanner;

public class ArrayEqual {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열 a 요소 수 : ");
		int na = sc.nextInt();
		
		int[] a = new int[na];
		for(int i=0;i<a.length;++i) {
			System.out.print("a["+i+"] : ");
			a[i] = sc.nextInt();
		}
		
		System.out.print("배열 b 요소 수 : ");
		int nb = sc.nextInt();
		
		int[] b = new int[nb];
		for(int i=0;i<b.length;++i) {
			System.out.print("b["+i+"] : ");
			b[i] = sc.nextInt();
		}
		
		
		System.out.println("배열 a와 b는 "+ (equals(a,b) ? "같습니다" : "같지않습니다."));
		copy(a,b);
		
		for(int i=0;i<a.length;++i) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean equals(int[] a,int[] b) {
		//a와 b와 같은지를 판단
		if(a.length != b.length)//a와 b의 길이 비교
			return false;
		for(int i=0;i<a.length;++i) {
			if(a[i] != b[i])
				return false;//중간에 같지 않을경우 리턴
		}
		return true;//프로그램이 끝까지 실행된 경우
	}
	//연습문제 4 : 배열 b의 모든요소를 배열 a에 복사하는 메소드 copy작성
	public static void copy(int[] a,int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for(int i=0;i<num;++i)
			a[i]=b[i];
	}
	//연습문제 5 : 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메소드 rcopy작성
	public static void rcopy(int[] a,int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for(int i=0;i<num;++i)
			a[i]=b[num-i-1];
	}
}
