package ch2_231023;

public class ArrayCopyByFor {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = new int[5];

		arr2 = arr1;

		for (int i : arr2) {
			System.out.print(i + " "); // 1 2 3
		}

		System.out.println();

		int[] arr3 = { 1, 2, 3 };
		int[] arr4 = new int[5];

		for (int i = 0; i < arr3.length; i++) {
			arr4[i] = arr3[i];
		}

		for (int k : arr4) {
			System.out.print(k + " "); // 1 2 3 0 0
		}
		
		System.out.println();

		int[] arr5 = { 1, 2, 3 };
		int[] arr6 = new int[5];

		System.arraycopy(arr5, 1, arr6, 0, arr5.length - 1);

		for (int i : arr6) {
			System.out.print(i + " ");
		}

	}
}
