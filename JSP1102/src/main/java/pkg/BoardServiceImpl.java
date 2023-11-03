package pkg;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao;

	public BoardServiceImpl() {
		dao = new BoardDaoImpl();
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

}
