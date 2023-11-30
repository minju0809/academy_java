<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="DBPKG.teacher.TeacherVO" %>
<%@ page import="java.text.DecimalFormat" %>

<%
List<TeacherVO> priceList = (List<TeacherVO>) request.getAttribute("priceList");
%>
<section>
	<br>
		<h2 align=center>강사매출현황</h2>
		<table border=1 align=center>
			<tr>
				<td>강사코드</td>
				<td>강의명</td>
				<td>강사명</td>
				<td>총매출</td>
			</tr>
			<%
			DecimalFormat df = new DecimalFormat("0");
			
			for(TeacherVO m : priceList) {
				
				int price = m.getTuition();
				df = new DecimalFormat("\u00A4 ###,###");	
				String priceStr = df.format(price);
			%> 
			<tr>
				<td><%=m.getTeacher_code() %></td>
				<td><%=m.getClass_name() %></td>
				<td><%=m.getTeacher_name() %></td>
				<td><%=priceStr %></td>
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