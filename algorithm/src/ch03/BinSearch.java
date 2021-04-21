package ch03;

import java.util.Scanner;

public class BinSearch {
	public static int binSearch(int[] x,int n,int key) {
		/*
		int pl = 0;
		int pr = n-1;
		do {
			int pc = (pl+pr)/2;
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//검색값이 오른쪽에 있음
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}while(pl<=pr);
		
		return -1;
		*/
		int pl = 0;
		int pr = n-1;
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//검색값이 오른쪽에 있음
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}
		return -1;
		//연습문제 1 : for문으로 변경 
	}
	public static int printBinSearch(int[] x,int n,int key) {//연습문제 4 : 콘솔로 알고리즘 진행 표현
		
		int pl = 0;
		int pr = n-1;
		
		
		System.out.print("  | ");
		for(int i=0;i<n;++i) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("--+-------------------");
		//for문 변경
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			System.out.print("  | ");
			for(int i=0;i<=n;++i) {
				if(pl==i) {
					System.out.print("<-");
				}else if(pr == i) {
					System.out.print("->");
				}else if(pc == i) {
					System.out.print("+");
				}else {
					System.out.print("  ");
				}
			}
			
			System.out.println();
			System.out.print(pc+" | ");
			for(int j=0;j<n;++j) {
				System.out.print(x[j]+" ");
			}
			
			System.out.println();
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//검색값이 오른쪽에 있음
				pl = pc+1;
			}else {
				pr = pc-1;
			}
			
		}
		
		
			
		
		return -1;
		//연습문제 1 : for문으로 변경 
	}
	public static int binSearchX(int[] x,int n,int key) {
		//연습문제 5: 검색할 값과 같은값을 갖는 요소가 하나 이상일 경우 그 요소의 맨앞 요소를 찾지 못한다.(맨앞 요소를 찾도로 변경)
		int pl = 0;
		int pr = n-1;
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			if(x[pc] == key) {
				int returnValue = pc;
				do{
					if(x[--returnValue] == key)
						pc = returnValue;
				}while(x[pc] != key);
				return pc;
			}
			else if(x[pc] < key) {//검색값이 오른쪽에 있음
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}
		return -1;
		//연습문제 1 : for문으로 변경 
	}
	public static void main(String[] args) {
		//이진 검색  : 이미 정렬이되어 있는 조건을 데이터를 가지고 원하는 키값을 뽑는다.
		// 			 초기 찾고자 하는 값이 중간값과 비교하여 크면 오른쪽 작으면 왼쪽을 검색
		//			 원하는 값이 중앙요소인지를 계속 비교하며 계속 진행
		//ex) 맨앞 인덱스 : pl, 중앙 : pc 맨끝 : pr
		//			1)	pl = 0 pr= n-1 pc=n-1/2
		//			2-1) a[pc] < key 경우 : 원하는 키 값이 오른쪽에 있으므로 a[pc+1] ~ a[pr]로 검색
		//				pl =pc+1  pr= pr pc=pl+pr/2
		//			2-2) a[pc] > key 경우 : 원하는 키 값이 왼쪽에 있으므로 a[pl] ~ a[pc-1]로 검색
		//				pl =pl  pr= pc-1 pc=pl+pr/2
		// 종료조건은 : a[pc]와 key가 일치 , 검색범위가 더이상 없는경우
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		System.out.println("오름차순으로 입력하세요");//정렬이 되어야된다.
		System.out.print("x["+0+"] : ");
		x[0] = sc.nextInt();
		
		for(int i =1; i<num;++i) {
			do {
				System.out.print("x["+i+"] : ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);//바로 앞 요소보다 작으면 다시 입력
		}
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int idx = binSearchX(x, num, ky);
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
	}

}
