package pkg;

import java.sql.*;

public class DBConnection {

	private static DBConnection db = new DBConnection();
	private Connection conn = null;

	String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/xe";
	String dbId = "system";
	String dbPass = "1234";

	private DBConnection() {
	}

	public static DBConnection getInstance() {
		return db;
	}

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
