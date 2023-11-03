package pkg;

import java.sql.*;

public class DBConnection {
	static String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	static String UID = "system";
	static String PWD = "1234";

	public static Connection getConnection() throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(URL, UID, PWD);
		return con;
	}
}
