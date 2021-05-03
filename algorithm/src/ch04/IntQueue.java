package ch04;
//�����۷� ť ����� : �迭 ��Ҹ� �������� �ű��� �ʴ� ť, �迭�� ó���� ���� ����Ǿ� �ִ� �ڷᱸ��(� ��Ұ� ó������ ���������� �ĺ��ϱ� ���� ������ front,rear�̴�)
public class IntQueue {
	private int max; // ť�� �뷮(ť�� �ִ� �뷮�� �����ϴ� �ʵ�= que�� ������ �� �ִ� �ִ�뷮)
	private int front; //ù ��° ��� Ŀ��(��ť�ϴ� ������ ��� ù��° ����� �ε����� ����)
	private int rear; //������ ��� Ŀ��(��ť�� ������ ��� �� ���߿� ���� ����� �ϳ� ���� �ε����� ����)
	private int num; // ���� ������ ��(ť�� �׾Ƴ��� ������ ���� ��Ÿ����, max�� num�� ���� �� ���� á�����, num=0�϶� ����������)
	//que�� ����ִ��� �ƴ����� �����ϱ� ���� ��쿡 ���� rear�� front�� ���� ����ε� �̶��� ���� �� ���� ���������� ��� rear�� front�� ���� ������ �Ǻ��� �Ұ��� �ϴ�.
	//���� num ���� �ʿ�
	private int[] queue; // ť ��ü(enqueue �ϴ� �����͸� �����ϱ� ���� ť ��ü�� �迭)
	// ����� ���� : ť�� �������
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//����� ���� : ť�� ���� ��
	public class OverFlowIntQueueException extends RuntimeException{
		public OverFlowIntQueueException() {}
	}
	//������
	public IntQueue(int capacity) {
		num = 0;//������ ť�� ����ֱ⶧�� rear,front,num���� 0 ���� �ʱ�ȭ �Ѵ�
		front = 0;
		rear = 0;
		max = capacity;// �뷮 ����
		try {
			queue=new int[max];//ť ��ü�� �迭 ����
		}catch(OutOfMemoryError e) {// �뷮���� Ŭ ��� (���� �Ұ���)
			max = 0;
		}
	}
	//ť�� �����͸� ��ť
	public int enqueue(int x) throws OverFlowIntQueueException{
		if(num >= max) // ť�� ���� á����
			throw new OverFlowIntQueueException();
		queue[rear++] = x;
		num++;
		if(rear == max) // rear ���� ť�� �ִ�뷮�� ������ ��� rear�� 0���� �ʱ�ȭ ���ش�(�� ����)
			rear = 0;
		return x;
	}
	//ť�� �����͸� ��ť
	public int dequeue() throws EmptyIntQueueException {
		if(num <= 0) { //ť�� ���������
			throw new EmptyIntQueueException();
		}
		int x = queue[front++];//���尪�� ������ front�� �ϳ� ������Ų��.
		num--;
		if(front == max )//front�� �ε����� �ʰ� �� ��� front�� 0���� �ʱ�ȭ ��Ų��.
			front =0;
		return x;
	}
	//ť���� �����͸� ��ũ
	public int peek() throws EmptyIntQueueException { // dequeue�� �����͸� �鿩�ٺ�
		if(num<=0)
			throw new EmptyIntQueueException();//ť�� �������
		return queue[front];//front, rear, num �� ���� ������ �ʴ´�
	}
	//ť���� x�� �˻��Ͽ� �ε���(ã�� ���ϸ� -1 ��ȯ)
	public int indexOf(int x) {//front->rear���� �˻�
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// ��ȯ�˻��� �����ϰ�
			//��ĵ�� ������ front���� max������ ũ�� %max���� �������� ��� �˻��Ѵ�
			if(queue[idx]==x)
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
	public int search(int x) {
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// ��ȯ�˻��� �����ϰ�
			//��ĵ�� ������ front���� max������ ũ�� %max���� �������� ��� �˻��Ѵ�
			if(queue[idx]==x)
				return (i+1);//�˻� ����
		}
		return 0;//�˻� ����
	}
}
