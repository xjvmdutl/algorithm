package ch03;

public class A implements Comparable<A> {//자연정렬 : 컴퓨터에서의 정렬이 아닌 사용자 커스텀 정렬을 위한 interface
	//필드 , 메소드
	
	public int compareTo(A c) {
		//this가 c보다 크면 양의값 반환
		//this가 c보다 작으면 음의값 반환
		//this가 c와 같으면 0 반환
		return 0;
	}
	public boolean equals(Object b) {
		//this가 c와 같으면 true
		//this가 c와 다르면 false
		return true;
	}
	//자연정렬로 정렬되지 않은 배열에서의 정렬에서의 검색은 제네릭 메서드로 하면 된다.
	//제네릭 메소드의 첫 매개변수는 a(검색대상), 두번쨰 매개변수는 key입니다.
	//제네릭 메소드는 자료형에 구애 x
	//세번째 매개변수  c(comparator) 전달
	//객체의 대소 관계를 판단하는 comparator를 직접 구현하기 위해서는 comparator인터페이스를 구현한 클래스를 정의 하고 그 클래스형의 인스턴스를직접 선언해야 된다.
	
}
