package ch6_231027;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		String data = null;

		System.out.println("아무 문제 없음");

		try {
			String str = "우리";
			int i = Integer.parseInt(str); // NumberFormatException
			int[] array = { 1, 2, 3, 4, 5 };
			array[5] = 10; // ArrayIndexOutOfBoundsException
			int result = data.length(); // NullPointerException
			int k = 10 / 0; // ArithmeticException
			Class.forName("java.lang.String2"); // ClassNotFoundException

			System.out.println("try 끝 - 윗 줄에서 예외 발생하면 실행 안됨");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException 예외 발생하면 실행 됨");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException 예외 발생하면 실행 됨");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 예외 발생하면 실행 됨");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException 예외 발생하면 실행 됨");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException 예외 발생하면 실행 됨");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외 발생하면 실행 됨");
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행");
		}
	}
}
