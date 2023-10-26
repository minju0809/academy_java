package ch4_231025;

public class Phone {
	public String model;
	public String color;
	public String sno = "Phone 100";

	public Phone() {
		System.out.println("===> Phone 기본 생성자");
	} // 기본 생성자가 있어야 호출 가능

	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("===> Phone(String model, String color) 생성자");
	} // 생성자를 만들었기 때문에 기본 생성자 생략 불가능

	public void bell() {
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}

	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
