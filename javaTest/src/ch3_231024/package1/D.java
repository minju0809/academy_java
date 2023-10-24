package ch3_231024.package1;

public class D {

	A a = new A();
	
	void play() {
		new A();
		new B();
		
		System.out.println(a.name1);
		System.out.println(a.name2);
//		System.out.println(a.name3); // private이기 때문에 접근 불가
	} 
	
}
