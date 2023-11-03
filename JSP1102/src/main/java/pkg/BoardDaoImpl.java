package pkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "insert into T1102 (idx, name, age) values (ST1102.nextval,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> li = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from T1102";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			BoardVO m = null;
			while (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getInt("idx"));
				m.setName(rs.getString("name"));
				m.setAge(rs.getInt("age"));
				li.add(m);
//				System.out.println("===> " + m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return li;
	}

}
