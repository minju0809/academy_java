package board.pageBoard1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.apache.coyote.Request;

import board.DBConnection;
import oracle.net.aso.m;

public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String insert_sql = "insert into board1127 (idx,sname,title,content,cnt) values (idx_board2.nextval,?,?,?,1)";
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public void bigInsert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			for (int i = 1; i <= 17; i++) {
				
				int snameR = (int) (Math.random()*7);
				int titleR1 = (int) (Math.random()*5);
				int titleR2 = (int) (Math.random()*3);
				int contentR = (int) (Math.random()*4);
				
				String[] sname = {"영심이","하니","똘이","하늘이","바다","지효","지솔"};
				String[] title1 = {"영어","국어","수학","역사","컴퓨터"};
				String[] title2 = {"초급","중급","고급"};
				String[] content = {"열심히 공부하자","기초부터 차근차근","휴강","그룹과제 하기"};
				 
				String arrSname = sname[snameR];
				String arrTitle = title1[titleR1] + " " + title2[titleR2] + i;
				String arrContent = arrSname + " " + arrTitle + " " + content[contentR];
				
				String insert_sql = "insert into board1127 (idx,sname,title,content,cnt) values (idx_board2.nextval,?,?,?,1)";
				pstmt = conn.prepareStatement(insert_sql);
				pstmt.setString(1, arrSname);
				pstmt.setString(2, arrTitle);
				pstmt.setString(3, arrContent);
				pstmt.executeUpdate();
				
				System.out.println("===>" + i + "번 실행" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public void update(BoardVO vo) {
		try {	
			conn = DBConnection.getConnection();
			String update_sql = "update board1127 set sname=?,title=?,content=? where idx=?";
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIdx());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idx) {
		try {
			conn = DBConnection.getConnection();
			String delete_sql = "delete from board1127 where idx=?";
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setString(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public BoardVO edit(String idx) {
		BoardVO m = null;	
		try {
			conn = DBConnection.getConnection();
			String edit_sql = "select * from board1127 where idx=?";
			pstmt = conn.prepareStatement(edit_sql);
			pstmt.setString(1, idx);
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
	public List<BoardVO> select(BoardVO vo) {
		List<BoardVO> li = new ArrayList<BoardVO>();
		System.out.println("===> select : " + vo.getCh1() + " : " + vo.getCh2());
		String select_sql = null;
		try {
			// 페이지 나누기
			int startIndex = vo.getStart();
			int pageSize = vo.getPageSize();
			
			// 검색
			String ch1 = vo.getCh1();
			String ch2 = vo.getCh2();
			
			conn = DBConnection.getConnection();
			if (ch1 == null || ch1.equals("null") || ch2.equals("")) {
				select_sql = "select  rownum, Q.* "
						+ " from (  "
						+ " select rownum as rnum, K.* from (select * from board1127 order by idx desc ) K"
						+ " where  rownum <= ? ) Q"
						+ " where rnum >= ? ";
				pstmt = conn.prepareStatement(select_sql);
				pstmt.setInt(1, startIndex + pageSize - 1);
				pstmt.setInt(2, startIndex);
			} else if (ch1.equals("sname")) {
				select_sql = "select  rownum, Q.* "
						+ " from (  "
						+ " select rownum as rnum, K.* from (select * from board1127 where sname like ? order by idx desc ) K"
						+ " where  rownum <= ? ) Q"
						+ " where rnum >= ? ";
				pstmt = conn.prepareStatement(select_sql);
				pstmt.setString(1, "%" + ch2 + "%");
				pstmt.setInt(2, startIndex + pageSize - 1);
				pstmt.setInt(3, startIndex);
			} else if (ch1.equals("title")) {
				select_sql = "select  rownum, Q.* "
						+ " from (  "
						+ " select rownum as rnum, K.* from (select * from board1127 where title like ? order by idx desc ) K"
						+ " where  rownum <= ? ) Q"
						+ " where rnum >= ? ";
				pstmt = conn.prepareStatement(select_sql);
				pstmt.setString(1, "%" + ch2 + "%");
				pstmt.setInt(2, startIndex + pageSize - 1);
				pstmt.setInt(3, startIndex);
			}
			
			rs = pstmt.executeQuery();
			BoardVO m = null;
			while(rs.next()) {
				m = new BoardVO();
				m.setIdx(rs.getString("idx"));
				m.setSname(rs.getString("sname"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.setCnt(rs.getInt("cnt"));
				
				m.setRownum(rs.getInt("rownum"));
				m.setRnum(rs.getInt("rnum"));
				li.add(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public int totalCount(BoardVO vo) {
		String ch1 = vo.getCh1();
		String ch2 = vo.getCh2();
		
		int tc = 0;
		try {
			conn = DBConnection.getConnection();
			String select_sql = null;
			if (ch1 == null || ch1.equals("null") || ch2 == null || ch2.equals("")) {
				select_sql = "select count(*) tc from board1127";
				pstmt = conn.prepareStatement(select_sql);
			} else if (ch1.equals("sname")) {
				select_sql = "select count(*) tc from board1127 where sname like ?";
				pstmt = conn.prepareStatement(select_sql);
				pstmt.setString(1, "%" + ch2 + "%");
			} else if (ch1.equals("title")) {
				select_sql = "select count(*) tc from board1127 where title like ?";
				pstmt = conn.prepareStatement(select_sql);
				pstmt.setString(1, "%" + ch2 + "%");
			}
 			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tc = rs.getInt("tc");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return tc;
	}

}
