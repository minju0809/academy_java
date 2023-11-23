<<<<<<< HEAD
<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<link href="<%=path%>/css/style.css" rel=stylesheet type="text/css" />

</head>
<body>
	<header>게시판 만들기 프로젝트 ver 1.0</header>
	<nav>
		<a href="<%=path%>/basicBoard/board_write.jsp">게시판글쓰기</a>
		<a href="<%=path%>/BasicBoardController?sw=S">게시판목록보기</a>
		
		<a href="<%=path%>/commentBoard/board_write.jsp">코맨트글쓰기</a>
		<a href="<%=path%>/CommentController?sw=S">코맨트목록보기</a>
		
		<a href="<%=path%>/reBoard/board_write.jsp">답변형글쓰기</a>
		<a href="<%=path%>/ReBoardController?sw=S">답변형목록보기</a>
		<a href="<%=path%>/index.jsp">홈으로</a>
=======
<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<link href="<%=path%>/css/style.css" rel=stylesheet type="text/css" />

</head>
<body>
	<header>게시판 만들기 프로젝트 ver 1.0</header>
	<nav>
		<a href="<%=path%>/basicBoard/board_write.jsp">게시판글쓰기</a>
		<a href="<%=path%>/BasicBoardController?sw=S">게시판목록보기</a>
		
		<a href="<%=path%>/commentBoard/board_write.jsp">코맨트글쓰기</a>
		<a href="<%=path%>/CommentController?sw=S">코맨트목록보기</a>
		<a href="<%=path%>/index.jsp">홈으로</a>
>>>>>>> 37c817c84e9ceefc2fab1390af0949fde27c29fe
	</nav>