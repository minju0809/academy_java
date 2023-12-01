package DBPKG.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;

public class MemberDaoImpl implements MemberDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<MemberVO> select() {
		List<MemberVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select c.regist_month, c.c_no, m.c_name, t.class_name, c.class_area, c.tuition, m.grade from tbl_member_202201 m join tbl_class_202201 c on m.c_no = c.c_no \r\n"
					+ "join tbl_teacher_202201 t on c.teacher_code = t.teacher_code order by c.c_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			MemberVO m = null;
			while (rs.next()) {
				m = new MemberVO();
				m.setRegist_month(rs.getString("regist_month"));
				m.setC_no(rs.getString("c_no"));
				m.setC_name(rs.getString("c_name"));
				m.setClass_name(rs.getString("class_name"));
				m.setClass_area(rs.getString("class_area"));
				m.setTuition(rs.getInt("tuition"));
				m.setGrade(rs.getString("grade"));
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
	public void insert(ClassVO vo) {
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into tbl_class_202201 (regist_month,c_no,class_area,tuition,teacher_code) "
					+ " values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRegist_month());
			pstmt.setString(2, vo.getC_no());
			pstmt.setString(3, vo.getClass_area());
			pstmt.setInt(4, vo.getTuition());
			pstmt.setString(5, vo.getTeacher_code());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public List<ClassVO> classSelect() {
		List<ClassVO> classList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select c.REGIST_MONTH, c.c_no, c.class_area, c.tuition, c.teacher_code, t.teacher_name "
					+ " from tbl_class_202201 c join tbl_teacher_202201 t "
					+ " on c.teacher_code = t.teacher_code order by c_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ClassVO m = null;
			while (rs.next()) {
				m = new ClassVO();
				m.setRegist_month(rs.getString("regist_month"));
				m.setC_no(rs.getString("c_no"));
				m.setClass_area(rs.getString("class_area"));
				m.setTuition(rs.getInt("tuition"));
				m.setTeacher_code(rs.getString("teacher_code"));
				m.setTeacher_name(rs.getString("teacher_name"));
				classList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return classList;
	}

	@Override
	public MemberVO detail(String c_no) {
		MemberVO m = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from tbl_member_202201 where c_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_no);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				m = new MemberVO();
				m.setC_no(rs.getString("c_no"));
				m.setC_name(rs.getString("c_name"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setGrade(rs.getString("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return m;
	}

}
