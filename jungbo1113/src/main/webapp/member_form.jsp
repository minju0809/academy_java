<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/top.jsp"%>

<% 
int custno = (int) request.getAttribute("custno");

Date day = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
String toDay = sdf.format(day);
%>
<script>
function ck() {
	if(f1.custname.value=="") {
		alert("회원성명이 입력되지 않았습니다.!");
		f1.custname.focus();
		return false;
	}
	alert("회원등록이 완료 되었습니다!");
}

function listK() {
	location.href="<%=path %>/JungboController?sw=S";
} 
	
</script>

<section>
<br>
	<div align=center>
		<b>홈쇼핑 회원 등록</b>
		
		<form name="f1" action="<%=path %>/JungboController" onsubmit="return ck()">
		<input type=hidden name="sw" value="I">
			<table border=1>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type=text name="custno" value=<%=custno %> readonly></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type=text name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type=text name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type=text name="address" size=50></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td>
						<input type=text name="joindate" value="<%=LocalDate.now()%>">
					</td>
					
				</tr>
				<tr>
					<th>고객등급 [A:VIP,B:일반,C:직원]</th>
					<td><input type=text name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type=text name="city"></td>
				</tr>
				<tr>
					<td align=center colspan=2>
						<input type=submit value='등록'>
						<input type=button value='조회' onClick="listK()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="./include/bottom.jsp"%>