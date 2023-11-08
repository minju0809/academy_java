package pkg.board;

import java.util.List;

public interface BoardDao {
	List<BoardVO> select(BoardVO vo);
	
	void insert(BoardVO vo);
	
	BoardVO edit(BoardVO vo);
}
