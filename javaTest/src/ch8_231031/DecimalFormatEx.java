package ch8_231031;

import java.text.DecimalFormat;

public class DecimalFormatEx {
	public static void main(String[] args) {
		double num = 1234567.89;
		
		DecimalFormat df;
		
		// 정수 자리까지 표기
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		// 무조건 소수 첫째 자리까지 표기
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
		
		// 숫자로 표기
		df = new DecimalFormat("000,000,000.0");
		System.out.println(df.format(num));
		
		// 지수로 표기
		df = new DecimalFormat("0.0E0");
		System.out.println(df.format(num));
	}
}
