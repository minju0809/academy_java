package DBPKG.guestbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;

public class GuestbookDaoImpl implements GuestbookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void guestbookInsertAll() {
		try {
			conn = DBConnection.getConnection();
			for (int i = 0; i < 55; i++) {

				int nameR = (int) (Math.random() * 10);
				int titleR1 = (int) (Math.random() * 5);
				int titleR2 = (int) (Math.random() * 3);
				int contentR = (int) (Math.random() * 5);

				String nameArr[] = { "강한영", "김상준", "김윤영", "김준우", "박선주", "김한글", "강상이", "최성근", "조진호", "양희군" };
				String title1[] = { "아주좋아요", "좋아요", "보통이에요", "나빠요", "아주나빠요" };
				String title2[] = { "우와", "정말", "대박" };
				String content[] = { "서울지점", "영등포분점", "제주지점", "울산지점", "독도지점" };

				String sql = "Insert into guestbook (idx, name, title, content) values (guestbookidx.nextval,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nameArr[nameR]);
				pstmt.setString(2, title1[titleR1] + title2[titleR2]);
				pstmt.setString(3, content[contentR]);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}

	@Override
	public List<GuestbookVO> guestbookSelect(GuestbookVO vo) {
		System.out.println(vo.getCh1() + " : " + vo.getCh2());
		List<GuestbookVO> li = new ArrayList<>();
		int start = vo.getStart();
		int pageSize= vo.getPageSize();
		
		try {
			conn = DBConnection.getConnection();

			if (vo.getCh1() == null || vo.getCh2() == "") {
				String SQL = "select  rownum, Q.* from "
						+ "		(select rownum as rnum, K.* from "
						+ "			(select * from  guestbook order by idx desc) K "
						+ "		where  rownum <= ? ) Q "
						+ " where rnum >= ? ";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, start+pageSize-1);
				pstmt.setInt(2, start);
			} else if (vo.getCh1().equals("name")) {
				String SQL = "select * from guestbook where name like ? order by idx desc";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			} else if (vo.getCh1().equals("title")) {
				String SQL = "select * from guestbook where title like ? order by idx desc";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GuestbookVO m = new GuestbookVO();
				m.setIdx(rs.getInt("idx"));
				m.setName(rs.getString("name"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
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
	public int totalCount(GuestbookVO vo) {
		int totalCount = 0;
		try {
			conn = DBConnection.getConnection();
			if (vo.getCh1() == null || vo.getCh2() == "") {
				String sql = "select count(*) as totalCount from guestbook";
				pstmt = conn.prepareStatement(sql);
			} else if (vo.getCh1().equals("name")) {
				String sql = "select count(*) as totalCount from guestbook where name like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			} else if (vo.getCh1().equals("title")) {
				String sql = "select count(*) as totalCount from guestbook where title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalCount = (rs.getInt("totalCount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		return totalCount;
	}

	@Override
	public void guestbookDelete(int idx) {
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from guestbook where idx=?";
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
