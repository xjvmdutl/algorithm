package ch06;

import java.util.Scanner;

public class shakeSort {
	//���� ���� ���� : ���� �������� �� �տ� �ְԵǸ� ������ �н����� �Ǿ� ��Ұ� ��ĭ�� ���� ������ �ð��� �����ɸ���.
	//				Ȧ�� ��° �н��� ���� ���� ��Ҹ� �Ǿ����� ¦����° �н��� ���� ū ��Ҹ� �ǵڷ� �ű�� ���
	//				����� ���� ����
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	//�������� ���� : �������� 5
	static void shakeSort(int[] a,int n) {
		int left = 0;
		int right = n - 1;
		int last = right;
		while (left < right) {
			for (int j = right; j > left; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			left = last;

			for (int j = left; j < right; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					last = j;
				}
			}
			right = last;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����(���� 4)");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shakeSort(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
}
