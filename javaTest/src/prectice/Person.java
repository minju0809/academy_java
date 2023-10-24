package prectice;

public class Person {
	String name;
	int age = 20;
	String gender = "female";
	
	public Person(String name) {
		this(name, 20, "female");
//		this.name = name;
	}
	
	public Person(String name, int age) {
		this(name, age, "male");
//		this.name = name;
//		this.age = age;
	}
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
	}
}
