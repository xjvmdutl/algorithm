package ch05;

import java.util.Scanner;
//�� ������ �ִ������� ��ͷ� ���ϴ� ��� : �� ������ �־��� ��� ū���� ���� ������ ���������� ������ �������� ���� ���� �� = �ִ� �����
//									������ ���� ������ �������� ���� ������ ������������ ���� ������ ��������� �ݺ�
//									���� �ִ� ������� gcd(x,y)���� y�� 0�̸� x�̰� y�� 0�� �ƴϸ� gcd(y,x%y)�� ���Ѵ�
//ex) ���簢������ : �μ��� �Ѻ��� x,y�� ���簢������ ������ �ϸ� ª������ ������ ���簢���� ª������ ũ�⺸�� ���� ���簢��(x%y,22,8�ϰ�� 22�� 8�γ��� ������)�� ������ �Ǵµ�
//	�̸� ���簢���鸸�� �������� ���� �ɶ����� (x%y == 0) ����Լ��� �����ش� = gcd(y,x%y)
					
public class EuclidGCD {
	static int gcd(int x,int y) {
		if(y==0)
			return x;
		else
			return gcd(y,x%y);
	}
	//�������� 2 : ��͸� ������� �ʰ� �ִ����� ���ϱ�
	static int notGcd(int x,int y) {
		int num = 1;
		while(num!=0) {
			//������ ����
			num = x%y;
			x = y;
			y = num;
		}
		return x;
	}
	//�������� 3 : �迭 a�� ������� �ִ������� ���ϴ� �޼ҵ带 �ۼ�
	static int gcdArray(int[] a) {
		int x =a[0];
		for(int i=1;i<a.length;++i) {
			x = gcd(x,a[i]);
		}
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �ִ������� ���մϴ�.");
		
		System.out.print("������ �Է��ϼ��� : "); 
		int x  = sc.nextInt();
		
		System.out.print("������ �Է��ϼ��� : "); 
		int y  = sc.nextInt();
		
		
		System.out.println("�ִ� ������� "+gcd(x,y)+"�Դϴ�");
		System.out.println("�ִ� ������� "+notGcd(x,y)+"�Դϴ�");
		
		System.out.println("�迭 ����� �ִ������� ���մϴ�.");
		
		int size  = 1;
		
		do {
			System.out.print("�迭 ũ�⸦ �Է��ϼ��� : "); 
			size = sc.nextInt();
		}while(size<2);
		int[] a = new int[size];
		int z;
		for(int i=0;i<size;++i) {
			do {
				System.out.print("������ �Է��ϼ��� : "); 
				z = sc.nextInt();
			}while(z<=0);
			a[i] = z;
		}
		
		System.out.println("�ִ� ������� "+gcdArray(a) +"�Դϴ�");
	}
}
