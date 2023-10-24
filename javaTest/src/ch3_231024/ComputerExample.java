package ch3_231024;

public class ComputerExample {
	public static void main(String[] args) {
		// Computer 객체 생성
		Computer myCom = new Computer();

		// sum() 메소드 호출 시 매개값 1, 2, 3을 제공하고 합산 결과를 리턴 받아 result1 변수에 대입
		int result1 = myCom.sum(1, 2, 3);
		System.out.println("result1: " + result1);

		// sum() 메소드 호출 시 매개값 1, 2, 3, 4, 5를 제공하고 합산 결과를 리턴 받아 result2 변수에 대입
		int result2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("result2: " + result2);

		// sum() 매소드 호출 시 배열을 제공하고 합산 결과를 리턴 받아 result3 변수에 대입
		int[] values = { 1, 2, 3, 4, 5 };
		int result3 = myCom.sum(values);
		System.out.println("result3: " + result3);

		// sum() 메소드 호출 시 배열을 제공하고 합산 결과를 리턴 받아 result4 변수에 대입
		int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result4: " + result4);

		int[] valuesArr = new int[] { 1, 2, 3, 4, 5, 6 };
		int result5 = myCom.sumArr(valuesArr);
		System.out.println(result5);

		// 문제 배열로 값 넘겨서 배열값 받아오기
		valuesArr = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] valueArr = myCom.sumArr2(valuesArr);
		for (int v : valueArr) {
			System.out.print(v + " ");
		}
	}
}