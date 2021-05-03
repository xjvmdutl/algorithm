package ch04;
public class IntStack {
	int max; //���� �뷮
	int ptr; //���� ������
	int[] stk;//������ ��ü
	
	//����� ���� : ������ �������
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException(){
			
		}
	}
	//����� ���� : ������ ���� ��
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
			
		}
	}
	//������
	public IntStack(int capacity) {//������ ��� ������� ptr�� 0�̵ǰ� ���� �� ������� max���� �����ϴ�.
		ptr = 0;//������ ������ ��� ������ ptr 0 �ʱ�ȭ
		max = capacity;//���� �뷮
		try {
			stk = new int[max];//���� ��ä�� �迭�� ����
		}catch (OutOfMemoryError e) {//������ �� ����
			max = 0; 
		}
	}
	//���ÿ� x�� Ǫ��
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) {//IntStack  �����ڸ� ���ؼ� �����۾��� ����� ���������ʹ� �ݵ�� 0�̻� max���ϰ� �Ǵµ� ������ ���� �� �ִ����� ���� 
						//�˻�� � �����ڸ� ����(==)�˻��� ���� ������ ���α׷��� �Ǽ��� ���� �������� ���� ptr�� �߸� �ԷµǸ� max�� �ʰ��Ҽ� �ֱ� ������ ���迬����(<=)�� ��� 
			throw new OverflowIntStackException();//������ ���� �� ���, ������ OverflowIntStackException ���ܸ� ������.
		}
		return stk[ptr++] = x;//���� ���� �����͸� �迭 ��� stk[ptr]�� ���� �� ���� �����͸� �ϳ� ���� ��Ų��.
	}
	//pop �޼ҵ�
	//���ÿ��� �����͸� ��
	public int pop() throws EmptyIntStackException{
		if(ptr <= 0)//������ ��� �������
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	//peek�޼ҵ�(������ ����⿡ �ִ� �����͸� ���� ������ �޼ҵ�(������ ��� ������� ���� EmptyIntStackException�� ������)
	public int peek() throws EmptyIntStackException{
		if(ptr <= 0)//������ �������
			throw new EmptyIntStackException();
		return stk[ptr-1];//���� �����ʹ� ��ȭ���� �ʴ´�.(������ ������ ���⶧��)
	}
	//�˻� �޼ҵ� (indexOf) : ���� ��ü�� �迭 stk�� x�� ���� ���� �����Ͱ� ���ԵǾ� �ִ��� �ִٸ� �迭 ��� �ִ����� �����ϴ� �޼ҵ�
	// �˻��� ����⿡�� �ٴ����� ���� �˻��� �����մϴ�.���нô� -1 �����ô� �ش� ����� �ε��� ��ȯ
	// ���� �����Ͱ� ������ �� ���� �����͸� ��ȯ(���� pop()�Ǵ� �����͸� ã������)
	public int IndexOf(int x) {
		for(int i=ptr-1;i>=0;++i) {
			if(stk[i] == x)
				return i;//�˻� ����
		}
		return -1;//�˻� ����
	}
	//������ ��� ��Ҹ� �����ϴ� �޼ҵ� clear
	//������ �迭 ��ڰ��� ������ �ʿ� ���� ptr ���� 0���θ���� �ȴ�.
	public void clear() {
		ptr = 0;
	}
	//�뷮�� Ȯ���ϴ� capacity : ������ �뷮(max)�� ��ȯ�ϴ� �޼ҵ�
	public int capacity() {
		return max;
	}
	//������ ���� Ȯ���ϴ� size : ���� ���ÿ� �׿��ִ� ������ ���� ��ȯ(ptr)
	public int size() {
		return ptr;
	}
	//������ ��� �ִ��� �˻��ϴ� isEmpty : ������ ��� �ִ����˻��ϴ� �޼ҵ� , ��������� true, �ƴϸ� flase
	public boolean isEmpty() {
		return ptr <= 0;
	}
	//������ ���� ������ �˻��ϴ� �޼ҵ�  isFull : ������ ���� ã���� �˻��ϴ� �޼ҵ�, ������ ���� ã���� true, �ƴϸ� false
	public boolean isFull() {
		return ptr >= max;
	}
	//���þ��� ��� �����͸� ��Ź -> ����� ������ ���
	public void dump() {
		if(ptr<=0){//������ �������
			System.out.println("������ ��� �ֽ��ϴ�.");
		}else {
			for(int i=0;i<ptr;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
}
