package DBPKG.comment;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommentVO {
	int idx;
	String c_no;
	String writer;
	String memo;
}	
