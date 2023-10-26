package ch05_231026;

// 9번
class CD {
	int r;

	CD(int r) {
		this.r = r;
	}
}

class DVD extends CD {
	int c;

	DVD(int r, int c) {
		super(r); // 부모클래스의 생성자를 가져옴
		this.c = c;
	}
}

// 13번
class Vehicle1 {
	int x;

	Vehicle1() {
		this(10);
//		System.out.println("1");
	}

	Vehicle1(int x) {
		this.x = x;
//		System.out.println("2");
	}
}

class Car1 extends Vehicle1 {
	int y;

	Car1() {
		super(10);
//		System.out.println("3");
	}

	Car1(int y) {
		super(y);
		this.y = y;
//		System.out.println("4");
	}

//	public String toString() {
//		return super.x + ":" + this.y;
//	}
}

//18번
class Vehicle2 {
	String type = "4w";
	int maxSpeed = 1000;

	Vehicle2(String type, int maxSpeed) {
		this.type = type;
		this.maxSpeed = maxSpeed;
	}

	Vehicle2() {
	}
}

class Car2 extends Vehicle2 {
	String trans;

	Car2(String trans) {
		this.trans = trans;
	}

	Car2(String type, int maxSpeed, String trans) {
//		super(type, maxSpeed);
		this(type, maxSpeed);
//		this.type = type;
//		this.maxSpeed = maxSpeed;
		this.trans = trans;
	}

	Car2(String type, int maxSpeed) {
		this.type = type;
		this.maxSpeed = maxSpeed;
	}
}

// 21번
class Vehicle4 {
	Vehicle4() {
		System.out.println("Vehicle");
	}
}

class Bus4 extends Vehicle4 {
	Bus4() {
		System.out.println("Bus");
	}
}

// 24번
class A {
	public A() {
//		System.out.println("A");
	}
}

class B extends A {
	public B() {
//		System.out.println("B");
	}
}

// 60번
interface Readable {
	public void readBook();
	public void setBookMark();
}

// 추상클래스는 인터페이스를 가져오지 않아도 됨
abstract class Book implements Readable {
	public void readBook() { }
	
//	public abstract void setBookMark(); 
}

// 그 자식에서는 오버라이딩 해줘야 함
class EBook extends Book {
	public void readBook() { }

	@Override
	public void setBookMark() {
		
	}
}

// 66번
interface I {
	public void displayI ();
}

abstract class C2 implements I {
	public void displayC2 () {
		System.out.print("C2");
	}
}

class C1 extends C2 {
	public void displayI () {
		System.out.print("C1");
	}
}

// 67번
class Caller {
	private void init() {
		System.out.println("Initialized");
	}
	
	private void start () {
		init();
		System.out.println("Started");
	}
}

// 82번
class Alpha {
	int ns;
	static int s;
	Alpha(int ns) {
		if(s < ns) {
			s = ns;
			this.ns = ns;
		}
	}
	void doPrint() {
		System.out.println("ns = " + ns + " s = " + s);
	}
}


public class OCAJP extends B {

	// 17번
	int x, y1;

//	public OCAJP() {};

	public OCAJP(int x, int y1) {
		initialize(x, y1);
//		System.out.println("1");
	}

	public void initialize(int x, int y1) {
		this.x = x * x;
		this.y1 = y1 * y1;
//		System.out.println("2");
	}

	// 20번
	int a1;

	public static void doProduct(int a) {
		a = a * a;
	}

	public static void doString(String s) {
		s.concat(" " + s);
	}

	class A {

	}

	// 24번
	public OCAJP() {
//		System.out.println("C");
	}

	// 33번
	String name;
	boolean contract;
	double salary;

//	OCAJP() {
//		this.name = new String("Joe");
//		this.contract = new Boolean(true);
//		this.salary = new Double(100);
//	};
	public String toString() {
		return name + ": " + contract + ": " + salary;
	}

	// 34번
	static double area;
	int b = 2, h = 3;

