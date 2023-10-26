package ch05_231026.Polymorphism;

public class Car {
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();
	
	Speaker speaker = null;
	
	// 필드의 다형성
	void run() {
		tire1.roll();
		tire2.roll();
	}
	
	void speaker () {
		speaker.sound();
	}
	
	// 매개변수의 다형성
	void drive(Vehicle vehicle) {
		vehicle.vehicle();
	}
}
