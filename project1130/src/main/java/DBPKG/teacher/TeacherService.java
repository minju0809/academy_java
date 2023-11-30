package DBPKG.teacher;

import java.util.List;

public interface TeacherService {
	List<TeacherVO> select();
	void insert(TeacherVO vo);
	List<TeacherVO> priceSelect();
}
