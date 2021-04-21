package ch03;

public class IdTester {

	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		System.out.println("a의 아이디 : "+a.getId());
		System.out.println("b의 아이디 : "+b.getId());
		
		System.out.println("부여한 아이디의 갯수 : "+Id.getCounter());//인스턴스에 포함되지 x , 인스턴스 갯수 상관없이 1개만..
	}

}
