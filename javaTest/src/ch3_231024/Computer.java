package ch3_231024;

public class Computer {
	// 가변길이 매개변수를 갖는 메소드 선언
	int sum (int ... values) { 
		// sum 변수 선언
		int sum = 0;
		
		// values는 배열 타입의 변수처럼 사용
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		// 합산 결과 리턴
		return sum;
	}
	
	int sumArr (int [] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	int[] sumArr2 (int [] values) {
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] + 1;
		}
		return values;
	}
}
