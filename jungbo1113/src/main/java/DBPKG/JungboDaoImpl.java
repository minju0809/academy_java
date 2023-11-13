package DBPKG;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JungboDaoImpl implements JungboDao {
	DBConnection DBConn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@SuppressWarnings("static-access")
	@Override
	public List<MemberVO> select(MemberVO vo) {
		List<MemberVO> li = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from member_tbl_02";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			MemberVO m = null;
			while (rs.next()) {
				m = new MemberVO();
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getString("custname"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setJoindate(rs.getDate("joindate"));
				m.setGrade(rs.getString("grade"));
				m.setCity(rs.getString("city"));
				li.add(m);
				System.out.println("===> " + m);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@SuppressWarnings("static-access")
	@Override
	public int custno() {
		int custno = 0;
		try {
			conn = DBConn.getConnection();
			String SQL = "select max(custno)+1 as custno from member_tbl_02";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			rs.next();
			custno = rs.getInt("custno");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custno;
	}

	@SuppressWarnings("static-access")
	@Override
	public void insert(MemberVO vo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "insert into member_tbl_02 values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setDate(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void delete(MemberVO vo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "delete from member_tbl_02 where custno=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getCustno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO edit(int custno) {
		MemberVO m = new MemberVO();
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from member_tbl_02 where custno=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getString("custname"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setJoindate(rs.getDate("joindate"));
				m.setGrade(rs.getString("grade"));
				m.setCity(rs.getString("city"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}
