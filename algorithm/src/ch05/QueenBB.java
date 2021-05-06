package ch05;

public class QueenBB {
	static int[] pos = new int[8];
	static boolean[] flag = new boolean[8];//같은 행에 중복하여 퀸이 배치되는 것을 방지하기 위한 표시
	static void print() {
		for(int i=0;i<8;++i)
			System.out.printf("%2d",pos[i]);
		System.out.println();
	}
	static void set(int i) {
		for(int j=0;j<8;++j) {
			if(flag[j] == false) {
				pos[i]=j;
				if(i==7)
					print();
				else {
					flag[j] = true;//j행에 퀸을 배치하게 될 경우 flag[j]를 true로 하고 배치되지 않은 상태의 값은 false로 합니다.
					set(i+1);
					flag[j] = false;//재귀 호출한 set(i+1)메소드 실행이 끝나게 되면 퀸이 j행에서 제거되었기 때문에 flag[j]에는 아직 배치하지 않았음을 나타내는 false대입
					//이처럼 필요하지 않은 분기를 없애 불필요한 조합을 줄이는 방법을 한정조작이라고 하며, 가지뻗기와 한정조작을 조합하여 문제를 풀어가는 방법을 분기한정법이라고 한다.
				}
			}
		}
	}
	public static void main(String[] args) {
		set(0);
	}

}
