package ch01;

import java.util.Scanner;

public class SumFor {

	public static void main(String[] args) {
		// 1~n���� ���� �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.println("1���� n������ ���� ���մϴ�.");
		System.out.print("n�� �� : ");
		int n = sc.nextInt();
		int sum =0;//��
		
		for(int i=1;i<=n;++i) {
			sum+=i;//sum�� i�� ���Ѵ�
		}
		
		System.out.println("1���� "+n+ "������ ���� "+sum+"�Դϴ�");
		
		test1(n);
		test2(n);
		sumof(2,5);
		//for�� �ڼ��� �˱� : 1) �ʱ�ȭ ����� ������Ʈ �κ��� ������ ���������� �����ݷ� ����x 2) for�� �ʱ�ȭ �κп��� ����� ������ for���ȿ����� ��� �����ϴ�.
		//���� ���� �Լ��� �ϳ��̻��� for������ �����̸��� ������ ����Ϸ��� for������ ������ �����ϸ� �ȴ�.
		
	}
	//��������7 : n�� 7�ϰ�� 1+2+3+4+5+6+7=28�� ����ϴ� ���α׷� �ۼ�
	public static void test1(int n) {
		int sum = 0;
		for(int i=1;i<=n;++i) {
			System.out.print(i);
			sum+=i;
			if(i==n) {
				System.out.println(" = "+ sum);
				break;
			}
			System.out.print(" + ");
		}
	}
	//��������8 : 1~10������ ���� (1+10)*5�� ���� ������� ���Ҽ� �ֽ��ϴ� �� ����� �̿��Ͽ� 1~n������ ���� ���ϴ� ���α׷� �ۼ�
	public static void test2(int n) {
		int sum = 0;
		if(n%2==0) {
			sum = (1+n)*(n/2);
		}else {
			sum = (1+n)*(n/2)+n/2+1;
		}
		System.out.println("1���� "+n+ "������ ���� "+sum+"�Դϴ�");
	}
	//��������9 : 1~10������ ���� (1+10)*5�� ���� ������� ���Ҽ� �ֽ��ϴ� �� ����� �̿��Ͽ� 1~n������ ���� ���ϴ� ���α׷� �ۼ�
	public static void sumof(int a,int b) {
		int sum = 0;
		for(int i=a;i<=b;++i) {
			sum+=i;
		}
		System.out.println(a+"���� "+b+ "������ ���� "+sum+"�Դϴ�");
	}
}
