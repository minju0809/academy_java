package ch3_231024;

public class TelevisionExample {
	// fianl : 값을 변경할 수 없음 (재정의 불가능)
	public static final String name = "영심이";
	
	void play() {
		System.out.println("play");
	}
	
	static void play2() {
		System.out.println("play");
	}

	public static void main(String[] args) {
		
		Television c = new Television();
		System.out.println("인스턴스 변수 받아오기: "+ c.field1);
		
		// [정적 변수 사용하기]
		System.out.println(Television.info);
		System.out.println(Television.company);
		System.out.println(Television.model);
		
//		name = "둘리";
		
		TelevisionExample t = new TelevisionExample();
		System.out.println(t.name);
		
		t.play();
		play2();
	}

}
