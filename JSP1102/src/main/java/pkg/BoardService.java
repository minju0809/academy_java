package pkg;

import java.util.List;

public interface BoardService {
	void insert(BoardVO vo);
	
	List<BoardVO> getBoardList();
}
