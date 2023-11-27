
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.basicBoard.*"%>

<%@ include file="/include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
BoardVO m = (BoardVO) request.getAttribute("m");
%>
<section>
	<br>
	<div align=center>
		<h2>게시판 글 상세보기/수정하기</h2>
		<form action="<%=path %>/BasicBoardController?sw=U" method=post enctype="multipart/form-data">
			<input type=hidden name=sw value="U"> <input type=hidden
				name=idx value="<%=m.getIdx()%>">
			<table border=1>
				<tr>
					<th>번호</th>
					<td><input type=text name=idx size=10 value="<%=m.getIdx()%>"
						readonly></td>
					<td rowspan=3>
						<img src="<%=path%>/basicBoard/files/<%=m.getImg()%>" width=30
						height=50></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type=text name=title size=30
						value="<%=m.getTitle()%>"></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type=text name=sname
						value="<%=m.getSname()%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan=2><textarea cols=40 rows=5 name=content><%=m.getContent()%></textarea></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type=file name=img></td>
				</tr>
				<tr>
					<td colspan=3 align=center><input type=submit value="글수정하기">
						&emsp; <input type=submit value="목록보기"
						onClick="action='<%=path%>/BasicBoardController?sw=S'"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>