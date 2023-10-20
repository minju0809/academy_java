package ch01;

import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		String name0 = "홍길동";
		String name1 = new String("홍길동");
		String name2 = new String("홍길동");
		String name3 = name2;
		
		if(name0 == name1) { // 다르다	
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		if(name1 == name2) { // 다르다	
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		if(name0 == name3) { // 다르다
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
	}
}
