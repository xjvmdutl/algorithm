package ch03;

import java.util.Scanner;

public class SeqSearch {
	public static int seqSearch(int[] a,int n, int key) {//요소수 =n 배열 a , key값 찾기
		/*
		int i =0;
		while(true) {
			if(i == n) {//검색 실패
				return -1;
			}
			if(a[i] == key) { //검색 성공(인덱스 반환)
				return i;
			}
			i++;
		}
		*/
		
		//for문 변경
		for(int i=0;i<a.length;++i) {
			if(a[i] == key) { //검색 성공(인덱스 반환)
				return i;
			}
			
		}
		//검색 실패
		return -1;
	}
	public static int printSeqSearch(int[] a,int n, int key) {//연습문제2: 화면으로 출력
		System.out.print("  | ");
		for(int i=0;i<n;++i) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("--+-------------------");
		//for문 변경
		for(int i=0;i<a.length;++i) {
			System.out.print("  | ");
			for(int j=0;j<=i;++j) {
				if(i==j)
					System.out.print("*");
				System.out.print("  ");
				
			}
			System.out.println();
			System.out.print(i+" | ");
			for(int j=0;j<n;++j) {
				System.out.print(a[j]+" ");
			}
			System.out.println();
			if(a[i] == key) { //검색 성공(인덱스 반환)
				return i;
			}
			
		}
		//검색 실패
		return -1;
	}
	
	public static void main(String[] args) {
		//검색 : 1. 선형검색 : 무작위로 늘어놓은 데이터 모임에서 검색을 수행 
		//		2. 이진 검색 : 일정한 규칙으로 늘어놓은 데이터 모임에서 아주 빠른 검색
		//		3. 해시 법 : 추가,삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색
		//		- 체인법 : 같은 해시값의 데이터를 선형 리스트로 연결
		//		- 오픈 주소법 : 데이터를 위한 해시값이 충돌할때 재해시 하는 방법
		// 선형검색 : 요소가 직선모양으로 늘어선 배열에서의 검색은 원하는 키값을 갖는 요소를 만날때 까지 맨앞부터 순서대로 요소를 검색
		// 성공 : 배열 크기안 원하는 검색값 찾았다, 실패 : 검색을 끝까지 실행해도 원하는 값을 찾지 못했다.(종료조건)
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
		
		int idx = seqSearch(x, num, ky);
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");

	}

}
