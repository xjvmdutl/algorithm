package ch02;

public class PrimeNumber3 {

	public static void main(String[] args) {
		//5*20 �� 20*5 �ǰ���� ���� => �ϳ��� �����θ� �Ҽ��� �������� �õ��ϰ�, �װ��������� ������ �������� �ʴ´ٸ� �Ҽ��� ����  
		//����
		//prime[i]�� ������ n�����ΰ��� �Ǻ�
		//������ �������� ó������� ���� ������ count�� ������ ������ Ƚ���� �հ踦 ����
		int count = 0;//����,������ Ƚ��
		int ptr = 0;//ã�� �Ҽ��� ����
		int[] prime = new int[500]; //�Ҽ� �����ϴ� �迭
		prime[ptr++] = 2;//2�� �Ҽ�
		prime[ptr++] = 3;//3�� �Ҽ�
		for(int n=5;n<=1000; n+=2) {//n�� 2�� �����Ѵ�. 4�̻��� ¦���� 2�� ������ �������� �Ҽ��� �ƴϱ� ����
			boolean flag = false;
			for(int i=1;prime[i]*prime[i]<=n;++i) {
				count+=2;
				//prime[i]*prime[i]
				//n%prime[i]
				if(n%prime[i] ==0) {
					flag =true; //���̻� �ݺ� x
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
		System.out.println("�������� ������ Ƚ�� : "+count);
		
		
	}

}
