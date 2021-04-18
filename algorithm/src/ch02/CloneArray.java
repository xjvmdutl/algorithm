package ch02;

public class CloneArray {

	public static void main(String[] args) {
		// 배열의 복제는 clone메소드를 호출하여 쉽게 가능
		// 배열 이름.clone();
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();//b는 a의 복제를 참조
		b[3] = 0;//한요소에만 0대입
				//배열변수 b의 참조가 배열 a의 본체가 아니라 그 복제임을 참조하는것을 확인
		System.out.print("a = ");
		for(int i=0;i<a.length;++i)
			System.out.print(" "+a[i]);
		System.out.print("\nb = ");
		for(int i=0;i<b.length;++i)
			System.out.print(" "+b[i]);
		

	}

}
