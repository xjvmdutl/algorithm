package ch01;

import java.util.Scanner;

public class JudgeSign {

	public static void main(String[] args) {
		// �������� ��ȣ�� �Ǵ��Ͽ� ����ϴ� ���α׷�(����,0,���)
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int n= sc.nextInt();
		if(n>0)
			System.out.println("�� ���� ����Դϴ�.");
		else if(n<0)
			System.out.println("�� ���� �����Դϴ�.");
		else
			System.out.println("�� ���� 0�Դϴ�.");
	}
	

}
