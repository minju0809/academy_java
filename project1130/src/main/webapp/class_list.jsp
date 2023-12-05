<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<%@ page import="java.util.*"%>
<%@ page import="DBPKG.member.ClassVO"%>

<section>
	<br> 
	<h2 align=center>수강정보현황 [<c:out value="${ k }"></c:out>]</h2> 
	<table border=1 align=center>
		<tr>
			<td>수강월</td>
			<td>회원번호</td>
			<td>회원명</td>
			<td>수강료</td>
			<td>강사코드</td>
			<td>강사명</td>
		</tr>
		<c:forEach items="${classList}"  var="m" >
			<c:set  var="RM" value="${ m.getRegist_month() }"/>
			<fmt:formatNumber var="tuition" value="${ m.getTuition() }" type="currency" currencySymbol="￦" />
			
            <c:set var="bgcolorArr" value="${fn:split('green,yellow,orange,blue,gold,blue,cyan,deeppink,aqua,brown,red,black',',')}" />
            <c:set var="colorIndex" value="${fn:substring(m.getRegist_month(),4,6)}"></c:set>
            <c:set var="bgcolor" value="${bgcolorArr[colorIndex-1]}"></c:set>

			<c:set var="no">${m.getC_no()}</c:set>
			<c:choose>
				<c:when test="${ no == '10001' }">
					<c:set var="name" value="홍길동"></c:set>
				</c:when>
				<c:when test="${ no == '10002' }">
					<c:set var="name" value="장발장"></c:set>
				</c:when>
				<c:when test="${ no == '10003' }">
					<c:set var="name" value="임꺽정"></c:set>
				</c:when>
				<c:when test="${ no == '20001' }">
					<c:set var="name" value="성춘향"></c:set>
				</c:when>
				<c:when test="${ no == '20002' }">
					<c:set var="name" value="이몽룡"></c:set>
				</c:when>
			</c:choose>
		
			<tr bgcolor="${bgcolor}">
				<td>${ fn:substring(RM, 0, 4) }년${ fn:substring(RM, 4, 6) }월 </td>
				<td>${ m.getC_no() }(<c:out value="${ name }"></c:out>)</td>
				<td>${ m.getClass_area() }</td>
				<td>${ tuition }</td>
				<td>${ m.getTeacher_code() }</td>
				<td>${ m.getTeacher_name() }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>