	// 55번
	public static boolean isAvailable(int x5) {
		return x5-- > 0 ? true : false;
	}

/////////////////////////////////////// main ////////////////////////////////////////
	public static void main(String[] args) {
		// 9번
		DVD dvd = new DVD(10, 20);
//		System.out.println(dvd.r + ":" + dvd.c);

		// 13번
		Vehicle1 y = new Car1(20);
//		System.out.println(y);

		// 15번
		StringBuilder sb1 = new StringBuilder("Duke");
//		System.out.println(sb1);
		String str1 = sb1.toString();
//		System.out.println(str1);
		String str2 = str1; // true
//		String str2 = new String(str1); // false
//		String str2 = sb1.toString(); // false
//		String str2 = "Duke"; // false
//		System.out.println(str1 == str2);

		// 17번
		int x = 3, y1 = 5;
		OCAJP obj = new OCAJP(x, y1);
//		System.out.println(x + " " + y1); // 3 5
//		System.out.println(obj.x + " " + obj.y1); // 9 25

		// 18번
		Car2 c1 = new Car2("Auto");
		Car2 c2 = new Car2("4w", 150, "Manual");
		String s = c1.type + " " + c1.maxSpeed + " " + c1.trans;
//		System.out.println(s);
//		System.out.println(c2.type + " " + c2.maxSpeed + " " + c2.trans);

		// 20번
		OCAJP item = new OCAJP();
		item.a1 = 11;
		String sb = "Hello";
		Integer i = 10;
		doProduct(i);
		doString(sb);
		doProduct(item.a1);
//		System.out.println(i + " " + sb + " " + item.a1);

		// 21번
//		Vehicle4 v = new Bus4();

		// 24번
//		OCAJP c = new OCAJP();

		// 33번
//		OCAJP e = new OCAJP();
//		e.name = "Joe";
//		e.contract = true;
//		e.salary = 100;
//		System.out.println(e);

		// 34번
		double p, b, h;
		if (area == 0) {
			b = 3;
			h = 4;
			p = 0.5;
//			area = p * b * h;
		}
//		System.out.println("Area is " + area);

		// 55번
		int x5 = 5;
		while (isAvailable(x5)) {
//			System.out.print(x5);
			x5--;
		}
		
		// 66번
		C2 obj1 = new C1();
		I obj2 = new C1();
		
		C2 ss = (C2) obj2;
		I tt = obj2;
		
//		tt.displayI();
//		ss.displayC2();
		
		// 67번
		Caller cc = new Caller();
//		cc.start(); // private라서 접근 불가
//		cc.init(); // private라서 접근 불가
		
		// 78번
		String str11 = "Java";
		String [] str22 = {"J", "a", "v", "a"};
		String str33 = "";
		for (String str : str22) {
			str33 = str33 + str;
		}
		boolean b1 = (str11.equals(str33));
		boolean b2 = (str11 == str33);
//		System.out.println (str11 + ":" + str33);
//		System.out.print(b1 + ", " + b2);
		
		// 82번
		Alpha ref1 = new Alpha(50);
//		ref1.doPrint(); // ns = 50 s = 50
		Alpha ref2 = new Alpha(125);
//		ref2.doPrint(); // ns = 125 s = 125
		Alpha ref3 = new Alpha(100);
//		ref1.doPrint(); // ns = 50 s = 125
//		ref2.doPrint(); // ns = 125 s = 125
//		ref3.doPrint(); // ns = 0 s = 125
		
		// 84번 배열의 형태
//		int array[] = new int[3] {1,2,3};
		int array0[] = new int[3];
//		array[0] = 1;
//		array[1] = 2;
//		array[2] = 3;
//		int array[3] = new int[] {1,2,3};
//		int array[] = new int[3];
//		array = {1,2,3};
		int array[] = new int[] {1,2,3};
		
		// 92번 가능한 형
		Integer x6 = new Integer("1");
//		long x6 = 1;
		switch (x6) {
		case 1 :
//			System.out.println("One");
			break;
		case 2 :
//			System.out.println("Two");
			break;
		}
		
		// 107번
		boolean aa = new Boolean(Boolean.valueOf(args[0]));
		boolean bb = new Boolean (args[1]);
		
		
		System.out.println(aa + " " + bb);
	}
}
