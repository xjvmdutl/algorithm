package ch02;

import java.util.Scanner;

public class MaxOfArray {

	public static void main(String[] args) {
		//�迭 ����� �ִ� ���ϱ�
		//��� 3���̸� if����2�� , 4���̸� if�� 3��
		//a[0]�� max������ �����ѵ� if���� �����ϴ� �������� �ʿ信 ���� max���� ���� �����Ѵ�. 
		//��Ұ� n���̸� if���� n-1���̴�.
		//���� max���� ���ϴ� ������ int max = a[i]; for(int i=1;i<n;++i) if(a[i]>max)) max=a[i]; �̷��� �ۼ��Ҽ� �ִ�.
		// �迭�� ù��° ��Һ��� ��������ұ��� ���ʷ� ���캻�� => �ֻ�(����)
		Scanner sc = new Scanner(System.in);
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� �� : ");
		int num = sc.nextInt();//����� �Է¹���
		int[] height = new int[num];//��Ҽ��� num�� �迭 ����
		for(int i=0;i<num;++i) {
			System.out.print("height["+i+"] : ");
			height[i] = sc.nextInt();
		}
		System.out.println("�ִ��� "+maxOf(height)+"�Դϴ�.");
	}
	public static int maxOf(int[] height) {//�迭 height����� �ִ��� ���ϴ� �޼ҵ�,�迭 ��ü�� ���� ������ �����Ѵ�.
		//���� ������: �ɹ��� ���� ������ �����Ѵ�.
		//public : ��� ���� ���
		//protected : ���� ��Ű���� ��ü , ��Ӱ����� ��ü ���
		//default : ���� ��Ű���� ��ü ���
		//private : ������ ��ü �ȿ����� ���
		//���� ������ ���
		//Ŭ���� : public, default
		//������ : public, protected,default,private
		//������� : public, protected,default,private
		//��� �޼��� public, protected,default,private
		//�������� : ��� x
		
		int max = height[0];
		for(int i=0;i<height.length;++i)
			if(height[i]>max)
				max=height[i];
		return max;
	}

}
