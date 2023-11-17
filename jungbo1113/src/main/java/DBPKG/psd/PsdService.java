package DBPKG.psd;

import java.util.List;

public interface PsdService {
	void insert(PsdVO vo);
	
	List<PsdVO> select();
	
	void delete(int idx);
}
