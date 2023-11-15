<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<link href="./css/style.css" rel=stylesheet type="text/css" />

</head>
<body>
	<header>쇼핑몰 회원관리 ver 1.0</header>
	<nav>
		<a href="<%=path %>/JungboController?sw=F">회원등록</a>
		<a href="<%=path %>/JungboController?sw=S">회원목록조회/수정</a>
		<a href="<%=path %>/JungboController?sw=M">회원매출조회</a>
		<a href="<%=path %>/JungboController?sw=ML1">매출그래프1</a>
		<a href="<%=path %>/JungboController?sw=ML2">매출그래프2</a>
		<a href="<%=path %>/index.jsp">홈으로</a>
	</nav>