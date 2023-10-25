package ch4_201025;

public class BoardImpl implements Board {

	Board board = new BoardImpl();
	
	@Override
	public void insert() {
		System.out.println(Board.max_volume);
	}
	
	public void del() {
		// 인터페이스의 디폴트 메소드 사용
		board.delete();
	}
	
	// 인터페이스의 디폴트 메소드 재정의 
	// default -> public 변경
	public void delete() {
		System.out.println("public 디폴트 메소드");
	}

	// 정적 메소드 호출
	public void change() {
		Board.changeBattery();
	}
	
	// private 메소드 호출
	public void change2() {
		board.defaultTest();
	} 
	
	// private 정적 메소드 사용
	public void change3() {
		Board.defaultTest2();
	}
}
