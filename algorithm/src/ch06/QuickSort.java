package ch06;

import java.util.Scanner;

import ch04.IntStack;
//��Ұ� 1���� ������ ���� ��� �׷����� ������ �����Ѵ�.
//pr�� a[0]���� �����ʿ� ������ (left < pr) ���ʱ׷����� ������
//pl�� a[8]���� ���ʿ� ������ (right > pl) �����ʱ׷����� ������
//��� �׷��� ���� ��󿡼� ����
public class QuickSort {
	static void swap(int[] a,int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	static void quickSort(int[] a, int left,int right) {
		
		int pl = left;//���� Ŀ��
		int pr =right;//������ Ŀ��
		int x = a[(pl+pr)/2];//�ǹ�
		//��Ȱ ���� �߰�
		System.out.printf("a[%d]~a[%d]:{",left,right);
		for(int i=left;i<right;++i) 
			System.out.printf("%d , ",a[i]);
		System.out.printf("%d}\n",a[right]);
		
		do {
			while(a[pl]<x)pl++;
			while(a[pr]>x)pr--;
			if(pl <=pr)
				swap(a,pl++,pr--);
		}while(pl <= pr);
		//left < pr, pl< right�� ��� �׷��� 1���� ��� �������� �ʴ� �����̴�
		/*
		if(left < pr) quickSort(a, left, pr);
		if(pl < right) quickSort(a, pl, right);
		*/
		//�������� 12 : ����� ������ ���� �׷���� ���� ������ �޼ҵ�� ����
		if((pr - left) > (right - pl) ) {//������ Ŭ���
			if(left < pr) quickSort(a, left, pr);
			if(pl < right) quickSort(a, pl, right);
		}else {
			if(pl < right) quickSort(a, pl, right);
			if(left < pr) quickSort(a, left, pr);
		}
		
		
	}
	//�� ����� ����
	/*
	static void romoveQuickSort(int[] a, int left,int right) {
		IntStack lstack = new IntStack(right-left+1);//���� ������ ���� ������� �ε����� ����
		IntStack rstack = new IntStack(right-left+1);//���� ������ ������ ������� �ε����� ����
		//������ ũ��� ���� �迭�� ��ڼ�
		lstack.push(left);
		rstack.push(right);
		//�������� 11 : push,pop,���Ұ����� ���
		System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", left, right);
		System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();
		while(!lstack.isEmpty()) {//������ �������� ����
			int pl = left = lstack.pop();//���� ���ÿ��� ���Ѱ��� left����
			int pr = right = rstack.pop();//�����ʽ��ÿ��� ���Ѱ��� right����
			int x = a[(left+right)/2];//�ǹ�
			System.out.printf("���ÿ��� �����ϴ� ������ ���½��ϴ�.a[%d]~a[%d]�� �����մϴ�.\n", left, right);
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl <=pr)
					swap(a,pl++,pr--);
			}while(pl <= pr);
			if(left < pr) {//�׷��� 2���� ������ ���� left�� pr�� push
				lstack.push(left);
				rstack.push(pr);
				System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", left, pr);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
			if(pl < right) {//�׷��� 2���� ������ ���� pl��ҿ� right��  push
				lstack.push(pl);
				rstack.push(right);		
				System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", pl, right);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
		}
	}
	*/
	static void romoveQuickSort(int[] a, int left,int right) {
		//������ �뷮 : ���� �׷�� ������ �׷��� ����� ������ ���Ͽ� ���� ������ ���� ������ ���� ��������
		//ex ) 6 5 4 2 7 3 1 8 :������ ��� �Ǻ� = 2
		// 1 2  / 4 5 7 3 6 8 
		//1. ����� ������ ���� �׷���� Ǫ�� : ���ÿ� �ִ� ���� = 2 
		//2. ����� ������ ���� �׷���� Ǫ�� : ���ÿ� �ִ� ���� = 4
		// �� ����� ������ ���� �׷��� ������ ���� ����� ������ ���� �׷���� ���� �����ؾ��� ���ÿ� ���ÿ� ���̴� ������ ���� �پ���.
	
		
		IntStack lstack = new IntStack(right-left+1);
		IntStack rstack = new IntStack(right-left+1);
		lstack.push(left);
		rstack.push(right);
		System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", left, right);
		System.out.print("Lstack:");
		lstack.dump();
		System.out.print("Rstack:");
		rstack.dump();
		while(!lstack.isEmpty()) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left+right)/2];
			System.out.printf("���ÿ��� �����ϴ� ������ ���½��ϴ�.a[%d]~a[%d]�� �����մϴ�.\n", left, right);
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl <=pr)
					swap(a,pl++,pr--);
			}while(pl <= pr);
			//�������� 12 : ����� ������ ���� �׷���� ���� ������ �޼ҵ�� ����
			if((pr - left) > (right - pl) ) {//������ Ŭ���
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
					System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", left, pr);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);		
					System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", pl, right);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
			}else {
				if(pl < right) {
					lstack.push(pl);
					rstack.push(right);		
					System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", pl, right);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
				if(left < pr) {
					lstack.push(left);
					rstack.push(pr);
					System.out.printf("a[%d]~a[%d]�� �����ϴ� ������ ���ÿ� Ǫ���մϴ�.\n", left, pr);
					System.out.print("Lstack:");
					lstack.dump();
					System.out.print("Rstack:");
					rstack.dump();
				}
			}
			
		}
	}
	
	//�������� 10 : quickSort(int[] a,int n)���� �����ϴ� �޼ҵ带 ����
	// ������(n �� ��ڼ�)
	static void quickSort(int[] a, int n) {
		//quickSort(a, 0, n - 1);
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
