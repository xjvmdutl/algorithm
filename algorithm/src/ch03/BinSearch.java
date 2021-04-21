package ch03;

import java.util.Scanner;

public class BinSearch {
	public static int binSearch(int[] x,int n,int key) {
		/*
		int pl = 0;
		int pr = n-1;
		do {
			int pc = (pl+pr)/2;
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//�˻����� �����ʿ� ����
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}while(pl<=pr);
		
		return -1;
		*/
		int pl = 0;
		int pr = n-1;
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//�˻����� �����ʿ� ����
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}
		return -1;
		//�������� 1 : for������ ���� 
	}
	public static int printBinSearch(int[] x,int n,int key) {//�������� 4 : �ַܼ� �˰��� ���� ǥ��
		
		int pl = 0;
		int pr = n-1;
		
		
		System.out.print("  | ");
		for(int i=0;i<n;++i) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("--+-------------------");
		//for�� ����
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			System.out.print("  | ");
			for(int i=0;i<=n;++i) {
				if(pl==i) {
					System.out.print("<-");
				}else if(pr == i) {
					System.out.print("->");
				}else if(pc == i) {
					System.out.print("+");
				}else {
					System.out.print("  ");
				}
			}
			
			System.out.println();
			System.out.print(pc+" | ");
			for(int j=0;j<n;++j) {
				System.out.print(x[j]+" ");
			}
			
			System.out.println();
			if(x[pc] == key)
				return pc;
			else if(x[pc] < key) {//�˻����� �����ʿ� ����
				pl = pc+1;
			}else {
				pr = pc-1;
			}
			
		}
		
		
			
		
		return -1;
		//�������� 1 : for������ ���� 
	}
	public static int binSearchX(int[] x,int n,int key) {
		//�������� 5: �˻��� ���� �������� ���� ��Ұ� �ϳ� �̻��� ��� �� ����� �Ǿ� ��Ҹ� ã�� ���Ѵ�.(�Ǿ� ��Ҹ� ã���� ����)
		int pl = 0;
		int pr = n-1;
		for(;pl<=pr;) {
			int pc = (pl+pr)/2;
			if(x[pc] == key) {
				int returnValue = pc;
				do{
					if(x[--returnValue] == key)
						pc = returnValue;
				}while(x[pc] != key);
				return pc;
			}
			else if(x[pc] < key) {//�˻����� �����ʿ� ����
				pl = pc+1;
			}else {
				pr = pc-1;
			}
		}
		return -1;
		//�������� 1 : for������ ���� 
	}
	public static void main(String[] args) {
		//���� �˻�  : �̹� �����̵Ǿ� �ִ� ������ �����͸� ������ ���ϴ� Ű���� �̴´�.
		// 			 �ʱ� ã���� �ϴ� ���� �߰����� ���Ͽ� ũ�� ������ ������ ������ �˻�
		//			 ���ϴ� ���� �߾ӿ�������� ��� ���ϸ� ��� ����
		//ex) �Ǿ� �ε��� : pl, �߾� : pc �ǳ� : pr
		//			1)	pl = 0 pr= n-1 pc=n-1/2
		//			2-1) a[pc] < key ��� : ���ϴ� Ű ���� �����ʿ� �����Ƿ� a[pc+1] ~ a[pr]�� �˻�
		//				pl =pc+1  pr= pr pc=pl+pr/2
		//			2-2) a[pc] > key ��� : ���ϴ� Ű ���� ���ʿ� �����Ƿ� a[pl] ~ a[pc-1]�� �˻�
		//				pl =pl  pr= pc-1 pc=pl+pr/2
		// ���������� : a[pc]�� key�� ��ġ , �˻������� ���̻� ���°��
		Scanner sc = new Scanner(System.in);
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		System.out.println("������������ �Է��ϼ���");//������ �Ǿ�ߵȴ�.
		System.out.print("x["+0+"] : ");
		x[0] = sc.nextInt();
		
		for(int i =1; i<num;++i) {
			do {
				System.out.print("x["+i+"] : ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);//�ٷ� �� ��Һ��� ������ �ٽ� �Է�
		}
		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();
		
		int idx = binSearchX(x, num, ky);
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
	}

}
