package ch03;

import java.util.Scanner;

public class SeqSearchSen {
	public static int seqSearch(int[] a,int n, int key) {//요소수 =n 배열 a , key값 찾기
		
		int i =0;
		a[n] = key;//보초를 추가
		
		while(true) {
			if(a[i] == key) { //검색 성공(인덱스 반환)
				break;
			}
			i++;
		}
		return i==n ? -1 : i;
		
	}
	
	public static void main(String[] args) {
		//보초법 : 종료조건을 검사하는 비용을 반으로 줄인다. 검색하기 전에 검색하고자 하는 키값을 맨 끝요소a[7]에 저장(보초)
		//   	 원하는 데이터가 나오지 않더라도 보초까지만 돌고 종료
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];//요소수 +1(보초값을 저장)
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
