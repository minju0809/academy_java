package pkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JungDaoImpl implements JungDao {
	DBConnection DBConn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public JungDaoImpl() {
		DBConn = DBConnection.getInstance();
	}

	@Override
	public void insert(JungVO vo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "insert into examtbl (sNo, sName, kor, eng, math, hist, today, nowDate) values(?,?,?,?,?,?,?,sysdate)";
			System.out.println(vo);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getsNo());
			pstmt.setString(2, vo.getsName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setInt(6, vo.getHist());
			pstmt.setString(7, vo.getToday());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<JungVO> select() {
		List<JungVO> li = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from examtbl order by sNo";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			JungVO m = null;
			while (rs.next()) { // 커서 넘기기
				m = new JungVO();
				m.setsNo(rs.getString("sNo"));
				m.setsName(rs.getString("sName"));
				m.setKor(rs.getInt("kor"));
				m.setEng(rs.getInt("eng"));
				m.setMath(rs.getInt("math"));
				m.setHist(rs.getInt("hist"));
				m.setToday(rs.getString("today"));
				m.setNowDate(rs.getDate("nowDate"));
				m.setCnt(rs.getInt("cnt"));
				li.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public int sNo() {
		int sNo = 0;
		try {
			conn = DBConn.getConnection();
			String SQL = "select max(sNo) + 1 as sNo from examtbl";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			rs.next();
			sNo = rs.getInt("sNo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sNo;
	}

	@Override
	public JungVO edit(int sNo) {
		JungVO m = null;
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from examtbl where sNo = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, sNo);
			rs = pstmt.executeQuery();
			rs.next();
			m = new JungVO();
			m.setsNo(rs.getString("sNo"));
			m.setsName(rs.getString("sName"));
			m.setKor(rs.getInt("kor"));
			m.setEng(rs.getInt("eng"));
			m.setMath(rs.getInt("math"));
			m.setHist(rs.getInt("hist"));
			m.setToday(rs.getString("today"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(JungVO vo) {
		try {
			System.out.println(vo);
			conn = DBConn.getConnection();
			String SQL = "update examtbl set sName=?, kor=?, eng=?, math=?, hist=?, today=? where sNo=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getsName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getHist());
			pstmt.setString(6, vo.getToday());
			pstmt.setString(7, vo.getsNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String sNo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "delete from examtbl where sNo=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, sNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void cnt(String sNo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "update examtbl set cnt=cnt+1 where sNo=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, sNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
