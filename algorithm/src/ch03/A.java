package ch03;

public class A implements Comparable<A> {//�ڿ����� : ��ǻ�Ϳ����� ������ �ƴ� ����� Ŀ���� ������ ���� interface
	//�ʵ� , �޼ҵ�
	
	public int compareTo(A c) {
		//this�� c���� ũ�� ���ǰ� ��ȯ
		//this�� c���� ������ ���ǰ� ��ȯ
		//this�� c�� ������ 0 ��ȯ
		return 0;
	}
	public boolean equals(Object b) {
		//this�� c�� ������ true
		//this�� c�� �ٸ��� false
		return true;
	}
	//�ڿ����ķ� ���ĵ��� ���� �迭������ ���Ŀ����� �˻��� ���׸� �޼���� �ϸ� �ȴ�.
	//���׸� �޼ҵ��� ù �Ű������� a(�˻����), �ι��� �Ű������� key�Դϴ�.
	//���׸� �޼ҵ�� �ڷ����� ���� x
	//����° �Ű�����  c(comparator) ����
	//��ü�� ��� ���踦 �Ǵ��ϴ� comparator�� ���� �����ϱ� ���ؼ��� comparator�������̽��� ������ Ŭ������ ���� �ϰ� �� Ŭ�������� �ν��Ͻ������� �����ؾ� �ȴ�.
	
}
