package pkg;

import java.util.List;

public interface JungDao {
	void insert(JungVO vo);

	List<JungVO> select();

	int sNo();
	
	JungVO edit(int sNo);
	
	void update(JungVO vo);
	
	void delete(int sNo);
}
