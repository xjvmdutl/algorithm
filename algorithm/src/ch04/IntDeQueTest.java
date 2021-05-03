package ch04;

import java.util.Scanner;

public class IntDeQueTest {
	//링큐 사용 예
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntDeQue q = new IntDeQue(4);//최대 10개를 EnQueue할수 있는 큐
		while(true) {
			System.out.println("현재 데이터 수 : "+q.size() + " / "+ q.capacity());
			System.out.print("(1) enqueFront (2) enqueRear "
					+ "(3) dequeFront (4) dequeRear "
					+ "(5) peekFront  (6) peekRear "
					+ "(7) dump (8) indexOf"
					+ "(9) clear (10) isEmpty "
					+ "(11) isFull (12) search (0) 종료 : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					q.enqueFront(x);
				}catch (IntDeQue.OverflowIntDequeException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
			case 2 : 
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					q.enqueRear(x);
				}catch (IntDeQue.OverflowIntDequeException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
			case 3: 
				try {
					x = q.dequeFront();
					System.out.println("deQueue한 데이터는 "+x+"입니다.");
				} catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 4: 
				try {
					x = q.dequeRear();
					System.out.println("deQueue한 데이터는 "+x+"입니다.");
				} catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 5: 
				try {
					x = q.peekFront();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 6: 
				try {
					x = q.peekRear();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 7: 
				q.dump();
				break;
			case 8:// IndexOf 
				System.out.print("찾을 데이터 : ");
				x = sc.nextInt();
				int i = q.indexOf(x);
				if(i==-1)
					System.out.println("찾을 데이터가 Queue에 존재하지 않습니다.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 9://clear
				q.clear();
				break;
			case 10://isEmpty
				if(q.isEmpty())
					System.out.println("큐가 비어있습니다.");
				else
					System.out.println("큐가 비어있지 않습니다.");
				break;
			case 11://isFull
				if(q.isFull())
					System.out.println("큐가 가득 찼습니다.");
				else
					System.out.println("큐가 가득 차지 않았습니다.");
				break;
			case 12://search
				System.out.print("찾을 데이터 : ");
				x = sc.nextInt();
				int queueIndex = q.search(x);
				if(queueIndex == 0)
					System.out.println("찾을 데이터가 Queue에 존재하지 않습니다.");
				else
					System.out.println("찾을 데이터가 "+ queueIndex+ "번째에 존재합니다");
				break;
			default : 
				System.out.println("메뉴에 없습니다.");
				break;
			}
		}
	}

}
