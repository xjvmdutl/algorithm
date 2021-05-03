package ch04;
//링버퍼로 큐 만들기 : 배열 요소를 앞쪽으로 옮기지 않는 큐, 배열을 처음과 끝이 연결되어 있는 자료구조(어떤 요소가 처음인지 마지막인지 식별하기 위한 변수가 front,rear이다)
public class IntQueue {
	private int max; // 큐의 용량(큐의 최대 용량을 저장하는 필드= que에 저장할 수 있는 최대용량)
	private int front; //첫 번째 요소 커서(인큐하는 데이터 가운데 첫번째 요소의 인덱스를 저장)
	private int rear; //마지막 요소 커서(인큐한 데이터 가운데 맨 나중에 넣은 요소의 하나 뒤의 인덱스를 저장)
	private int num; // 현재 데이터 수(큐에 쌓아놓은 데이터 수를 나타낸다, max와 num이 같을 때 가득 찼을경우, num=0일때 비어있을경우)
	//que가 비어있는지 아닌지를 구별하기 위한 경우에 수는 rear와 front가 같을 경우인데 이때는 가득 찬 경우와 비어있을경우 모두 rear와 front가 같기 때문에 판별이 불가능 하다.
	//따라서 num 변수 필요
	private int[] queue; // 큐 본체(enqueue 하는 데이터를 저장하기 위한 큐 본체용 배열)
	// 실행시 예외 : 큐가 비어있음
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//실행시 예외 : 큐가 가득 참
	public class OverFlowIntQueueException extends RuntimeException{
		public OverFlowIntQueueException() {}
	}
	//생성자
	public IntQueue(int capacity) {
		num = 0;//생성시 큐는 비어있기때문 rear,front,num값을 0 으로 초기화 한다
		front = 0;
		rear = 0;
		max = capacity;// 용량 지정
		try {
			queue=new int[max];//큐 본체용 배열 생성
		}catch(OutOfMemoryError e) {// 용량보다 클 경우 (생성 불가능)
			max = 0;
		}
	}
	//큐에 데이터를 인큐
	public int enqueue(int x) throws OverFlowIntQueueException{
		if(num >= max) // 큐가 가득 찼을때
			throw new OverFlowIntQueueException();
		queue[rear++] = x;
		num++;
		if(rear == max) // rear 값이 큐의 최대용량과 같아질 경우 rear를 0으로 초기화 해준다(링 버퍼)
			rear = 0;
		return x;
	}
	//큐에 데이터를 디큐
	public int dequeue() throws EmptyIntQueueException {
		if(num <= 0) { //큐가 비어있을때
			throw new EmptyIntQueueException();
		}
		int x = queue[front++];//저장값을 꺼내고 front를 하나 증가시킨다.
		num--;
		if(front == max )//front가 인덱스를 초과 할 경우 front를 0으로 초기화 시킨다.
			front =0;
		return x;
	}
	//큐에서 데이터를 피크
	public int peek() throws EmptyIntQueueException { // dequeue할 데이터를 들여다봄
		if(num<=0)
			throw new EmptyIntQueueException();//큐가 비어있음
		return queue[front];//front, rear, num 의 값이 변하지 않는다
	}
	//큐에서 x를 검색하여 인덱스(찾지 못하면 -1 반환)
	public int indexOf(int x) {//front->rear선형 검색
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// 순환검색이 가능하게
			//스캔의 시작은 front부터 max값보다 크면 %max나눈 나머지로 계속 검색한다
			if(queue[idx]==x)
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
	public int search(int x) {
		for(int i=0;i<num;++i) {
			int idx = (i + front ) % max;// 순환검색이 가능하게
			//스캔의 시작은 front부터 max값보다 크면 %max나눈 나머지로 계속 검색한다
			if(queue[idx]==x)
				return (i+1);//검색 성공
		}
		return 0;//검색 실패
	}
}
