package DBPKG;

public class MoneyVO {
	private int custno;
	private String custname;
	private String grade;
	private int money;

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MeneyVO [custno=");
		builder.append(custno);
		builder.append(", custname=");
		builder.append(custname);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", money=");
		builder.append(money);
		builder.append("]");
		return builder.toString();
	}

}
