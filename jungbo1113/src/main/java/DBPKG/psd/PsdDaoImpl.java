package DBPKG.psd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSetInternal;

//import org.apache.coyote.Request;
//import org.apache.tomcat.dbcp.dbcp2.PStmtKey;
//import org.apache.tomcat.jni.Sockaddr;

import DBPKG.DBConnection;
import DBPKG.money.MoneyVO;

public class PsdDaoImpl implements PsdDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(PsdVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "insert into psd_table (idx, title, fname, fimg, age, etc) values (psdS.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getFname());
			pstmt.setString(3, vo.getFimg());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getEtc());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<PsdVO> select(PsdVO vo) {
		List<PsdVO> li = new ArrayList<PsdVO>();
		try {
			System.out.println("List<PsdVO> select ===> " + vo.getCh1() + ": " + vo.getCh2());
			
			conn = DBConnection.getConnection();
			
	         String ch1 = vo.getCh1();
	         String ch2 = vo.getCh2();
	         String SQL = "";

			
			if(ch1 == null || ch2 == null) {
				SQL = "select * from psd_table order by idx desc";
				pstmt = conn.prepareStatement(SQL);
			} else if (ch1.equals("title")) {
				SQL = "select * from psd_table where title like ?";
				pstmt = conn.prepareStatement(SQL);
				 pstmt.setString(1, "%"+ch2+"%");
			} else if (vo.getCh1().equals("fname")) {
				SQL = "select * from psd_table where fname like ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%"+ch2+"%");
			}
		
			rs = pstmt.executeQuery();

			PsdVO m = null;
			while (rs.next()) {
				m = new PsdVO();
				m.setIdx(rs.getInt("idx"));
				m.setTitle(rs.getString("title"));
				m.setFname(rs.getString("fname"));
				m.setFimg(rs.getString("fimg"));
				m.setAge(rs.getInt("age"));
				m.setEtc(rs.getString("etc"));
				li.add(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void delete(int idx) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "delete from psd_table where idx=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String selectFileName(int idx) {
		String fimg = null;
		try {
			conn = DBConnection.getConnection();
			String SQL = "select fimg from psd_table where idx=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			rs.next();
			fimg = rs.getString("fimg");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fimg;
	}

	@Override
	public PsdVO edit(int idx) {
		PsdVO m = null;
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from psd_table where idx=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new PsdVO();
				m.setIdx(rs.getInt("idx"));
				m.setTitle(rs.getString("title"));
				m.setFname(rs.getString("fname"));
				m.setFimg(rs.getString("fimg"));
				m.setAge(rs.getInt("age"));
				m.setEtc(rs.getString("etc"));
				System.out.println("edit" + m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(PsdVO vo) {
		try {
			conn = DBConnection.getConnection();

				String SQL = "update psd_table set title=? , fname = ?, fimg = ?, age = ?, etc = ? where idx = ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getFname());
				pstmt.setString(3, vo.getFimg());
				pstmt.setInt(4, vo.getAge());
				pstmt.setString(5, vo.getEtc());
				pstmt.setInt(6, vo.getIdx());
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
