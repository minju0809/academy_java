<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="pkg.service.*"%>
<%@ page import="pkg.model.*"%>
<%@ page import="java.util.*"%>

<%
String path = request.getContextPath();

@SuppressWarnings("unchecked")
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li"); // SelectController 의 "li"를 가지고 옴
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
		<h2>회원 목록 보기</h2>
		<table border=1>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>암호</th>
				<th>이메일</th>
			</tr>
			<%
			for (MemberVO m : li) {
			%>
			<tr>
				<td><%=m.getId()%></td>
				<td><a href="<%=path%>/EditController?id=<%=m.getId()%>&select=e"><%=m.getName()%></a></td>
				<td><%=m.getPwd()%></td>
				<td><%=m.getEmail()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div class="practice1">
			<a href="<%=path%>/index.jsp" style="--clr: #1e9bff"><span>홈으로</span><i></i></a>
		</div>
	</div>
</body>
</html>