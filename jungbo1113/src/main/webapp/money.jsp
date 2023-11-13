<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<style>
	* {
		margin: 0;
		padding: 4px;
	}
	
	a {
		text-decoration: none;
		color: #fff;
	}

	header {
		background: #ff00ff;
		height: 90px;
		line-height: 90px;
		color: #fff;
		font-size: 30px;
		text-align: center;
	}
	
	nav {
		background: #00ff;
		height: 40px;
		line-height: 40px;
		color: #fff;
	}

	section {
		min-height: 500px;
		background: #e2e2e2;
	}
		
	footer {
		background: #ff00ff;
		height: 40px;
		line-height: 40px;
	}
</style>
</head>
<body>
	<header>쇼핑몰 회원관리 ver 1.0</header>
	<nav>
		<a href="<%=path %>/JungboController?sw=F">회원등록</a>
		<a href="<%=path %>/JungboController?sw=S">회원목록조회/수정</a>
		<a href="<%=path %>/JungboController?sw=M">회원매출조회</a>
		<a href="<%=path %>/index.jsp">홈으로</a>
	</nav>
	<section>
	<br>
		<div align=center><b>회원매출조회</b></div>
		<div>
			
		</div>
	<br>
	</section>
	<footer>HRDOKREA Copyright&copy; All rights reserved. Human Resources Development Service of Korea.</footer>
</body>
</html>