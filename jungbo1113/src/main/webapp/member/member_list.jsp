<%@page import="java.sql.Date"%>
<%@page import="DBPKG.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<%
@SuppressWarnings("unchecked")
List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
%>
<section>
	<br>
	<div align="center">
		<h2>회원목록조회/수정</h2>
	</div>

	<div align=center>
		<table border=1 width=900>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>회원암호</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
				<th>삭제</th>
			</tr>
			<%
			for (MemberVO m : list) {
				int custno = m.getCustno();
				String custname = m.getCustname();
				String pwd = m.getPwd();
				String phone = m.getPhone();
				String address = m.getAddress();
				Date joindate = m.getJoindate();
				String grade = m.getGrade();
				String city = m.getCity();
			%>
			<tr align=center>
				<td><a href="./JungboController?sw=E&custno=<%=custno%>"><%=custno%></a></td>
				<td><%=custname%></td>
				<td><%=pwd%></td>
				<td><%=phone%></td>
				<td><%=address%></td>
				<td><%=joindate%></td>
				<td><%=grade%></td>
				<td>
					<a id="city" href="./JungboController?sw=D&custno=<%=custno%>"><%=city%></a></td>
				<td>
					<input type="submit" value="삭제" onclick="deleteK(<%=custno%>)">
					<input type="button" value="삭제" onclick="deleteK(<%=custno%>)">
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>
<%@ include file="/include/bottom.jsp" %>