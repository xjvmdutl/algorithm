package ch01;

import java.util.Scanner;

public class Multi99Table {

	public static void main(String[] args) {
		//�ݺ����� �ݺ��� : ���� ����
		System.out.println("  ----------����ǥ-----------");
		for(int i=1;i<=9;++i) {
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",i*j);
			}
			System.out.println();
		}
		System.out.println();
		Test1();
		Test2();
		Test3();
	}
	public static void Test1() {//�������� 12: ���ʰ� ���ʿ� ���ϴ� ���� �ִ� ����ǥ �ۼ� 
								//1 2 3 4 5 6 7 8 9
								//2
								//3
								//...
								//9
		System.out.print("   |");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.println("---+--------------------------");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d|",i);
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",j*i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void Test2() {//�������� 13 : ������ �ƴ϶� ������ ����ϴ� ���α׷��� �ۼ�
		System.out.print("   |");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		System.out.println("---+--------------------------");
		for(int i=1;i<=9;++i) {
			System.out.printf("%3d|",i);
			for(int j=1;j<=9;++j) {
				System.out.printf("%3d",j+i);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void Test3() {//�������� 14 : �Է��� ���� �Ѻ����� �ϴ� ���簢���� * ��ȣ�� ���
		Scanner sc = new Scanner(System.in);
		System.out.println("�簢���� ����մϴ�.");
		System.out.print("�� �� : ");
		int n = sc.nextInt();
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n;++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

