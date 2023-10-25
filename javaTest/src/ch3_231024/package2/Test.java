package ch3_231024.package2;

import ch3_231024.package1.A;

public class Test {
	public static void main(String[] args) {
		Singleton c1 = Singleton.getInstance(); // 객체 생성
		Singleton c2 = Singleton.getInstance();
		Singleton c3 = Singleton.getInstance();

		System.out.println(c1); // ch3_231024.package2.Singleton@2133c8f8
		System.out.println(c2); // ch3_231024.package2.Singleton@2133c8f8
		System.out.println(c3); // ch3_231024.package2.Singleton@2133c8f8
	}
}
