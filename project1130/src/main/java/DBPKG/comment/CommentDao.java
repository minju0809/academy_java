package DBPKG.comment;

import java.util.List;

public interface CommentDao {
	void commentInsert(CommentVO vo);
	List<CommentVO> commentSelect(String c_no);	
	
	void commentDelete(int idx);
}
