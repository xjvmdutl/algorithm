package ch01;

import java.util.Scanner;

public class SumForPos {

	public static void main(String[] args) {
		// 1~n���� ���� �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.println("1���� n������ ���� ���մϴ�.");
		int n;
		do {//���� ������ �ѹ� ���� ��� �ݺ��� ������ �Ǵ��ϴ� ���� �Ǵ� �ݺ���
			System.out.print("n�� �� : ");
			n = sc.nextInt();
		}while(n<=0);//0���� Ŭ������ �ݺ�
		// ����/���� �Ǵ� �ݺ����� ���� : ������ �ѹ��� ���� �ȵɼ��� ������ ���Ĵ� �ݵ�� �ѹ��� ����ȴ�.
		int sum =0;//��
	
		for(int i=1;i<=n;++i) {
			sum+=i;//sum�� i�� ���Ѵ�
		}
		
		System.out.println("1���� "+n+ "������ ���� "+sum+"�Դϴ�");
		
		test1();
		test2();
	}
	public static void test1() {//�������� 10: �� ���� a,b�� ������ �Է��ϰ� b-a�� ����ϴ� ���α׷��ۼ�(�� b�� a���� Ŀ�ߵȴ�,������ �ٽ��Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("b-a�� ���� ���մϴ�.");
		int b;
		System.out.print("a�� �� : ");
		int a = sc.nextInt();
		do {//���� ������ �ѹ� ���� ��� �ݺ��� ������ �Ǵ��ϴ� ���� �Ǵ� �ݺ���
			System.out.print("b�� �� : ");
			b = sc.nextInt();
			if(b<=a) System.out.println("a���� ū���� �Է��ϼ���");
		}while(b<=a);//a���� Ŭ������ �ݺ�
		System.out.println("b-a�� "+(b-a)+"�Դϴ�");
	}
	public static void test2() {//�������� 11: ���� ������ �Է��ϰ� �ڸ����� ����ϴ� ���α׷�
		Scanner sc = new Scanner(System.in);
		System.out.println("�ڸ����� ���մϴ�");
		int num;
		int count = 0;
		do {//���� ������ �ѹ� ���� ��� �ݺ��� ������ �Ǵ��ϴ� ���� �Ǵ� �ݺ���
			System.out.print("num�� �� : ");
			num = sc.nextInt();
		}while(num<=0);//0���� Ŭ������ �ݺ�
		do {
			num/=10;
			count++;
		}while(num>0);
		System.out.println("�׼��� "+count + "�ڸ��Դϴ�");
	}
}
