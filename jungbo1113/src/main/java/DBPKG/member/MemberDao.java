package DBPKG.member;

import java.util.List;

//import DBPKG.member.MemberVO;

public interface MemberDao {
	List<MemberVO> select(MemberVO memberVO);

	void insert(MemberVO memberVO);

	int maxCustno();

	void delete(int custno);

	MemberVO selectCustno(int custno);

	void update(MemberVO memberVO);
}
