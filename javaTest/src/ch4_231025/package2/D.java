package ch4_231025.package2;

import ch4_231025.package1.A;

public class D extends A {
	public D() {
		super(); // 클래스 A의 기본 생성자 호출
	}

	public void method4() {
		System.out.println(this.field);
		this.method1();
	}

	public void method5() {
//		new A(); // 에러 발생 (직접 객체 생성해서 사용은 불가
	}
}
