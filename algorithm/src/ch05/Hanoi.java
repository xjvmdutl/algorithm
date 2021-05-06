package ch05;

import java.util.Scanner;

import ch04.IntStack;

public class Hanoi {
	//�ϳ����� ž : ���������� ���� ū ������ �Ʒ��� ��ġ�Ҽ� �ֵ��� ������ 3�� ��ջ��̿��� �ű�� ����
	//��� ������ ũ�Ⱑ �ٸ��� ó������ ��� ������ ��Ģ�� �°� ù��° ��տ� �׿� �ִ�. �̻��¿��� ��� ������ ����° ������� �ű�� �ּ� Ƚ�� ���ϱ�(ū ������ ���� �������� �Ѽ� ����)
	//������ �ּ������� �ű�� ���ؼ��� 1,2 ������ �߰���տ� �ְ� ������ ������ ������ ������� �Űܾ� �ȴ�.
	//���� 2���� �ű�� ���� = 1�� ������ �߰�������� �ְ� 2�������� ������ ������� ������ �ٽ� 1�� ������ ���� �ø���.
	//��Ģ : ������ ������ ������ ������ �׷����� ���� �����ִ� ��տ� �ְ� ������ ������ ��ǥ ��տ� ������ �׷� ������ ���� �ø���.

	//no���� ������ x�� ��տ��� y�� ������� �ű��.
	static final String[] name = {"A","B","C"};//�������� : ���ڰ� �ƴ� ���ڿ��� ��� �̸��� ���
	static void move(int no, int x, int y) {
		if(no > 1) {
			move(no-1,x,6-x-y);//�߰�������� �ű��.//��� ��ȣ�� ����(1+2+3)�̹Ƿ� ���� ���,��ǥ����� �������̵��� �߰� ����� 6-x-y �� ���Ҽ��� �ִ�
		}
		System.out.println("����["+no+"]�� "+name[x-1]+"��տ��� "+name[y-1]+" ������� �ű�");
		if(no >1) {
			move(no-1,6-x-y,y);
		}
		
	}
	static void RemoveMove(int no, int x, int y) {
		int[] xstk = new int[100];
		int[] ystk = new int[100];
		int[] sstk = new int[100]; // ����
		int ptr = 0; // ���� ������
		int sw = 0;
		while(true) {
			if (sw == 0 && no > 1) {
				xstk[ptr] = x; // x�� ���� Ǫ��
				ystk[ptr] = y; // y�� ���� Ǫ��
				sstk[ptr] = sw; // sw�� ���� Ǫ��
				ptr++;
				no = no - 1;
				y = 6 - x - y;
				continue;
			}
			System.out.println("����["+no+"]�� "+x+"��տ��� "+y+" ������� �ű�");
			
			if (sw == 1 && no > 1) {
				xstk[ptr] = x; // x�� ���� Ǫ��
				ystk[ptr] = y; // y�� ���� Ǫ��
				sstk[ptr] = sw; // sw�� ���� Ǫ��
				ptr++;
				no = no - 1;
				x = 6 - x - y;
				if (++sw == 2)
					sw = 0;
				continue;
			}
			do {
				if (ptr-- == 0) // ������ �� ��
					return;
				x = xstk[ptr]; // ���� �����ϰ� �ִ� x�� ��
				y = ystk[ptr]; // ���� �����ϰ� �ִ� y�� ��
				sw = sstk[ptr] + 1; // ���� �����ϰ� �ִ� sw�� ��
				no++;
			} while (sw == 2);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ϳ����� ž");
		System.out.print("���� ���� : ");
		
		int n = sc.nextInt();
		//move(n,1,3);//n���� ������ 1->3������
		RemoveMove(n,1,3);
	}

}
