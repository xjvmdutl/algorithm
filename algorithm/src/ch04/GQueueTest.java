package ch04;

import java.util.Scanner;

public class GQueueTest {
	//��ť ��� ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue q = new IntQueue(64);//�ִ� 10���� EnQueue�Ҽ� �ִ� ť
		while(true) {
			System.out.println("���� ������ �� : "+q.size() + " / "+ q.capacity());
			System.out.print("(1) enQueue (2) deQueue (3)peek  (4) dump (5) IndexOf (6) clear (7) isEmpty (8) isFull (9) search (0) ���� : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					q.enqueue(x);
				}catch (IntAryQueue.OverflowIntAryQueueException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
			case 2: 
				try {
					x = q.dequeue();
					System.out.println("deQueue�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntAryQueue.EmptyIntAryQueueException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 3: 
				try {
					x = q.peek();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 4: 
				q.dump();
				break;
			case 5:// IndexOf 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				int i = q.indexOf(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� Queue�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 6://clear
				q.clear();
				break;
			case 7://isEmpty
				if(q.isEmpty())
					System.out.println("ť�� ����ֽ��ϴ�.");
				else
					System.out.println("ť�� ������� �ʽ��ϴ�.");
				break;
			case 8://isFull
				if(q.isFull())
					System.out.println("ť�� ���� á���ϴ�.");
				else
					System.out.println("ť�� ���� ���� �ʾҽ��ϴ�.");
				break;
			case 9://search
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				int queueIndex = q.search(x);
				if(queueIndex == 0)
					System.out.println("ã�� �����Ͱ� Queue�� �������� �ʽ��ϴ�.");
				else
					System.out.println("ã�� �����Ͱ� "+ queueIndex+ "��°�� �����մϴ�");
				break;
				
			default : 
				System.out.println("�޴��� �����ϴ�.");
				break;
			}
		}
	}

}
