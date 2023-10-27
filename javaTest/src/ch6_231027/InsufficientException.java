package ch6_231027;

public class InsufficientException extends Exception {

//	public static void main(String[] args) throws Exception {
//		method();
//		System.out.println("예외 확인!"); // 떠넘겼기 때문에 출력 X
//	}
//
//	static void method() throws Exception {
//		throw new Exception();
//	}
	
	private static final long serialVersionUID = 1L;

	public InsufficientException() {
	}

	public InsufficientException(String message) {
		super(message);
	}
}
