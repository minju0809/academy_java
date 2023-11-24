package board.comment;

public class BoardVO {
	private String idx;
	private String sname;
	private String title;
	private String content;
	private int cnt;

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

	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", sname=" + sname + ", title=" + title + ", content=" + content + ", cnt=" + cnt
				+ "]";
	}
}
