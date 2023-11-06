package pkg.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection.DBConnection;
import pkg.model.MemberVO;

public class MemberDaoImpl implements MemberDao {
	DBConnection DBCon = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDaoImpl() {
		DBCon = DBConnection.getInstance();
	}

	@Override
	public void insert(MemberVO vo) {
		try {
			conn = DBCon.getConnection();
			String SQL = "insert into member200 (id, pwd, name, email) values (ST1102.nextval,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		List<MemberVO> li = null;
		try {
			li = new ArrayList<>();
			conn = DBCon.getConnection();
			String SQL = "select * from member200 order by id desc";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				li.add(m);
			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public MemberVO edit(MemberVO vo) {
		MemberVO m = null;
		try {
			m = new MemberVO();
			conn = DBCon.getConnection();
			String SQL = "select * from member200 where id=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void delete(String id) {
		try {
			conn = DBCon.getConnection();
			String SQL = "delete from member200 where id=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
