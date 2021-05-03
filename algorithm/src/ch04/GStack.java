package ch04;
public class GStack<T> {
	int max; //스택 용량
	int ptr; //스택 포인터
	T[] stk;//스텍의 본체
	
	//실행시 예외 : 스택이 비어있음
	public static class EmptyIntStackException extends RuntimeException{//제네릭 타입일 경우 static 붙여야 한다.
		public EmptyIntStackException(){
			
		}
	}
	//실행시 예외 : 스택이 가득 참
	public static class OverflowIntStackException extends RuntimeException{//제네릭 타입일 경우 static 붙여야 한다.
		public OverflowIntStackException() {
			
		}
	}
	//생성자
	public GStack(int capacity) {//스택이 비어 있을경우 ptr은 0이되고 가득 차 있을경우 max값과 같습니다.
		ptr = 0;//생성시 스택이 비어 있으니 ptr 0 초기화
		max = capacity;//스택 용량
		try {
			stk = (T[]) new Object[max];//스택 본채용 배열을 생성
		}catch (OutOfMemoryError e) {//생성할 수 없음
			max = 0; 
		}
	}
	//스택에 x를 푸시
	public T push(T x) throws OverflowIntStackException{
		if(ptr >= max) {//IntStack  생성자를 통해서 스택작업을 수행시 스택포인터는 반드시 0이상 max이하가 되는데 스택이 가득 차 있는지에 대한 
						//검사는 등가 연산자를 통해(==)검사할 수도 있지만 프로그래밍 실수와 같은 원인으로 인해 ptr이 잘못 입력되면 max를 초과할수 있기 떄문에 관계연산자(<=)를 사용 
			throw new OverflowIntStackException();//스택이 가득 찰 경우, 예외인 OverflowIntStackException 예외를 던진다.
		}
		return stk[ptr++] = x;//전달 받은 데이터를 배열 요소 stk[ptr]에 저장 후 스택 포인터를 하나 증가 시킨다.
	}
	//pop 메소드
	//스택에서 데이터를 팝
	public T pop() throws EmptyIntStackException{
		if(ptr <= 0)//스택이 비어 있을경우
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	//peek메소드(스택의 꼭대기에 있는 데이터를 몰래 엿보는 메소드(스택이 비어 있을경우 예외 EmptyIntStackException를 던진다)
	public T peek() throws EmptyIntStackException{
		if(ptr <= 0)//스택이 비어있음
			throw new EmptyIntStackException();
		return stk[ptr-1];//스택 포인터는 변화하지 않는다.(데이터 출입이 없기때문)
	}
	//검색 메소드 (indexOf) : 스택 본체의 배열 stk에 x와 같은 값의 데이터가 포함되어 있는지 있다면 배열 어디에 있는지를 조사하는 메소드
	// 검색은 꼭대기에서 바닥으로 선형 검색을 수행합니다.실패시는 -1 성공시는 해당 요소의 인덱스 반환
	// 같은 데이터가 있으면 더 위쪽 데이터를 반환(먼저 pop()되는 데이터를 찾기위해)
	public int IndexOf(T x) {
		for(int i=ptr-1;i>=0;++i) {
			if(stk[i].equals(x))
				return i;//검색 성공
		}
		return -1;//검색 실패
	}
	//스택의 모든 요소를 삭제하는 메소드 clear
	//스텍의 배열 요솟값을 변경할 필요 없이 ptr 값을 0으로만들면 된다.
	public void clear() {
		ptr = 0;
	}
	//용량을 확인하는 capacity : 스택의 용량(max)를 반환하는 메소드
	public int capacity() {
		return max;
	}
	//데이터 수를 확인하는 size : 현재 스택에 쌓여있는 데이터 수를 반환(ptr)
	public int size() {
		return ptr;
	}
	//스택이 비어 있는지 검사하는 isEmpty : 스택이 비어 있는지검사하는 메소드 , 비어있으면 true, 아니면 flase
	public boolean isEmpty() {
		return ptr <= 0;
	}
	//스택이 가득 찻는지 검사하는 메소드  isFull : 스택이 가득 찾는지 검사하는 메소드, 스택이 가득 찾으면 true, 아니면 false
	public boolean isFull() {
		return ptr >= max;
	}
	//스택안의 모든 데이터를 바탁 -> 꼭대기 순으로 출력
	public void dump() {
		if(ptr<=0){//스택이 비어있음
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i=0;i<ptr;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
}
