package DBPKG.psd;

import java.util.List;

public interface PsdDao {
	void insert(PsdVO vo);
	
	List<PsdVO> select(PsdVO vo);
	
	void delete(int idx);
	String selectFileName(int idx);
	
	PsdVO edit(int idx);
	
	void update(PsdVO vo);
}

