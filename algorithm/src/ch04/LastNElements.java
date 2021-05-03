package ch04;

import java.util.Scanner;

//링 버퍼의 활용 : 가장 오래된 데이터를 버리는 용도로 활용
// 예제 : 정수 입력은 무한이 될수 있지만 배열에 저장되는 데이터는 가장 최근에 입력한 데이터만 저장
public class LastNElements {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N];//입력 받은 값을 저장
		int cnt = 0;//입력받은 개수
		int retry; //다시한번?
		System.out.println("정수를 입력하세요");
		
		do {
			System.out.printf("%d번째 정수 : ",(cnt+1));
			a[cnt++ % N] = sc.nextInt();//입력한 값을 저장하는 인덱스 = cnt++ % N (순환)
			System.out.print("게속 할까요? (예.1/아니요.0) :");
			retry= sc.nextInt();
		}while(retry==1);
		
		int i = cnt-N;
		if(i<0) 
			i=0;
		for(;i<cnt;++i)
			System.out.printf("%2d번째의 정수 = %d\n",i+1,a[i%N]);//입력한 값이 10개 이상이면 인덱스가 증가된 값부터 그전까지 for문 돌아야된다
	}
}
