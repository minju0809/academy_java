<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.psd.*"%>


<%
// String sessionID = (String) session.getAttribute("sessionID");
List<PsdVO> li = (List<PsdVO>) request.getAttribute("li");
%>

<%@ include file="../include/top.jsp"%>

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
		<b>쇼핑몰 목록조회/수정</b>
	</div>

	<div align=center>
		<table border=1>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>회원성명</th>
				<th>파일명</th>
				<th>사진</th>
				<th>나이</th>
			</tr>
			<%
			for (PsdVO m : li) {
				int idx = m.getIdx();
				String title = m.getTitle();
				String fname = m.getFname();
				String fimg = m.getFimg();
				int age = m.getAge();
			%>
			<tr>
				<td><%=idx%></td>
				<td><a href="PsdController?sw=E&idx=<%=idx%>"><%=title%></a></td>
				<td><%=fname%></td>
				<td><%=fimg%></td>
				<td><img src="<%=path%>/files/<%=fimg%>" width=70 height=50></td>
				<td><a href="PsdController?sw=D&idx=<%=idx%>"><%=age%></a></td>
			</tr>
			<%
			}
			%>
		</table>
		<form action="<%=path%>/PsdController">
		<input type=hidden name=sw value="S">
			<select name=ch1>
				<option value=title>제목</option>
				<option value=fname>이름</option>
			</select> 
			<input type=text name=ch2> 
			<input type=submit value="검색하기">
		</form>
	</div>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>