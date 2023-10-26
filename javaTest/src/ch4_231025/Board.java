package ch4_231025;

public interface Board {
//	1. public 상수 필드
//	2. public 추상 메소드
//	3. public 디폴트 메소드
//	4. public 정적 메소드
//	5. private 메소드 - 클래스에서 직접 호출 불가
//	6. private 정적 메소드 - 클래스에서 직접 호출 불가
	
	// 1. public 상수 필드
	public static final int max_volume = 10;
	int nim_volume = 0; // public static final 생략 가능
	
	// 2. public 추상 메소드
//	public abstract void insert0(); 
	void insert(); // public abstract는 생략 가능
	
	// 3. public 디폴트 메소드
	default void delete() {
		System.out.println("public 디폴트 메소드");
	}
	
	// 4. public 정적 메소드
	public static void changeBattery() {
		System.out.println("public 정적 메소드");
	}
	
	default void defaultTest() {
		System.out.println("private 메소드 호출");
		default1();
		default2();
	}
	
	static void defaultTest2() {
		System.out.println("private 메소드 호출");
//		default1(); // 사용불가
		default2();
	}
	
	// 5. private 메소드
	private void default1() {
		System.out.println("private 메소드");
	}
	
	// 6. private 정적 메소드
	private static void default2() {
		System.out.println("private 정적 메소드");
	}
}
