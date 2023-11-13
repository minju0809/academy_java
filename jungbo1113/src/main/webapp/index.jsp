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
		<div align=center><b>쇼핑몰 회원관리 프로그램</b></div>
		<div>
			쇼핑몰 회원정보와 회원대출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
			프로그램 작성 순서<br>
			1. 회원정보 테이블을 생성한다.<br>
			2. 매출정보 테이블을 생성한다.<br>
			3. 회원정보, 매출정보 테이블에 제시된 문제지와 참조데이터를 추가 생성한다.<br>
			4. 회원정보 입력 화면프로그램을 작성한다.<br>
			5. 회원정보 조회 프로그램을 작성한다.<br>
			6. 회원매출정보 조회 프로그램을 작성한다.<br>
		</div>
	<br>
	</section>
	<footer>HRDOKREA Copyright&copy; All rights reserved. Human Resources Development Service of Korea.</footer>
</body>
</html>