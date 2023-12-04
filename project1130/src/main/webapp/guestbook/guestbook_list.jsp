<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.guestbook.*"%>

<%
List<GuestbookVO> li = (List<GuestbookVO>) request.getAttribute("li");
int totalCount = (int) request.getAttribute("totalCount");
String ch1 = (String) request.getAttribute("ch1");
String ch2 = (String) request.getAttribute("ch2");

int start = (int) request.getAttribute("start");
int pageSize = (int) request.getAttribute("pageSize");
int totalPage = (totalCount / pageSize) + 1;
int currentPage = (start / pageSize) + 1;
int lastPage = (totalPage - 1) * pageSize + 1; 

%>
<section>
	<br>
	<h2 align=center>방명록 목록 (전체 레코드 수: <%=totalCount %>, 전체 페이지: <%=totalPage %>, 현재 페이지: <%=currentPage %>)</h2>
	<form action="<%=path %>/GuestbookController">
	<input type=hidden name="sw" value="GuestbookSelect">
		<select name=ch1>
			<option value="name">작성자</option>
			<option value="title">제목</option>
		</select> 
		<input type=text name=ch2> 
		<input type=submit value="검색하기">
	</form>
	<table border=1 align=center>
	
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>삭제</td>
		</tr>
		<%
		for (GuestbookVO m : li) {
		%>
 		<tr>
			<td><%=m.getIdx()%></td>
			<td><%=m.getName()%></td>
			<td><%=m.getTitle()%></td>
			<td><input type=button value="삭제" onClick="location.href='<%=path %>/GuestbookController?sw=GuestbookDelete&idx=<%=m.getIdx() %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>'"></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="<%=path%>/GuestbookController?sw=GuestbookSelect&start=1">처음으로</a>
	<% 
	if(start != 1) { 
	%>
	<a href="<%=path%>/GuestbookController?sw=GuestbookSelect&start=<%=start - pageSize%>">이전</a>
	<% 
	} else {
	%>
	이전	
	<% 
	} 
	%>
	
	<% 
	if(currentPage != totalPage) { 
	%>
	<a href="<%=path%>/GuestbookController?sw=GuestbookSelect&start=<%=start + pageSize %>">다음</a>
	<% 
	} else {
	%>
	다음
	<% 
	} 
	%>
	<a href="<%=path%>/GuestbookController?sw=GuestbookSelect&start=<%=lastPage %>">마지막으로</a>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>