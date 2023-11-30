<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="DBPKG.member.MemberVO" %>
<%@ page import="java.text.DecimalFormat" %>

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
				<td><%=m.getC_no() %></td>
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