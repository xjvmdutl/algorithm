package ch01;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// ���߷����� �����ϸ� ��ȣ�� �þ���� �ﰢ���̳� �簢�� ������� ��� ����
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("���� �Ʒ��� ������ �̵ �ﰢ���� ����մϴ�.");
		do {
			System.out.print("�� �� �ﰢ���Դϱ�?: ");
			n=sc.nextInt();
		}while(n<=0);
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
		
		spira(n);
		npira(n);
	}
	public static void triangleLB(int n) {//��������15: �����ﰢ���� ����ϴ� �κ��� �Ʒ��� ���� ������ �޼ҵ�� �ۼ�
		//���� �Ʒ��� ������ �̵ �ﰢ��
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleLU(int n) {//��������15: �����ﰢ���� ����ϴ� �κ��� �Ʒ��� ���� ������ �޼ҵ�� �ۼ�
		//������ ���� ������ �̵ �ﰢ��
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=n-i+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleRU(int n) {//��������15: �����ﰢ���� ����ϴ� �κ��� �Ʒ��� ���� ������ �޼ҵ�� �ۼ�
		//���� �Ʒ��� ������ �̵ �ﰢ��
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=i-1;++j) {
				System.out.print(" ");
			}
			for(int j=1;j<=n-i+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void triangleRB(int n) {//��������15: �����ﰢ���� ����ϴ� �κ��� �Ʒ��� ���� ������ �޼ҵ�� �ۼ�
		//���� �Ʒ��� ������ �̵ �ﰢ��
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=i;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	
	public static void spira(int n) {//��������16:n���� �Ƕ�̵帮 ���
		//i�࿡ (i-1)*2+1��
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=(i-1)*2+1;++j) {
				System.out.print("*");
			}	
			System.out.println();
		}
		System.out.println();
	}
	public static void npira(int n) {//��������17:n���� ���� �Ƕ�̵帮 ���
		//i�࿡ i%10��->10�̻� ������ ��� ����
		for(int i=1;i<=n;++i) {
			for(int j=1;j<=(n-i);++j) {
				System.out.print(" ");
			}	
			for(int j=1;j<=(i-1)*2+1;++j) {
				System.out.print(i%10);
			}	
			System.out.println();
		}
		System.out.println();
	}

}
