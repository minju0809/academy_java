package pkg.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection;

public class BoardDaoImpl implements BoardDao {
	DBConnection DBConn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public BoardDaoImpl() {
		DBConn = DBConnection.getInstance();
	};

	@Override
	public List<BoardVO> select(BoardVO vo) {
		System.out.println(vo.getCh1() + " : " + vo.getCh2());

		List<BoardVO> li = new ArrayList<>();
		BoardVO m = null;
		try {
			conn = DBConn.getConnection();

			if (vo.getCh1() == null || vo.getCh2().equals("")) {
				String SQL = "select * from test order by num_id desc";
				pstmt = conn.prepareStatement(SQL);
			} else if (vo.getCh1().equals("title")) {
				String SQL = "select * from test where title like ? order by num_id desc";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			} else if (vo.getCh1().equals("content")) {
				String SQL = "select * from test where content like ? order by num_id desc";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new BoardVO();
				m.setNum_id(rs.getInt("num_id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				li.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "insert into test (num_id, title, content) values((select nvl(max(num_id),0)+1 from test),?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO edit(BoardVO vo) {
//		System.out.println("edit 접근 확인" + vo.getNum_id());
		BoardVO m = null;
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from test where num_id = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getNum_id());

			rs = pstmt.executeQuery();
			rs.next();
			m = new BoardVO();
			m.setNum_id(rs.getInt("num_id"));
			m.setTitle(rs.getString("title"));
			m.setContent(rs.getString("content"));

//			System.out.println("DaoImpl m : " + m);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

}
