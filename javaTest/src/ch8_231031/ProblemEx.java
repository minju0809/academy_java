package ch8_231031;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class ProblemEx {
	public static void main(String[] args) {
		// 확인문제 6번
		ProblemMember member = new ProblemMember("blue", "이파란");
//		System.out.println(member);

		// 확인문제 8번
		long time1 = System.nanoTime();

		int[] scores = new int[1000];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = i;
		}

		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
//		System.out.println("총합: " + sum);

		double avg = sum / scores.length;
//		System.out.println("평균: " + avg);

		long time2 = System.nanoTime();
		DecimalFormat df = new DecimalFormat("#,###.0");
//		System.out.println("작업 시간: " + df.format(time2 - time1) + " 나노초");

		// 확인문제 10번
		long time3 = System.nanoTime();
		
		String str = "";
//		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= 100; i++) {
			str += i; // for문이 도는 만큼 객체 생성
//			str.append(i); // 하나의 객체의 끝에 값 추가
		}
		
		long time4 = System.nanoTime();
		
		DecimalFormat df2 = new DecimalFormat("#,###.0");
//		System.out.println("작업 시간: " + df2.format(time4 - time3) + " 나노초");
		
//		System.out.println(str);
		
		// 확인문제 11번
		String data1 = "아이디,이름,패스워드";
		
		// split 이용 - 정규표현식으로 구분
//		String[] arr = data1.split(",");
//		for(String data : arr) {
//			System.out.println(data);
//		}
		
		// StringTokenizer 이용 - 문자로 구분
		StringTokenizer st = new StringTokenizer(data1, ",");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
