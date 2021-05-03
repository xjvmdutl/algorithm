package ch04;

import java.util.Scanner;

public class GQueueTest {
	//링큐 사용 예
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64);//최대 10개를 EnQueue할수 있는 큐
		while(true) {
			System.out.println("현재 데이터 수 : "+q.size() + " / "+ q.capacity());
			System.out.print("(1) enQueue (2) deQueue (3)peek  (4) dump (5) IndexOf (6) clear (7) isEmpty (8) isFull (9) search (0) 종료 : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					q.enqueue(x);
				}catch (IntAryQueue.OverflowIntAryQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;
			case 2: 
				try {
					x = q.dequeue();
					System.out.println("deQueue한 데이터는 "+x+"입니다.");
				} catch (IntAryQueue.EmptyIntAryQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 3: 
				try {
					x = q.peek();
					System.out.println("peek한 데이터는 "+x+"입니다.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
			case 4: 
				q.dump();
				break;
			case 5:// IndexOf 
				System.out.print("찾을 데이터 : ");
				x = sc.nextInt();
				int i = q.indexOf(x);
				if(i==-1)
					System.out.println("찾을 데이터가 Queue에 존재하지 않습니다.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 6://clear
				q.clear();
				break;
			case 7://isEmpty
				if(q.isEmpty())
					System.out.println("큐가 비어있습니다.");
				else
					System.out.println("큐가 비어있지 않습니다.");
				break;
			case 8://isFull
				if(q.isFull())
					System.out.println("큐가 가득 찼습니다.");
				else
					System.out.println("큐가 가득 차지 않았습니다.");
				break;
			case 9://search
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
