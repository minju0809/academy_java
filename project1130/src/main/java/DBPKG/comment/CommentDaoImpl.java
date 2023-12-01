package DBPKG.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;
import DBPKG.member.MemberVO;

public class CommentDaoImpl implements CommentDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void commentInsert(CommentVO vo) {
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into tbl_member_memo (idx,c_no,writer,memo) "
					+ " values (memo_sequence.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getC_no());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getMemo());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public List<CommentVO> commentSelect(String c_no) {
		List<CommentVO> commentList = new ArrayList<>();
		CommentVO m = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from tbl_member_memo where c_no = ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new CommentVO();
				m.setIdx(rs.getInt("idx"));
				m.setC_no(rs.getString("c_no"));
				m.setWriter(rs.getString("writer"));
				m.setMemo(rs.getString("memo"));
				commentList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return commentList;
	}

	@Override
	public void commentDelete(int idx) {
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from tbl_member_memo where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

}
