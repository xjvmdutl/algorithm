package ch02;

public class CloneArray {

	public static void main(String[] args) {
		// �迭�� ������ clone�޼ҵ带 ȣ���Ͽ� ���� ����
		// �迭 �̸�.clone();
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();//b�� a�� ������ ����
		b[3] = 0;//�ѿ�ҿ��� 0����
				//�迭���� b�� ������ �迭 a�� ��ü�� �ƴ϶� �� �������� �����ϴ°��� Ȯ��
		System.out.print("a = ");
		for(int i=0;i<a.length;++i)
			System.out.print(" "+a[i]);
		System.out.print("\nb = ");
		for(int i=0;i<b.length;++i)
			System.out.print(" "+b[i]);
		

	}

}
