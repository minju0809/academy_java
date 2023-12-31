<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="DBPKG.member.MemberVO" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");
%>
<section>
	<br>
		<h2 align=center>회원정보조회</h2>
		<table border=1 align=center>
			<tr>
				<td>수강월</td>
				<td>회원번호</td>
				<td>회원명</td>
				<td>강의명</td>
				<td>강의장소</td>
				<td>수강료</td>
				<td>등급</td>

			</tr>
			<%
			DecimalFormat df = new DecimalFormat("0");
			
			for(MemberVO m : li) {
				String regist_month = (String) m.getRegist_month().substring(0,4) + "년" +
						(String) m.getRegist_month().substring(4,6) + "월";
				int tuition = m.getTuition();
				df = new DecimalFormat("\u00A4 ###,###");	
				String tuitionStr = df.format(tuition);
				
			%> 
			<tr>
				<td><%=regist_month %></td>
				<td>
					<a href="<%=path %>/Controller?sw=MemberDetail&c_no=<%=m.getC_no() %>"><%=m.getC_no() %></a>
					<c:url var="url" value="/Controller">
						<c:param name="sw">MemberDetail</c:param>
						<c:param name="c_no" value="<%=m.getC_no() %>"></c:param>
					</c:url>
					<a href="${ url }"><%=m.getC_no() %></a>
				</td>
				<td><%=m.getC_name() %></td>
				<td><%=m.getClass_name() %></td>
				<td><%=m.getClass_area() %></td>
				<td><%=tuitionStr %></td>			
				<td><%=m.getGrade() %></td>
			</tr>
			<%
			}
			%>
		</table>
	<br>
</section>
<footer align=center>
	HRDKOREA Copyright&copy;2016 All rights reserved. Human Resources Development Service of Korea.
</footer>

</body>
</html>