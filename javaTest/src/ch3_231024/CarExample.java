package ch3_231024;

public class CarExample {
	public static void main(String[] args) {
		// CarImpl 객체 생성 (기본 생성자 호출)
		CarImpl myCar1 = new CarImpl();
		CarImpl myCar2 = new CarImpl("테슬라");
		CarImpl myCar3 = new CarImpl("테슬라", "Model S");
		CarImpl myCar4 = new CarImpl("기아", "K5", "빨강", 300);

		// CarImpl 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar1.company);
		System.out.println("모델명: " + myCar1.model);
		System.out.println("색깔: " + myCar1.color);
		System.out.println("최고속도: " + myCar1.maxSpeed);
		System.out.println("현재속도: " + myCar1.speed);

		// CarImpl 객체의 필드값 변경;
		myCar1.speed = 60;
		System.out.println("수정된 속도: " + myCar1.speed);
	}
}
