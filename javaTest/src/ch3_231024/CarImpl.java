package ch3_231024;

public class CarImpl {
	// 필드 선언
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;

	// 생성자 오버로딩 - 매개변수의 타입, 개수, 순서가 다르게 여러개의 생성자 선언
	public CarImpl() {
		this("현대자동차", "Model S", "빨강", 330, 0);
		System.out.println("===> 확인1");
//		1. this() 첫번째 줄에 작성
//		2. 다음 줄에 명령문 사용 가능
//		3. 매개변수의 개수가 같은 생성자 호출
//		4. 생성자 호출 후 돌아와서 명령문 실행
	}

	public CarImpl(String company) {
		this(company, "Model S", "빨강", 330, 0);
	}

	public CarImpl(String company, String model) {
		this(company, model, "빨강", 330, 0);
	}

	public CarImpl(String company, String model, String color) {
		this(company, model, color, 330, 0);
	}

	public CarImpl(String company, String model, String color, int maxSpeed) {
		this(company, model, color, 330, 0);
	}

	public CarImpl(String company, String model, String color, int maxSpeed, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.speed = 0;
//		System.out
//				.println("company: " + company + ", model: " + model + ", color: " + color + ", maxSpeed: " + maxSpeed);
	}
}
