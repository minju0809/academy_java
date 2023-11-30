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
</head>

<style>
header {
	color: #fff;	
	background-color: blue;
	height: 80px;
	line-height: 80px;
}

nav {
	padding: 0 4px;
	background-color: skyblue;	
	height: 40px;
	line-height: 40px;
}

nav a {
	text-decoration: none;
}

section {
	padding: 0 4px;
	background-color: lightgray;	
	min-height: 600px;
	
}

footer {
	color: #fff;
	padding: 0 4px;
	height: 40px;
	line-height: 40px;
	background-color: blue;
}
	
</style>

<body>

<header>
	<h1  align=center> 골프연습장 회원관리 ver 1.0</h1>
</header>

<nav>
	<a href="<%=path %>/Controller?sw=TeacherSelect">강사조회</a>
	<a href="<%=path %>/Controller?sw=MemberInfoSelect">수강신청</a>
	<a href="<%=path %>/Controller?sw=MemberSelect">회원정보조회</a>
	<a href="<%=path %>/Controller?sw=TeacherPriceSelect">강사매출현황</a>
	<a href="<%=path %>/index.jsp">홈으로</a>
</nav>