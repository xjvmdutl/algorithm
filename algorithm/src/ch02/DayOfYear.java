package ch02;

import java.util.Scanner;

public class DayOfYear {
	static int[][] mdays = {
		{31,28,31,30,31,30,31,31,30,31,30,31},//평년
		{31,29,31,30,31,30,31,31,30,31,30,31}//윤년
	};
	static int isLeap(int year) {//서기 year은 윤년인가? 윤년 =1,평년 =0
		return (year%4 ==0 && year%100 !=0 || year % 400 ==0) ? 1:0;
	}
	static int dayOfYear(int y,int m,int d) {
		/*
		int days = d;
		for(int i=1;i<m;++i) {//1~(M-1)월을 일수 더함
			days+=mdays[isLeap(y)][i-1];
		}
		return days;
		*/
		//연습문제 8 : 변수 i 와 days없이 구현
		int count =0;
		int sum =0;
		do{
			sum+=mdays[isLeap(y)][count];
			count++;
		}while(count < m);
		return sum;
	}
	public static void main(String[] args) {
		//한해의 경과 일수 구하기
		//2차원 배열을 활용하여 어떤 날짜의 경과 일수를 구한다.
		//그 해의 경과 일수 = 1월 ,2월 ...,m-1월의 일수의 합 + d
		//윤년이 존재 하기 때문에 [0][n] 에 평년에 일수 [1][n]에 윤년에 일수를 저장
		Scanner sc = new Scanner(System.in);
		int retry; //다시 한 번?
		System.out.println("그 해 경과 일수를 구합니다.");
		
		do {
			System.out.print("년 : "); int year = sc.nextInt();//년
			System.out.print("월 : "); int month = sc.nextInt();//년
			System.out.print("일 : "); int day = sc.nextInt();//년
			System.out.printf("그 해 %d일째 입니다.\n",dayOfYear(year, month, day));
			
			System.out.println(leftDayOfYear(year,month,day));
			
			System.out.print("한번 더 할까요? (1.예 / 0.아니요) : ");
			
			retry = sc.nextInt();
		}while(retry == 1);
		//이차원 배여에 대한 복제는 최상위 1레벨만 수행(하위레벨의 배열은 복제가 안되고 공유)
			
	}
	public static int leftDayOfYear(int y,int m,int d) {
		// 연습문제 9 : y년 m월 d일의 그해 남은 일수를 구하는 메소드 작성 12월31일이면0
		int lastDay = dayOfYear(y,12,31);
		int currentDay = dayOfYear(y,m,d);
		return lastDay - currentDay;
	}
	

}
