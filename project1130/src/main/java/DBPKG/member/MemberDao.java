package DBPKG.member;

import java.util.List;

public interface MemberDao {
	List<MemberVO> select();
	void insert(ClassVO vo);
}
