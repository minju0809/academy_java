package DBPKG.login;

import java.sql.*;

import DBPKG.DBConnection;

public class LoginDaoImpl implements LoginDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public String login(LoginVO vo) {
		
		String str = "";
		try {
			conn = DBConnection.getConnection();
			String SQL = "select * from member_tbl_02 where custname=? and pwd=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getCustname());
			pstmt.setString(2, vo.getPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				str = rs.getString("grade");
			} else {
				str = "F";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
