package ch04;
public class IntDoubleStack {
	//연습문제 3 : 양쪽으로 데이터를 입력받는 스택 구현
	int max; //스택 용량
	int ptrLeft; //스택 포인터
	int ptrRight; //스택 포인터
	int[] stk;//스텍의 본체
	
	//실행시 예외 : 스택이 비어있음
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException(){
		}
	}
	//실행시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
		}
	}
	//생성자
	public IntDoubleStack(int capacity) {//스택이 비어 있을경우 ptr은 0이되고 가득 차 있을경우 max값과 같습니다.
		ptrLeft = 0;//생성시 스택이 비어 있으니 ptr 0 초기화
		ptrRight = capacity;
		max = capacity;//스택 용량
		try {
			stk = new int[max];//스택 본채용 배열을 생성
		}catch (OutOfMemoryError e) {//생성할 수 없음
			max = 0; 
		}
	}
	//왼쪽 스택에 push
	public int pushLeft(int x) throws OverflowIntStackException{
		if(ptrLeft >= ptrRight) {//오른쪽 ptr보다 클경우 
			throw new OverflowIntStackException();
		}
		return stk[ptrLeft++] = x;//전달 받은 데이터를 배열 요소 stk[ptr]에 저장 후 스택 포인터를 하나 증가 시킨다.
	}
	//오른쪽 스택에 push
	public int pushRight(int x) throws OverflowIntStackException{
		if(ptrLeft >= ptrRight) {//왼쪽 ptr보다 작을경우 
			throw new OverflowIntStackException();
		}
		return stk[--ptrRight] = x;//전달 받은 데이터를 배열 요소 stk[ptr]에 저장 후 스택 포인터를 하나 증가 시킨다.
	}
	//pop 메소드
	//스택에서 데이터를 팝
	public int popLeft() throws EmptyIntStackException{
		if(ptrLeft <= 0)//스택이 비어 있을경우
			throw new EmptyIntStackException();
		return stk[--ptrLeft];
	}
	//pop 메소드
	//스택에서 데이터를 팝
	public int popRight() throws EmptyIntStackException{
		if(ptrRight >= max)//스택이 비어 있을경우
			throw new EmptyIntStackException();
		return stk[++ptrRight];
	}
	
	//peek메소드(스택의 꼭대기에 있는 데이터를 몰래 엿보는 메소드(스택이 비어 있을경우 예외 EmptyIntStackException를 던진다)
	public int peekLeft() throws EmptyIntStackException{
		if(ptrLeft <= 0)//스택이 비어있음
			throw new EmptyIntStackException();
		return stk[ptrLeft-1];//스택 포인터는 변화하지 않는다.(데이터 출입이 없기때문)
	}
	
	//peek메소드(스택의 꼭대기에 있는 데이터를 몰래 엿보는 메소드(스택이 비어 있을경우 예외 EmptyIntStackException를 던진다)
	public int peekRight() throws EmptyIntStackException{
		if(ptrRight >= max)//스택이 비어있음
			throw new EmptyIntStackException();
		return stk[ptrRight];//스택 포인터는 변화하지 않는다.(데이터 출입이 없기때문)
	}
	//검색 메소드 (indexOf) : 스택 본체의 배열 stk에 x와 같은 값의 데이터가 포함되어 있는지 있다면 배열 어디에 있는지를 조사하는 메소드
	// 검색은 꼭대기에서 바닥으로 선형 검색을 수행합니다.실패시는 -1 성공시는 해당 요소의 인덱스 반환
	// 같은 데이터가 있으면 더 위쪽 데이터를 반환(먼저 pop()되는 데이터를 찾기위해)
	public int IndexOfLeft(int x) {
		for(int i=ptrLeft-1;i>=0;++i) {
			if(stk[i] == x)
				return i;//검색 성공
		}
		return -1;//검색 실패
	}
	//검색 메소드 (indexOf) : 스택 본체의 배열 stk에 x와 같은 값의 데이터가 포함되어 있는지 있다면 배열 어디에 있는지를 조사하는 메소드
	// 검색은 꼭대기에서 바닥으로 선형 검색을 수행합니다.실패시는 -1 성공시는 해당 요소의 인덱스 반환
	// 같은 데이터가 있으면 더 위쪽 데이터를 반환(먼저 pop()되는 데이터를 찾기위해)
	public int IndexOfRight(int x) {
		for(int i=ptrRight;i<max;++i) {
			if(stk[i] == x)
				return i;//검색 성공
		}
		return -1;//검색 실패
	}
	//스택의 모든 요소를 삭제하는 메소드 clear
	//스텍의 배열 요솟값을 변경할 필요 없이 ptr 값을 0으로만들면 된다.
	public void clearLeft() {
		ptrLeft = 0;
	}
	//스택의 모든 요소를 삭제하는 메소드 clear
	//스텍의 배열 요솟값을 변경할 필요 없이 ptr 값을 0으로만들면 된다.
	public void clearRight() {
		ptrRight = max;
	}
	//용량을 확인하는 capacity : 스택의 용량(max)를 반환하는 메소드
	public int capacityLeft() {
		return ptrRight;
	}
	//용량을 확인하는 capacity : 스택의 용량(max)를 반환하는 메소드
	public int capacityRight() {
		return max-ptrLeft;
	}
	//데이터 수를 확인하는 size : 현재 스택에 쌓여있는 데이터 수를 반환(ptr)
	public int sizeLeft() {
		return ptrLeft;
	}
	//데이터 수를 확인하는 size : 현재 스택에 쌓여있는 데이터 수를 반환(ptr)
	public int sizeRight() {
		return max-ptrRight;
	}
	//스택이 비어 있는지 검사하는 isEmpty : 스택이 비어 있는지검사하는 메소드 , 비어있으면 true, 아니면 flase
	public boolean isEmptyLeft() {
		return ptrLeft <= 0;
	}
	//스택이 비어 있는지 검사하는 isEmpty : 스택이 비어 있는지검사하는 메소드 , 비어있으면 true, 아니면 flase
	public boolean isEmptyRight() {
		return ptrRight >= max;
	}
	//스택이 가득 찻는지 검사하는 메소드  isFull : 스택이 가득 찾는지 검사하는 메소드, 스택이 가득 찾으면 true, 아니면 false
	public boolean isFullLeft() {
		return ptrLeft >= ptrRight;
	}
	//스택이 가득 찻는지 검사하는 메소드  isFull : 스택이 가득 찾는지 검사하는 메소드, 스택이 가득 찾으면 true, 아니면 false
	public boolean isFullRight() {
		return ptrRight <= ptrLeft;
	}
	//스택안의 모든 데이터를 바탁 -> 꼭대기 순으로 출력
	public void dumpLeft() {
		if(ptrLeft<=0){//스택이 비어있음
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i=0;i<ptrLeft;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
	//스택안의 모든 데이터를 바탁 -> 꼭대기 순으로 출력
	public void dumpRight() {
		if(ptrRight>=max){//스택이 비어있음
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i=ptrRight;i<max;++i)
				System.out.print(stk[i]+" ");
			System.out.println();
		}
	}
}
