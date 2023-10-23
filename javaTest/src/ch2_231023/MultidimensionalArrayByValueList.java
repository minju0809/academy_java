package ch2_231023;

public class MultidimensionalArrayByValueList {
	public static void main(String[] args) {
						//  0,0  0,1  0,2   1,0  1,1
		int[][] intArr = { { 80, 90, 96 }, { 76, 88 } };
		intArr[1][1] = 100; // 88을 100으로 변경
		System.out.println("1차원 배열 길이(반의 수):  " + intArr.length);
		System.out.println("1반 학생 수:  " + intArr[0].length);
		System.out.println("2반 학생 수:  " + intArr[1].length);
		
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr[i].length; j++) {
				System.out.print("" + intArr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
