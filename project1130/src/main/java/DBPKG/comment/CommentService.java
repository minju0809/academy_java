package DBPKG.comment;

import java.util.List;

public interface CommentService {
	void commentInsert(CommentVO vo);
	List<CommentVO> commentSelect(String c_no);
	
	void commentDelete(int idx);
}
