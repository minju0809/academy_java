
package DBPKG.member;

import java.util.List;

//import DBPKG.member.MemberVO;

public class MemberServiceImpl implements MemberService {

	
	MemberDao jungboDao = new MemberDaoImpl();
	@Override
	public List<MemberVO> select(MemberVO memberVO) {
		return jungboDao.select(memberVO);
	}

	@Override
	public void insert(MemberVO memberVO) {
		jungboDao.insert(memberVO);
	}

	@Override
	public int maxCustno() {
		return jungboDao.maxCustno();
	}

	@Override
	public void delete(int custno) {
		jungboDao.delete(custno);
	}

	@Override
	public MemberVO selectCustno(int custno) {
		return jungboDao.selectCustno(custno);
	}

	@Override
	public void update(MemberVO memberVO) {
		jungboDao.update(memberVO);
	}


}
