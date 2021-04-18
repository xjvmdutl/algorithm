package ch02;

public class IntArrayInit {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};//배열 초기자에 의해 생성
		//int[] a = new int[]{1,2,3,4,5};//이렇게 명시적으로도 선언이 가능
		for(int i=0;i<a.length;++i)
			System.out.println("a["+i+"] = "+a[i]);
		
	}

}
