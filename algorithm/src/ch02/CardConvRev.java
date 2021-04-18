package ch02;

import java.util.Scanner;

public class CardConvRev {

	public static void main(String[] args) {
		//��� ��ȯ : 10������ ���� n������ ��ȯ�Ϸ��� ������ n���� �������� ���ϰ� ���ÿ� �׸� ���� �������� �ݺ��Ѵ�.
		//���� 0�� �ɶ����� �ݺ��ѵ� �������� �Ųٷ� �þ���� ���ڸ� ����Ѵ�.
		//0x = 16���� ǥ��, 0 = 8���� ǥ��
		Scanner sc = new Scanner(System.in);
		int no; //��ȯ�ϴ� ���
		int cd; //���
		int dno; //��ȯ���� �ڸ���
		int retry; //�ٽ��ѹ�?
		char[] cno = new char[32];//��ȯ�� �� �ڸ��� ���ڸ� �־�δ� ������ �迭
		System.out.println("10������ ��� ��ȯ �մϴ�.");
		do {
			do {
				System.out.print("��ȯ�ϴ� ���� �ƴ� ���� :");
				no = sc.nextInt();
			}while(no <0);
			do {
				System.out.print("� ������ ��ȯ�ұ��? (2~36) :");
				cd = sc.nextInt();
			}while(cd <2 || cd >36);
			dno = DetailCardConvR(no,cd,cno);//no�� cd������ ��ȯ
			System.out.print(cd + "�����δ� ");
			for(int i=dno-1;i>=0;i--) {//���ڸ����� ���ʷ� ���
				System.out.print(cno[i]);
			}
			System.out.println("�Դϴ�.");
			/*
				cno = new char[32];
				dno = cardConv(no,cd,cno);//no�� cd������ ��ȯ
				System.out.print(cd + "�����δ� ");
				for(int i=0;i<dno;i++) {//���ڸ����� ���ʷ� ���
					System.out.print(cno[i]);
				}
				System.out.println("�Դϴ�.");
			*/
			
			System.out.println("�� �� �� �ұ��? (1.��/0.�ƴϿ�) : ");
			retry = sc.nextInt();
		}while(retry == 1);
	}
	public static int cardConvR(int x,int r,char[] d) {//���� x�� r������ ��ȯ�Ͽ� �迭 d�� �Ʒ��ڸ����� �־�ΰ� �ڸ����� ��ȯ
		int dights = 0; //��ȯ �� �ڸ���
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//���ڿ����� ������ ���ڸ� ������
		do {
			d[dights++] = dchar.charAt(x%r);//r�� ���� �������� ����
			x /= r;
		}while(x != 0);
		return dights;
	}
	//�������� 6 : �迭�� ���ʿ� �Ʒ��ڸ��� �ƴ϶� ���ڸ��� �־�δ� �޼ҵ� �ۼ�
	public static int cardConv(int x,int r,char[] d) {
		int dights = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[dights++] = dchar.charAt(x%r);//r�� ���� �������� ����
			x /= r;
		}while(x != 0);
		for(int i =0;i<dights/2;++i) {
			swap(d,i,dights-1-i);
		}
		return dights;		
	}
	public static void swap(char[] d,int idx1,int idx2) {
		char tmp = d[idx1];
		d[idx1] = d[idx2];
		d[idx2] = tmp;
	}
	//�������� 7 : ��� ��ȯ ������ �ڼ��� ��Ÿ���� ���α׷� �ۼ�
	public static int DetailCardConvR(int x,int r,char[] d) {
		int dights = 0; //��ȯ �� �ڸ���
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//���ڿ����� ������ ���ڸ� ������
		
		do {
			
			System.out.println(r+"|       "+x + "  ......"+dchar.charAt(x%r));
			System.out.println(" + -------------");
			
			d[dights++] = dchar.charAt(x%r);//r�� ���� �������� ����
			x /= r;
			if(x == 0) {
				System.out.println("         "+x + "  ......"+d[dights-1]);
			}
		}while(x != 0);
		return dights;
	}
	
}
