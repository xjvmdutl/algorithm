package ch03;

import java.util.Scanner;

public class SeqSearch {
	public static int seqSearch(int[] a,int n, int key) {//��Ҽ� =n �迭 a , key�� ã��
		/*
		int i =0;
		while(true) {
			if(i == n) {//�˻� ����
				return -1;
			}
			if(a[i] == key) { //�˻� ����(�ε��� ��ȯ)
				return i;
			}
			i++;
		}
		*/
		
		//for�� ����
		for(int i=0;i<a.length;++i) {
			if(a[i] == key) { //�˻� ����(�ε��� ��ȯ)
				return i;
			}
			
		}
		//�˻� ����
		return -1;
	}
	public static int printSeqSearch(int[] a,int n, int key) {//��������2: ȭ������ ���
		System.out.print("  | ");
		for(int i=0;i<n;++i) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("--+-------------------");
		//for�� ����
		for(int i=0;i<a.length;++i) {
			System.out.print("  | ");
			for(int j=0;j<=i;++j) {
				if(i==j)
					System.out.print("*");
				System.out.print("  ");
				
			}
			System.out.println();
			System.out.print(i+" | ");
			for(int j=0;j<n;++j) {
				System.out.print(a[j]+" ");
			}
			System.out.println();
			if(a[i] == key) { //�˻� ����(�ε��� ��ȯ)
				return i;
			}
			
		}
		//�˻� ����
		return -1;
	}
	
	public static void main(String[] args) {
		//�˻� : 1. �����˻� : �������� �þ���� ������ ���ӿ��� �˻��� ���� 
		//		2. ���� �˻� : ������ ��Ģ���� �þ���� ������ ���ӿ��� ���� ���� �˻�
		//		3. �ؽ� �� : �߰�,������ ���� �Ͼ�� ������ ���ӿ��� ���� ���� �˻�
		//		- ü�ι� : ���� �ؽð��� �����͸� ���� ����Ʈ�� ����
		//		- ���� �ּҹ� : �����͸� ���� �ؽð��� �浹�Ҷ� ���ؽ� �ϴ� ���
		// �����˻� : ��Ұ� ����������� �þ �迭������ �˻��� ���ϴ� Ű���� ���� ��Ҹ� ������ ���� �Ǿպ��� ������� ��Ҹ� �˻�
		// ���� : �迭 ũ��� ���ϴ� �˻��� ã�Ҵ�, ���� : �˻��� ������ �����ص� ���ϴ� ���� ã�� ���ߴ�.(��������)
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		for(int i =0; i<num;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();
		
		int idx = seqSearch(x, num, ky);
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");

	}

}
