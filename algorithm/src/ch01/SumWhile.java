package ch01;

import java.util.Scanner;

public class SumWhile {

	public static void main(String[] args) {
		// 1~n���� ���� �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.println("1���� n������ ���� ���մϴ�.");
		System.out.print("n�� �� : ");
		int n = sc.nextInt();
		int sum =0;//��
		int i=1;
		while(i<=n) {//i�� n���ϸ� �ݺ�
			sum+=i;//sum�� i���Ѵ�
			
			i++;//i�� ����
		}
		System.out.println(i);//�������� while���� ����ɋ� ���� i���� n+1�� ���� Ȯ���ϼ���(���� i���� ����ϵ���)
		System.out.println("1���� "+n+ "������ ���� "+sum+"�Դϴ�");

	}


}
