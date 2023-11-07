package pkg;

import java.util.List;

public interface JungService {
	void insert(JungVO vo);

	List<JungVO> select();

	int sNo();

	JungVO edit(int sNo);
	
	void update(JungVO vo);
	
	void delete(String sNo);
	
	void cnt(String sNo);
}
