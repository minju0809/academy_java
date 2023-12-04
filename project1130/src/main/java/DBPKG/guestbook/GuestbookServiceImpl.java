package DBPKG.guestbook;

import java.util.List;

public class GuestbookServiceImpl implements GuestbookService {
	GuestbookDao dao = null;
	
	public GuestbookServiceImpl() {
		dao = new GuestbookDaoImpl();
	}
			
	@Override
	public void guestbookInsertAll() {
		dao.guestbookInsertAll();
	}

	@Override
	public List<GuestbookVO> guestbookSelect(GuestbookVO vo) {
		return dao.guestbookSelect(vo);
	}

	@Override
	public int totalCount(GuestbookVO vo) {
		return dao.totalCount(vo);
	}

	@Override
	public void guestbookDelete(int idx) {
		dao.guestbookDelete(idx);
	}
	
}
