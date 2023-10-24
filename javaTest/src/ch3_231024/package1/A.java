package ch3_231024.package1;

// 클래스는 default와 public만 가능
public class A {
	// 필드 선언
	A a1 = new A(); // 모든 패키지에서 호출 가능
	A a2 = new A("영심이"); // 같은 패키지에서만 호출 가능
	A a3 = new A("영심이", "하늘이"); // 클래스 내부에서만 호출 가능
	
	public A() {

	}

	A(String a) {

	}

	private A(String a, String b) {

	}
	
	/////////////////////////////////////////////////////////
	// 필드는 public, default, private 사용 가능
	public String name1 = "둘리";
	String name2 = "영심이";
	private String name3 = "하니";
	
	void getPrint() {
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);
	}
}
