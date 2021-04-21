package ch03;

import java.util.Scanner;

public class SearchIdx {
	public static int searchIdx(int[] a,int key, int[] idx) {
		//연습문제 3 : 요소수가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열idx에 맨앞부터 순서대로저장하고 일치한 요소수 반환
		int returnValue = -1;
		for(int i=0;i<a.length;++i) {
			if(a[i] == key) {
				idx[++returnValue] = key;
			}
		}
		
		
		return returnValue;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		for(int i =0; i<num;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int[] idx = new int[x.length]; 
		int idxLength= searchIdx(x, ky, idx);
		int[] tmp = new int[idxLength];
		for(int i=0;i<idxLength;++i) {
			tmp[i] = idx[i];
		}
		idx= tmp;
		if(idxLength == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			for(int i=0;i<idx.length;++i)
				System.out.print(idx[i]+" ");

	}
}
