package ch02;

public class PrimeNumber3 {

	public static void main(String[] args) {
		//5*20 과 20*5 의결과는 같다 => 하나의 값으로만 소수로 나눗셈을 시도하고, 그과정에서도 나누어 떨어지지 않는다면 소수로 판정  
		//개선
		//prime[i]의 제곱이 n이하인가를 판별
		//곱셈과 나눗셈을 처리비용이 같기 때문에 count에 곱셈과 나눗셈 횟수에 합계를 저장
		int count = 0;//곱셈,나눗셈 횟수
		int ptr = 0;//찾은 소수의 갯수
		int[] prime = new int[500]; //소수 저장하는 배열
		prime[ptr++] = 2;//2는 소수
		prime[ptr++] = 3;//3도 소수
		for(int n=5;n<=1000; n+=2) {//n은 2씩 증가한다. 4이상을 짝수는 2로 나누어 떨어져서 소수가 아니기 떄문
			boolean flag = false;
			for(int i=1;prime[i]*prime[i]<=n;++i) {
				count+=2;
				//prime[i]*prime[i]
				//n%prime[i]
				if(n%prime[i] ==0) {
					flag =true; //더이상 반복 x
					break;
				}
			}
			if(!flag) {
				prime[ptr++] = n;
				count++;
			}
		}
		for(int i=0;i<ptr;++i)
			System.out.println(prime[i]);
		System.out.println("나눗셈을 실행한 횟수 : "+count);
		
		
	}

}
