package ch4_231025.package3;

public abstract class Phone {
	String owner;
	
	public Phone() {};

	public Phone(String owner) {
		this.owner = owner;
	}
	
	// 추상메소드는 { }를 사용할 수 없음
	// 추상메소드는 추상클래스에서만 만들 수 있음
//	public abstract void sound() ;

	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
