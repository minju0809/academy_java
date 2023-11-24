<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.basicBoard.*"%>

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
		<table border=1>
			<tr>
				<th>번호</th>
				<th>사진</th>
				<th>이름</th>
				<th>제목</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<%
			for (BoardVO m : li) {
			%>
			<tr>
				<td><%=m.getIdx() %></td>
				<td><img src="<%=path%>/basicBoard/files/<%=m.getImg() %>" width=30 height=30></td>
				<td><%=m.getSname() %></td>
				<td><a href="<%=path %>/BasicBoardController?sw=E&idx=<%=m.getIdx() %>"><%=m.getTitle() %></a></td>
				<td><%=m.getCnt() %></td>
				<%
				String str = java.net.URLEncoder.encode(m.getImg(), "UTF-8");
				%>
				<td><input type=button value="삭제" onClick="location.href='<%=path %>/BasicBoardController?sw=D&idx=<%=m.getIdx() %>&img=<%=str %>'"></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>