package ch06;

import java.util.Scanner;

//�ܼ����� ���� : ������ ��Ҹ� �׺��� �� ������ �˸��� ��ġ�� �����ϴ� �۾��� �ݺ�
// 			   ���� ���ĵ��� ���� ù��° ��Ҹ� ���ĵ� �κ��� �˸��� ��ġ�� ����
//			   -> �˸��� ��ġ�� �����ϱ����� ���ʿ� �̿��� ��Ұ� ������ ��Һ��� ũ�� �װ��� �����ϰ� ������ �̵��ϸ鼭 ���۾����ݺ�
//				= ������ �� ������ ��Ҹ� ������ �ش� ��ġ�� ������ ���� ����
//			   1. ���ĵ� ���� ���ʳ��� �����մϴ�. => j�� 0���� ũ��
//			   2. tmp���� �۰ų� ���� key�� ���� �׸�a[j]�� �߰��մϴ�. => a[j-1]���� tmp���� ũ��
//			   1.2.������ �ϳ��������Ҷ�����(=>�������� ��� �����Ҷ�����) �ݺ��Ѵ�.
public class InsertionSort {
	//�ܼ� ���� ����
	static void insertionSort(int[] a,int n) {
	
		for(int i=1;i<n;++i) {
			int j;
			int tmp = a[i];
			for(j=i ; j>0 && a[j-1] > tmp;j--) {
				a[j] = a[j-1];
			}
			a[j] = tmp;
			//�������� ����
			// ����� ��Ƚ���� ��ȯȽ�� = n^2/2 ȸ
		}
	}
	// �������� 7 : �ܼ���������(���ʹ����迭�� �Ӹ���Ҵ� ����ֽ��ϴ�.)
	static void insertionSortBacket(int[] a,int n) {
		for(int i=2;i<n;++i) {
			int j = i;
			int tmp = a[i];
			a[0] = a[i];
			for(; a[j-1] > tmp;j--) {
				a[j] = a[j-1];
			}
			if(j>0)
				a[j] = tmp;
		}
	}
	// �������� 8 : ������������(���ĵ� �պκп��� ��Ҹ� ã���� ���� Ž���� �̿��Ѵ�)
	static void insertionBinarySort(int[] a,int n) {
		for(int i=1;i<n;++i) {
			int tmp = a[i];
			int left =0;
			int right = i-1;
			int ptr;
			do {
				ptr = (left+right)/2;
				if(a[ptr] == tmp)//�˻� ����
					break;
				else if(a[ptr] < tmp)
					left = ptr+1;
				else
					right = ptr-1;
			}while(left <= right);
			int pd = (left <= right) ? ptr + 1 : right + 1;

			for (int j = i; j > pd; j--)
				a[j] = a[j - 1];
			a[pd] = tmp;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܼ� ���� ����");
		System.out.print("��ڼ� : ");
		
		int nx = sc.nextInt(); 
		int[] x = new int[nx]; 
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : "); 
			x[i] = sc.nextInt();
		}
		/*
		int nx = sc.nextInt();
		int[] x = new int[nx + 1]; // 1�� �������� ����

		for (int i = 1; i <= nx; i++) { // x[1]~x[nx]�� �о� ����
			System.out.print("x[" + i + "]��");
			x[i] = sc.nextInt();
		}
	 */
		//insertionSort(x, nx);
		//insertionSortBacket(x,nx+1);
		insertionBinarySort(x,nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<x.length;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
