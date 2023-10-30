package ch7_231030;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MathEx {
	public static void main(String[] args) {
//		int[] s = new int[5];
//		int i = 0;
//
//		while (true) {
//			Random random = new Random();
//			int r = random.nextInt(10) + 1;
//			if (s[0] != r && s[1] != r && s[2] != r && s[3] != r && s[4] != r) {
//				s[i] = r;
//				i++;
//				if (i == 5)
//					break;
//			}
//		}
//		Arrays.sort(s);
//		for (int number : s) {
//			System.out.print(number + " ");
//		}

//////////////////////////////////////////////////////////////////////
//		int n = 5;
//		int[] arr = new int[n];
//		int random;
//		boolean check;
//		int count = 0;
//
		// 랜덤 값 중복없이 받기 방법 1
//		while (count < n) {
//			random = (int) (Math.random() * 10) + 1;
//			check = true;
//			for (int i = 0; i < n; i++) {
//				if (arr[i] == random) {
//					check = false;
//				}
//			}
//			if (check) {
//				arr[count++] = random;
//			}
//		}
		
		// 랜덤 값 중복없이 받기 방법 2
//		for (int i = 0; i < n; i++) {
//			arr[i] = (int) (Math.random() * n) + 1;
//			for (int j = 0; j < i; j++) {
//				if (arr[i] == arr[j]) {
//					i--;
//					break;
//				}
//			}
//		}
//
//		Arrays.sort(arr);
//		for (int number : arr) {
//			System.out.print(number + " ");
//		}

////////////////////////////////////////////////////////////////////
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		int[] k = new int [5];

		while (set.size() < 5) {
			int ran = random.nextInt(10) + 1;
			set.add(ran);
		}

		// 거꾸로 출력까지
		int i = 0;
		for (int s : set) {
			k[i] = s;
			i++;
			System.out.print(s + " ");
		}
		
		System.out.println();
		for (int j = 4; j >= 0 ; j--) {
			System.out.print(k[j] + " ");
		}
	}
}
