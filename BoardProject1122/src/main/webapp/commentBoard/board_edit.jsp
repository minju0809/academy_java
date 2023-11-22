<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*"%>
<%@ page import="board.comment.*"%>

<%@ include file="/include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
BoardVO m = (BoardVO)request.getAttribute("m");
List<CommentVO> li = (List<CommentVO>)request.getAttribute("li");
%>

<section>
	<br>
	<div align=center>
		<h2>코맨트 글 상세보기/수정하기</h2>
		<form action="<%=path %>/CommentController" method=get >
		<input type=hidden name=sw value="U">
		
			<table border=1 width=500>
				<tr><th>번호</th><td><input type=text name=idx size=10 value="<%=m.getIdx()%>" readonly></td></tr>
				<tr><th>제목</th><td><input type=text name=title size=30  value="<%=m.getTitle()%>"></td></tr>
				<tr><th>글쓴이</th><td><input type=text name=sname  value="<%=m.getSname()%>"></td></tr>
				<tr><th>내용</th><td><textarea cols=40 rows=5 name=content><%=m.getContent()%></textarea></td></tr>
				<tr><td colspan=2 align=center>
					<input type=submit value="글수정하기"> &emsp;
					<input type=submit value="목록보기" onClick="action='<%=path %>/CommentController?sw=S'">
				</td></tr>
			</table>
		</form>
		
		<form action="<%=path%>/CommentController">
		<input type=hidden name=sw value="CI">
		<input type=hidden name=comment_idx value="<%=m.getIdx() %>">
			<table width=500 border=1>
				<tr>
					<td><input type=text size=55 name=commentContent></td>
					<td><input type=submit value="코맨트저장"></td>
				</tr>
			</table>
		</form>
		
		<table border=1 width=500>
			<tr>
				<th width=20>번호</th>
				<th width=340>코맨트</th>
				<th width=100>날짜</th>
				<th width=40>삭제</th>
			</tr>
			<%
			for (CommentVO m1 : li) {
			%>
			<tr>
				<td><%=m1.getIdx() %></td>
				<td><%=m1.getCommentContent() %></td>
				<td><%=m1.getCommentDate() %></td>
				<td><input type=button value="삭제" onClick="location.href='<%=path%>/CommentController?sw=CD&idx=<%=m1.getIdx()%>&comment_idx=<%=m.getIdx()%>'"></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>