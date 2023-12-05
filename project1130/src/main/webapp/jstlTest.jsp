<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<c:forEach var="dan" begin="2" end="9" step="1">
		<c:if test="${ dan%3==0 }">
			<tr bgcolor="yellow">
				<c:forEach var="gugu" begin="1" end="9" step="1">
					<td><c:out value="${ dan }*${ gugu }=${ dan * gugu }" /></td>
				</c:forEach>
			</tr>
		</c:if>
		<c:if test="${ dan%3!=0 }">
			<tr bgcolor="green">
				<c:forEach var="gugu" begin="1" end="9" step="1">
					<td><c:out value="${ dan }*${ gugu }=${ dan * gugu }" /></td>
				</c:forEach>
			</tr>
		</c:if>
		</c:forEach>
	</table>
</body>
</html>