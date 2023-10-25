package ch4_201025;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator calculator = new Calculator();
		calculator.areaCircle(r);
		
		Computer computer = new Computer();
		computer.areaCircle(r);
		
		// 부모 메소드는 숨겨지고 자식메소드가 우선으로 사용
		Calculator computer1 = new Computer();
		computer1.areaCircle(r);
	}
}
