<<<<<<< HEAD
package board.comment;

import java.sql.Date;

public class CommentVO {
	private String cidx;
	private String comment_idx;
	private String commentContent;
	private Date commentDate;


	public String getCidx() {
		return cidx;
	}

	public void setCidx(String cidx) {
		this.cidx = cidx;
	}

	public String getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(String comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "CommentVO [idx=" + cidx + ", comment_idx=" + comment_idx + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + "]";
	}

}
=======
package board.comment;

import java.sql.Date;

public class CommentVO {
	private String idx;
	private String comment_idx;
	private String commentContent;
	private Date commentDate;

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(String comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "CommentVO [idx=" + idx + ", comment_idx=" + comment_idx + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + "]";
	}

}
>>>>>>> 37c817c84e9ceefc2fab1390af0949fde27c29fe
