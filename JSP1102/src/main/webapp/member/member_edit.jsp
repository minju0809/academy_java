<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="pkg.service.*"%>
<%@ page import="pkg.model.*"%>
<%@ page import="java.util.*"%>

<%
String path = request.getContextPath();

@SuppressWarnings("unchecked")
MemberVO m = (MemberVO) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>회원 정보 상세 보기</h2>
		<table border=1>
			<tr>
				<th>아이디</th>
				<td><%=m.getId()%></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=m.getName()%></td>
			</tr>
			<tr>

				<th>암호</th>
				<td><%=m.getPwd()%></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=m.getEmail()%></td>
			</tr>
		</table>
		<div class="practice1">
			<a href="<%=path%>/JoinController?id=<%=m.getId()%>&select=d" style="--clr: #ff1867"><span>삭제</span><i></i></a>
			<a href="<%=path%>/index.jsp" style="--clr: #1e9bff"><span>홈으로</span><i></i></a>
		</div>
</body>
</html>