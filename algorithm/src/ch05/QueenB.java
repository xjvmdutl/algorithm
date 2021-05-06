package ch05;

public class QueenB {
	//가지 뻗기 ( 모든 조합을 경우의 수를 전부 표현)
	//퀸의 위치가 나올수 있는 모든 조합을 출력한다.
	//조건 1 : 퀸은 각행에 1개만 배치될수 있다.
	static int[] pos = new int[8];
	//각 열의 퀸의 위치를 출력
	static void print() {
		for(int i=0;i<8;++i)
			System.out.printf("%2d",pos[i]);
		System.out.println();
	}
	//i열에 퀸을 넣습니다.
	static void set(int i) {
		for(int j=0;j<8;++j) {
			pos[i]=j;//퀸을 j행에 배치합니다
			if(i==7)//모든열에 배치합니다.
				print();
			else
				set(i+1);//다음열에 배치합니다.
		}
	}
	public static void main(String[] args) {
		set(0);//0열에 퀸을 배치합니다.
	}

}
