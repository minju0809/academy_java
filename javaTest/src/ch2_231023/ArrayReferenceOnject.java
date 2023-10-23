package ch2_231023;

public class ArrayReferenceOnject {
	public static void main(String[] args) {
		String[] arr = new String[4];
		arr[0] = "Java";
		arr[1] = "Java";
		arr[2] = new String("Java");
		arr[3] = new String("Java");

		if (arr[0] == arr[1]) {
			System.out.println("arr[0]와 arr[1]는 같다");
		} else {
			System.out.println("arr[0]와 arr[1]는 다르다");
		}
		
		if (arr[0] == arr[2]) {
			System.out.println("arr[0]와 arr[2]는 같다");
		} else {
			System.out.println("arr[0]와 arr[2]는 다르다");
		}
		
		if (arr[2] == arr[3]) {
			System.out.println("arr[2]와 arr[3]는 같다");
		} else {
			System.out.println("arr[2]와 arr[3]는 다르다");
		}
		
		if (arr[2].equals(arr[3])) {
			System.out.println("arr[2]와 arr[3]는 같다");
		} else {
			System.out.println("arr[2]와 arr[3]는 다르다");
		}
	}
}
