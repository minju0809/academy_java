package DBPKG.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;

public class MemberDaoImpl implements MemberDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MemberDaoImpl() {
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> select(MemberVO memberVO) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			String SQL = "select * from member_tbl_02";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getString("custname"));
				m.setPwd(rs.getString("pwd"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setJoindate(rs.getDate("joindate"));
				m.setGrade(rs.getString("grade"));
				m.setCity(rs.getString("city"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void insert(MemberVO memberVO) {
		try {
			String SQL = "insert into member_tbl_02 " + "values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, memberVO.getCustno());
			pstmt.setString(2, memberVO.getCustname());
			pstmt.setString(3, memberVO.getPhone());
			pstmt.setString(4, memberVO.getAddress());
			pstmt.setDate(5, memberVO.getJoindate());
			pstmt.setString(6, memberVO.getGrade());
			pstmt.setString(7, memberVO.getCity());
			pstmt.setString(8, memberVO.getPwd());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int maxCustno() {
		int maxCustno = 0;
		try {
			String SQL = "select max(custno)+1 as custno from member_tbl_02";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxCustno = rs.getInt("custno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxCustno;
	}

	@Override
	public void delete(int custno) {
		try {
			String SQL = "delete from member_tbl_02 where custno=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, custno);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public MemberVO selectCustno(int custno) {
		MemberVO memberVO = null;
		try {
			String SQL = "select * from member_tbl_02 where custno = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setCustno(rs.getInt("custno"));
				memberVO.setCustname(rs.getString("custname"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setJoindate(rs.getDate("joindate"));
				memberVO.setGrade(rs.getString("grade"));
				memberVO.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberVO;

	}

	@Override
	public void update(MemberVO memberVO) {
		try {
			String SQL = "update member_tbl_02 set custname=?, phone=?, address=?, "
					+ "joindate=?, grade=?, city=?, pwd=? where custno = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, memberVO.getCustname());
			pstmt.setString(2, memberVO.getPhone());
			pstmt.setString(3, memberVO.getAddress());
			pstmt.setDate(4, memberVO.getJoindate());
			pstmt.setString(5, memberVO.getGrade());
			pstmt.setString(6, memberVO.getCity());
			pstmt.setString(7, memberVO.getPwd());
			pstmt.setInt(8, memberVO.getCustno());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
