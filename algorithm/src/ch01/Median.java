package ch01;

import java.util.Scanner;

public class Median {

	public static void main(String[] args) {
		//������ �߾Ӱ�
		Scanner sc = new Scanner(System.in);
		//3���� ������ ������ 13������ �ִ� (������ ������ ����� ���������̹Ƿ� ����Ʈ����� �Ѵ�)
		System.out.println("�� ������ �߾Ӱ��� ���Ѵ�.");
		System.out.print("a�� �� : ");int a = sc.nextInt();
		System.out.print("b�� �� : ");int b = sc.nextInt();
		System.out.print("c�� �� : ");int c = sc.nextInt();
		System.out.println("�߾Ӱ��� "+med3(a, b, c)+"�Դϴ�");
	}
	static int med3(int a,int b,int c) {//�������� 4
		if(a>b) {
			if(b>=c) {
				return b;
			}else if(a<=c) {
				return a;
			}else {
				return c;
			}
		}else if(a>=c) {
			return a;
		}else if(b<=c) {
			return b;
		}else {
			return c;
		}
	}
	/*
	static int med3(int a,int b,int c) {//�������� 5(ȿ�� �ٿ�)
		if((b>=a &&c<=a) || (b<=a && c>=a)){
			return a;
		}else if((a>b && c<b) || (a<b && c>b)){
			return b;
		}else{
			return c;
		}
		//ȣ���� �������� ������ �ϳ��� if������ �������� ������ ����ϱ� ������
	}
	*/
	
}
