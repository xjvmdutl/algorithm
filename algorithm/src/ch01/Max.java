package ch01;

import java.util.Scanner;

public class Max {
	
	public static void main(String[] args) {
		//������ �ִ���  ���Ѵ�.
		Scanner sc = new Scanner(System.in);//Ű����� ����� ǥ�� �Է½�Ʈ��
		System.out.println("�� ������ �ִ��� ���մϴ�.");
		System.out.print("a�� �� : "); int a = sc.nextInt();//-2147483648 ~ 2147483648 ����
		System.out.print("b�� �� : "); int b = sc.nextInt();
		System.out.print("c�� �� : "); int c = sc.nextInt();
		int max = a;
		if(b> max) max = b;
		if(c> max) max = c;
		//a,b,c�ִ��� ���Ͽ� max �� ����
		//���� ������ ���������� ����Ǵ� ������ ������ ������� �Ѵ�.
		//()�ȿ� �ִ� ���� �򰡰���� ���� ���α׷��� ���� �帧�� �����ϴ� if���� ���ñ������ �Ѵ�.
		//if���� ���� ���α׷� �帧�� �б⸦ �ֱ� �����̶�� �Ѵ�.
		//->:���� ,<>:���� (yes,no)
		System.out.println("�ִ��� "+ max +" �Դϴ�.");
		//���α׷����� ����
		System.out.println("max3(3,2,1) = "+max3(3,2,1));
		System.out.println("max3(3,2,2) = "+max3(3,2,2));
		System.out.println("max3(3,1,2) = "+max3(3,1,2));
		System.out.println("max3(3,2,3) = "+max3(3,2,3));
		System.out.println("max3(2,1,3) = "+max3(2,1,3));
		System.out.println("max3(3,2,2) = "+max3(3,2,2));
		System.out.println("max3(3,3,3) = "+max3(3,3,3));
		System.out.println("max3(2,2,3) = "+max3(2,2,3));
		System.out.println("max3(2,3,1) = "+max3(2,3,1));
		System.out.println("max3(2,3,2) = "+max3(2,3,2));
		System.out.println("max3(1,3,2) = "+max3(1,3,2));
		System.out.println("max3(2,3,3) = "+max3(2,3,3));
		System.out.println("max3(1,2,3) = "+max3(1,2,3));
		
		//�������� �׽�Ʈ1
		System.out.println("max4(2,3,19,3) = "+max4(2,3,19,3));
		
		//�������� �׽�Ʈ2
		System.out.println("min3(2,3,1) = "+min3(2,3,1));
		//�������� �׽�Ʈ3
		System.out.println("min4(2,3,19,3) = "+min4(2,3,19,3));
		
		
	}	
	static int max3(int a, int b,int c) {//�޼ҵ带 �����Ҷ� �޼ҵ忡 ���޵Ǵ� ���� �����ϱ� ���� ������ �����ϴµ� �̸� �Ű�����,���ĸŰ������� �Ѵ�.
										 //���ĸŰ������� ���μ��� �ϰ� �޼ҵ带 ȣ���� �� ����ϴ� �Ű������� ���� ���μ���� �Ѵ�.(�����Ҷ� �Ű�����,ȣ���ҋ� ���μ�)
		int max = a;
		if(b>max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;//���� �ִ��� ȣ���� ������ ��ȯ
	}
	//return void = ��ȯ�� x
	//�������� 1 : �װ��� �ִ��� ���ϴ� max4�ۼ�
	static int max4(int a,int b,int c,int d) {
		int max =a;
		if(b>max) max =b;
		if(c>max) max =c;
		if(d>max) max =d;
		return max;
	}
	//�������� 2 : �� ���� �ּڰ��� ���ϴ� min3 �ۼ�
	static int min3(int a, int b,int c) {
		int min = a;
		if(min>b) min = b;
		if(min>c) min = c;
		return min;
	}
	//�������� 3 : �� ���� �ּڰ��� ���ϴ� min4 �ۼ�
	static int min4(int a, int b,int c,int d) {
		int min = a;
		if(min>b) min = b;
		if(min>c) min = c;
		if(min>d) min = d;
		return min;
	}
}
