package ch04;

import java.util.Scanner;

public class IntDoubleStackTest {
	//스택을 사용 예
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IntDoubleStack s = new IntDoubleStack(4);//최대 64개를 push할수 있는 스택
		while(true) {
			System.out.println("현재 데이터 수 : "+s.sizeLeft() + " / "+ s.capacityLeft());
			System.out.println("현재 데이터 수 : "+s.sizeRight() + " / "+ s.capacityRight());
			System.out.print("(1) pushLeft (2) pushRight "
					+ "(3) popLeft (4) popRight "
					+ "(5) peekLeft (6) peekRight "
					+ "(7) dumpLeft (8) dumpRight "
					+ "(9) IndexOfLeft (10) IndexOfRight "
					+ "(11) clearLeft (12) clearRight "
					+ "(13) isEmptyLeft (14) isEmptyRight "
					+ "(15) isFullLeft (16)isFullRight"
					+ "(0) 종료 : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			int i;
			switch (menu) {
			case 1 : 
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					s.pushLeft(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2 : 
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					s.pushRight(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 3: 
				try {
					x = s.popLeft();
					System.out.println("pop한 데이터는 "+x+"입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 4: 
				try {
					x = s.popRight();
					System.out.println("pop한 데이터는 "+x+"입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 5:
				try {
					x = s.peekLeft();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 6:
				try {
					x = s.peekRight();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 7: 
				s.dumpLeft();
				break;
			case 8: 
				s.dumpRight();
				break;
			case 9: 
				System.out.print("찾을 데이터 : ");
				x = sc.nextInt();
				i = s.IndexOfLeft(x);
				if(i==-1)
					System.out.println("찾을 데이터가 stack에 존재하지 않습니다.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 10: 
				System.out.print("찾을 데이터 : ");
				x = sc.nextInt();
				i = s.IndexOfRight(x);
				if(i==-1)
					System.out.println("찾을 데이터가 stack에 존재하지 않습니다.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 11://clear
				s.clearLeft();
				break;
			case 12://clear
				s.clearRight();
				break;
			case 13://isEmpty
				if(s.isEmptyLeft())
					System.out.println("스택이 비어있습니다.");
				else
					System.out.println("스택이 비어있지 않습니다.");
				break;
			case 14://isEmpty
				if(s.isEmptyRight())
					System.out.println("스택이 비어있습니다.");
				else
					System.out.println("스택이 비어있지 않습니다.");
				break;
			case 15://isFull
				if(s.isFullLeft())
					System.out.println("스택이 가득 찼습니다.");
				else
					System.out.println("스택이 가득 차지 않았습니다.");
				break;
			case 16://isFull
				if(s.isFullRight())
					System.out.println("스택이 가득 찼습니다.");
				else
					System.out.println("스택이 가득 차지 않았습니다.");
				break;
			default : 
				System.out.println("메뉴에 없습니다.");
				break;
			}
		}
	}

}
