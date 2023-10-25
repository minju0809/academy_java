package ch4_201025;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
		child.method1(); // Parent-method1()
		child.method2(); // Child-method1()
		child.method3(); // Child-method1()
		
		Parent parent = child;
		
		parent.method1(); // Parent-method1()
		parent.method2(); // Child-method1()
//		parent.method3(); // 호출 불가능
		
		// 강제 형 변환
		Child child1 = (Child) parent;
		child1.method1(); // Parent-method1()
		child1.method2(); // Child-method1()
		child1.method3(); // Child-method1()
	}
}
