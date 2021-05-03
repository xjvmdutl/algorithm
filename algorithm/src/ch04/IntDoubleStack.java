package ch04;
public class IntDoubleStack {
	//�������� 3 : �������� �����͸� �Է¹޴� ���� ����
	int max; //���� �뷮
	int ptrLeft; //���� ������
	int ptrRight; //���� ������
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
	public IntDoubleStack(int capacity) {//������ ��� ������� ptr�� 0�̵ǰ� ���� �� ������� max���� �����ϴ�.
		ptrLeft = 0;//������ ������ ��� ������ ptr 0 �ʱ�ȭ
		ptrRight = capacity;
		max = capacity;//���� �뷮
		try {
			stk = new int[max];//���� ��ä�� �迭�� ����
		}catch (OutOfMemoryError e) {//������ �� ����
			max = 0; 
		}
	}
	//���� ���ÿ� push
	public int pushLeft(int x) throws OverflowIntStackException{
		if(ptrLeft >= ptrRight) {//������ ptr���� Ŭ��� 
			throw new OverflowIntStackException();
		}
		return stk[ptrLeft++] = x;//���� ���� �����͸� �迭 ��� stk[ptr]�� ���� �� ���� �����͸� �ϳ� ���� ��Ų��.
	}
	//������ ���ÿ� push
	public int pushRight(int x) throws OverflowIntStackException{
		if(ptrLeft >= ptrRight) {//���� ptr���� ������� 
			throw new OverflowIntStackException();
		}
		return stk[--ptrRight] = x;//���� ���� �����͸� �迭 ��� stk[ptr]�� ���� �� ���� �����͸� �ϳ� ���� ��Ų��.
	}
	//pop �޼ҵ�
	//���ÿ��� �����͸� ��
	public int popLeft() throws EmptyIntStackException{
		if(ptrLeft <= 0)//������ ��� �������
			throw new EmptyIntStackException();
		return stk[--ptrLeft];
	}
	//pop �޼ҵ�
	//���ÿ��� �����͸� ��
	public int popRight() throws EmptyIntStackException{
		if(ptrRight >= max)//������ ��� �������
			throw new EmptyIntStackException();
		return stk[++ptrRight];
	}
	
	//peek�޼ҵ�(������ ����⿡ �ִ� �����͸� ���� ������ �޼ҵ�(������ ��� ������� ���� EmptyIntStackException�� ������)
	public int peekLeft() throws EmptyIntStackException{
		if(ptrLeft <= 0)//������ �������
			throw new EmptyIntStackException();
		return stk[ptrLeft-1];//���� �����ʹ� ��ȭ���� �ʴ´�.(������ ������ ���⶧��)
	}
	
	//peek�޼ҵ�(������ ����⿡ �ִ� �����͸� ���� ������ �޼ҵ�(������ ��� ������� ���� EmptyIntStackException�� ������)
	public int peekRight() throws EmptyIntStackException{
		if(ptrRight >= max)//������ �������
			throw new EmptyIntStackException();
		return stk[ptrRight];//���� �����ʹ� ��ȭ���� �ʴ´�.(������ ������ ���⶧��)
	}
	//�˻� �޼ҵ� (indexOf) : ���� ��ü�� �迭 stk�� x�� ���� ���� �����Ͱ� ���ԵǾ� �ִ��� �ִٸ� �迭 ��� �ִ����� �����ϴ� �޼ҵ�
	// �˻��� ����⿡�� �ٴ����� ���� �˻��� �����մϴ�.���нô� -1 �����ô� �ش� ����� �ε��� ��ȯ
	// ���� �����Ͱ� ������ �� ���� �����͸� ��ȯ(���� pop()�Ǵ� �����͸� ã������)
	public int IndexOfLeft(int x) {
		for(int i=ptrLeft-1;i>=0;++i) {
			if(stk[i] == x)
				return i;//�˻� ����
		}
		return -1;//�˻� ����
	}
	//�˻� �޼ҵ� (indexOf) : ���� ��ü�� �迭 stk�� x�� ���� ���� �����Ͱ� ���ԵǾ� �ִ��� �ִٸ� �迭 ��� �ִ����� �����ϴ� �޼ҵ�
	// �˻��� ����⿡�� �ٴ����� ���� �˻��� �����մϴ�.���нô� -1 �����ô� �ش� ����� �ε��� ��ȯ
	// ���� �����Ͱ� ������ �� ���� �����͸� ��ȯ(���� pop()�Ǵ� �����͸� ã������)
	public int IndexOfRight(int x) {
		for(int i=ptrRight;i<max;++i) {
			if(stk[i] == x)
				return i;//�˻� ����
		}
		return -1;//�˻� ����
	}
	//������ ��� ��Ҹ� �����ϴ� �޼ҵ� clear
	//������ �迭 ��ڰ��� ������ �ʿ� ���� ptr ���� 0���θ���� �ȴ�.
	public void clearLeft() {
		ptrLeft = 0;
	}
	//������ ��� ��Ҹ� �����ϴ� �޼ҵ� clear
	//������ �迭 ��ڰ��� ������ �ʿ� ���� ptr ���� 0���θ���� �ȴ�.
	public void clearRight() {
		ptrRight = max;
	}
	//�뷮�� Ȯ���ϴ� capacity : ������ �뷮(max)�� ��ȯ�ϴ� �޼ҵ�
	public int capacityLeft() {
		return ptrRight;
	}
	//�뷮�� Ȯ���ϴ� capacity : ������ �뷮(max)�� ��ȯ�ϴ� �޼ҵ�
	public int capacityRight() {
		return max-ptrLeft;
	}
	//������ ���� Ȯ���ϴ� size : ���� ���ÿ� �׿��ִ� ������ ���� ��ȯ(ptr)
	public int sizeLeft() {
		return ptrLeft;
	}
	//������ ���� Ȯ���ϴ� size : ���� ���ÿ� �׿��ִ� ������ ���� ��ȯ(ptr)
	public int sizeRight() {
		return max-ptrRight;
	}
	//������ ��� �ִ��� �˻��ϴ� isEmpty : ������ ��� �ִ����˻��ϴ� �޼ҵ� , ��������� true, �ƴϸ� flase
	public boolean isEmptyLeft() {
		return ptrLeft <= 0;
	}
	//������ ��� �ִ��� �˻��ϴ� isEmpty : ������ ��� �ִ����˻��ϴ� �޼ҵ� , ��������� true, �ƴϸ� flase
	public boolean isEmptyRight() {
		return ptrRight >= max;
	}
	//������ ���� ������ �˻��ϴ� �޼ҵ�  isFull : ������ ���� ã���� �˻��ϴ� �޼ҵ�, ������ ���� ã���� true, �ƴϸ� false
	public boolean isFullLeft() {
		return ptrLeft >= ptrRight;
	}
	//������ ���� ������ �˻��ϴ� �޼ҵ�  isFull : ������ ���� ã���� �˻��ϴ� �޼ҵ�, ������ ���� ã���� true, �ƴϸ� false
	public boolean isFullRight() {
		return ptrRight <= ptrLeft;
	}
	//���þ��� ��� �����͸� ��Ź -> ����� ������ ���
	public void dumpLeft() {
		if(ptrLeft<=0){//������ �������
			System.out.println("������ ��� �ֽ��ϴ�.");
		}else {
			for(int i=0;i<ptrLeft;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
	//���þ��� ��� �����͸� ��Ź -> ����� ������ ���
	public void dumpRight() {
		if(ptrRight>=max){//������ �������
			System.out.println("������ ��� �ֽ��ϴ�.");
		}else {
			for(int i=ptrRight;i<max;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
}
