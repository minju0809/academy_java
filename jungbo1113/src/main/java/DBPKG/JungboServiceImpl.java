
package DBPKG;

import java.util.List;

public class JungboServiceImpl implements JungboService {
	JungboDao dao = null;

	public JungboServiceImpl() {
		dao = new JungboDaoImpl();
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		return dao.select(vo);
	}

	@Override
	public int custno() {
		return dao.custno();
	}

	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		dao.delete(vo);
	}

	@Override
	public MemberVO edit(int custno) {
		return dao.edit(custno);
	}
	
	@Override
	public void update(MemberVO vo) {
		dao.update(vo);
	}

	@Override
	public List<MoneyVO> money() {
		return dao.money();
	}

}
