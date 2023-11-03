<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>오라클 DB 연동</title>
</head>
<body>
	<%
	/* 자바 DB 연동 프로그램 */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userId = "system";
		String pass = "1234";
		con = DriverManager.getConnection(url, userId, pass);

		out.println("Database Connect : [ " + " <b>접속성공</b> ]<br>");
		stmt = con.createStatement();
		rs = stmt.executeQuery("select sysdate from dual");
		if (rs.next()) {
			out.println("Today date : " + rs.getString(1) + "<hr>");
		}
	} catch (Exception e) {
		out.println("Database Connect : [ " + " <b>접속실패</b> ]<br>");
	} finally {
		out.println("프로그램 종료");
		try {
			if (rs != null) {
		rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (stmt != null) {
		stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (con != null) {
		con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>
</body>
</html>
