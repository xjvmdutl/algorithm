package ch04;

import java.util.Scanner;

public class GStackTest {
	//스택을 사용 예
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		GStack<String> s = new GStack(64);//최대 64개를 push할수 있는 스택
		while(true) {
			System.out.println("현재 데이터 수 : "+s.size() + " / "+ s.capacity());
			System.out.print("(1) push (2) pop (3) peek (4)dump (5)IndexOf (6)clear (7)isEmpty (8)isFull (0) 종료 : ");//연습문제 1 : IntStack을 모드 메소드를 사용하는 프로그램 작성
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			String x;
			switch (menu) {
			case 1 : 
				System.out.print("데이터 : ");
				x = sc.next();
				try {
					s.push(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2: 
				try {
					x = s.pop();
					System.out.println("pop한 데이터는 "+x+"입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 4: 
				s.dump();
				break;
			
			case 5:// IndexOf 
				System.out.print("찾을 데이터 : ");
				x = sc.next();
				int i = s.IndexOf(x);
				if(i==-1)
					System.out.println("찾을 데이터가 stack에 존재하지 않습니다.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 6://clear
				s.clear();
				break;
			case 7://isEmpty
				if(s.isEmpty())
					System.out.println("스택이 비어있습니다.");
				else
					System.out.println("스택이 비어있지 않습니다.");
				break;
			case 8://isFull
				if(s.isFull())
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
