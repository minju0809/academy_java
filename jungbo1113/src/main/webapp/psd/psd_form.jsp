<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp"%>

<%

%>

<script>
</script>

<section>
	<br>
	<div align=center>
		<b>홈쇼핑 회원 사진 등록</b>

		<form name="f1" method="post" enctype="multipart/form-data"
			action="<%=path%>/PsdController?sw=I">
			<table border=1>
				<tr>
					<th>제목</th> 
					<td><input type=text name="title"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type=text name="fname"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type=text name="age"></td>
				</tr>
				<tr>
					<th>특이사항</th>
					<td><textarea name="etc" cols=30 rows=5></textarea></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type=file name="fimg"></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value='자료등록'></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>