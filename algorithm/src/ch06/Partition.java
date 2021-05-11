package ch06;

import java.util.Scanner;

//�� ���� : ���ļӵ��� �ſ� ������. �ǹ�(������ ����)�� ���� �׷��� ������ �ٽ� �ǹ��� �����س����� ������ �ݺ��ϸ� ��� �׷��� 1���� �Ǹ� ������ ��ģ��.
//�迭 �� �� �׷����� ������ : �׷����� ������ ���� ���� 
//1. a[pl] >= x �����ϴ� ��Ҹ� ã��������  pl�� ������ ��ĵ
//2. a[pr] <= x �� �����ϴ� ��Ҹ� ã�� ������ pr�� ���� ��ĵ
// ã�� ��� : a[pl] <-> a[pr] ��� swap
// pr�� pl�� �����ϰ� �ɶ����� ����
// pl�� pr�� ���Ͽ�ҿ� ������� ��ȯ���ش�(�ǹ� ���� ���������� ��ȯ���� �ʴ´ٸ� ��Ҹ� ��ȯ�ϱ� ���� pl, pr�� ���Ͽ������ �ִ����� �Ź� �˻��ؾߵȴ�)
public class Partition {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	//�迭�� ������.
	static void partition(int[] a, int n) {
		int pl = 0;//���� Ŀ��
		int pr = n-1;//������ Ŀ��
		int x = a[n/2];//�ǹ�
		do {
			while(a[pl]<x)pl++;
			while(a[pr]>x)pr--;
			if(pl <=pr)
				swap(a,pl++,pr--);
		}while(pl <= pr);
		System.out.println("�ǹ��� ���� "+x+"�Դϴ�");
		
		System.out.println("�ǹ� ������ �׷�");//a[0] ~ a[pl-1]
		for(int i=0;i<=pl-1;++i)
			System.out.print(a[i]+" ");
		System.out.println();
		
		if(pl>pr+1) {
			System.out.println("�ǹ��� ��ġ�ϴ� �׷�");//a[pr+1] ~ a[pl-1]
			for(int i=pr+1;i<=pl-1;++i)
				System.out.print(a[i]+" ");
			System.out.println();
		}
		
		System.out.println("�ǹ� �̻��� �׷�");//a[pr+1] ~ a[n-1]
		for(int i=pr+1;i<n;++i)
			System.out.print(a[i]+" ");
		System.out.println();
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���� �迭 ������(step1)");
		System.out.print("��ڼ� : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		partition(x,nx);
		
	}

}
