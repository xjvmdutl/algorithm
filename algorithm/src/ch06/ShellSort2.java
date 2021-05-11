package ch06;

import java.util.Scanner;
public class ShellSort2 {
	//�� ����
	static void shellSort2(int[] a,int n) {
		int h;
		int count = 0;//�������� 9 : ����� �̵� Ƚ���� ���
		for(h=1; h<n/9;h=h*3+1)//h�� �ʱ갪�� ���Ѵ� 1���� �����Ͽ� ���� 3���ϰ� 1�� ���ϸ鼭 �迭�� ��Ҽ� n�� 9�γ������� ���� �ȵ��� ����
			;
		for(;h>0;h/=3) {//h���� 1�ϵɋ����� h�� 3���� ������. (h���� ���� ����� ���� �ʰ��ϱ� ����)
			//ȿ�������� �������� �ʴ´� : ��Ұ��� ������ ������ �ٽ� �ի����� ó���ܰ�� ������ ���°� �Ǳ⶧��
			//h���� 1,4,13,40... �̷��� �ٲ�� ¥���Ѵ�(n*3+1)
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
		System.out.println("�� ����(����2)");
		System.out.print("��ڼ� : ");
		int nx = sc.nextInt();
		int[] x = new int[nx];
		for(int i=0;i<nx;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		shellSort2(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0;i<nx;++i)
			System.out.println("x["+i+"]="+x[i]);
	}

}
