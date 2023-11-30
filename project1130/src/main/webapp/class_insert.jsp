<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.member.MemberVO"%>
<%@ page import="java.text.DecimalFormat"%>

<%
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");
%>

<script>
function fn_function1() {
	f1.c_no.value = f1.c_name.value;
}

function fn_function2() {
	price = f1.class_name.value * 1000;
	
	if (f1.c_no.value >= 20000) {
		price = price * 0.5;
	}
	f1.tuition.value = price;
}

function ck1() {
	
	if (f1.regist_month.value=="") {
		alert("수강월을 입력해주세요");
		f1.regist_month.focus();
		return false;
	} else if (f1.address.value=="") {
		alert("강의장소를 입력해주세요");
		f1.address.focus();
		return false;
	}
}

</script>

<section>
	<br>
	<h2 align=center>수강신청</h2>
	<form name=f1 action="<%=path%>/Controller" onSubmit="return ck1()">
		<input type=hidden name="sw" value="ClassInsert">
		<table border=1 align=center>
			<tr>
				<td>수강월</td>
				<td><input name="regist_month" type=text>예) 2022년03월 ->
					202203</td>
			</tr>
			<tr>
				<td>회원명</td>
				<td><select id="c_name" name="c_name" onChange="fn_function1()">
						<option>회원명</option>
						<%
						for (MemberVO m : li) {
						%>
						<option value="<%=m.getC_no()%>"><%=m.getC_name()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<td>회원번호</td>

				<td><input name="c_no" type=text readonly>예)10001</td>
			</tr>
			<tr>
				<td>강의장소</td>
				<td><input name="address" type=text></td>
			</tr>
			<tr>
				<td>강의명</td>
				<td><select id="class_name" name="class_name"
					onChange="fn_function2()">
						<option>강의신청</option>
						<option value="100">초급반</option>
						<option value="200">중급반</option>
						<option value="300">고급반</option>
						<option value="400">심화반</option>
				</select></td>
			</tr>
			<tr>
				<td>수강료</td>
				<td><input name="tuition" type=text readonly>원</td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=submit value="수강신청">
					<input type=reset value="다시쓰기"></td>
			</tr>

		</table>
	</form>
	<br>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>