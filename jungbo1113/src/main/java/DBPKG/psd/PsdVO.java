package DBPKG.psd;

public class PsdVO {
	int idx;
	String fname;
	String fimg;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
		builder.append(", fname=");
		builder.append(fname);
		builder.append(", fimg=");
		builder.append(fimg);
		builder.append("]");
		return builder.toString();
	}
	
	
}
