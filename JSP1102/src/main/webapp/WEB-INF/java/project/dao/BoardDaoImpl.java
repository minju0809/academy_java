package project.dao;

import java.sql.*;

import project.BoardVO;
import project.conn.DBConnection;

public class BoardDaoImpl implements BoardDao {
	public Connection conn = null;
	public PreparedStatement pstmt = null;

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConnection.getConnection();
			String SQL = "insert into T1102 (name, age) values (?,?)";
			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getAge());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
