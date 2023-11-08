<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%@ page import="java.util.*"%>
<%@ page import="pkg.board.BoardVO"%>

<%
BoardVO m = (BoardVO) request.getAttribute("m");

int num_id = m.getNum_id();
String title = m.getTitle();
String content = m.getContent();
%>

<section>
	<div align="center">
		<h2>상세보기</h2>
	</div>
	<div align="center">
		<table border=1>
			<tr>
				<th>번호</th>
				<td><%=num_id%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=title%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=content%></td>
			</tr>
		</table>
	</div>
</section>

<%@ include file="/include/bottom.jsp"%>