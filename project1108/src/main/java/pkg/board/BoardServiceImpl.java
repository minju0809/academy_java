package pkg.board;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = null;

	public BoardServiceImpl() {
		dao = new BoardDaoImpl();
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		return dao.select(vo);
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public BoardVO edit(BoardVO vo) {
		return dao.edit(vo);
	}
}
