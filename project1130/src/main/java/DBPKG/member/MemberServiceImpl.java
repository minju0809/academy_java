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

	@Override
	public List<ClassVO> classSelect() {
		return dao.classSelect();
	}

	@Override
	public MemberVO detail(String c_no) {
		return dao.detail(c_no);
	}

}
