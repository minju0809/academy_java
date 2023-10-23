package ch2_231023;

import java.time.LocalDate;

public class OCAJP {
	// 26.
	Character c;
	boolean b;
	float f;
	double d;
	long l;
	String s;

	void printAll() {
		System.out.println("c = " + c); // c = null
		System.out.println("b = " + b); // b = false
		System.out.println("f = " + f); // f = 0.0
		System.out.println("d = " + d); // d = 0.0
		System.out.println("l = " + l); // l = 0
		System.out.println("s = " + s); // s = null
	}

	public static void main(String[] args) {
		// 22.
		int ans = 0;
		try {
			int num = 10;
			int div = 0;
			ans = num / div;
		} catch (ArithmeticException e) {
			ans = 0;
		} catch (Exception e) {
			System.out.println("Invalid calculation");
		}
//		System.out.println("Answer = " + ans);

		OCAJP f = new OCAJP();
//		f.printAll();

		// 35.
		String opt = "true";
		switch (opt) {
		case "true":
//			System.out.println("True");
			break;
		default:
			System.out.println("***");
		}
//		System.out.println("Done");

		// 36.
		String[] arr = { "A", "B", "C", "D" };
		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
			if (arr[i].equals("C")) {
				continue;
			}
//			System.out.println("Work dane");
			break;
		}

		// 37.
		int data[] = { 2010, 2013, 2014, 2015, 2014 };
		int key = 2014;
		int count = 0;
		for (int e : data) {
			if (e != key) {
				count++;
				continue;
			}
		}
//		System.out.print(count + " Found");

		// 49.
		int n[][] = { { 1, 3 }, { 2, 4 } };
		for (int i = n.length - 1; i >= 0; i--) {
			for (int y : n[i]) {
//				System.out.print(y);
			}
		}

		// 52.
		String[][] chs = new String[2][];
		chs[0] = new String[2];
		chs[1] = new String[5];
		int i = 97;

		for (int a = 0; a < chs.length; a++) {
			for (int b = 0; b < chs.length; b++) {
				chs[a][b] = "" + i;
				i++;
			}
		}
		for (String[] ca : chs) {
			for (String c : ca) {
//				System.out.print(c + " ");
			}
//			System.out.println();
		}
		// 97 98
		// 99 100 null null null

		// 69.
		String [][] chs2 = new String[5][2];
		chs2[0] = new String[2];
		chs2[1] = new String[5];
		int ii = 97;
		
		for (int a = 0; a < chs2.length; a++) {
			for ( int b = 0; b < chs2.length; b++) {
//				chs2[a][b] = "" + i;
			}
		}
		
		for (String[] ca : chs2) {
			for (String c : ca) {
//				System.out.print(c + " ");
			}
//			System.out.println();  // ArrayIndexOutOfBoundsException
		}
		
		// 70.  | (비트연산) : 전체를 실행, || : 하나만 참이면 넘어감
		int x = 10;
		int y = ++x;
		int z = 0;
		if (y >= 10 | y <= ++x) {
			z = x;
		} else {
			z = x++;
		}
//		System.out.println(z); // 12
		
		// 73.
		LocalDate date = LocalDate.of(2012, 1, 30);
		date.plusDays(10);
//		System.out.println(date); // 2012-01-30
		date = date.plusDays(10);
//		System.out.println(date); // 2012-02-09
	}
}
