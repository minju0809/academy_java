<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="./include/top.jsp" />
<%@ page import="java.util.*" %>
<%@ page import="DBPKG.teacher.TeacherVO" %>
<%@ page import="java.text.DecimalFormat" %>


<%
List<TeacherVO> li = (List<TeacherVO>) request.getAttribute("li");
%>
<section>
	<br>
	<h2 align=center>강사조회</h2>
	<table border=1 align=center>
		<tr>
			<td>순번</td>
			<td>강사코드</td>
			<td>강사명</td>
			<td>강의명</td>
			<td>수강료</td>
			<td>강사자격취득일</td>
		</tr>
		<c:forEach items="${ li }" var="m" varStatus="status">
			<c:set  var="TRD" value="${ m.teacher_regist_date }"/>
			<c:set  var="i" value="${ i = i + 1 }"/> 
			
			<c:if test="${ i%2 == 1 }">
				<c:set var="bg" value="skyblue" />
			</c:if>
			<c:if test="${ i%2 == 0 }">
				<c:set var="bg" value="yellow" />
			</c:if>
					
			<tr bgcolor= "${ bg }">
				<td>${ i } / ${ status.count }</td>
				<td><a href="Controller?sw=TeacherJSTL&code=${ m.getTeacher_code() }&name=${ m.getClass_name() }">${ m.getTeacher_code() }</a></td>
				<c:url var="url" value="/Controller">
					<c:param name="sw">TeacherJSTL</c:param>
					<c:param name="code">${ m.getTeacher_code() }</c:param>
					<c:param name="name">${ m.getClass_name() }</c:param>
				</c:url>
				<td><a href="${ url }">${ m.getTeacher_name() }</a></td>
				<td>${ m.getClass_name() }</td>
				<td><fmt:formatNumber value="${ m.class_price }" type="currency" currencySymbol="￦" /></td>
				<td>${ fn:substring(TRD, 0, 4) }년 
					${ fn:substring(TRD, 4, 6) }월 
					${ fn:substring(TRD, 6, 8) }일</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</section>
<footer align=center>
	HRDKOREA Copyright&copy;2016 All rights reserved. Human Resources Development Service of Korea.
</footer>

</body>
</html>