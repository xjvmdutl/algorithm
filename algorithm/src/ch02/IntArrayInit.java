package ch02;

public class IntArrayInit {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};//�迭 �ʱ��ڿ� ���� ����
		//int[] a = new int[]{1,2,3,4,5};//�̷��� ��������ε� ������ ����
		for(int i=0;i<a.length;++i)
			System.out.println("a["+i+"] = "+a[i]);
		
	}

}
