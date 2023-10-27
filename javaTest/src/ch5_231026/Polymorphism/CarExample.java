package ch5_231026.Polymorphism;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();

		// 필드의 다형성
		myCar.run();

		myCar.tire1 = new KumhoTire();
		myCar.tire2 = new KumhoTire();

		myCar.run();

		myCar.speaker = new KakaoSpeaker();
		myCar.speaker();

		myCar.speaker = new SonySpeaker();
		myCar.speaker();

		// 매개변수의 다형성
		Bus bus = new Bus();

		myCar.drive(bus);
		myCar.drive(new Taxi());
	}
}
