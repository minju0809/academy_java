<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="board.pageBoard1.*"%>

<%@ include file="/include/top.jsp"%>

<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
@SuppressWarnings("unchecked")
List<BoardVO> li = (List<BoardVO>) request.getAttribute("li");

String ch1 = (String) request.getParameter("ch1");
String ch2 = (String) request.getParameter("ch2");

if (ch2 != null) {
	ch2 = java.net.URLEncoder.encode(ch2, "UTF-8");
} 

int start = (int) request.getAttribute("start");

int tc = (int) request.getAttribute("tc");
int pageSize = (int) request.getAttribute("pageSize");
int pageListSize = (int) request.getAttribute("pageListSize");
int totalPage = (int) request.getAttribute("totalPage");
int currentPage = (int) request.getAttribute("currentPage");
int listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;
int listEndPage = listStartPage + pageListSize - 1;
%>

<section>
	<br>
	<div align=center>
		1. 페이지사이즈 : <%=pageSize %> &emsp;
		2. 페이지 List 사이즈 (숫자개수) : <%=pageListSize %> &emsp;
		3. 전체 레코드 수 : <%=tc %> &emsp;
		4. 총 페이지 수 : <%=totalPage %> &emsp;
		<br>
		5. 현재 레코드 : <%=start %> &emsp;
		6. 현재 페이지 : <%=currentPage %> &emsp;
		7. 가로 하단 시작 : <%=listStartPage %> &emsp;
		8. 가로 하단 마지막 : <%=listEndPage %> &emsp;
		<h2>목록보기</h2>
		<table border=1>
			<tr>
				<th>row</th>
				<th>rnum1</th>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
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
				<td><a href="<%=path %>/PageBoardController?sw=E&idx=<%=m.getIdx() %>&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>"><%=m.getTitle() %></a></td>
				<td><%=m.getCnt() %></td>
				<td><a href="<%=path %>/PageBoardController?sw=D&idx=<%=m.getIdx() %>&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">삭제</a>
				<input type=button value="삭제" onClick="location.href='<%=path%>/PageBoardController?sw=D&idx=<%=m.getIdx() %>&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>'">
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<div>
			<%
			int endPage = (totalPage - 1) * pageSize + 1;
			%>
			<a href="PageBoardController?sw=S&start=1&ch1=<%=ch1 %>&ch2=<%=ch2 %>">처음으로</a>
			
			<% 
			// * pageListSize가 15라면, listStartPage는 1, 16, 31, ...
			// 만약 listStartPage가 pageListSize보다 크면 링크 걸린 이전이 오고, 그렇지 않으면 그냥 이전
			if (listStartPage > pageListSize) { 
				start = (listStartPage - pageListSize - 1) * pageSize + 1;
			%>
				<a href="PageBoardController?sw=S&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">이전<%=pageListSize %></a>
			<% 
			} else { 
			%>	
				이전
			<% 
			} 
			%>
			
			<%
			// i = 1 --> 1, i = 2 --> 11, i = 3 --> 21
			for (int i = listStartPage; i <= listEndPage; i++) {
				start = (i-1) * pageSize + 1;
				if (i <= totalPage) {
			%>
				<a href="PageBoardController?sw=S&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">[<%=i %>]</a>&nbsp;
			<%
				}
			}
			%>
			
			<% 
			if (listEndPage < totalPage) { 
				start = listEndPage * pageSize + 1;
			%>
				<a href="PageBoardController?sw=S&start=<%=start %>&ch1=<%=ch1 %>&ch2=<%=ch2 %>">다음<%=pageListSize %></a>
			<% 
			} else { 
			%>
				다음
			<%
			} 
			%>
			
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