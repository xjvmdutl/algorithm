package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
		//�����˻� ǥ�� ���̺귯�� : java.util.Arrays Ŭ������ binarySearch�޼ҵ� (���� �˻��޼ҵ带 ���� �ڵ�x, ��� �ڷ��� �迭���� �˻� ����)
		//API ���� : https://docs.oracle.com/javase/8/docs/api
		//9���� ������� �����ε� �Ǿ� �ִ�.
		//�˻� ���� : key�� ��ġ�ϴ� ����� �ε��� ��ȯ(�������� �������� �ε��� ��ȯ, �Ǿ� ��ȯ x)
		// 	  ���� : - ���� ����Ʈ -1 ��ȯ (�˻��ϱ� ���� ������ key���� ū����� ù��° �ε���),���� ��� ��Ұ� key���� �۴ٸ� �迭�� ���̸� ��������Ʈ ����
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
		
		int idx = Arrays.binarySearch(x, ky);//�迭�� key���� ����
		if(idx < 0) {
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
			System.out.println(-(idx+1));//���������� // �������� 6: ���������� ���
		}
		else
			System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
	}
	//Ŭ���� �޼ҵ�,�ν��Ͻ� �޼ҵ� : Ŭ�����޼ҵ�(static x), �ν��Ͻ� �޼ҵ� (static o)
	
}
