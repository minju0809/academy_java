package DBPKG.comment;

import java.util.List;

public class CommentServiceImpl implements CommentService {
	CommentDao dao = null;
	
	public CommentServiceImpl() {
		dao = new CommentDaoImpl();
	}

	@Override
	public void commentInsert(CommentVO vo) {
		dao.commentInsert(vo);
	}

	@Override
	public List<CommentVO> commentSelect(String c_no) {
		return dao.commentSelect(c_no);
	}

	@Override
	public void commentDelete(int idx) {
		dao.commentDelete(idx);
	}
}
