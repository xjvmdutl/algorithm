package ch04;
//
public class GQueue<E> {
	private int max; 
	private int front;
	private int rear; 
	private int num; 
	private E[] queue; 
	
	// 실행시 예외 : 큐가 비어있음
	public static class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//실행시 예외 : 큐가 가득 참
	public static class OverFlowIntQueueException extends RuntimeException{
		public OverFlowIntQueueException() {}
	}
	//생성자
	public GQueue(int capacity) {
		num = 0;//생성시 큐는 비어있기때문 rear,front,num값을 0 으로 초기화 한다
		front = 0;
		rear = 0;
		max = capacity;// 용량 지정
		try {
			queue = (E[]) new Object[max];//큐 본체용 배열 생성
		}catch(OutOfMemoryError e) {// 용량보다 클 경우 (생성 불가능)
			max = 0;
		}
	}
	//큐에 데이터를 인큐
	public E enqueue(E x) throws OverFlowIntQueueException{
		if(num >= max) // 큐가 가득 찼을때
			throw new OverFlowIntQueueException();
		queue[rear++] = x;
		num++;
		if(rear == max) // rear 값이 큐의 최대용량과 같아질 경우 rear를 0으로 초기화 해준다(링 버퍼)
			rear = 0;
		return x;
	}
	//큐에 데이터를 디큐
	public E dequeue() throws EmptyIntQueueException {
		if(num <= 0) { //큐가 비어있을때
			throw new EmptyIntQueueException();
		}
		E x = queue[front++];//저장값을 꺼내고 front를 하나 증가시킨다.
		num--;
		if(front == max )//front가 인덱스를 초과 할 경우 front를 0으로 초기화 시킨다.
			front =0;
		return x;
	}
	//큐에서 데이터를 피크
	public E peek() throws EmptyIntQueueException { // dequeue할 데이터를 들여다봄
		if(num<=0)
			throw new EmptyIntQueueException();//큐가 비어있음
		return queue[front];//front, rear, num 의 값이 변하지 않는다
	}
	//큐에서 x를 검색하여 인덱스(찾지 못하면 -1 반환)
	public int indexOf(E x) {//front->rear선형 검색
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// 순환검색이 가능하게
			//스캔의 시작은 front부터 max값보다 크면 %max나눈 나머지로 계속 검색한다
			if(queue[idx].equals(x))
				return idx;//검색 성공
		}
		return -1;//검색 실패
	}
	//큐를 비움
	public void clear() {//큐의 모든 데이터를 삭제
		num = front =rear= 0;
	}
	//큐의 용량을 반환
	public int capacity() {//최대 용량의 확인
		return max;
	}
	//큐에 쌓여있는 데이터 수를 반환
	public int size() {//현재 큐의 데이터 수를 확인
		return num;
	}
	//큐가 비어 있나요
	public boolean isEmpty() {//큐가 비어있는지를 판단
		return num<=0;
	}
	//큐가 가득 찼나요
	public boolean isFull() {//큐가 가득 차있는지를 판단
		return num>=max;
	}
	//큐안의 모든 데이터를 front -> rear순으로 출력
	public void dump() {
		if(num <= 0)
			System.out.println("큐가 비어 있습니다");
		else {
			for(int i=0;i<num;++i)
				System.out.print(queue[(i+front)%max]+" ");
			System.out.println();
		}
			
	}
	//연습문제 5: 임의의 데이터를 검색하는 int search(int x) 를 구현 
	// 	        배열의 인덱스가 아닌 큐안에서 몇번째에 있는가를 양수로 반환하는 함수
	public int search(E x) {
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// 순환검색이 가능하게
			//스캔의 시작은 front부터 max값보다 크면 %max나눈 나머지로 계속 검색한다
			if(x.equals(queue[idx]))
				return (i+1);//검색 성공
		}
		return 0;//검색 실패
	}
}
