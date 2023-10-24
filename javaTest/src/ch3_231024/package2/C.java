package ch3_231024.package2;

import ch3_231024.package1.A;
import ch3_231024.package1.CarVO;

public class C {
	static CarVO vo = new CarVO();

	public static void main(String[] args) {
		play();
	}

	public static void play() {
//		new A(); // public이라 접근 가능
//		new B(); // default 클래스는 같은 패키지에서만 접근 가능
//		new A("영심이"); // default 클래스는 같은 패키지에서만 접근 가능
//		new A("영심이", "하늘이"); // private라 사용 불가

		vo.setSpeed(100);
		System.out.println("getSpeed: " + vo.getSpeed());
	}
}
