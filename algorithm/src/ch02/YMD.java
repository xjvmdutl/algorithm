package ch02;

import java.util.Scanner;

//연습문제 11 : 서기 년월일을 필드로 갖는 클래스를 만들기
public class YMD {
	
	// 각 달의 일수
	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // 윤년
	};

	// 서기 year년은 윤년인가? (윤년：1／평년：0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	int y;//년
	int m;//월(1~12)
	int d;//일(1~31)
	
	YMD(int y,int m,int d){//생성자
		this.y=y;
		this.m=m;
		this.d=d;
	}
	public YMD after(int n) {//n일 뒤 날짜 반환
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (before(-n));

		temp.d += n;//n일을 d에 더한다.

		while(temp.d >= mdays[isLeap(temp.y)][temp.m-1]) {
			temp.d -= mdays[isLeap(temp.y)][temp.m-1];
			temp.m++;
			if(temp.m > 12) {
				temp.y++;
				temp.m=1;
			}
		}
		return temp;
	}
	// n일 앞의 날짜를 반환
	YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (after(-n));

		temp.d -= n;

		while (temp.d < 1) {
			if (--temp.m < 1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m - 1];
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년：");
		int y = stdIn.nextInt();
		System.out.print("월：");
		int m = stdIn.nextInt();
		System.out.print("일：");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);

		System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
		int n = stdIn.nextInt();

		YMD d1 = date.after(n);
		System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

		YMD d2 = date.before(n);
		System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);
	}
	
	//클래스 공부
	//클래스 내부 : 맴버, 클래스 초기화, 인스턴스 초기화, 생성자
	//			 필드/메소드/생성자 선언시 public/protected/private 지정
	//			 메소드/생성자 오버로드 가능
	//			 final선언한 필드는 한번만 값 대입가능
	//			 생성자는 새로 생성한 인스턴스의 초기화를 위해 사용
	//공개 클래스 : 클래스의 접근 제한자를 public으로 선언한 클래스로 다른 패키지에서 사용 가능
	//final 클래스 : 클래스 접근 제한자를 final로 선언한 클래스로 서브클래스를 가질수 없다(상속x)
	//파생 클래스 : 클래스 A를 직접 상위  클래스로 하려면 선언시 extends A를 추가
	//인터 페이스 : 인터페이스 X를 구현하려면 선언에 implements X를 추가
	//추상 클래스 : 클래스의 접근 제한자 abstract를 붙혀 클래스를 선언시 추상 메소드를 가질수 있는 추상클래스가 된다(불완전한 클래스로 인스턴스 만들수 없다)
	//중첩 클래스 : 클래스/인터페이스 안에 선언한 클래스 
	//			 멤버클래스 = 선언이 다른 클래스 또는 인터페이스 선언에 둘러쌓인 클래스
	//			 내부클래스 = 명시적으로도 암묵적으로도 정적으로 선언되지 않은 중첩클래스(정적 초기화나 멤버 인터페이스 선언할수 없다)(컴파일시 상수필드가 아닌 정적 멤버를 선언할수 없다)
	//			 지역클래스 = 이름이 주어진 중첩클래스인 내부 클래스(어떤 클래스의 멤버도 될수 없다)
}
