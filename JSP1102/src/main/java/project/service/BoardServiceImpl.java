package project.service;

import project.BoardVO;
import project.dao.BoardDao;
import project.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {

	public BoardDao dao = null;
	@Override
	public void insert(BoardVO vo) {
		BoardDao dao = new BoardDaoImpl();
		dao.insert(vo);
	}
}
