package ch06;

import java.util.Scanner;

import ch04.IntStack;
//��Ұ� 1���� ������ ���� ��� �׷����� ������ �����Ѵ�.
//pr�� a[0]���� �����ʿ� ������ (left < pr) ���ʱ׷����� ������
//pl�� a[8]���� ���ʿ� ������ (right > pl) �����ʱ׷����� ������
//��� �׷��� ���� ��󿡼� ����
public class QuickSort2 {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	// �ܼ���������
	static void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int tmp = a[i];
			int j;
			for (j = i; j > left && a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
	//�������� 13 : ��Ҽ��� 9�� ������ ��� �ܼ� ���� ���ķ� 
	static void quickSort(int[] a, int left,int right) {
		
		if (right - left < 9)
			insertionSort(a, left, right);
		else {
			int pl = left; // ���� Ŀ��
			int pr = right; // ������ Ŀ��
			int x = a[(pl + pr) / 2]; // �ǹ� (�߾��� ���)

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			if (pr - left < right - pl) {
				int temp;
				temp = left;
				left = pl;
				pl = temp;
				temp = right;
				right = pr;
				pr = temp;
			}
			if (left < pr)
				quickSort(a, left, pr);
			if (pl < right)
				quickSort(a, pl, right);
		}
	}

	static void romoveQuickSort(int[] a, int left,int right) {
		
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);

		lstack.push(left);
		rstack.push(right);

		while (!lstack.isEmpty()) {
			int pl = left = lstack.pop(); // ���� Ŀ��
			int pr = right = rstack.pop(); // ������ Ŀ��

			if (right - left < 9)
				insertionSort(a, left, right);
			else {
				int x = a[(left + right) / 2]; // �ǹ��� �߾��� ���
				do {
					while (a[pl] < x)
						pl++;
					while (a[pr] > x)
						pr--;
					if (pl <= pr)
						swap(a, pl++, pr--);
				} while (pl <= pr);

				if (pr - left < right - pl) {
					int temp;
					temp = left;
					left = pl;
					pl = temp;
					temp = right;
					right = pr;
					pr = temp;
				}
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			}
		}
	}
	static void quickSort(int[] a, int n) {
		romoveQuickSort(a,0,n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���� ������Լ�");
		//System.out.println("�� ���� ����Լ�");
		System.out.print("��ڼ� : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		quickSort(x,nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"] = "+ x[i]);
	}

}
