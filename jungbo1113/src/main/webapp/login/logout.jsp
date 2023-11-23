<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<section>
	<br>
	<%
	session.invalidate();
	response.sendRedirect(path+"/index.jsp");
	%>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>

