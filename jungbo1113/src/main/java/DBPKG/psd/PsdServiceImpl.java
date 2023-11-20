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
	public List<PsdVO> select() {
		return dao.select();
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

}