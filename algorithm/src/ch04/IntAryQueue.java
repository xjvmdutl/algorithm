package ch04;
//ť : ���Լ���
//�����͸� �ִ´� : ��ť , �����͸� ������ : ��ť, �����͸� �������� : ����Ʈ(front) , �����͸� �ִ��� : ����(rear)
//�����͸�  ��ť�ϰ� �ɰ�� ��Ҹ� ������ �ϳ��� �Űܾ� �Ѵ�.
public class IntAryQueue {
	private int max;//ť �뷮
	private int num;//���� ������ ��
	private int[] que;//ť ��ä
	//����� ���� : ť �������
	public class EmptyIntAryQueueException extends RuntimeException{
		public EmptyIntAryQueueException(){
			
		}
	}
	//����� ���� : ť ���� ��
	public class OverflowIntAryQueueException extends RuntimeException{
		public OverflowIntAryQueueException() {
			
		}
	}
	public IntAryQueue(int capacity) {
		num = 0;
		max = capacity;
		try {
			que = new int[max];//ť ��ä�� �迭�� ����
		}catch (OutOfMemoryError e) {//������ �� ����
			max = 0; 
		}
	}
	public void EnQueue(int x) throws OverflowIntAryQueueException{
		if(num >= max)//ťũ�⸦ �ʰ��� ���
			throw new OverflowIntAryQueueException();
		que[num++] = x;
	}
	public int DeQueue() throws EmptyIntAryQueueException{
		if(num <= 0)//ťũ�⸦ �ʰ��� ���
			throw new EmptyIntAryQueueException();
		int data = que[0];
		for(int i=1;i<num;++i) {
			swap(i-1,i);
		}
		num--;
		return data;
	}
	private void swap(int i,int j) {
		int tmp = que[i];
		que[i]=que[j];
		que[j]=tmp;
	}
	public int size() {
		return num;
	}
	public int capacity() {
		return max;
	}
	public void dump() {
		if(num<=0){//ť�� �������
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		}else {
			for(int i=0;i<num;++i)
				System.out.print(que[i]+" ");
			System.out.println();
		}
	}
	public int IndexOf(int x) {
		for(int i=0;i<num;++i) {
			if(que[i] == x)
				return i;//�˻� ����
		}
		return -1;//�˻� ����
	}
	public void clear() {
		num=0;
	}
	public boolean isEmpty() {
		return num<=0;
	}
	public boolean isFull() {
		return num>=max;
	}
}
