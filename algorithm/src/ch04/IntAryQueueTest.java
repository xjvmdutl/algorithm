package ch04;

import java.util.Scanner;

public class IntAryQueueTest {
	//������ ��� ��
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IntAryQueue q = new IntAryQueue(10);//�ִ� 10���� EnQueue�Ҽ� �ִ� ť
		while(true) {
			System.out.println("���� ������ �� : "+q.size() + " / "+ q.capacity());
			System.out.print("(1) enQueue (2) deQueue (3)dump (4)IndexOf (5)clear (6)isEmpty (7)isFull (0) ���� : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					q.EnQueue(x);
				}catch (IntAryQueue.OverflowIntAryQueueException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
			case 2: 
				try {
					x = q.DeQueue();
					System.out.println("deQueue�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntAryQueue.EmptyIntAryQueueException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 3: 
				q.dump();
				break;
			case 4:// IndexOf 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				int i = q.IndexOf(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� Queue�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 5://clear
				q.clear();
				break;
			case 6://isEmpty
				if(q.isEmpty())
					System.out.println("ť�� ����ֽ��ϴ�.");
				else
					System.out.println("ť�� ������� �ʽ��ϴ�.");
				break;
			case 7://isFull
				if(q.isFull())
					System.out.println("ť�� ���� á���ϴ�.");
				else
					System.out.println("ť�� ���� ���� �ʾҽ��ϴ�.");
				break;
			default : 
				System.out.println("�޴��� �����ϴ�.");
				break;
			}
		}
		
	}

}
