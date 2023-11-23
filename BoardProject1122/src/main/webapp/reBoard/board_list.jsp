<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.reBoard.*"%>

<%@ include file="/include/top.jsp"%>

<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
@SuppressWarnings("unchecked")
List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");
%>

<section>
	<br>
	<div align=center>
		<h2>게시판 글 목록보기</h2>
		<table border=1 width=700>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>조회수</th>
				<th>ref</th>
				<th>레벨</th>
				<th>스텝</th>
				<th>삭제</th>
			</tr>
			<%
			int w = 0;
			for (BoardVO m : li) {
				w = (m.getRe_level() * 20) - 20;
			%>
			<tr>
				<td><%=m.getIdx() %></td>
				<td><%=m.getSname() %></td>
				<td>
					<img src="<%=path %>/img/space.png" width=<%=w %> height=10>
					<% if (m.getRe_level() > 1) { %>
						<img src="<%=path %>/img/review.png" width=12 height=12>
					<% } %>
					<a href="<%=path %>/ReBoardController?sw=E&idx=<%=m.getIdx() %>"><%=m.getTitle() %></a>
				</td>
				<td><%=m.getCnt() %></td>
				<td><%=m.getRef() %></td>
				<td><%=m.getRe_level() %></td>
				<td><%=m.getRe_step() %></td>
				<td><a href="<%=path %>/ReBoardController?sw=D&idx=<%=m.getIdx() %>">삭제</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>