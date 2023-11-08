<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<br>
	<div align="center">
		<h2>글쓰기</h2>
	</div>
	<div align="center">
		<form action="<%=path%>/BoardController">
		<input type=hidden name=sw value="I">
			<table border=1 width=350>
				<tr>
					<th>제목</th>
					<td>&nbsp;<input type=text name=title></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>&nbsp;<textarea cols=30 rows=6 name=content></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="글 저장"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>