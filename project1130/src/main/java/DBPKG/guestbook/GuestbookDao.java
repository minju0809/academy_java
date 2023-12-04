package DBPKG.guestbook;

import java.util.List;

public interface GuestbookDao {
	void guestbookInsertAll();
	
	List<GuestbookVO> guestbookSelect(GuestbookVO vo);
	
	int totalCount(GuestbookVO vo);
	
	void guestbookDelete(int idx);
}
