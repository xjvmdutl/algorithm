package ch03;

public class GenericClassTester {
	//제네릭 : 처리해야할 대상의 자료형에 의존하지 않는 클래스(인터페이스)구현방식
	//제네릭 클래스는 클래스 이름 바로 뒤에 <Type>같은 형식의 파라미터를 붙혀서 선언
	//class :클래스 이름 <파라미터,파라미터2>{...}
	//interface : 인터페이스 이름 <파라미터,파라미터2,파라미터3>{...}
	//쉽표로 여러개 파라미터 지정가능
	//형변수에는 와일드 카드지정 가능 : <? extends T> 클래스 T의 서브 클래스를 전달 받는다,<? super T> 클래스 T의 슈퍼 클래스를 전달 받는다
	
	//제네릭 클래스의 파라미터를 T라고 작성
	static class GenericClass<T>{
		private T xyz;
		public GenericClass(T t) {
			this.xyz = t;
		}
		T getXyz() {
			return xyz;
		}
	}
	public static void main(String[] args) {
		//파라미터로 int String모두 넘길수 있다.
		GenericClass<String> s = new GenericClass<String>("ABC");
		GenericClass<Integer> i = new GenericClass<Integer>(15);
		System.out.println(s.getXyz());
		System.out.println(i.getXyz());
	}

}
