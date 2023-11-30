package DBPKG.teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
	TeacherDao dao = null;
	
	public TeacherServiceImpl() {
		dao = new TeacherDaoImpl();
	}
	
	@Override
	public List<TeacherVO> select() {
		return dao.select();
	}

	@Override
	public void insert(TeacherVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherVO> priceSelect() {
		return dao.priceSelect();
	}

}
