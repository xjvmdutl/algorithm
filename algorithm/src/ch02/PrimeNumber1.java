package ch02;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		//�Ҽ� ���ϱ� : �ڽŰ� 1�̿��� � �����ε� ������ ���� �ʴ� ����(2~n-1���� � �����ε� ������ �������� �ʴ´�)
		int count =0;
		for(int n=2;n<=1000;++n) {
			int i;//�������� Ƚ��
			for(i=2;i<n;++i) {
				count++;
				if(n%i ==0)//������ �������� �Ҽ��� �ƴϴ�
					break;//���̻� �ݺ� x
			}
			if(n==i) {//���������� ������ �������� ����
				System.out.println(n);
			}
		}
		System.out.println("�������� ������ Ƚ�� : "+count);//���ʿ��� �������� �ϰ� �ִ°� Ȯ���Ҽ��ִ�. 
		
		
	}

}
