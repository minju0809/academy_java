package ch9;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

class School {
	School() {
	}

	public int helloWorld() {
		return 0;
	}
}

public class examEx {
	public static void main(String[] args) {
//		Random random = new Random();
//		for (int i = 0; i < 5; i ++) {
//			System.out.println(random.nextInt(10) + 11);
//		}

//		StringTokenizer st = new StringTokenizer("홍길동&이수홍&둘리", "&");
//		int count = 0;
//		String str = null;
//		while (st.hasMoreTokens()) {
//			count++;
//			String token = st.nextToken();
//			if (count > token.length()) {
//				str = token;
//			} else {
//				str = token + ",";
//			}
//			System.out.print(str);
//		}
		
//		double num = 5.56;
//		double result = Math.round(num * 10) / 10.0; 
//		System.out.println(result);

		String regExp = "\\d{6}\\-[1-4]\\d{6}";
		String num = "910809-2222222";
		System.out.println("주민번호 결과: " + num.matches(regExp));
		
		boolean result = Pattern.matches(regExp, num);
		if(result) {
			System.out.println("일치합니다.");
		} else {
			System.out.println("일치하지 않습니다.");
		}
	}
}
