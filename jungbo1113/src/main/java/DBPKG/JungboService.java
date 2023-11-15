package DBPKG;

import java.util.List;

public interface JungboService {
	List<MemberVO> select(MemberVO vo);
	
	int custno();
	
	void insert(MemberVO vo);
	
	void delete(MemberVO vo);
	
	MemberVO edit(int custno);
	
	void update(MemberVO vo);
	
	List<MoneyVO> money();
}