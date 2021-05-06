package ch05;

public class EightQueen {
	static int[] pos = new int[8];//���࿡ ���� ��ġ�ߴ��� üũ
	static boolean[] flag_a = new boolean[8];//�� �࿡ ���� ��ġ�ߴ��� üũ
	static boolean[] flag_b = new boolean[15];//�밢�� ����(���� �밢�� /) ���� ��ġ�ߴ��� üũ
	static boolean[] flag_c = new boolean[15];//�밢�� ����(�Ʒ��� �밢�� \) ���� ��ġ�ߴ��� üũ
	static void print() {
		//�������� 8 : print �޼ҵ带 �����Ͽ� ������ȣ '��' �� '��' �� ����� ���� ��ġ ��Ȳ ���		
		for(int i=0;i<8;++i) {
			for(int j=0;j<8;++j) {
				if(pos[i]==j) {
					System.out.printf("��");
				}
				else {
					System.out.print("��");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	static void set(int i) {

		for(int j=0;j<8;++j) {
			if(flag_a[j] == false 
					&& flag_b[i+j] == false //�밢�� /�� ���� ��ġx // 0~14 
					&& flag_c[i-j+7] == false) {//�밢�� \�� ���� ��ġ x // 14~0
				pos[i]=j;
				if(i==7)
					print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
					set(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
				}
			}
		}
	}
	static void removeSet(int i) {//�������� 9 : �� ����� �ذ�
		int j;
		int[] jstk = new int[8];

		Start: while (true) {
			j = 0;
			while (true) {
				while (j < 8) {
					if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
						pos[i] = j;
						if (i == 7) // ��� ���� ��ġ ��ħ
							print();
						else {
							flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
							jstk[i++] = j; // i ���� ���� Push
							continue Start;
						}
					}
					j++;
				}
				if (--i == -1)
					return;
				j = jstk[i]; // i ���� ���� Pop
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}
	}
	public static void main(String[] args) {
		removeSet(0);
	}

}
