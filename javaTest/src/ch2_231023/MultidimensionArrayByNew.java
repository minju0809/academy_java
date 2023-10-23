package ch2_231023;

public class MultidimensionArrayByNew {
	public static void main(String[] args) {
		String[][] names = new String[3][3];
		names[1][1] = "둘리";
		names[1][2] = "영심이";

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (names[1][i] == "둘리") {
					System.out.print("[" + i + "]" + "[" + j + "]" + names[i][j] + " ");
				}
			}
			System.out.println("");
		}
	}
}
