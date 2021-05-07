package ch06;

import java.util.Scanner;

public class BubbleSort2 {
	//���� ���� ���� : � �н����� ����� ��ȯ Ƚ���� 0�̸� ���̻� ������ ��Ұ� ���ٴ� ���̱� ������ ������ ���߾ �ȴ�.
	
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void print(int[] a,int idx,boolean isChk) {
		for(int i=0;i<a.length;++i) {
			if(i == idx) {
				if(isChk) 
					System.out.print("+");
				else
					System.out.print("-");
			}
			System.out.printf("%d  ",a[i]);
		}
		System.out.println();
	}
	//���� ����
	static void bubbleSort(int[] a,int n) {
		//�������� 3 : �� ��ȯ������ �ڼ��� ����ϸ鼭 ���ϴ� �� ��� ���� ��ȯ�� �����ϸ� + ������ -�� ����ϰ� ������ ��ġ�� ��Ƚ���� ��ȯȽ���� ���
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<n;++i) {
			System.out.println("�н� "+(i+1));
			int exchg = 0;
			for(int j=n-1;j>i;j--) {
				count1++;
				if(a[j-1] > a[j]) {
					count2++;//��ȯ Ƚ��
					print(a,j,true);
					swap(a, j-1, j);
					exchg++;
				}else {
					print(a,j,false);
				}
			}
			print(a,-1,false);
			if(exchg == 0)//��ȯ�� �̷�� ���� ������� 
				break;
			
		}
		System.out.println("�񱳸� "+count1+"ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� "+count2+"ȸ �߽��ϴ�.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����(���� 2)");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
}
