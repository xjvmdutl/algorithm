package ch02;

import java.util.Scanner;

public class ReverseArray {
	
	public static void main(String[] args) {
		//배열 요소 거꾸로 정렬하기 
		//1. 배열 첫번째 요소와 마지막 요소를 비교 하여 교환한다
		//2. 배열 두번째 요소와 마지막 전 요소를 비교하면 교환한다(..반복)
		// 왼쪽요소 인덱스 : i (0,1,2...) 오른쪽요소 인덱스 : n-1-i(n-1,n-2,..)
		//for(int i=0;i<n/2;++i)
		//요소를 교환할때는 t형 임시변수를 만들어서 교환한다.(해당 메소드는 자주 사용하므로 독립적인 메소드 필요)
		//3. 교환 횟수는 요소의수 /2 이며, 나머지는 버린다(요소가 홀수인 경우 가운데 요소는 교환할 필요가 없다)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = sc.nextInt();
		
		int[] x = new int[num];
		for(int i=0;i<x.length;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		reverse2(x);
		System.out.println("요소를 역순으로 정렬하였습니다.");
		for(int i=0;i<x.length;++i) {
			System.out.println("x["+i+"] = "+x[i]);
		}
		System.out.println("배열의 합계 : "+sumOf(x));
	}
	public static void reverse(int[] x) {
		for(int i=0;i<x.length/2;++i) {
			
			swap(x,i,x.length-i-1);
		}
	}
	public static void swap(int[] x,int idx1,int idx2) {
		int tmp = x[idx1];
		x[idx1] = x[idx2];
		x[idx2] = tmp;
	}
	//연습문제2 : 배열요소를 역순으로 정렬해 나가는 과정을 하나씩 나타내는 프로그램 작성
	public static void reverse2(int[] x) {
		for(int j=0;j<x.length;++j) {
			System.out.print(x[j]+" ");
		}
		System.out.println();
		for(int i=0;i<x.length/2;++i) {
			System.out.println("x["+i+"]과(와) x["+(x.length-1-i)+"]를 교환합니다");
			swap(x,i,x.length-i-1);
			for(int j=0;j<x.length;++j) {
				System.out.print(x[j]+" ");
			}
			System.out.println();
		}
		System.out.println("역순정렬을 마쳣습니다");
	}
	//연습문제3 : 배열 x의모든 요소의 합계를 구하여 반환
	public static int sumOf(int[] x) {
		int sum = 0;
		for(int i=0;i<x.length;++i) {
			sum+=x[i];
		}
		return sum;
	}
}
