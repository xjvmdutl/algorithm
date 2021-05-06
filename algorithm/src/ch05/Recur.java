package ch05;

import java.util.Scanner;

import ch04.IntStack;

public class Recur {
	//����Լ� �����ϱ�
	static void recur(int n) {//�Ͼ�� �м� �� ��
		if(n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
		// ���� ���ʿ� ��ġ�� ������ �޼ҵ� ȣ����� ������ ��ܽ����� �ڼ��� �����ϴ� �м� ��� : �Ͼ�� �м�
		//�Ʒ��ʺ��� �׾� �ö󰡸� �м��ϴ±�� : ����� �м�

		
	}
	//��͸� ���ֱ�
	//1)���� ��� ���ֱ� : recur(n-2)�� n�� n-2������ ������Ʈ �ϰ� �޼ҵ��� ������������ ���ư���.
	static void removeRecur(int n) {
		//2)��� ���ֱ� : ���� n�� ��µǱ� ���� recur(n-1)�� �����ؾߵǱ� ������ ���ֱ� �����.
		//ó���� ���� �ʾҴٸ� ���� n���� �����ؾ� �Ѵ�.
		//(������ ����Ͽ� �ذ�)
		IntStack s = new IntStack(n);
		/*
		while(n>0) {
			recur(n-1);
			System.out.println(n);
			n = n-2;
		}
		*/
		//���� ���� 4���� ���ÿ� Ǫ�� -> n���� �ϳ� ����(3) -> while�� �ʱ�� ���ư���.
		//4321 ���� stack�� push�� ������ ������� �������� 2��° if�� ���� 
		//���ÿ��� ���� 1���� n�� ���� -> ��� -> n�� n-2�� ������Ʈ -> while�� ó������ ���ư���.
		
		while(true) {
			if(n>0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(!s.isEmpty()) {
				n = s.pop();
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
		}
		
	}
	static void recur2(int n) {
		if(n>0) {
			recur2(n-2);
			System.out.println(n);
			recur2(n-1);
		}
	}
	static void recur3(int n) {//�������� 5 : �ش� �޼ҵ带 �� ��ͷ� ���ϼ���
		if(n>0) {
			recur3(n-1);
			recur3(n-2);
			System.out.println(n);
		}
	}
	static void RemoveRecur3(int n) {//�� ���ذ� ���� �ʴ´�...
		int[] nstk = new int[100];
		int[] sstk = new int[100];
		int ptr = -1;
		int sw = 0;

		while (true) {
			if (n > 0) {
				ptr++;
				nstk[ptr] = n;
				sstk[ptr] = sw;

				if (sw == 0)
					n = n - 1;
				else if (sw == 1) {
					n = n - 2;
					sw = 0;
				}
				continue;
			}
			do {
				n = nstk[ptr];
				sw = sstk[ptr--] + 1;

				if (sw == 2) {
					System.out.println(n);
					if (ptr < 0)
						return;
				}
			} while (sw == 2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int x = sc.nextInt();
		System.out.println("----recur-----");
		recur(x);
		System.out.println("----recur2-----");
		recur2(x);
		System.out.println("----removeRecur-----");
		removeRecur(x);
		System.out.println("----recur3-----");
		recur3(x);
		System.out.println("----RemoveRecur3-----");
		RemoveRecur3(x);
	}

}
