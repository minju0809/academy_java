package DBPKG.psd;

public class PsdVO {
	int idx;
	String title;
	String fname;
	int age;
	String etc;
	String fimg;
	
	String ch1;
	String ch2;
	
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getFimg() {
		return fimg;
	}
	public void setFimg(String fimg) {
		this.fimg = fimg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PsdVO [idx=");
		builder.append(idx);
		builder.append(", title=");
		builder.append(title);
		builder.append(", fname=");
		builder.append(fname);
		builder.append(", age=");
		builder.append(age);
		builder.append(", etc=");
		builder.append(etc);
		builder.append(", fimg=");
		builder.append(fimg);
		builder.append("]");
		return builder.toString();
	}
}
