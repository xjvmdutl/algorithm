package ch04;
//
public class GQueue<E> {
	private int max; 
	private int front;
	private int rear; 
	private int num; 
	private E[] queue; 
	
	// ����� ���� : ť�� �������
	public static class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//����� ���� : ť�� ���� ��
	public static class OverFlowIntQueueException extends RuntimeException{
		public OverFlowIntQueueException() {}
	}
	//������
	public GQueue(int capacity) {
		num = 0;//������ ť�� ����ֱ⶧�� rear,front,num���� 0 ���� �ʱ�ȭ �Ѵ�
		front = 0;
		rear = 0;
		max = capacity;// �뷮 ����
		try {
			queue = (E[]) new Object[max];//ť ��ü�� �迭 ����
		}catch(OutOfMemoryError e) {// �뷮���� Ŭ ��� (���� �Ұ���)
			max = 0;
		}
	}
	//ť�� �����͸� ��ť
	public E enqueue(E x) throws OverFlowIntQueueException{
		if(num >= max) // ť�� ���� á����
			throw new OverFlowIntQueueException();
		queue[rear++] = x;
		num++;
		if(rear == max) // rear ���� ť�� �ִ�뷮�� ������ ��� rear�� 0���� �ʱ�ȭ ���ش�(�� ����)
			rear = 0;
		return x;
	}
	//ť�� �����͸� ��ť
	public E dequeue() throws EmptyIntQueueException {
		if(num <= 0) { //ť�� ���������
			throw new EmptyIntQueueException();
		}
		E x = queue[front++];//���尪�� ������ front�� �ϳ� ������Ų��.
		num--;
		if(front == max )//front�� �ε����� �ʰ� �� ��� front�� 0���� �ʱ�ȭ ��Ų��.
			front =0;
		return x;
	}
	//ť���� �����͸� ��ũ
	public E peek() throws EmptyIntQueueException { // dequeue�� �����͸� �鿩�ٺ�
		if(num<=0)
			throw new EmptyIntQueueException();//ť�� �������
		return queue[front];//front, rear, num �� ���� ������ �ʴ´�
	}
	//ť���� x�� �˻��Ͽ� �ε���(ã�� ���ϸ� -1 ��ȯ)
	public int indexOf(E x) {//front->rear���� �˻�
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// ��ȯ�˻��� �����ϰ�
			//��ĵ�� ������ front���� max������ ũ�� %max���� �������� ��� �˻��Ѵ�
			if(queue[idx].equals(x))
				return idx;//�˻� ����
		}
		return -1;//�˻� ����
	}
	//ť�� ���
	public void clear() {//ť�� ��� �����͸� ����
		num = front =rear= 0;
	}
	//ť�� �뷮�� ��ȯ
	public int capacity() {//�ִ� �뷮�� Ȯ��
		return max;
	}
	//ť�� �׿��ִ� ������ ���� ��ȯ
	public int size() {//���� ť�� ������ ���� Ȯ��
		return num;
	}
	//ť�� ��� �ֳ���
	public boolean isEmpty() {//ť�� ����ִ����� �Ǵ�
		return num<=0;
	}
	//ť�� ���� á����
	public boolean isFull() {//ť�� ���� ���ִ����� �Ǵ�
		return num>=max;
	}
	//ť���� ��� �����͸� front -> rear������ ���
	public void dump() {
		if(num <= 0)
			System.out.println("ť�� ��� �ֽ��ϴ�");
		else {
			for(int i=0;i<num;++i)
				System.out.print(queue[(i+front)%max]+" ");
			System.out.println();
		}
			
	}
	//�������� 5: ������ �����͸� �˻��ϴ� int search(int x) �� ���� 
	// 	        �迭�� �ε����� �ƴ� ť�ȿ��� ���°�� �ִ°��� ����� ��ȯ�ϴ� �Լ�
	public int search(E x) {
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// ��ȯ�˻��� �����ϰ�
			//��ĵ�� ������ front���� max������ ũ�� %max���� �������� ��� �˻��Ѵ�
			if(x.equals(queue[idx]))
				return (i+1);//�˻� ����
		}
		return 0;//�˻� ����
	}
}
