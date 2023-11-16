package DBPKG;

import java.sql.Date;

public class MoneyVO {
	private int custno;
	private String custname;
	private String grade;
	private int money;
	
	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Date sDate;

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

	
	public int getSalenol() {
		return salenol;
	}

	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MoneyVO [custno=");
		builder.append(custno);
		builder.append(", salenol=");
		builder.append(salenol);
		builder.append(", pcost=");
		builder.append(pcost);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", price=");
		builder.append(price);
		builder.append(", pcode=");
		builder.append(pcode);
		builder.append(", sDate=");
		builder.append(sDate);
		builder.append("]");
		return builder.toString();
	}

}
