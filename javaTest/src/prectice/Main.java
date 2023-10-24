package prectice;

public class Main {
	public static void main(String[] args) {
		Person person1 = new Person("Alice");
		Person person2 = new Person("Bob", 30);
		Person person3 = new Person("Charlie", 25, "Male");
		
		System.out.println("Person1: ");
		person1.printInfo();
		System.out.println("Person2: ");
		person2.printInfo();
		System.out.println("Person3: ");
		person3.printInfo();
	}
}
