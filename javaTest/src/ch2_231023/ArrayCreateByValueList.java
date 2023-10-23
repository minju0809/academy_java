package ch2_231023;

public class ArrayCreateByValueList {
	public static void main(String[] args) {
		int[] scores = new int[] {83, 90, 87};
		
		int sum1 = 0;
		for(int i = 0; i<scores.length; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합: " + sum1);
		
		int[] scores2 = {100};
		
		printItem(new int[] {83, 90, 87});
		printItem(scores2);
		
	}
	
	public static void printItem(int[] scores) {
		int i = 0;
		for (int s : scores) {
			System.out.println("score["+i+"]: " + s);
			i++;
		}
	}
}
