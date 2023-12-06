<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="DBPKG.guestbook.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<%
/*
List<GuestbookVO> li = (List<GuestbookVO>) request.getAttribute("li");
int totalCount = (int) request.getAttribute("totalCount");
String ch1 = (String) request.getAttribute("ch1");
String ch2 = (String) request.getAttribute("ch2");

int start = (int) request.getAttribute("start");
int pageSize = (int) request.getAttribute("pageSize");
int totalPage = (int) request.getAttribute("totalPage");
int currentPage = (int) request.getAttribute("currentPage");
int lastPage = (int) request.getAttribute("lastPage"); 
*/
%>
<section> 
	<div align=center>
	    1.페이지사이즈 : ${ pageSize } &emsp;
		2.페이지 List 사이즈(숫자개수) : ${ pageListSize } &emsp;
	    3.전체레코드 수 : ${ totalCount } &emsp;
	    4.총 페이지수 : ${ totalPage } 
	    <br>
	    5.현재 레코드 : ${ start } &emsp;
	    6.현재 페이지 : ${ currentPage } &emsp;
	    7.가로 하단 시작 : ${ listStartPage } &emsp;
	    8.가로 하단 마지막 :${ listEndPage }
		<br>
		<h2>방명록 목록</h2>
		<form action="${ path }/GuestbookController">
		<input type=hidden name="sw" value="GuestbookSelect">
			<select name=ch1>
				<option value="name">작성자</option>
				<option value="title">제목</option>
			</select> 
			<input type=text name=ch2> 
			<input type=submit value="검색하기">
		</form>
		<br>
		<table border=1>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>삭제</td>
			</tr>
			<%
			%>
			<c:forEach var="m" items="${ li }">
	 		<tr>
				<td>${ m.getIdx() }</td>
				<td>${ m.getName() }</td>
				<td>${ m.getTitle() }</td>
				<td><input type=button value="삭제" onClick="location.href='${ path }/GuestbookController?sw=GuestbookDelete&idx=${ m.getIdx() }&ch1=${ ch1 }&ch2=${ ch2 }'"></td>
			</tr>
			</c:forEach>
			<%
			%>
		</table>
		<br>
		<a href="${ path }/GuestbookController?sw=GuestbookSelect&start=1&ch1=${ ch1 }&ch2=${ ch2 }">처음으로</a>
		
		<c:if test="${ listStartPage > pageListSize }">
			<c:set var="start" value="${ (listStartPage - pageListSize -1) * pageSize  + 1 }"/>
			<a href="GuestbookController?sw=GuestbookSelect&start=${ start }&ch1=${ ch1 }&ch2=${ ch2 }">이전</a>
		</c:if>
		<c:if test="${ listStartPage <= pageListSize }">
			이전	
		</c:if>
		
		<c:forEach var="i" begin="${ listStartPage }" end="${ listEndPage }">
			<c:set var="start" value="${ (i-1) * pageSize + 1 }"/>
			<c:if test="${ i <= totalPage }">
				<a href="GuestbookController?sw=GuestbookSelect&start=${ start }&ch1=${ ch1 }&ch2=${ ch2 }">[${ i }]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${ listEndPage < totalPage }">
			<c:set var="start" value="${ listEndPage * pageSize + 1 }"/>
			<a href="GuestbookController?sw=GuestbookSelect&start=${ start }&ch1=${ ch1 }&ch2=${ ch2 }">다음</a>
		</c:if>
		<c:if test="${ listEndPage >= totalPage }">
			다음
		</c:if>
		
		<a href="GuestbookController?sw=GuestbookSelect&start=${ lastPage }&ch1=${ ch1 }&ch2=${ ch2 }">마지막으로</a>
	</div>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>