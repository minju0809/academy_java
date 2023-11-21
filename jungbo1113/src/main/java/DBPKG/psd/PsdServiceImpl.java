package DBPKG.psd;

import java.util.List;

public class PsdServiceImpl implements PsdService {
	PsdDao dao = null;
	
	public PsdServiceImpl() {
		dao = new PsdDaoImpl();
	}

	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<PsdVO> select(PsdVO vo) {
		return dao.select(vo);
	}

	@Override
	public void delete(int idx) {
		dao.delete(idx);
	}

	@Override
	public String selectFileName(int idx) {
		return dao.selectFileName(idx);
	}

	@Override
	public PsdVO edit(int idx) {
		return dao.edit(idx);
	}

	@Override
	public void update(PsdVO vo) {
		dao.update(vo);
	}

}
