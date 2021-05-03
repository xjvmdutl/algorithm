package ch04;

import java.util.Scanner;

public class IntDeQueTest {
	//��ť ��� ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntDeQue q = new IntDeQue(4);//�ִ� 10���� EnQueue�Ҽ� �ִ� ť
		while(true) {
			System.out.println("���� ������ �� : "+q.size() + " / "+ q.capacity());
			System.out.print("(1) enqueFront (2) enqueRear "
					+ "(3) dequeFront (4) dequeRear "
					+ "(5) peekFront  (6) peekRear "
					+ "(7) dump (8) indexOf"
					+ "(9) clear (10) isEmpty "
					+ "(11) isFull (12) search (0) ���� : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					q.enqueFront(x);
				}catch (IntDeQue.OverflowIntDequeException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
			case 2 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					q.enqueRear(x);
				}catch (IntDeQue.OverflowIntDequeException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
			case 3: 
				try {
					x = q.dequeFront();
					System.out.println("deQueue�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 4: 
				try {
					x = q.dequeRear();
					System.out.println("deQueue�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 5: 
				try {
					x = q.peekFront();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 6: 
				try {
					x = q.peekRear();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntDeQue.EmptyIntDequeException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 7: 
				q.dump();
				break;
			case 8:// IndexOf 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				int i = q.indexOf(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� Queue�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 9://clear
				q.clear();
				break;
			case 10://isEmpty
				if(q.isEmpty())
					System.out.println("ť�� ����ֽ��ϴ�.");
				else
					System.out.println("ť�� ������� �ʽ��ϴ�.");
				break;
			case 11://isFull
				if(q.isFull())
					System.out.println("ť�� ���� á���ϴ�.");
				else
					System.out.println("ť�� ���� ���� �ʾҽ��ϴ�.");
				break;
			case 12://search
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
