package ch02;

import java.util.Scanner;

//�������� 11 : ���� ������� �ʵ�� ���� Ŭ������ �����
public class YMD {
	
	// �� ���� �ϼ�
	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ���
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // ����
	};

	// ���� year���� �����ΰ�? (���⣺1����⣺0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}
	
	int y;//��
	int m;//��(1~12)
	int d;//��(1~31)
	
	YMD(int y,int m,int d){//������
		this.y=y;
		this.m=m;
		this.d=d;
	}
	public YMD after(int n) {//n�� �� ��¥ ��ȯ
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (before(-n));

		temp.d += n;//n���� d�� ���Ѵ�.

		while(temp.d >= mdays[isLeap(temp.y)][temp.m-1]) {
			temp.d -= mdays[isLeap(temp.y)][temp.m-1];
			temp.m++;
			if(temp.m > 12) {
				temp.y++;
				temp.m=1;
			}
		}
		return temp;
	}
	// n�� ���� ��¥�� ��ȯ
	YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (after(-n));

		temp.d -= n;

		while (temp.d < 1) {
			if (--temp.m < 1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m - 1];
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("��¥�� �Է��ϼ���.\n");
		System.out.print("�⣺");
		int y = stdIn.nextInt();
		System.out.print("����");
		int m = stdIn.nextInt();
		System.out.print("�ϣ�");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);

		System.out.print("�� �� ��/���� ��¥�� ���ұ��?��");
		int n = stdIn.nextInt();

		YMD d1 = date.after(n);
		System.out.printf("%d�� ���� ��¥�� %d�� %d�� %d���Դϴ�.\n", n, d1.y, d1.m, d1.d);

		YMD d2 = date.before(n);
		System.out.printf("%d�� ���� ��¥�� %d�� %d�� %d���Դϴ�.\n", n, d2.y, d2.m, d2.d);
	}
	
	//Ŭ���� ����
	//Ŭ���� ���� : �ɹ�, Ŭ���� �ʱ�ȭ, �ν��Ͻ� �ʱ�ȭ, ������
	//			 �ʵ�/�޼ҵ�/������ ����� public/protected/private ����
	//			 �޼ҵ�/������ �����ε� ����
	//			 final������ �ʵ�� �ѹ��� �� ���԰���
	//			 �����ڴ� ���� ������ �ν��Ͻ��� �ʱ�ȭ�� ���� ���
	//���� Ŭ���� : Ŭ������ ���� �����ڸ� public���� ������ Ŭ������ �ٸ� ��Ű������ ��� ����
	//final Ŭ���� : Ŭ���� ���� �����ڸ� final�� ������ Ŭ������ ����Ŭ������ ������ ����(���x)
	//�Ļ� Ŭ���� : Ŭ���� A�� ���� ����  Ŭ������ �Ϸ��� ����� extends A�� �߰�
	//���� ���̽� : �������̽� X�� �����Ϸ��� ���� implements X�� �߰�
	//�߻� Ŭ���� : Ŭ������ ���� ������ abstract�� ���� Ŭ������ ����� �߻� �޼ҵ带 ������ �ִ� �߻�Ŭ������ �ȴ�(�ҿ����� Ŭ������ �ν��Ͻ� ����� ����)
	//��ø Ŭ���� : Ŭ����/�������̽� �ȿ� ������ Ŭ���� 
	//			 ���Ŭ���� = ������ �ٸ� Ŭ���� �Ǵ� �������̽� ���� �ѷ����� Ŭ����
	//			 ����Ŭ���� = ��������ε� �Ϲ������ε� �������� ������� ���� ��øŬ����(���� �ʱ�ȭ�� ��� �������̽� �����Ҽ� ����)(�����Ͻ� ����ʵ尡 �ƴ� ���� ����� �����Ҽ� ����)
	//			 ����Ŭ���� = �̸��� �־��� ��øŬ������ ���� Ŭ����(� Ŭ������ ����� �ɼ� ����)
}
