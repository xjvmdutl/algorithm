package ch04;

import java.util.Scanner;

public class GStackTest {
	//������ ��� ��
	public static void main(String[] args) {
		
		
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
	}

}
