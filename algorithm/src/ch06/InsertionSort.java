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
		insertionSort(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
