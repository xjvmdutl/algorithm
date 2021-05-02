package ch03;

public class GenericClassTester {
	//���׸� : ó���ؾ��� ����� �ڷ����� �������� �ʴ� Ŭ����(�������̽�)�������
	//���׸� Ŭ������ Ŭ���� �̸� �ٷ� �ڿ� <Type>���� ������ �Ķ���͸� ������ ����
	//class :Ŭ���� �̸� <�Ķ����,�Ķ����2>{...}
	//interface : �������̽� �̸� <�Ķ����,�Ķ����2,�Ķ����3>{...}
	//��ǥ�� ������ �Ķ���� ��������
	//���������� ���ϵ� ī������ ���� : <? extends T> Ŭ���� T�� ���� Ŭ������ ���� �޴´�,<? super T> Ŭ���� T�� ���� Ŭ������ ���� �޴´�
	
	//���׸� Ŭ������ �Ķ���͸� T��� �ۼ�
	static class GenericClass<T>{
		private T xyz;
		public GenericClass(T t) {
			this.xyz = t;
		}
		T getXyz() {
			return xyz;
		}
	}
	public static void main(String[] args) {
		//�Ķ���ͷ� int String��� �ѱ�� �ִ�.
		GenericClass<String> s = new GenericClass<String>("ABC");
		GenericClass<Integer> i = new GenericClass<Integer>(15);
		System.out.println(s.getXyz());
		System.out.println(i.getXyz());
	}

}
