
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.comment.*"%>

<%@ include file="/include/top.jsp"%>

<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
@SuppressWarnings("unchecked")
List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");
%>

<section>
	<br>
	<div align=center>
		<h2>코맨트 글 목록보기</h2>
		<table border=1>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>우편번호</th>
				<th>주소</th>
				<th>상세주소</th>
				<th>참고항목</th>
				<th>조회수</th>
			</tr>
			<%
			for (BoardVO m : li) {
			%>
			<tr>
				<td><%=m.getIdx() %></td>
				<td><%=m.getSname() %></td>
				<td><a href="<%=path %>/CommentController?sw=E&idx=<%=m.getIdx() %>"><%=m.getTitle() %></a></td>
				<td><%=m.getPostcode() %></td>
				<td><%=m.getAddress() %></td>
				<td><%=m.getDetail_address() %></td>
				<td><%=m.getExtra_address() %></td>
				<td><%=m.getCnt() %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>