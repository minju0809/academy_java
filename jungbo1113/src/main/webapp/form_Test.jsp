<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보처리 산업기사 과정평가형</title>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<script>
	function fncK(swK) {
		if (f1.id.value == "") {
			alert("id를 입력해주세요");
			f1.id.focus();
			return false;
		} 
		f1.action="./TestController";
		
		if (swK=='I') {
			f1.sw.value="I";
			alert("추가");
		} else if (swK=='U') {
			f1.sw.value="U";
			alert("수정");
		}
	}
</script>



</head>
<body>
	<header>쇼핑몰 회원관리 ver 1.0</header>
	<nav></nav>

	<section>
		<br>
		<div align=center>
			<b>홈쇼핑 회원 등록</b>
			<form name="f1" method="post">
				<input type=hidden name=sw>
				<table border=1>
					<tr>
						<th>아이디</th>
						<td><input type=text name=id></td>
					</tr>
					<tr>
						<th>암호</th>
						<td><input type=text name=pwd></td>
					</tr>
					<tr>
						<td colspan=2 align=center>
							<input type=submit value="저장하기" onclick="fncK('I')"> 
							<input type=submit value="수정하기" onclick="fncK('U')">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
	</section>
	<footer>HRDOKREA Copyright&copy; All rights reserved. Human
		Resources Development Service of Korea.</footer>
</body>
</html>