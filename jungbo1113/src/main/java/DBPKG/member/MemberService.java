package DBPKG.member;

import java.util.List;
//import DBPKG.member.MemberVO;

public interface MemberService {
	List<MemberVO> select(MemberVO memberVO);

	MemberVO selectCustno(int custno);

	void insert(MemberVO memberVO);

	void update(MemberVO memberVO);

	void delete(int custno);

	int maxCustno();
}
