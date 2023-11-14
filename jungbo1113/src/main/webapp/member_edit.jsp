<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
MemberVO m = (MemberVO) request.getAttribute("m");
%>

<script>
function ck(str, s) {
	alert(str + " : " + s);
	if(f1.custname.value=="") {
		alert("회원성명이 입력되지 않았습니다.!");
		f1.custname.focus();
		return false;
	}
	
	if (str == 'I') {
		f1.sw.value = "I";
		alert("회원등록이 완료 되었습니다!");
	} else if (str == 'U') {
		f1.sw.value = "U";
		alert("수정이 완료 되었습니다!");
	}
}

function listK() {
	location.href="<%=path%>/JungboController?sw=S";
}
</script>

<section>
	<br>
	<div align=center>
		<b>홈쇼핑 회원 정보 수정</b>

		<form name="f1" action = "<%=path%>/JungboController">
			<input type=hidden name="sw">
			<table border=1>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type=text name="custno"
						value="<%=m.getCustno()%>" readonly></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type=text name="custname" value="<%=m.getCustname()%>"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type=text name="phone" value="<%=m.getPhone()%>"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type=text name="address" size=50 value="<%=m.getAddress()%>"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type=text name="joindate" value="<%=m.getJoindate()%>"></td>
				</tr>
				<tr>
					<th>고객등급 [A:VIP,B:일반,C:직원]</th>
					<td><input type=text name="grade" value="<%=m.getGrade()%>"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type=text name="city" value="<%=m.getCity()%>"></td>
				</tr>
				<tr>
					<td align=center colspan=2>
						<input type=submit value='등록' onClick="ck('I', '추가')"> 
						<input type=button value='조회' onclick="listK()"> 
						<input type=submit value='수정' onClick="ck('U', '수정')">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
	
<%@ include file="./include/bottom.jsp"%>