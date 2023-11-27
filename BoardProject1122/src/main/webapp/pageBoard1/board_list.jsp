<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.pageBoard1.*"%>

<%@ include file="/include/top.jsp"%>

<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
@SuppressWarnings("unchecked")
List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");

int start = (int) request.getAttribute("start");
int tc = (int) request.getAttribute("tc");
int pageSize = (int) request.getAttribute("pageSize");
int totalPage = (int) request.getAttribute("totalPage");
int currentPage = (int) request.getAttribute("currentPage");

String ch1 = (String) request.getParameter("ch1");
String ch2 = (String) request.getParameter("ch2");

%>

<section>
	<br>
	<div align=center>
		<h2>목록보기 (전체레코드 수: <%=tc %>, 현재페이지: <%=currentPage %>, 전체페이지: <%=totalPage %>)</h2>
		<table border=1>
			<tr>
				<th>row</th>
				<th>rnum1</th>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>내용</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<%
			for (BoardVO m : li) {
			%>
			<tr>
				<td><%=m.getRownum() %></td>
				<td><%=m.getRnum() %></td>
				<td><%=m.getIdx() %></td>
				<td><%=m.getSname() %></td>
				<td><a href="<%=path %>/PageBoardController?sw=E&idx=<%=m.getIdx() %>"><%=m.getTitle() %></a></td>
				<td><%=m.getContent() %></td>
				<td><%=m.getCnt() %></td>
				<td><a href="<%=path %>/PageBoardController?sw=D&idx=<%=m.getIdx() %>">삭제</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<div>
			<%
			if (ch2 != null) {
				ch2 = java.net.URLEncoder.encode(ch2, "UTF-8");
			}
			
			int endPage = (totalPage - 1) * pageSize + 1;
			%>
			<a href="PageBoardController?sw=S&start=1&ch1=<%=ch1 %>&ch2=<%=ch2 %>">처음으로</a>
			
			<% if (start > 1) { %>
			<a href="PageBoardController?sw=S&start=<%=start - 10 %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">이전</a>
			<% } else { %>	
			이전
			<% } %>
			
			<% if (start != endPage) { %>
			<a href="PageBoardController?sw=S&start=<%=start + 10 %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">다음</a>
			<% } else { %>
			다음
			<% } %>
			
			<a href="PageBoardController?sw=S&start=<%=endPage %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">마지막으로</a>
		</div>
		
		<form action="PageBoardController">
		<input type="hidden" name="sw" value="S">
			<select name="ch1">
				<option value="sname">이 름</option>
				<option value="title">제 목</option>
			</select>
			<input type=text name="ch2">		
			<input type=submit value="검색">
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>