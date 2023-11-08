package pkg.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> select(BoardVO vo);

	void insert(BoardVO vo);
	
	BoardVO edit(BoardVO vo);
}
