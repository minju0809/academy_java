package ch8_231031;

import java.util.Calendar;
import java.util.Random;

// 4.
class PlusMinus {
	public int plus(int a, int b) {
		int plusResult = a + b;
		return plusResult;
	}

	public int minus(int a, int b) {
		int minusResult = a - b;
		return minusResult;
	}
}

// 5.
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

// 6. 
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

public class Exam {
	public static void main(String[] args) {
		// 1.
		int hap = 0, count = 1;

		for (count = 1; count <= 10; count++) {
			hap += count;
		}

//		System.out.println("1부터 10까지의 합은 " + hap + "입니다.");

		// 2.
		int i = 1;
		int sum = 0;
		for (i = 1; i <= 10; i++) {
//			System.out.print(i);
			sum += i;
		}
//		System.out.println();
//		System.out.println("---------------");
//		System.out.println(sum);

		// 3.
		for (int dan = 1; dan < 10; dan++) {
			int j = 2;
			while (j < 10) {
//				System.out.printf("%sX%s=%2s ", dan, j, (dan * j));
				j++;
			}
//			System.out.println();
		}

		// 1.
		PlusMinus m = new PlusMinus();
		int k1 = m.plus(10, 5);
//		System.out.println(k1);

		int k2 = m.minus(10, 5);
//		System.out.println(k2);

		// 2.
		String ii = "111";
		String jj = "222";

		int k = Integer.parseInt(ii) + Integer.parseInt(jj);

//		System.out.println(k);

		// 3.
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		Random random = new Random();

		for (int x = 0; x < 10; x++) {
			int ran = random.nextInt(6);
			System.out.print(ran + " ");
			if (ran == 1) {
				i1++;
			} else if (ran == 2) {
				i2++;
			} else if (ran == 3) {
				i3++;
			} else {
				i4++;
			}
		}

		System.out.println("\n1의 개수는 : " + i1 + " 개 입니다.");
		System.out.println("2의 개수는 : " + i2 + " 개 입니다.");
		System.out.println("3의 개수는 : " + i3 + " 개 입니다.");
		System.out.println("기타 숫자는 개수는 : " + i4 + " 개 입니다.");

		// 4.
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int date = now.get(Calendar.DATE);

//		System.out.println(year + "년" + month + "월" + date + "일");

		// 5.
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
//		snowTire.run();
//		tire.run();

		// 6.
//		new B();

	}
}
