package ch03;

import java.util.Scanner;

public class SearchIdx {
	public static int searchIdx(int[] a,int key, int[] idx) {
		//�������� 3 : ��Ҽ��� n�� �迭 a���� key�� ��ġ�ϴ� ��� ����� �ε����� �迭idx�� �Ǿպ��� ������������ϰ� ��ġ�� ��Ҽ� ��ȯ
		int returnValue = -1;
		for(int i=0;i<a.length;++i) {
			if(a[i] == key) {
				idx[++returnValue] = key;
			}
		}
		
		
		return returnValue;
		
	}
	
	public static void main(String[] args) {
		
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
		
		int[] idx = new int[x.length]; 
		int idxLength= searchIdx(x, ky, idx);
		int[] tmp = new int[idxLength];
		for(int i=0;i<idxLength;++i) {
			tmp[i] = idx[i];
		}
		idx= tmp;
		if(idxLength == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			for(int i=0;i<idx.length;++i)
				System.out.print(idx[i]+" ");

	}
}
