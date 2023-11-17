package DBPKG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MoneyDaoImpl implements MoneyDao {
	DBConnection DBConn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<MoneyVO> money(String order) {
		List<MoneyVO> li = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
//			String SQL = "SELECT rownum, k.* FROM ( "
//					+ " SELECT m1.custno, m1.custname, grade, NVL(SUM(price), 0) AS price "
//					+ " FROM member_tbl_02 m1 "
//					+ " LEFT OUTER JOIN money_tbl_02 m2 ON m1.custno = m2.custno "
//					+ " GROUP BY m1.custno, m1.custname, grade "
//					+ " ORDER BY price DESC ) k "
//					+ " WHERE rownum <= 5";
			String SQL = "";
			if (order.equals("list")) {
				SQL = "SELECT m1.custno, m1.custname, grade, NVL(SUM(price), 0) AS price " + " FROM member_tbl_02 m1 "
						+ " LEFT OUTER JOIN money_tbl_02 m2 ON m1.custno = m2.custno "
						+ " GROUP BY m1.custno, m1.custname, grade " + " ORDER BY price DESC ";
			} else if (order.equals("graph")) {
				SQL = "SELECT m1.custno, m1.custname, grade, NVL(SUM(price), 0) AS price " + " FROM member_tbl_02 m1 "
						+ " LEFT OUTER JOIN money_tbl_02 m2 ON m1.custno = m2.custno "
						+ " GROUP BY m1.custno, m1.custname, grade " + " ORDER BY custno ";
			}
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			MoneyVO m = null;
			while (rs.next()) {
				m = new MoneyVO();
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getString("custname"));
				m.setGrade(rs.getString("grade"));
				m.setMoney(rs.getInt("price"));
				li.add(m);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void moneyInsert(MoneyVO vo) {
		try {
			conn = DBConn.getConnection();
			String SQL = "insert into money_tbl_02 values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setInt(2, vo.getSalenol());
			pstmt.setInt(3, vo.getPcost());
			pstmt.setInt(4, vo.getAmount());
			pstmt.setInt(5, vo.getPrice());
			pstmt.setString(6, vo.getPcode());
			pstmt.setDate(7, vo.getsDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int salenol() {
		int salenol = 0;
		try {
			conn = DBConn.getConnection();
			String SQL = "select max(salenol)+1 as salenol from money_tbl_02 ";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			rs.next();
			salenol = rs.getInt("salenol");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salenol;
	}

	@Override
	public List<MoneyVO> moneySelect(MoneyVO vo) {
		List<MoneyVO> li = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from money_tbl_02 order by custno";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			MoneyVO m = null;
			while (rs.next()) {
				m = new MoneyVO();
				m.setCustno(rs.getInt("custno"));
				m.setSalenol(rs.getInt("salenol"));
				m.setPcost(rs.getInt("pcost"));
				m.setAmount(rs.getInt("amount"));
				m.setPrice(rs.getInt("price"));
				m.setPcode(rs.getString("pcode"));
				m.setsDate(rs.getDate("sDate"));
				li.add(m);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	

	@Override
	public List<MoneyVO> dayMoneySelect(MoneyVO vo) {
		List<MoneyVO> li = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select sDate, sum(price) as price from money_tbl_02 group by sDate";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			MoneyVO m = null;
			while (rs.next()) {
				m = new MoneyVO();
				m.setsDate(rs.getDate("sDate"));
				m.setPrice(rs.getInt("price"));
				li.add(m);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public List<Integer> getMoneySelectCustno() {
		List<Integer> custno = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select custno from money_tbl_02 group by custno order by sdate";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			int m = 0;
			while (rs.next()) {
				rs.getInt("custno");
				custno.add(m);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custno;
	}

}
