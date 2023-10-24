package ch3_231024;

public class Television {
	int field1 = 101;

	static String company = "MyCompany";
	static String model = "LCD";
	static String info;

	static {
//		field1; // 컴파일 에러
		model = "모니터";
		info = company + "-" + model;
	}

	static void method() {
		model = "LCD";
		info = "정보";
//		feilds = 컴파일에러
	}
	
	void play() {
		System.out.println("play");
	}
	
	String name = "영심이";
	
	void getPrint() {
		name = "둘리";
		System.out.println();
		play();
	}
}
