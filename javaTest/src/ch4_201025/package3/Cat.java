package ch4_201025.package3;

public class Cat extends Animal implements CatI, CatII {

	@Override
	public void sound() {
		System.out.println("야옹");
	}

	@Override
	public void sound2() {
		System.out.println("야야옹옹");
	}

}
