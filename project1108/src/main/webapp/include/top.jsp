<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>

</head>
<body>
	<header> (과정평가형 정보처리산업기사) 성적조회 프로그램 Ver1.0 </header>

	<nav>
		&emsp;<a href="<%=path%>/member/member.jsp">회원가입</a> &emsp;<a
			href="<%=path%>/MemberController?sw=S">회원목록</a> &emsp;<a
			href="<%=path%>/board/board.jsp">글쓰기</a> &emsp;<a
			href="<%=path%>/BoardController?sw=S">글목록</a> &emsp;<a
			href="<%=path%>/index.jsp">홈으로</a>
	</nav>