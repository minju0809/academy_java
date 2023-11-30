package DBPKG.member;

import java.util.List;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = null;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public List<MemberVO> select() {
		return dao.select();
	}

	@Override
	public void insert(ClassVO vo) {
		dao.insert(vo);
	}

}
