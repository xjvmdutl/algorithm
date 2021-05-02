package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
		//이진검색 표준 라이브러리 : java.util.Arrays 클래스의 binarySearch메소드 (이진 검색메소드를 직접 코딩x, 모든 자료형 배열에서 검색 가능)
		//API 문서 : https://docs.oracle.com/javase/8/docs/api
		//9가지 방법으로 오버로딩 되어 있다.
		//검색 성공 : key와 일치하는 요소의 인덱스 반환(여러개면 무작위의 인덱스 반환, 맨앞 반환 x)
		// 	  실패 : - 삽입 포인트 -1 반환 (검색하기 위해 지정한 key보다 큰요소의 첫번째 인덱스),만약 모든 요소가 key보다 작다면 배열을 길이를 삽입포인트 설정
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
		
		int idx = Arrays.binarySearch(x, ky);//배열과 key값을 전달
		if(idx < 0) {
			System.out.println("그 값의 요소가 없습니다.");
			System.out.println(-(idx+1));//삽질포인터 // 연습문제 6: 삽질포인터 출력
		}
		else
			System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
	}
	//클래스 메소드,인스턴스 메소드 : 클래스메소드(static x), 인스턴스 메소드 (static o)
	
}
