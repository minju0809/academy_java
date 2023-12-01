package DBPKG.teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;

public class TeacherDaoImpl implements TeacherDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<TeacherVO> select() {
		List<TeacherVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from tbl_teacher_202201 order by teacher_code";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			TeacherVO m = null;
			while (rs.next()) {
				m = new TeacherVO();
				m.setTeacher_code(rs.getString("teacher_code"));
				m.setTeacher_name(rs.getString("teacher_name"));
				m.setClass_name(rs.getString("class_name"));
				m.setClass_price(rs.getInt("class_price"));
				m.setTeacher_regist_date(rs.getString("teacher_regist_date"));
				li.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public void insert(TeacherVO vo) {

	}

	@Override
	public List<TeacherVO> priceSelect() {
		List<TeacherVO> priceList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String sql = "	select t.teacher_code, t.class_name, t.teacher_name, sum(c.tuition) tuition from tbl_class_202201 c"
					+ "	join tbl_teacher_202201 t on c.teacher_code = t.teacher_code "
					+ "	group by t.teacher_code, t.class_name, t.teacher_name order by t.teacher_code";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			TeacherVO m = null;
			while (rs.next()) {
				m = new TeacherVO();
				m.setTeacher_code(rs.getString("teacher_code"));
				m.setTeacher_name(rs.getString("teacher_name"));
				m.setClass_name(rs.getString("class_name"));
				m.setTuition(rs.getInt("tuition"));
				priceList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return priceList;
	}
}
