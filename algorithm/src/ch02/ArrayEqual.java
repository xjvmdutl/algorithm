package ch02;

import java.util.Scanner;

public class ArrayEqual {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭 a ��� �� : ");
		int na = sc.nextInt();
		
		int[] a = new int[na];
		for(int i=0;i<a.length;++i) {
			System.out.print("a["+i+"] : ");
			a[i] = sc.nextInt();
		}
		
		System.out.print("�迭 b ��� �� : ");
		int nb = sc.nextInt();
		
		int[] b = new int[nb];
		for(int i=0;i<b.length;++i) {
			System.out.print("b["+i+"] : ");
			b[i] = sc.nextInt();
		}
		
		
		System.out.println("�迭 a�� b�� "+ (equals(a,b) ? "�����ϴ�" : "�����ʽ��ϴ�."));
		copy(a,b);
		
		for(int i=0;i<a.length;++i) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean equals(int[] a,int[] b) {
		//a�� b�� �������� �Ǵ�
		if(a.length != b.length)//a�� b�� ���� ��
			return false;
		for(int i=0;i<a.length;++i) {
			if(a[i] != b[i])
				return false;//�߰��� ���� ������� ����
		}
		return true;//���α׷��� ������ ����� ���
	}
	//�������� 4 : �迭 b�� ����Ҹ� �迭 a�� �����ϴ� �޼ҵ� copy�ۼ�
	public static void copy(int[] a,int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for(int i=0;i<num;++i)
			a[i]=b[i];
	}
	//�������� 5 : �迭 b�� ��� ��Ҹ� �迭 a�� �������� �����ϴ� �޼ҵ� rcopy�ۼ�
	public static void rcopy(int[] a,int[] b) {
		int num = a.length <= b.length ? a.length : b.length;
		for(int i=0;i<num;++i)
			a[i]=b[num-i-1];
	}
}
