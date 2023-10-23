package ch2_231023;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
//		// 199 페이지 7번
//		int[] array = { 1, 5, 3, 8, 2 };
//		int max = array[0];
//
//		for (int k : array) {
//			if (max < k) {
//				max = k;
//			}
//		}
//
//		System.out.println("최대값: " + max);
//
//		// 199 페이지 8번
//		int[][] arr = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
//
//		int count = 0;
//		double sum = 0;
//		double avg = 0;
//		for (int x = 0; x < arr.length; x++) {
//			for (int y = 0; y < arr[x].length; y++) {
//				count++;
//				System.out.print(arr[x][y] + " ");
//				sum += arr[x][y];
//				avg = sum / count;
//			}
//			System.out.println();
//		}
//		System.out.println("학생 수: " + count);
//		System.out.println("총합: " + (int)sum);
//		System.out.println("평균: " + avg);

		// 199페이지 9번
		Scanner scanner = new Scanner(System.in);

		boolean run = true;

		int student = 0;
		int[] studentArray = {};

		int score = 0;
		double sum = 0;
		double avg = 0;

		while (run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택> ");

			int select = scanner.nextInt();

			if (select == 1) {
				System.out.print("학생수> ");
				student = scanner.nextInt();
				studentArray = new int[student];
			} else if (select == 2) {
				for (int i = 0; i < studentArray.length; i++) {
					System.out.print("scores[" + i + "]: ");
					score = scanner.nextInt();
					studentArray[i] = score;
					sum += studentArray[i];
				}
			} else if (select == 3) {
				for (int i = 0; i < studentArray.length; i++) {
					System.out.println("scores[" + i + "]: " + studentArray[i]);
				}
			} else if (select == 4) {
				int max = studentArray[0];
				for (int s : studentArray) {
					if (max < s) {
						max = s;
					}
				}
				avg = sum / student;
				System.out.println("최고점수: " + max);
				System.out.printf("평균점수: %.1f\n", avg);
			} else if (select == 5) {
				run = false;
				System.out.print("프로그램 종료");
			} else {
				System.out.println("번호를 확인하고 선택해주세요.");
			}
		}
		scanner.close();
	}
}
