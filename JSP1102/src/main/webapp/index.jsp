<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
System.out.println("path: " + path);
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
		<br>
		<h1>시작페이지</h1>
		<div class="practice1">
			<a href="<%=path%>/member/member_form.jsp" style="--clr:#6eff3e"><span>회원가입</span><i></i></a>
			<a href="<%=path%>/JoinController?select=s" style="--clr:#ff1867"><span>회원목록</span><i></i></a>
		</div>
	</div>
</body>
</html>