package ch4_201025.package3;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.breathe();
		dog.sound();
		
		Cat cat = new Cat();
		cat.breathe();
		cat.sound();
		
		animalSound(new Dog());
		animalSound(new Cat());
	}

	private static void animalSound(Animal animal) {
		animal.sound();
	}
}
