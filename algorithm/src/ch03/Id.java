package ch03;
class Id {
	private static int counter = 0;//���̵� � �ο��ߴ���
	private int id; 
	//������
	public Id() { id=++counter;}
	public int getId() {
		return id;
	}
	//counter�� ��ȯ�ϴ� �޼ҵ�
	public static int getCounter() {
		return counter;
	}
	
}

