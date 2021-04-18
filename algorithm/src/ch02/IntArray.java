package ch02;

public class IntArray {

	public static void main(String[] args) {
		//array = 같은 자료형들의 집합  
		//int[] a , int a[] 이렇게 선언 
		//a = new int[5]; //길이가 5인 배열을 참조
		//new 연산자가 생성하는것은 배열 본체에 대한 참조 이다.
		//a[i]는 배열 a에서 처음부터 i개뒤의 구성요소에 접근한다.
		//a.length = 배열의 구성 요솟수 = 배열의 길이
		int[] a = new int[5];//배열의 선언
		a[1]= 37;//a[1]에 37 대입
		a[2]=51;//a[2]에 51대입
		a[4] = a[1]*2;//a[4]에 37*2대입
		for(int i=0;i<a.length;++i)
			System.out.println("a["+i+"] = "+a[i]);
		//배열은 생성할떄 초깃값을 가진다 a[0],a[3] = 0
		//자바에서는 초기화나 대입에 의해 값이 넣어져 있지 않은 변수로부터는 값을 꺼낼수 없다(컴파일 에러)
		
	}

}
