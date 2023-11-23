<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<section>
	<br>
	<div align=center>
		<b>회원 로그인</b>
	</div>
	<div align=center>
		<form action="<%=path %>/LoginController">
		<input type=hidden name=sw value="loginOK">
			<table border=1>
				<tr>
					<th>아이디</th>
					<td><input type=text name="custname"></td>
				</tr>
				<tr>
					<th>암 호</th>
					<td><input type=text name="pwd"></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<input type=submit value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="../include/bottom.jsp"%>

