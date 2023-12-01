<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.member.MemberVO"%>
<%@ page import="DBPKG.comment.CommentVO"%>
<%@ page import="java.text.DecimalFormat"%>

<%
MemberVO m = (MemberVO) request.getAttribute("m");
List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
%>
<section>
	<br>
	<h2 align=center>회원정보상세보기</h2>
	<table border=1 align=center>
		<tr>
			<td>회원번호</td>
			<td><%=m.getC_no()%></td>
		</tr>
		<tr>
			<td>회원명</td>
			<td><%=m.getC_name()%></td>
		</tr>
		<tr>

			<td>번호</td>
			<td><%=m.getPhone()%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=m.getAddress()%></td>
		</tr>
		<tr>
			<td>등급</td>
			<td><%=m.getGrade()%></td>
		</tr>
	</table>
	<form action="<%=path%>/Controller">
		<input type=hidden name="sw" value="CommentInsert">
		<input type=hidden name="c_no" value="<%=m.getC_no()%>">
		<table border=1 align=center>
			<tr>
				<th>메모</th>
				<th>작성자</th>
				<th></th>
			</tr>
			<tr>
				<td>
					<input type=text name="memo" size=50%> 
				</td>
				<td>
					<input type=text name="writer" size=20%>
				</td>
				<td>
					<input type=submit value="입력">
				</td>
			</tr>
		</table>
	</form>
	<table border=1 align=center>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
		<%
		for (CommentVO comment : commentList) {
		%>
		<tr>
			<td><%=comment.getIdx() %></td>
			<td><%=comment.getMemo() %></td>
			<td><a href="<%=path %>/Controller?sw=memoDelete&c_no=<%=m.getC_no() %>&idx=<%=comment.getIdx() %>"><%=comment.getWriter() %></a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>