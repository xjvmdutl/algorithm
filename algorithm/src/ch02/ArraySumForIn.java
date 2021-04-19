package ch02;

public class ArraySumForIn {

	public static void main(String[] args) {
		double[] a = {1.0,2.0,3.0,4.0,5.0};
		for(int i=0;i<a.length;++i)
			System.out.println("a["+i+"]="+a[i]);
		double sum = 0;
		for(double i : a) {//for-in문,for-each문 , 확장된 for문
			sum +=i;
		}
		System.out.println("모든 요소의 합은 "+sum+"입니다.");
		
		//클래스는 임의의 데이터형을 자유로이 조합하여 만들수 있는 자료구조
		
	}

}
