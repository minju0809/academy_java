package ch4_231025;

public class SmartPhone extends Phone {
	public boolean wifi;
	public String sno = "SmartPhone 100";

	public SmartPhone() {
		System.out.println("===> SmartPhone 기본 생성자");
	}

	public void bell() {
		System.out.println("SmartPhone 벨이 울립니다.");
	}

	public SmartPhone(String model, String color) {
		super(model, color); // 부모 클래스에 기본 생성자가 있어야 함
//		this.model = model;
//		this.color = color;
		System.out.println("===> SmartPhone 매개변수 생성자 " + this.model + ", " + this.color);
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
