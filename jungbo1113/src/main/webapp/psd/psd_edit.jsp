<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="DBPKG.psd.*"%>
<%@ include file="../include/top.jsp"%>

<%
PsdVO m = (PsdVO) request.getAttribute("m");
int idx = m.getIdx();
String title = m.getTitle();
String fname = m.getFname();
String fimg = m.getFimg();
int age = m.getAge();
String etc = m.getEtc();
%>

<script>
	
</script>

<section>
	<br>
	<div align=center>
		<b>홈쇼핑 회원 사진 상세보기/수정</b>

		<form name="f1" method="post" enctype="multipart/form-data"
			action="<%=path%>/PsdController?sw=U&idx=<%=idx %>">
			 <input  type=hidden name="idx" value="<%=idx %>" >
			<img src=<%=path%>/files/<%=fimg%> width=400 height=250>
			<table border=1>
				<tr>
					<th>제목</th>
					<td><input type=text name="title" value="<%=title%>"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type=text name="fname" value="<%=fname%>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type=text name="age" value="<%=age%>"></td>
				</tr>
				<tr>
					<th>특이사항</th>
					<td><textarea name="etc" cols=30 rows=5><%=etc%></textarea></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type=file name="fimg"></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value='자료수정'></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>