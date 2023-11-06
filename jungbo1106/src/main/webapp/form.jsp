<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="pkg.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<script>
		function ck() {
			if (f1.sNo.value == '') {
				alert("학번이 입력되지 않았습니다.");
				f1.sNo.focus();
				return false;
			}
			if (f1.sName.value == '') {
				alert("이름이 입력되지 않았습니다.");
				f1.sName.focus();
				return false;
			}
			alert("성적입력이 완료 되었습니다!");
		}
	</script>
	<header> (과정평가형 정보처리기능사) 성적조회 프로그램 Ver 1.0 </header>
	<nav>
		&emsp;<a href="JungboController?sw=F">성적입력</a> &emsp;<a
			href="JungboController?sw=S">성적조회</a> &emsp;<a href="index.jsp">홈으로</a>
	</nav>

	<%
	int sNo = (int) request.getAttribute("sNo");
	%>
	<section>
		<br>
		<div align=center>
			<h2>학생 성적 입력</h2>
		</div>
		<div align=center>
			<form name=f1 action="JungboController" onSubmit="return ck()">
				<input type=hidden name=sw value="I">
				<table border=1 width=300>
					<tbody align=center>
						<tr>
							<th>학번</th>
							<td><input type=text name=sNo value=<%=sNo%> readonly></td>
						</tr>
						<tr>
							<th>성명</th>
							<td><input type=text name=sName></td>
						</tr>
						<tr>
							<th>국어</th>
							<td><input type=text name=kor></td>
						</tr>
						<tr>
							<th>영어</th>
							<td><input type=text name=eng></td>
						</tr>
						<tr>
							<th>수학</th>
							<td><input type=text name=math></td>
						</tr>
						<tr>
							<th>역사</th>
							<td><input type=text name=hist></td>
						</tr>
						<tr>
							<td colspan=2 align=center><input type=submit value="성적저장"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<br>
	</section>
	<footer> HRDKOREA Copyright&copy;2018 All rights reserved.
		Human Resources Development Service of Korea </footer>
</body>
</html>