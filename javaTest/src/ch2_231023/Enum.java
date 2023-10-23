package ch2_231023;

public class Enum {
	public static void main(String[] args) {
		String coffee = "1";

		EnumCoffee todayCoffee = null;

		if (coffee.equals("1")) {
			todayCoffee = EnumCoffee.ICE_AMERICANO;
		} else if (coffee.equals("2")) {
			todayCoffee = EnumCoffee.CAFE_LATTE;
		}
		System.out.println(todayCoffee);

		String str = "2";

		EnumAge age = null;

		if (str.equals("1")) {
			age = EnumAge.TEN;
		} else if (str.equals("2")) {
			age = EnumAge.TWENTY;
		} else if (str.equals("3")) {
			age = EnumAge.THIRTY;
		}
		System.out.println(age);
	}
}
