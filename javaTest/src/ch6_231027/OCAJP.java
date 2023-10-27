package ch6_231027;

import java.util.ArrayList;
import java.util.List;

// 216번
class Product {
	double price;
}

// 208번
class Caller {
	private void init() {
		System.out.println("Initialized");
	}

	private void start() {
		init();
		System.out.println("Started");
	}
}

// 201번
class Student {
	String name;

	public Student(String name) {
		this.name = name;
	}
}

public class OCAJP {
	// 219번
	public static void doSum(Integer x, Integer y) {
		System.out.println("Integer sum is " + (x + y));
	}

	public static void doSum(double x, double y) {
		System.out.println("double sum is " + (x + y));
	}

	public static void doSum(float x, float y) {
		System.out.println("float sum is " + (x + y));
	}

	// 216번
	public void updatePrice(Product product, double price) {
		price = price * 2;
		product.price += price;
	}

	// 214번
	public static final int MIN = 1;

	public static boolean checkLimit(int x) {
		return (x >= MIN) ? true : false;
	}

	// 189번
	public static int stVar = 100;
	public int var = 200;

	public String toString() {
		return stVar + ":" + var;
	}

	// 191번
	private char var0;

	// 179번
	static int count = 0;
	int i = 0;

	public void changeCount() {
		while (i < 5) {
			i++;
			count++;
		}
	}

////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// 221번
		List<String> colors = new ArrayList<>();
		colors.add("green");
		colors.add("blue");
		colors.add("red");
		colors.add("yellow");
		colors.remove(2);
		colors.add(3, "cyan");
//		System.out.print(colors);

		// 220번
//		System.out.println("String main " + args[0]);

		// 219번
//		doSum(10, 20);
//		doSum(10.0, 20.0);

		// 218번
		String str1 = "Java";
		String str2 = new String("java");

		if (str2.equals(str1.toLowerCase())) {
//			System.out.println("Equal");
		} else {
//			System.out.println("Not Equal");
		}

		// 216번
		Product prt = new Product();
		prt.price = 200;
		double newPrice = 100;

		OCAJP t = new OCAJP();
		t.updatePrice(prt, newPrice);
//		System.out.println(prt.price + " : " + newPrice);

		// 214번
		int x = args.length;
		if (checkLimit(x)) {
//			System.out.println("Java SE");
		} else {
//			System.out.println("Java EE");
		}

		// 208번
		Caller c = new Caller();
//		c.start();
//		c.init();

		// 207번
		int[][] arr = new int[2][4];

		arr[0] = new int[] { 1, 3, 5, 7 };
		arr[1] = new int[] { 1, 3 };

		for (int[] a : arr) {
			for (int i = 0; i < arr.length; i++) {
//				System.out.print(a[i] + " ");
			}
//			System.out.println();
		}

		for (int[] a : arr) {
			for (int i : a) {
//				System.out.print(i + " ");
			}
//			System.out.println();
		}

		// 206번 - 135 출력
		int a[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i <= a.length; i += 2) {
//			System.out.println(a[i]);
		}

		for (int i = 0; i <= a.length; i++) {
			if (i % 2 == 0) {
//				System.out.println(a[i]);
			}
		}

		// 203번
		String myStr = "Hello World ";
		myStr.trim();
		int i1 = myStr.indexOf(" ");
//		System.out.println(i1);

		// 201번
		Student[] students = new Student[3];
		students[1] = new Student("Richard");
		students[2] = new Student("Donald");
		for (Student s : students) {
//			System.out.println("" + s.name);
		}

		// 199번 - 삼항연산자로 변경
		String stuff = "TV";
		String res = null;

		if (stuff.equals("TV")) {
			res = "Walter";
		} else if (stuff.equals("Movie")) {
			res = "White";
		} else {
			res = "No Result";
		}

		String stuff1 = "TV";
		String res1 = stuff.equals("TV") ? "Walter" : stuff.equals("Movie") ? "White" : "No Result";

		// 193번
		int sum = 0;
		int xVal = 0;
		for (xVal = 1; xVal <= 5; xVal++) {
			sum = sum + xVal;
		}
//		System.out.println("The Sum of " + xVal + " nembers is: " + sum);

		// 189번
		OCAJP t1 = new OCAJP();
		t1.var = 300;
//		System.out.println(t1);
		OCAJP t2 = new OCAJP();
		t2.stVar = 300;
//		System.out.println(t2);

		// 191번
		char var1 = 'a';
		char var2 = var1;
		var2 = 'e';

		OCAJP obj1 = new OCAJP();
		OCAJP obj2 = obj1;
		obj1.var0 = 'o';
		obj2.var0 = 'i';

//		System.out.println(var1 + ", " + var2);
//		System.out.println(obj1.var0 + ", " + obj2.var0);

		// 179번
		OCAJP check1 = new OCAJP();
		OCAJP check2 = new OCAJP();
		check1.changeCount();
		check2.changeCount();
//		System.out.println(check1.count + " : " + check2.count);

		// 168번
		String names[] = { "Thomas", "Peter", "Joseph" };
		String pwd[] = new String[3];
		int idx = 0;
		try {
			for (String n : names) {
				pwd[idx] = n.substring(2, 6);
				idx++;
			}
		} catch (Exception e) {
//			System.out.println("Invalid Name");
		}
		for (String p : pwd) {
//			System.out.println(p);
		}
		
		// 167번
		int xx = 100;
		int aa = xx++;
		System.out.println(aa);
		int bb = ++xx;
		System.out.println(bb);
		int cc = xx++;
		System.out.println(cc);
		int dd = (aa > bb) ? (aa < cc) ? aa : (bb < cc) ? bb : cc : xx;
		System.out.println(dd);
	}
}
