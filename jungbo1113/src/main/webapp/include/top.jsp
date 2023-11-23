<%@ page language="java" pageEncoding="UTF-8"%>
    
<% 
String path=request.getContextPath(); 
String id= (String) session.getAttribute("id"); 
String id2= (String) session.getAttribute("id2"); 

/* if (id1 == null) {
	session.setAttribute("id1", "guest");
	response.sendRedirect(path+"/LoginController?sw=login");
} */
%>

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
	<% if (id == null) { %>
		<a href="<%=path %>/index.jsp">홈으로</a>
		<a href="<%=path %>/login/login.jsp">로그인</a>
		<% } else {
			if (id2.equals("A")) { %>
			<a href="<%=path%>/MemberController?sw=F">회원등록</a>
			<a href="<%=path%>/MemberController?sw=S">회원목록조회/수정</a>
			<a href="<%=path%>/MemberController?sw=M">회원매출조회</a>
			<a href="<%=path%>/MemberController?sw=ML1">매출그래프1</a>
			<a href="<%=path%>/MemberController?sw=ML2">매출그래프2</a>
			<a href="<%=path%>/MoneyController?sw=MF">주문등록</a>
			<a href="<%=path%>/MoneyController?sw=S">매출목록</a>
			<a href="<%=path%>/MoneyController?sw=DayS">일별매출목록</a>
			<a href="<%=path%>/psd/psd_form.jsp">자료등록</a>
			<a href="<%=path%>/PsdController?sw=S">자료실</a>
			<a href="<%=path%>/LoginController?sw=logout"><%=id %>(logout)</a>
			<a href="<%=path%>/index.jsp">홈으로</a>
		<% } else if (id2.equals("B")) { %>
			<a href="<%=path %>/MemberController?sw=F">회원등록</a>
			<a href="<%=path %>/MemberController?sw=S">회원목록조회/수정</a>
			<a href="<%=path %>/MoneyController?sw=M">회원매출조회</a>
			<a href="<%=path %>/MoneyController?sw=ML1">매출그래프1</a>
			<a href="<%=path %>/MoneyController?sw=ML2">매출그래프2</a>
			<a href="<%=path %>/MoneyController?sw=F">매출등록</a>
			<a href="<%=path %>/MoneyController?sw=S">매출목록</a>
			<a href="<%=path %>/MoneyController?sw=DayS">일별매출목록</a>
			<a href="<%=path %>/psd/psd_form.jsp">자료등록</a>
			<a href="<%=path %>/PsdController?sw=S">자료실</a>
			<a href="<%=path %>/login/login.jsp">로그인</a>
			<a href="<%=path %>/LoginController?sw=logout"><%=id %>(logout)</a>
			<a href="<%=path %>/index.jsp">홈으로</a>
		<% } else if (id2.equals("C")) { %>
			<a href="<%=path %>/MemberController?sw=F">회원등록</a>
			<a href="<%=path %>/MoneyController?sw=F">매출등록</a>
			<a href="<%=path %>/psd/psd_form.jsp">자료등록</a>
			<a href="<%=path %>/login/login.jsp">로그인</a>
			<a href="<%=path%>/LoginController?sw=logout"><%=id %>(logout)</a>
			<a href="<%=path %>/index.jsp">홈으로</a>
		<%
		}
	} 
	%>
	</nav>