<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
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
		<h2>회원가입하기</h2>
		<form action="<%=path%>/JoinController">
		<input type = hidden name = "select" value = "i">
			이름: <input type=text name="name" /><br> 
			암호: <input type=text name="pwd" /><br> 
			메일: <input type=text name="email" /><br>

			<input type=submit value="가입하기" /> <input type=reset value="가입취소" />
		</form>
		<div class="practice1">
			<a href="<%=path%>/index.jsp"style="--clr: #1e9bff"><span>홈으로</span><i></i></a>
		</div>
	</div>
</body>
</html>