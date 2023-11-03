package ch9;

import java.util.Calendar;
import java.util.Random;

class PlusK {
	public int plus(int a, int b) {
		return a + b;
	}
}

class Tire {
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}

class SnowTire extends Tire {
	public void run() {
		System.out.println("스노우 타이어가 굴러갑니다.");
	}
}

class A {
	A() {
		System.out.println("A");
	}
}

class B extends A {
	B() {
		System.out.println("B");
	}
}

class Member {
	String color;
	String name;

	Member(String color, String name) {
		this.color = color;
		this.name = name;
	}

	public String toString() {
		return "Member [color=" + color + ", name=" + name + "]";
	}
}

public class eaxmEx2 {

	public static void main(String[] args) {
		// 1.
//		int hap = 0, count = 1;
//		while(count <= 10) {
//			hap += count;
//			count++;
//		}
//		System.out.println("1부터 10까지의 합은 " + hap + "입니다." );

		// 2.
//		int count = 0;
//		int sum = 0;
//		for(int i = 1; i < 10; i+=2) {
//			count += 2;
//			if (count > 9) {
//				System.out.print(i);
//			} else {
//				System.out.print(i + ", ");
//			}
//			sum += i;
//		}
//		System.out.println("\n---------------");
//		System.out.println(sum);

		// 3.
//		for (int dan = 2; dan < 10; dan++) {
//			int i = 1;
//			while (i < 10) {
//				if (dan % 2 == 1) {
//					System.out.printf("%sX%s=%2s ", dan, i, dan * i);
//				}
//				i++;
//			}
//			System.out.println();
//		}

		// 4.
//		PlusK m = new PlusK();
//		int k1 = m.plus(7, 3);
//		System.out.println(k1);

		// 5.
//		String i = "111";
//		String j = "222";
//		int k = Integer.parseInt(i) + Integer.parseInt(j);
//		System.out.println(k);

		// 6.
//		Random random = new Random();
//		int ran = 0;
//		int i1 = 0;
//		int i2 = 0;
//		int i3 = 0;
//		for (int i = 0; i < 10; i++) {
//			ran = random.nextInt(6);
//
//			if (ran == 1) {
//				i1++;
//			} else if (ran == 2) {
//				i2++;
//			} else {
//				i3++;
//			}
//
//			System.out.print(ran + " ");
//		}
//		System.out.println("\n1의 개수는 : " + i1 + " 개 입니다.");
//		System.out.println("2의 개수는 : " + i2 + " 개 입니다.");
//		System.out.println("기타 숫자는 개수는 : " + i3 + " 개 입니다.");

		// 7.
//		Calendar now = Calendar.getInstance();
//		int year = now.get(Calendar.YEAR);
//		int month = now.get(Calendar.MONTH) + 1;
//		int date = now.get(Calendar.DATE);
//		int dateOfWeek = now.get(Calendar.DAY_OF_WEEK);
//		String[] weekArr = {"일","월","화","수","목","금","토"};
//		
//		String dayOfWeekStr = weekArr[dateOfWeek-1]; 
//		System.out.println(year + "년 " + month + "월 " + date + "일 " + dayOfWeekStr + "요일");

		// 8.
//		SnowTire snowTire = new SnowTire();
//		Tire tire = snowTire;
//		snowTire.run();
//		tire.run();

		// 9.
//		new B(); 

		// 10.
//		Member member = new Member("blue", "이파란");
//		System.out.println(member);
	}

}
