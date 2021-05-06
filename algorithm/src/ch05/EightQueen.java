package ch05;

public class EightQueen {
	static int[] pos = new int[8];//각행에 퀸을 배치했는지 체크
	static boolean[] flag_a = new boolean[8];//각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b = new boolean[15];//대각선 방향(위쪽 대각선 /) 퀸을 배치했는지 체크
	static boolean[] flag_c = new boolean[15];//대각선 방향(아랫쪽 대각선 \) 퀸을 배치했는지 체크
	static void print() {
		//연습문제 8 : print 메소드를 수정하여 전각기호 'ㅁ' 와 '■' 를 사용해 퀸의 배치 상황 출력		
		for(int i=0;i<8;++i) {
			for(int j=0;j<8;++j) {
				if(pos[i]==j) {
					System.out.printf("■");
				}
				else {
					System.out.print("□");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	static void set(int i) {

		for(int j=0;j<8;++j) {
			if(flag_a[j] == false 
					&& flag_b[i+j] == false //대각선 /에 아직 배치x // 0~14 
					&& flag_c[i-j+7] == false) {//대각선 \에 아직 배치 x // 14~0
				pos[i]=j;
				if(i==7)
					print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
					set(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
				}
			}
		}
	}
	static void removeSet(int i) {//연습문제 9 : 비 재귀적 해결
		int j;
		int[] jstk = new int[8];

		Start: while (true) {
			j = 0;
			while (true) {
				while (j < 8) {
					if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
						pos[i] = j;
						if (i == 7) // 모든 열에 배치 마침
							print();
						else {
							flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
							jstk[i++] = j; // i 열의 행을 Push
							continue Start;
						}
					}
					j++;
				}
				if (--i == -1)
					return;
				j = jstk[i]; // i 열의 행을 Pop
				flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				j++;
			}
		}
	}
	public static void main(String[] args) {
		removeSet(0);
	}

}
