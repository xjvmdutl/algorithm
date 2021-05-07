package ch06;

import java.util.Scanner;

public class BubbleSort {
	//�������� : Ű���� ���� �����͸� ���ʿ� , �������� : Ű���� ���� �����͸� ���ʿ�
	//���� ���İ� �ܺ� ���� : �ϳ��� �迭���� �۾��Ҽ� �ִ°�� = ���� ���� , �۾��Ҽ� ���°�� = �ܺ� ����
	//���� �˰����� �ٽ� : ��ȯ, ����, ����
	//���� ���� : �̿��� ��Ҹ� ���ϰ� ��ȯ�ϴ� �۾��� ù��° ��ұ��� ��� ����(n-1ȸ ����) ���� ���� ��Ұ� �� ������ �̵��ϰ� �ȴ� 
	// 	       �̷��� ������ �н�( �� - > ��ȯ) �̶�� �Ѵ�.
	//		   �̷��� �н� ������ ��� ���� = n-1ȸ , n-2ȸ .... 
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
		//�������� 2 : �� ��ȯ������ �ڼ��� ����ϸ鼭 ���ϴ� �� ��� ���� ��ȯ�� �����ϸ� + ������ -�� ����ϰ� ������ ��ġ�� ��Ƚ���� ��ȯȽ���� ���
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<n;++i) {
			System.out.println("�н� "+(i+1));
			for(int j=n-1;j>i;j--) {
				count1++;
				if(a[j-1] > a[j]) {
					count2++;
					print(a,j,true);
					swap(a, j-1, j);
				}else {
					print(a,j,false);
				}
				
			}
			print(a,-1,false);
		}
		System.out.println("�񱳸� "+count1+"ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� "+count2+"ȸ �߽��ϴ�.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����(���� 1)");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		bubbleSort(x, nx);
		//bubbleSortReverse(x,nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}
	//�������� 1: ���������� �н��� ���ʺ��� ���� ū���� ��� ������ �̵�
	static void bubbleSortReverse(int[] a, int n) {
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<n-i-1;++j) {				
				if(a[j] > a[j+1]) {
					swap(a,j,j+1);
				}
			}
		}
	}
}
