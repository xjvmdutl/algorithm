package ch05;

public class QueenBB {
	static int[] pos = new int[8];
	static boolean[] flag = new boolean[8];//���� �࿡ �ߺ��Ͽ� ���� ��ġ�Ǵ� ���� �����ϱ� ���� ǥ��
	static void print() {
		for(int i=0;i<8;++i)
			System.out.printf("%2d",pos[i]);
		System.out.println();
	}
	static void set(int i) {
		for(int j=0;j<8;++j) {
			if(flag[j] == false) {
				pos[i]=j;
				if(i==7)
					print();
				else {
					flag[j] = true;//j�࿡ ���� ��ġ�ϰ� �� ��� flag[j]�� true�� �ϰ� ��ġ���� ���� ������ ���� false�� �մϴ�.
					set(i+1);
					flag[j] = false;//��� ȣ���� set(i+1)�޼ҵ� ������ ������ �Ǹ� ���� j�࿡�� ���ŵǾ��� ������ flag[j]���� ���� ��ġ���� �ʾ����� ��Ÿ���� false����
					//��ó�� �ʿ����� ���� �б⸦ ���� ���ʿ��� ������ ���̴� ����� ���������̶�� �ϸ�, ��������� ���������� �����Ͽ� ������ Ǯ��� ����� �б��������̶�� �Ѵ�.
				}
			}
		}
	}
	public static void main(String[] args) {
		set(0);
	}

}
