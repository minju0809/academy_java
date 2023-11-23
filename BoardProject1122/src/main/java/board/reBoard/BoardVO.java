package board.reBoard;

public class BoardVO {
	private String idx;
	private String sname;
	private String title;
	private String content;
	private int cnt;
	private int ref;
	private int re_step;
	private int re_level;
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRe_step() {
		return re_step;
	}

	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [idx=");
		builder.append(idx);
		builder.append(", sname=");
		builder.append(sname);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", cnt=");
		builder.append(cnt);
		builder.append(", ref=");
		builder.append(ref);
		builder.append(", re_step=");
		builder.append(re_step);
		builder.append(", re_level=");
		builder.append(re_level);
		builder.append("]");
		return builder.toString();
	}


}
