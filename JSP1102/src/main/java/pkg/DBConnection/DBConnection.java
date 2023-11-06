package pkg.DBConnection;

import java.sql.*;

public class DBConnection {

	// [ 싱글톤 1 ]
	// 클래스를 싱글톤으로 생성한다. 싱글톤은 클래스 외부에서는 객체를 생성할 수 없고
	// 클래스 안에서 생성한 하나의 객체를 공용으로 사용하는 방법이다.
	// 현재 객체를 static 으로 생성하여 클래스 밖에서 헤당 클래스의 객체 생성 없이 사용할 수 있게 한다.
	private static DBConnection db = new DBConnection();
	private Connection conn = null;

	String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/xe";
	String dbId = "system";
	String dbPass = "1234";

	// [ 싱글톤 2 ]
	// 생성자를 private 으로 구현하여 클래스 밖에서는 객체를 생성할 수 없다.
	private DBConnection() {
	}

	// [ 싱글톤 3 ]
	// 싱글톤으로 생성한 객체가 private 이므로 클래스 밖에서 이 객체를 획득할 수 있도록 getter 를 제공한다.
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
