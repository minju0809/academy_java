<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");
%>

<style>
#city a {
	color: red;
}

</style>

<script>
function del(custno) {
	location.href="./JungboController?sw=D&custno=" + custno
	alert(custno+"번을 삭제하였습니다.");
}
</script>

<section>
	<br>
	<div align=center>
		<b>회원목록조회/수정</b>
	</div>

	<div align=center>
		<table border=1>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
				<th colspan=2>삭제</th>
			</tr>
			<%
			for (MemberVO m : li) {
				int custno = m.getCustno();
				String custname = m.getCustname();
				String phone = m.getPhone();
				String address = m.getAddress();
				Date joindate = m.getJoindate();
				String grade = m.getGrade();
				String city = m.getCity();
			%>
			<tr>
				<td><a href="<%=path%>/JungboController?sw=E&custno=<%=custno%>"><%=custno%></a></td>
				<td><%=custname%></td>
				<td><%=phone%></td>
				<td><%=address%></td>
				<td><%=joindate%></td>
				<td><%=grade%></td>
				<td id="city"><a href="<%=path%>/JungboController?sw=D&custno=<%=custno%>"><%=city%></a></td>
				<td><input type=submit value='삭제' onclick="del('<%=custno %>');"></td>
				<td><input type=button value='삭제' onclick="del('<%=custno %>');"></td>
			</tr>
			<%
			}
			%>
		</table>
		<select>
			<option></option>
		</select>
	</div>
	<br>
</section>
	
<%@ include file="./include/bottom.jsp"%>
