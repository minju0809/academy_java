package DBPKG.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> select();
	void insert(ClassVO vo);
}
