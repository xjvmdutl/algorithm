package ch06;

import java.util.Scanner;

//�ܼ� ���� ������ Ư¡ : ������ �����ų� ��ģ ���¿� �������� ���� �ӵ��� ������ (����) , ������ ��ġ�� �ָ� ������ ������ �̵�Ƚ���� ������(����)
//�� ���� : �ܼ� ���� ���� ������ �츮�� ������ ���� 
//		  ������ �迭�� ��Ҹ� �׷����� ���� ���׷캰�� �ܼ� ���� ������ �����ϰ� �� �׷��� ��ġ�鼭 ������ �ݺ�
//4���� : 4ĭ ��ŭ ������ ��Ҹ� ��� �׷����� ������ ����
//2���� : 2ĭ ��ŭ ������ ��Ҹ� ��� �׷����� ������ ����
//1���� : 1ĭ ��ŭ ������ ��Ҹ� ��� �׷����� ������ ���� 
//������� �����ϸ� ������ ����
public class ShellSort {
	//�� ����
	static void shellSort(int[] a,int n) {
		int count = 0;
		for(int h=n/2;h>0;h/=2) {//4->2->1����
			for(int i=h;i<n;++i) {
				int j;
				int tmp = a[i];
				for(j=i-h;j>=0 && a[j]>tmp; j-=h) {
					count++;
					a[j+h]=a[j];
				}
				a[j+h] = tmp;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ����");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shellSort(x, nx);
		//bubbleSortReverse(x,nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
