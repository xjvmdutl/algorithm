package ch06;

import java.util.Scanner;

public class BubbleSort3 {
	//���� ���� ���� : ��� ���� ���Ŀ� ��ȯ�� ���̻� ������� �ʴ´ٸ� �� ���� ��Ҵ� �̹� ������ ��ģ �����̴�.���� ���� �񱳺��ʹ� ��ȯ�� �� ������ �ε��� ������ �н��� �����ϸ�ȴ�. 
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
		//�������� 4 : �� ��ȯ������ �ڼ��� ����ϸ鼭 ���ϴ� �� ��� ���� ��ȯ�� �����ϸ� + ������ -�� ����ϰ� ������ ��ġ�� ��Ƚ���� ��ȯȽ���� ���
		int count1 = 0;
		int count2 = 0;
		int passCount = 0; 
		
		int k = 0; //a[k]���� ���� ��Ҵ� ������ ��ģ �����̴�.
		//0���� �ʱ�ȭ �ϴ� ������ ù �н����� ��� ��Ҹ� �˻��ؾߵǱ� ����
		while(k < n-1) {
			System.out.println("�н� "+(++passCount));
			
			int last = n-1;//�� �н����� ���������� ��ȯ�� �ο�� ��� ������ ����� �ε����� �����ϱ� ���� ����
			for(int j=n-1; j>k;j--) {// j�� ������ ��Һ��� k��° ����
				count1++;
				if(a[j-1] > a[j]) {
					print(a,j,true);
					count2++;
					swap(a, j-1, j);
					last = j;//��ȯ�� ����ɶ����� ������ ����� �ε����� last�� ����
				}else {
					print(a,j,false);
				}
			}
			print(a,-1,false);
			k = last;// �ϳ��� �н��� �������� last ���� k�� �����Ͽ� ���� ������ �н� ���� ����
		}
		System.out.println("�񱳸� "+count1+"ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� "+count2+"ȸ �߽��ϴ�.");
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����(���� 3)");
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
