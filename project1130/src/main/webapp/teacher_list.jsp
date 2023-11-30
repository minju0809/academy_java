<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp" %>
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
				<td>강사코드</td>
				<td>강사명</td>
				<td>강의명</td>
				<td>수강료</td>
				<td>강사자격취득일</td>
			</tr>
			<%
			DecimalFormat df = new DecimalFormat("0");
			
			for(TeacherVO m : li) {
				
				String regist_date = (String) m.getTeacher_regist_date().substring(0,4) + "년" +
						(String) m.getTeacher_regist_date().substring(4,6) + "월" +
						(String) m.getTeacher_regist_date().substring(6,8) + "일";
				int price = m.getClass_price();
				df = new DecimalFormat("\u00A4 ###,###");	
				String priceStr = df.format(price);
			%> 
			<tr>
				<td><%=m.getTeacher_code() %></td>
				<td><%=m.getTeacher_name() %></td>
				<td><%=m.getClass_name() %></td>
				<td><%=priceStr %></td>
				<td><%=regist_date %></td>
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