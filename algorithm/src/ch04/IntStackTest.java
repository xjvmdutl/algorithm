package ch04;

import java.util.Scanner;

public class IntStackTest {
	//������ ��� ��
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);//�ִ� 64���� push�Ҽ� �ִ� ����
		while(true) {
			System.out.println("���� ������ �� : "+s.size() + " / "+ s.capacity());
			System.out.print("(1) push (2) pop (3) peek (4)dump (5)IndexOf (6)clear (7)isEmpty (8)isFull (0) ���� : ");//�������� 1 : IntStack�� ��� �޼ҵ带 ����ϴ� ���α׷� �ۼ�
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.push(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2: 
				try {
					x = s.pop();
					System.out.println("pop�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 4: 
				s.dump();
				break;
			
			case 5:// IndexOf 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				int i = s.IndexOf(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� stack�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 6://clear
				s.clear();
				break;
			case 7://isEmpty
				if(s.isEmpty())
					System.out.println("������ ����ֽ��ϴ�.");
				else
					System.out.println("������ ������� �ʽ��ϴ�.");
				break;
			case 8://isFull
				if(s.isFull())
					System.out.println("������ ���� á���ϴ�.");
				else
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			default : 
				System.out.println("�޴��� �����ϴ�.");
				break;
			}
		}
		*/
		/*
		Scanner sc = new Scanner(System.in);
		GStack<String> s = new GStack(64);//�ִ� 64���� push�Ҽ� �ִ� ����
		while(true) {
			System.out.println("���� ������ �� : "+s.size() + " / "+ s.capacity());
			System.out.print("(1) push (2) pop (3) peek (4)dump (5)IndexOf (6)clear (7)isEmpty (8)isFull (0) ���� : ");//�������� 1 : IntStack�� ��� �޼ҵ带 ����ϴ� ���α׷� �ۼ�
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			String x;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.next();
				try {
					s.push(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2: 
				try {
					x = s.pop();
					System.out.println("pop�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 4: 
				s.dump();
				break;
			
			case 5:// IndexOf 
				System.out.print("ã�� ������ : ");
				x = sc.next();
				int i = s.IndexOf(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� stack�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 6://clear
				s.clear();
				break;
			case 7://isEmpty
				if(s.isEmpty())
					System.out.println("������ ����ֽ��ϴ�.");
				else
					System.out.println("������ ������� �ʽ��ϴ�.");
				break;
			case 8://isFull
				if(s.isFull())
					System.out.println("������ ���� á���ϴ�.");
				else
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			default : 
				System.out.println("�޴��� �����ϴ�.");
				break;
			}
		}
		*/
		Scanner sc = new Scanner(System.in);
		IntDoubleStack s = new IntDoubleStack(4);//�ִ� 64���� push�Ҽ� �ִ� ����
		while(true) {
			System.out.println("���� ������ �� : "+s.sizeLeft() + " / "+ s.capacityLeft());
			System.out.println("���� ������ �� : "+s.sizeRight() + " / "+ s.capacityRight());
			System.out.print("(1) pushLeft (2) pushRight "
					+ "(3) popLeft (4) popRight "
					+ "(5) peekLeft (6) peekRight "
					+ "(7) dumpLeft (8) dumpRight "
					+ "(9) IndexOfLeft (10) IndexOfRight "
					+ "(11) clearLeft (12) clearRight "
					+ "(13) isEmptyLeft (14) isEmptyRight "
					+ "(15) isFullLeft (16)isFullRight"
					+ "(0) ���� : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			int x;
			int i;
			switch (menu) {
			case 1 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.pushLeft(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2 : 
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.pushRight(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 3: 
				try {
					x = s.popLeft();
					System.out.println("pop�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 4: 
				try {
					x = s.popRight();
					System.out.println("pop�� �����ʹ� "+x+"�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 5:
				try {
					x = s.peekLeft();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 6:
				try {
					x = s.peekRight();
					System.out.println("peek�� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 7: 
				s.dumpLeft();
				break;
			case 8: 
				s.dumpRight();
				break;
			case 9: 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				i = s.IndexOfLeft(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� stack�� �������� �ʽ��ϴ�.");
				else
					System.out.println("s["+i+"] = "+x);
				break;
			case 10: 
				System.out.print("ã�� ������ : ");
				x = sc.nextInt();
				i = s.IndexOfRight(x);
				if(i==-1)
					System.out.println("ã�� �����Ͱ� stack�� �������� �ʽ��ϴ�.");
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
					System.out.println("������ ����ֽ��ϴ�.");
				else
					System.out.println("������ ������� �ʽ��ϴ�.");
				break;
			case 14://isEmpty
				if(s.isEmptyRight())
					System.out.println("������ ����ֽ��ϴ�.");
				else
					System.out.println("������ ������� �ʽ��ϴ�.");
				break;
			case 15://isFull
				if(s.isFullLeft())
					System.out.println("������ ���� á���ϴ�.");
				else
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			case 16://isFull
				if(s.isFullRight())
					System.out.println("������ ���� á���ϴ�.");
				else
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			default : 
				System.out.println("�޴��� �����ϴ�.");
				break;
			}
		}
	}

}
