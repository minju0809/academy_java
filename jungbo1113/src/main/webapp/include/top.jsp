<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<link href="<%=path %>/css/style.css" rel=stylesheet type="text/css" />

</head>
<body>
	<header>쇼핑몰 회원관리 ver 1.0</header>
	<nav>
		<a href="<%=path %>/JungboController?sw=F">회원등록</a>
		<a href="<%=path %>/JungboController?sw=S">회원목록조회/수정</a>
		<a href="<%=path %>/MoneyController?sw=M">회원매출조회</a>
		<a href="<%=path %>/MoneyController?sw=F">매출등록</a>
		<a href="<%=path %>/MoneyController?sw=ML1">매출그래프1</a>
		<a href="<%=path %>/MoneyController?sw=ML2">매출그래프2</a>
		<a href="<%=path %>/MoneyController?sw=S">매출목록</a>
		<a href="<%=path %>/MoneyController?sw=DayS">일별매출목록</a>
		<a href="<%=path %>/psd/psd_form.jsp">자료등록</a>
		<a href="<%=path %>/PsdSelectController?sw=S">자료실</a>
		<a href="<%=path %>/index.jsp">홈으로</a>
	</nav>