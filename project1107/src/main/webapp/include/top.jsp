<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header {
	background: #0000ff; /* 배경색깔 */
	height: 90px; /* 영역의 높이 */
	line-height: 90px; /* 라인높이  */
	color: #ffffff; /* 흰색 글자 */
	font-size: 30px; /* 글자 사이즈 */
	text-align: center; /* 글자 정렬 */
}

nav {
	background: #0088ff;
	height: 35px;
	line-height: 35px;
	color: #ffffff;
	font-size: 14px;
	text-align: left;
}

section {
	background: #eaeaea;
	min-height: 500px;
	line-height: 35px;
	font-size: 14px;
}

footer {
	background: #0000ff;
	height: 40px;
	line-height: 40px;
	color: #ffffff;
	font-size: 14px;
	text-align: center;
}

a {
	text-decoration: none;
	color: #ffffff;
}
</style>


</head>
<body>
	<header> (과정평가형 정보처리산업기사) 성적조회 프로그램 Ver1.0 </header>

	<nav>
		&emsp;&emsp;<a href="<%=path%>/TestController">TestController</a>
		&emsp;&emsp;<a href="<%=path%>/member/member.jsp">member</a>
		&emsp;&emsp;<a href="<%=path%>/index.jsp">홈으로</a>
	</nav>