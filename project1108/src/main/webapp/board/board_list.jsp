<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%@ page import="java.util.*"%>
<%@ page import="pkg.board.BoardVO"%>

<%
List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");
%>

<section>
	<br>
	<div align="center">
		<h2>글 목록 보기</h2>
	</div>
	<div align="center">
		<table border=1>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
			<%
			for (BoardVO m : li) {
				int num_id = m.getNum_id();
				String title = m.getTitle();
				String content = m.getContent();
				if (content.length() >= 10) {
					content = content.substring(0, 10) + "...";
				}
			%>
			<tr>
				<td><%=num_id%></td>
				<td><a href="<%=path%>/BoardController?sw=E&num_id=<%=num_id%>"><%=title%></a></td>
				<td><%=content%></td>
			</tr>
			<%
			}
			%>
		</table>
		<form action="<%=path%>/BoardController">
			<input type=hidden name=sw value="S"> 
			<select name=ch1>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select> 
			<input type=text name=ch2> 
			<input type=submit value="검색하기">
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>