package pkg;

public class JungVO {
	private String sNo;
	private String sName;
	private int kor;
	private int eng;
	private int math;
	private int hist;
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getHist() {
		return hist;
	}
	public void setHist(int hist) {
		this.hist = hist;
	}
	@Override
	public String toString() {
		return "JungVO [sNo=" + sNo + ", sName=" + sName + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", hist=" + hist + "]";
	}
}
