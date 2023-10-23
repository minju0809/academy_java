package ch2_231023;

public class ArrayLength {

	public static void main(String[] args) {
		long[] intArr = new long[5];
		System.out.println(intArr[0]); // 기본값: 0
		System.out.println(intArr.length); // 길이: 5
		intArr[1] = 10;
		intArr[4] = 10;
//		intArr[5] = 10; // 에러
		for (long i : intArr) {
			System.out.print(i + " ");
		}
	}

}
