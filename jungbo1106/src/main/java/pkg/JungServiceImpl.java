package pkg;

import java.util.List;

public class JungServiceImpl implements JungService {
	JungDao dao = null;

	public JungServiceImpl() {
		dao = new JungDaoImpl();
	}

	@Override
	public void insert(JungVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<JungVO> select() {
		return dao.select();
	}

	@Override
	public int sNo() {
		return dao.sNo();
	}

	@Override
	public JungVO edit(int sNo) {
		return dao.edit(sNo);
	}

	@Override
	public void update(JungVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int sNo) {
		dao.delete(sNo);
	}

}
