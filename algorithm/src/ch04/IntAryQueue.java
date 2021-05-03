package ch04;
//큐 : 선입선출
//데이터를 넣는다 : 인큐 , 데이터를 꺼낸다 : 디큐, 데이터를 꺼내는쪽 : 프런트(front) , 데이터를 넣는쪽 : 리어(rear)
//데이터를  디큐하게 될경우 요소를 앞으로 하나씩 옮겨야 한다.
public class IntAryQueue {
	private int max;//큐 용량
	private int num;//현재 데이터 수
	private int[] que;//큐 본채
	//실행시 예외 : 큐 비어있음
	public class EmptyIntAryQueueException extends RuntimeException{
		public EmptyIntAryQueueException(){
			
		}
	}
	//실행시 예외 : 큐 가득 참
	public class OverflowIntAryQueueException extends RuntimeException{
		public OverflowIntAryQueueException() {
			
		}
	}
	public IntAryQueue(int capacity) {
		num = 0;
		max = capacity;
		try {
			que = new int[max];//큐 본채용 배열을 생성
		}catch (OutOfMemoryError e) {//생성할 수 없음
			max = 0; 
		}
	}
	public void EnQueue(int x) throws OverflowIntAryQueueException{
		if(num >= max)//큐크기를 초과할 경우
			throw new OverflowIntAryQueueException();
		que[num++] = x;
	}
	public int DeQueue() throws EmptyIntAryQueueException{
		if(num <= 0)//큐크기를 초과할 경우
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
		if(num<=0){//큐가 비어있음
			System.out.println("큐가 비어 있습니다.");
		}else {
			for(int i=0;i<num;++i)
				System.out.print(que[i]+" ");
			System.out.println();
		}
	}
	public int IndexOf(int x) {
		for(int i=0;i<num;++i) {
			if(que[i] == x)
				return i;//검색 성공
		}
		return -1;//검색 실패
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
