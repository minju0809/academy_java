<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page info="copyright by Kang 2023-11-20"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 입문</h2>
	<hr />
	
	<%="처음으로 작성하는 JSP 페이지"%>
	<%-- 주석처리 --%>
	<%
	// 주석처리
	/* 여러 줄 주석 */ 
	%>
	<hr />
	
	<!-- HTML 주석 -->
	
	<%
	Timestamp now = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = format.format(now);
	%>

	오늘은
	<%=strDate%>
	입니다.
	<hr />
	
	<h2>page 디렉티브 연습 - info 속성</h2>
	<%=getServletInfo()%>
	<hr />
	
	<%!// 선언문 : 전역 변수 선언
	String str = "young";%>
	<%
	// 스크립트릿 : 지역 변수 
	String name = "Choi";
	%>

	<%=str%>
	<%=name%>
	<hr />
	
	<%
	String[] str = { "jsp", "java", "android", "html5" };
	int i = (int) (Math.random() * 4);
	%>
	<%=str[i]%>가(이) 재미있다.
</body>
</html>