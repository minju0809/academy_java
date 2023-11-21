package DBPKG.money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBConnection;

public class MoneyDaoImpl implements MoneyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MoneyDaoImpl() {
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MoneyVO> getMoney(String sort) {
		List<MoneyVO> list = new ArrayList<MoneyVO>();
		try {
			String SQL = "select member.custno, custname, grade, nvl(sum(money.price), 0) as sumMoney\r\n"
					+ "from member_tbl_02 member left join money_tbl_02 money\r\n"
					+ "on member.CUSTNO = money.CUSTNO\r\n" + "group by member.custno, custname, grade\r\n";

			if (sort.equals("sumMoney")) {
				SQL += "order by sumMoney desc, member.custno asc";
			} else if (sort.equals("custno")) {
				SQL += "order by member.custno asc";
			}
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MoneyVO m = new MoneyVO();
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getString("custname"));
				m.setGrade(rs.getString("grade"));
				m.setSumMoney(rs.getInt("sumMoney"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int maxSalenol() {
		int maxSalenol = 0;
		try {
			String SQL = "select max(salenol)+1 as salenol from money_tbl_02";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxSalenol = rs.getInt("salenol");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxSalenol;
	}

	@Override
	public void insert(MoneyVO moneyVO) {
		try {
			String SQL = "insert into money_tbl_02 " + "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, moneyVO.getCustno());
			pstmt.setInt(2, moneyVO.getSalenol());
			pstmt.setInt(3, moneyVO.getPcost());
			pstmt.setInt(4, moneyVO.getAmount());
			pstmt.setInt(5, moneyVO.getPrice());
			pstmt.setString(6, moneyVO.getPcode());
			pstmt.setDate(7, moneyVO.getSdate());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MoneyVO> getMoneySdate() {
		List<MoneyVO> list = new ArrayList<MoneyVO>();
		try {
			String SQL = "select sdate, sum(price) as sumMoney from money_tbl_02 group by sdate order by sdate";

			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MoneyVO m = new MoneyVO();
				m.setSdate(rs.getDate("sdate"));
				m.setSumMoney(rs.getInt("sumMoney"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
