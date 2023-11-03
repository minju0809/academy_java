package pkg;

import java.util.List;

public interface BoardDao {
	void insert(BoardVO vo);
	
	List<BoardVO> getBoardList();
}
