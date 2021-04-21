package ch03;
class Id {
	private static int counter = 0;//아이디 몇개 부여했는지
	private int id; 
	//생성자
	public Id() { id=++counter;}
	public int getId() {
		return id;
	}
	//counter를 반환하는 메소드
	public static int getCounter() {
		return counter;
	}
	
}

