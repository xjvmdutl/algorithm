package ch02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� �� : ");
		//int num = sc.nextInt();
		//�������� 1 : ����� ���� ������ ����
		int num = rand.nextInt(10)+1;//1~10���� ������ ����
		System.out.println(num);
		//nextBoolean() : true,false
		//nextInt() : -2147483648 ~ 2147483647
		//nextInt(n) : 0~n-1
		//nextLong() : -9223372036854775808 ~ 9223372036854775807
		//nextDouble : 0.0�̻� 1.0�̸�
		//nextFloat : 0.0�̻� 1.0�̸�
		//java.lang.MathŬ���������� ������ �����ϴ� �Լ� ����
		
		int[] height = new int[num];
		
		System.out.println("Ű ���� �Ʒ��� �����ϴ�.");
		for(int i=0;i<height.length;++i) {
			height[i]= 100+rand.nextInt(90);//����� ���� ������ ����
			//nextInt(n)�� ��ȯ�ϴ� ���� 0~n-1������ �����̴�.
			System.out.println("height["+i+"] : "+ height[i]);
		}
		System.out.println("�ִ��� "+maxOf(height) + "�Դϴ�.");
		
	}
	public static int maxOf(int[] height) {
		int max = height[0];
		for(int i=1;i<height.length;++i)
			if(max < height[i])
				max=height[i];
		return max;
	}
	
}
