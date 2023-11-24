package board.basicBoard;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.DBConnection;
import oracle.jdbc.internal.OracleTypes;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	CallableStatement cstmt = null;
	
	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			
			/*
			String insert_sql = "insert into board1122 (idx,sname,title,content,cnt) values (idx_board.nextval,?,?,?,1)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			*/
			
			String insert_sql = "{ call ps_board1122_insert(?,?,?,?) }";
			cstmt = conn.prepareCall(insert_sql);
			cstmt.setString(1, vo.getSname());
			cstmt.setString(2, vo.getTitle());
			cstmt.setString(3, vo.getContent());
			cstmt.setString(4, vo.getImg());
			cstmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(BoardVO vo) {
		System.out.println("update vo: " + vo.getImg());
		try {
			conn = DBConnection.getConnection();
			
			/*
			String update_sql = "update board1122 set sname=?,title=?,content=? where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIdx());
			pstmt.executeUpdate();
			*/
			
			if (vo.getImg() != null) {
				String update_sql = "{ call ps_board1122_update_img(?,?,?,?,?) }";
				cstmt = conn.prepareCall(update_sql);
				cstmt.setString(1, vo.getSname());
				cstmt.setString(2, vo.getTitle());
				cstmt.setString(3, vo.getContent());
				cstmt.setString(4, vo.getImg());
				cstmt.setString(5, vo.getIdx());
				cstmt.execute();
			} else {
				String update_sql = "{ call ps_board1122_update(?,?,?,?) }";
				cstmt = conn.prepareCall(update_sql);
				cstmt.setString(1, vo.getSname());
				cstmt.setString(2, vo.getTitle());
				cstmt.setString(3, vo.getContent());
				cstmt.setString(4, vo.getIdx());
				cstmt.execute();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			
			/*
			String delete_sql = "delete from board1122 where idx=?";
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			*/
			
			String delete_sql = "{ call ps_board1122_delete(?) }";
			cstmt = conn.prepareCall(delete_sql);
			cstmt.setString(1, vo.getIdx());
			cstmt.execute();
			
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
			
			/*
			String edit_sql = "select * from board1122 where idx=?";
			pstmt = conn.prepareStatement(edit_sql);
			pstmt.setString(1, vo.getIdx());
			rs = pstmt.executeQuery(); 
			*/
			
			String edit_sql = "{ call ps_board1122_edit(?,?) }";
			cstmt = conn.prepareCall(edit_sql);
			cstmt.setString(1, vo.getIdx());
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(2);
			
			if (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
				m.setImg(rs.getString("img"));
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
			
			
			// String select_sql = "select * from board1122 order by idx desc";
			// pstmt = conn.prepareStatement(select_sql);
			// rs = pstmt.executeQuery();
			
			
			String select_sql = "{ call ps_board1122_select(?) }";
			cstmt = conn.prepareCall(select_sql);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);
			
			list = new ArrayList<>();
			BoardVO m = null;
			while (rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
				m.setImg(rs.getString("img"));
				list.add(m);
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
			
			/*
			String update_sql = "update board1122 set cnt=cnt+1 where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getIdx());
			pstmt.executeUpdate();
			*/
			
			String cntCount_sql = "{ call ps_board1122_cntCount(?) }";
			cstmt = conn.prepareCall(cntCount_sql);
			cstmt.setString(1, vo.getIdx());
			cstmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
