<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.psd.*"%>


<%
String sessionID = (String) session.getAttribute("sessionID");
List<PsdVO> li = (List<PsdVO>) request.getAttribute("li");
%>
<%@ include file="../include/top.jsp"%>
sessionID : <%=sessionID %>

<style>
#city a {
	color: red;
}
</style>

<script>
	
</script>

<section>
	<br>
	<div align=center>
		<b>자료실</b>
	</div>

	<div align=center>
		<table border=1>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>회원성명</th>
				<th>파일명</th>
				<th>이미지</th>
				<th>나이</th>
				<th>특이사항</th>
			</tr>
			<%
			for (PsdVO m : li) {
				int idx = m.getIdx();
				String title = m.getTitle();
				String fname = m.getFname();
				String fimg = m.getFimg();
				int age = m.getAge();
				String etc = m.getEtc();
			%>
			<tr>
				<td><%=idx%></td>
				<td><a href="PsdSelectController?sw=E&idx=<%=idx%>"><%=title%></a></td>
				<td><%=fname%></td>
				<td><%=fimg%></td>
				<td><img src="<%=path%>/files/<%=fimg%>" width=100 height=100></td>
				<td><a href="PsdIUDController?sw=D&idx=<%=idx%>"><%=age%></a></td>
				<td><%=etc%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>
