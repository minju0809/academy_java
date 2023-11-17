package DBPKG.jungbo;

import java.util.List;

import DBPKG.MemberVO;

public interface JungboDao {
	List<MemberVO> select(MemberVO vo);
	
	int custno();
	
	void insert(MemberVO vo);
	
	void delete(MemberVO vo);
	
	MemberVO edit(int custno);
	
	void update(MemberVO vo);
}
