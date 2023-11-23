<<<<<<< HEAD
package board.basicBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.DBConnection;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String insert_sql = "insert into board1122 (idx,sname,title,content,cnt) values (idx_board.nextval,?,?,?,1)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String update_sql = "update board1122 set sname=?,title=?,content=? where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String delete_sql = "delete from board1122 where idx=?";
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO edit(BoardVO vo) {
		BoardVO m = null;
		try {
			conn = DBConnection.getConnection();
			String edit_sql = "select * from board1122 where idx=?";
			pstmt = conn.prepareStatement(edit_sql);
			pstmt.setString(1, vo.getIdx());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<BoardVO> list(BoardVO vo) {
		List<BoardVO> list = null;
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select * from board1122 order by idx desc";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			BoardVO m = null;
			while (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
				list.add(m);
				System.out.println("dao"+ m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void cntCount(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String update_sql = "update board1122 set cnt=cnt+1 where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
=======
package board.basicBoard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.DBConnection;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String insert_sql = "insert into board1122 (idx,sname,title,content,cnt) values (idx_board.nextval,?,?,?,1)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String update_sql = "update board1122 set sname=?,title=?,content=? where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String delete_sql = "delete from board1122 where idx=?";
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO edit(BoardVO vo) {
		BoardVO m = null;
		try {
			conn = DBConnection.getConnection();
			String edit_sql = "select * from board1122 where idx=?";
			pstmt = conn.prepareStatement(edit_sql);
			pstmt.setString(1, vo.getIdx());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<BoardVO> list(BoardVO vo) {
		List<BoardVO> list = null;
		try {
			conn = DBConnection.getConnection();
			String select_sql = "select * from board1122 order by idx desc";
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			BoardVO m = null;
			while (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
				list.add(m);
				System.out.println("dao"+ m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void cntCount(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String update_sql = "update board1122 set cnt=cnt+1 where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
>>>>>>> 37c817c84e9ceefc2fab1390af0949fde27c29fe
