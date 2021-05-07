package ch06;
//�ܼ� ���� ���� : ���� ���� ��Һ��� ������ �˸��� ��ġ�� �Űܼ� ������� �����ϴ� �˰���
//��ȯ ���� 1. ���� �������� ���� �κп��� �������� Ű�� ���� ����
//		  2. ���� ���� Ű ���� �������� ���� �κ��� ù��° ��Ҷ� ��ȯ
//�̰����� n-1ȸ �ݺ�

import java.util.Scanner;

public class SelectionSort {
	
	static void swap(int[] a, int idx1,int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void print(int[] a,int idx1,int idx2) {
		for(int i=0;i<a.length;++i) {
			if(i == idx1) {
				System.out.print("+  ");
			}else if(i==idx2){
				System.out.print("*  ");
			}else {
				System.out.print("   ");
			}
		}
		System.out.println();
		for(int i=0;i<a.length;++i) {
			System.out.printf("%d  ",a[i]);
		}
		System.out.println();
	}
	static void selectionSort(int[] a,int n) {
		for(int i=0;i<n-1;++i) {
			//��������6 : ����� ��ȯ������ �ڼ��ϰ� ����Ҽ� �ֵ��� ���� ( �������� ���� �κ��� ù��° ������� *, �������� ���� �κ��� �������� ���� ��������� +��)
			int min = i; //���� ���ĵ��� ���� �κп��� ���� ���� ����� �ε��� ���
			for(int j=i+1;j<n;++j) {
				if(a[j] < a[min])
					min = j;//���� ���� ����� �ε����� ����
			}
			print(a,min,i);
			//���� ������ �ִ� ��Ҹ� ��ȯ�ϴ� �� �̱� ������ ���������� �ʴ�(���� ��Ұ� 2�� ������ �� ����� ������ �ڹٲ��)
			swap(a,i,min);//���� ���ĵ��� ���� �κ��� ù�κа� ���� ���� ��Ҹ� ��ȯ
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		selectionSort(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
