<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.*"%>

<%
String path = request.getContextPath();

MemberVO m = (MemberVO) request.getAttribute("m");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>

<style>
* {
	margin: 0;
	padding: 4px;
}

a {
	text-decoration: none;
	color: #fff;
}

header {
	background: #ff00ff;
	height: 90px;
	line-height: 90px;
	color: #fff;
	font-size: 30px;
	text-align: center;
}

nav {
	background: #00ff;
	height: 40px;
	line-height: 40px;
	color: #fff;
}

section {
	min-height: 500px;
	background: #e2e2e2;
}

footer {
	background: #ff00ff;
	height: 40px;
	line-height: 40px;
}
</style>

</head>
<body>
	<header>쇼핑몰 회원관리 ver 1.0</header>
	<nav>
		<a href="<%=path%>/JungboController?sw=F">회원등록</a> <a
			href="<%=path%>/JungboController?sw=S">회원목록조회/수정</a> <a
			href="<%=path%>/JungboController?sw=M">회원매출조회</a> <a
			href="<%=path%>/index.jsp">홈으로</a>
	</nav>

	<section>
		<br>
		<div align=center>
			<b>홈쇼핑 회원 정보 수정</b>

			<form name="f1" action="<%=path%>/JungboController"
				onsubmit="return ck()">
				<input type=hidden name="sw" value="I">
				<table border=1>
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input type=text name="custno" value="<%=m.getCustno() %>"
							readonly></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type=text name="custname"  value="<%=m.getCustname() %>"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type=text name="phone" value="<%=m.getPhone() %>"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type=text name="address" size=50  value="<%=m.getAddress() %>"></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type=text name="joindate"
							value="<%=m.getJoindate()%>"></td>
					</tr>
					<tr>
						<th>고객등급 [A:VIP,B:일반,C:직원]</th>
						<td><input type=text name="grade" value="<%=m.getGrade() %>"></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type=text name="city"  value="<%=m.getCity() %>"></td>
					</tr>
					<tr>
						<td align=center colspan=2><input type=submit value='등록'>
							<input type=button value='조회' onClick="listK()"></td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</section>
	<footer>&copy;</footer>
</body>
</html>