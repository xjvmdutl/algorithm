package ch05;

import java.util.Scanner;

//���丮���� ��������� ����
public class Factorial {
	// ���� ���� n�� ���丮���� ��ȯ�մϴ�
	static int factorial(int n) {
		if(n>0)
			return n*factorial(n-1);//��� ȣ��(�ڱ� �ڽŰ� �Ȱ��� �޼ҵ带 ȣ��)
		else
			return 1;
	}
	
	//�������� 1 : ��͸� ������� ���� ���丮��
	static int notFactorial(int n) {
		int num=1;//������ ����
		for(int i = 1;i<=n;++i)
			num *= i;
		return num;
		
	}
	
	//������� : �ڽŰ� ���� �޼ҵ带 ȣ��
	//������� : a -> b -> a ȣ���ϴ� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int x  = sc.nextInt();
		System.out.println(x+"�� ���丮���� "+factorial(x)+"�Դϴ�");
		System.out.println(x+"�� ���丮���� "+notFactorial(x)+"�Դϴ�");
	}
	
	
}
