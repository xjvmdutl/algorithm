package ch02;

import java.util.Scanner;

public class ReverseArray {
	
	public static void main(String[] args) {
		//�迭 ��� �Ųٷ� �����ϱ� 
		//1. �迭 ù��° ��ҿ� ������ ��Ҹ� �� �Ͽ� ��ȯ�Ѵ�
		//2. �迭 �ι�° ��ҿ� ������ �� ��Ҹ� ���ϸ� ��ȯ�Ѵ�(..�ݺ�)
		// ���ʿ�� �ε��� : i (0,1,2...) �����ʿ�� �ε��� : n-1-i(n-1,n-2,..)
		//for(int i=0;i<n/2;++i)
		//��Ҹ� ��ȯ�Ҷ��� t�� �ӽú����� ���� ��ȯ�Ѵ�.(�ش� �޼ҵ�� ���� ����ϹǷ� �������� �޼ҵ� �ʿ�)
		//3. ��ȯ Ƚ���� ����Ǽ� /2 �̸�, �������� ������(��Ұ� Ȧ���� ��� ��� ��Ҵ� ��ȯ�� �ʿ䰡 ����)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��� �� : ");
		int num = sc.nextInt();
		
		int[] x = new int[num];
		for(int i=0;i<x.length;++i) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		reverse2(x);
		System.out.println("��Ҹ� �������� �����Ͽ����ϴ�.");
		for(int i=0;i<x.length;++i) {
			System.out.println("x["+i+"] = "+x[i]);
		}
		System.out.println("�迭�� �հ� : "+sumOf(x));
	}
	public static void reverse(int[] x) {
		for(int i=0;i<x.length/2;++i) {
			
			swap(x,i,x.length-i-1);
		}
	}
	public static void swap(int[] x,int idx1,int idx2) {
		int tmp = x[idx1];
		x[idx1] = x[idx2];
		x[idx2] = tmp;
	}
	//��������2 : �迭��Ҹ� �������� ������ ������ ������ �ϳ��� ��Ÿ���� ���α׷� �ۼ�
	public static void reverse2(int[] x) {
		for(int j=0;j<x.length;++j) {
			System.out.print(x[j]+" ");
		}
		System.out.println();
		for(int i=0;i<x.length/2;++i) {
			System.out.println("x["+i+"]��(��) x["+(x.length-1-i)+"]�� ��ȯ�մϴ�");
			swap(x,i,x.length-i-1);
			for(int j=0;j<x.length;++j) {
				System.out.print(x[j]+" ");
			}
			System.out.println();
		}
		System.out.println("���������� �������ϴ�");
	}
	//��������3 : �迭 x�Ǹ�� ����� �հ踦 ���Ͽ� ��ȯ
	public static int sumOf(int[] x) {
		int sum = 0;
		for(int i=0;i<x.length;++i) {
			sum+=x[i];
		}
		return sum;
	}
}
