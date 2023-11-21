<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int maxCustno = (int) request.getAttribute("maxCustno");
%>
<%@ include file="../include/top.jsp" %>
<section>
	<br>
	<div align="center">
		<h2>홈쇼핑 회원 정보 등록</h2>
	</div>

	<div align="center">
		<form name="f1" action="./JungboController" onsubmit="return ck()">
			<input type="hidden" name="sw" value="I">
			<table border=1 width=580px>
				<tr >
					<th width=250px>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%=maxCustno%>"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="text" name="pwd"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td width=30https://kkutu.co.kr/o/game?server=4#5700px><input size=30 type="text" name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td ><input size=50 type="text" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value="<%=LocalDate.now()%>"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]<br></th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type="submit" value="등록"> &emsp;
						<input type="button" value="조회" onclick="listK()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<%@ include file="../include/bottom.jsp" %>