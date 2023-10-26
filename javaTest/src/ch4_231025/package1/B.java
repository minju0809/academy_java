package ch4_231025.package1;

public class B {
	public void method2() {
		A a = new A();
		a.field = "value";
		a.method1();
		System.out.println("B 클래스의 메소드");
	}
}