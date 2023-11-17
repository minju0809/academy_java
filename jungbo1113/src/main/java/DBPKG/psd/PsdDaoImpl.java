package DBPKG.psd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import DBPKG.DBConnection;
import DBPKG.MoneyVO;

public class PsdDaoImpl implements PsdDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void insert(PsdVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "insert into psd_table (idx,fname,fimg) values (psdS.nextval,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getFname());
			pstmt.setString(2, vo.getFimg());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<PsdVO> select() {
		List<PsdVO> li = new ArrayList<PsdVO>();
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from psd_table";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			PsdVO m = null;
			while (rs.next()) {
				m = new PsdVO();
				m.setIdx(rs.getInt("idx"));
				m.setFname(rs.getString("fname"));
				m.setFimg(rs.getString("fimg"));
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
