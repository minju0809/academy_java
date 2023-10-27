package ch5_231026;

public class InterfaceExample {
	public static void main(String[] args) {
		InterfaceImpl impl = new InterfaceImpl();
		impl.methodA();
		impl.methodB();
		impl.methodC();
		
		InterfaceA ia = impl;
		ia.methodA();
		
		InterfaceB ib = impl;
		ib.methodB();
		
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
