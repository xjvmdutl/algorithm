package ch02;

public class PrimeNumber2 {

	public static void main(String[] args) {
		//소수인지는 그 수보다 작은 소수로 나눗셈을 하면 충분하다.
		//개선
		//소수를 구하는 과정에서 그때까지 구한 소수를 배열 prime에 저장한다. 이떄 n이 소수인지는 쌓아둔 소수들을 가지고 나눗셈을 진행
		int count = 0;//나눗셈 횟수
		int ptr = 0;//찾은 소수의 갯수
		int[] prime = new int[500];
		prime[ptr++] = 2;
		for(int n=3;n<=1000; n+=2) {//n은 2씩 증가한다. 4이상을 짝수는 2로 나누어 떨어져서 소수가 아니기 떄문
			int i;
			for(i =1;i<ptr;++i) {//이미 찾은 소수로 나누어본다
				count++;
				if(n%prime[i] == 0)//나누어 떨어지면 소수가 아니다
					break;//반복문 멈춘다.
			}
			if(ptr == i)//마지막까지 나누어 떨어지지 않음
				prime[ptr++]=n;//소수라고 배열에 저장
		}
		for(int i=0;i<ptr;++i)
			System.out.println(prime[i]);
		System.out.println("나눗셈을 실행한 횟수 : "+count);
		
		//개선 점 : n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않는다.
		//
		
	}

}
