package ch02;

import java.util.Scanner;

public class DayOfYear {
	static int[][] mdays = {
		{31,28,31,30,31,30,31,31,30,31,30,31},//���
		{31,29,31,30,31,30,31,31,30,31,30,31}//����
	};
	static int isLeap(int year) {//���� year�� �����ΰ�? ���� =1,��� =0
		return (year%4 ==0 && year%100 !=0 || year % 400 ==0) ? 1:0;
	}
	static int dayOfYear(int y,int m,int d) {
		/*
		int days = d;
		for(int i=1;i<m;++i) {//1~(M-1)���� �ϼ� ����
			days+=mdays[isLeap(y)][i-1];
		}
		return days;
		*/
		//�������� 8 : ���� i �� days���� ����
		int count =0;
		int sum =0;
		do{
			sum+=mdays[isLeap(y)][count];
			count++;
		}while(count < m);
		return sum;
	}
	public static void main(String[] args) {
		//������ ��� �ϼ� ���ϱ�
		//2���� �迭�� Ȱ���Ͽ� � ��¥�� ��� �ϼ��� ���Ѵ�.
		//�� ���� ��� �ϼ� = 1�� ,2�� ...,m-1���� �ϼ��� �� + d
		//������ ���� �ϱ� ������ [0][n] �� ��⿡ �ϼ� [1][n]�� ���⿡ �ϼ��� ����
		Scanner sc = new Scanner(System.in);
		int retry; //�ٽ� �� ��?
		System.out.println("�� �� ��� �ϼ��� ���մϴ�.");
		
		do {
			System.out.print("�� : "); int year = sc.nextInt();//��
			System.out.print("�� : "); int month = sc.nextInt();//��
			System.out.print("�� : "); int day = sc.nextInt();//��
			System.out.printf("�� �� %d��° �Դϴ�.\n",dayOfYear(year, month, day));
			
			System.out.println(leftDayOfYear(year,month,day));
			
			System.out.print("�ѹ� �� �ұ��? (1.�� / 0.�ƴϿ�) : ");
			
			retry = sc.nextInt();
		}while(retry == 1);
		//������ �迩�� ���� ������ �ֻ��� 1������ ����(���������� �迭�� ������ �ȵǰ� ����)
			
	}
	public static int leftDayOfYear(int y,int m,int d) {
		// �������� 9 : y�� m�� d���� ���� ���� �ϼ��� ���ϴ� �޼ҵ� �ۼ� 12��31���̸�0
		int lastDay = dayOfYear(y,12,31);
		int currentDay = dayOfYear(y,m,d);
		return lastDay - currentDay;
	}
	

}
