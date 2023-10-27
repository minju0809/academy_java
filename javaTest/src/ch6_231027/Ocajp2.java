package ch6_231027;

class School {
	int i;
	School () {
		int i = 1;
		System.out.println(i);
		print();
	}
	void print() {
		String i = null;
		System.out.println(i);
	}
}

public class Ocajp2 {
	public static void main(String[] args) {
		School s = new School();
		s.print();
		System.out.println(s.i);
	}
}
