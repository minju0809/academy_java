<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연동</title>
</head>
<body>

	<h3>Data base 연동 샘플</h3>
	<hr>
	<%
	/* 자바 DB 연동 프로그램 */
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		// 1. 드라이버 연동
		Class.forName("oracle.jdbc.OracleDriver");
		// 2. 객체 연결
		con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");

		out.println("Database Connect : [ " + " <b>success</b> ]<br>");
		// 3. 쿼리 생성
		stmt = con.createStatement();
		// 4. 쿼리 수행
		rs = stmt.executeQuery("select sysdate from dual");
		if (rs.next()) {
			out.println("Today date : " + rs.getString(1) + "<hr>");
		}
	} catch (Exception e) {
		//  e.printStackTrace();
		out.println("Database Connect : [ " + " <b>접속실패</b> ]<br>");
	} finally {
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

	<footer>
		<div align="center">
			<address>
				Web site Layout DB Connection Page.<br> Home page :
				http://www.visiongongjang.com <br> mobile : 010-2222-3333 <br>
			</address>
		</div>
	</footer>

</body>
</html>
