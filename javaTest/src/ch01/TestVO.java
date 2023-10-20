package ch01;

public class TestVO {
	private String str;
	private int startDan;
	private int endDan;

	public int getStartDan() {
		return startDan;
	}

	public void setStartDan(int startDan) {
		this.startDan = startDan;
	}

	public int getEndDan() {
		return endDan;
	}

	public void setEndDan(int endDan) {
		this.endDan = endDan;
	}

	public TestVO() {
		// 기본 생성자
	}

	public TestVO(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	

}
