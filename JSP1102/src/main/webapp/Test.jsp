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
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234qa");

		if (con != null) {
			out.println("Database Connect : [ " + " <b>접속 성공</b> ]<br>");
		}
		;

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select sysdate from dual");

		while (rs.next()) {
			out.println("Today date : " + rs.getString(1) + "<hr>");
		}

		stmt.close();
		con.close();

	} catch (Exception e) {
		e.printStackTrace();
		out.println("Database Connect : [ " + " <b>접속 실패</b> ]<br>");
	}
	%>

	<footer>
		<address>
			<center>
				Web site Layout DB Connection Page.<br> Home page :
				http://www.visiongongjang.com <br> mobile : 010-2222-3333 <br>
			</center>
		</address>
	</footer>
</body>

</html>