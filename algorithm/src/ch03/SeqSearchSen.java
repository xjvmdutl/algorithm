package ch03;

import java.util.Scanner;

public class SeqSearchSen {
	public static int seqSearch(int[] a,int n, int key) {//��Ҽ� =n �迭 a , key�� ã��
		
		int i =0;
		a[n] = key;//���ʸ� �߰�
		
		while(true) {
			if(a[i] == key) { //�˻� ����(�ε��� ��ȯ)
				break;
			}
			i++;
		}
		return i==n ? -1 : i;
		
	}
	
	public static void main(String[] args) {
		//���ʹ� : ���������� �˻��ϴ� ����� ������ ���δ�. �˻��ϱ� ���� �˻��ϰ��� �ϴ� Ű���� �� �����a[7]�� ����(����)
		//   	 ���ϴ� �����Ͱ� ������ �ʴ��� ���ʱ����� ���� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];//��Ҽ� +1(���ʰ��� ����)
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
