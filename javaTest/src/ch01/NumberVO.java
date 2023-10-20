package ch01;

public class NumberVO {
	private String num1;
	private String num2;
	
	private String result;

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "NumberVO [num1=" + num1 + ", num2=" + num2 + ", result=" + result + "]";
	}

}
