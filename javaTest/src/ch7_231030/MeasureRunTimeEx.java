package ch7_231030;

import java.text.NumberFormat;

public class MeasureRunTimeEx {
	public static void main(String[] args) {
		long time = 0;
		int sum = 0;
		long timeSum = 0;
		double timeAvg = 0;
		int j = 0;
		for (j = 1; j <= 5; j++) {
			long time1 = System.nanoTime();

			for (int i = 1; i <= 1000000; i++) {
				sum += i;
			}
			long time2 = System.nanoTime();
			time = time2 - time1;

			String commaNumTime = NumberFormat.getInstance().format(time);
			System.out.println("소요시간: " + commaNumTime + " 나노초");
			timeSum += time;
		}
		timeAvg = timeSum / (double)j;
		double result = Math.round(timeAvg * 100) / 100.0;
		String commaNumAvg = NumberFormat.getInstance().format(result);
		System.out.println("평균작업시간: " + commaNumAvg);
		System.out.println("----------------------------");
		System.out.println("1~1000000까지의 합: " + sum);
	}
}
