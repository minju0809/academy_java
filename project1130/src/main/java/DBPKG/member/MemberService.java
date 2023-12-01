package DBPKG.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> select();
	
	MemberVO detail(String c_no);
	
	void insert(ClassVO vo);
	
	List<ClassVO> classSelect();
}
