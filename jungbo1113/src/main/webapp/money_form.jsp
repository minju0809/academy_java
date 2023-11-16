<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.*"%>
<%@ page import="DBPKG.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp"%>

<%
int salenol = (int) request.getAttribute("salenol");

List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");
%>

<script>
	function ck() {
		if (f1.pcode.value == "") {
			alert("상품코드가 입력되지 않았습니다.!");
			f1.pcode.focus();
			return false;
		}

		if (f1.amount.value < 1) {
			alert("수량이 입력되지 않았습니다!");
			f1.pcode.focus();
			return false;
		}
		alert("매출등록이 완료 되었습니다!");
	}

	function priceC() {
		pcost = f1.pcost.value;
		amount = f1.amount.value;

		price = pcost * amount;
		
		if (amount >= 3) {
			price -= price * 0.1;
		}
		
		f1.price.value = price;		
	}

	function pcodeC() {
		pcode = f1.pcode.value.substring(0, 1);
		pcodeValue = 0;
		if (pcode == "A") {
			pcodeValue = 500;
		} else if (pcode == "B") {
			pcodeValue = 700;
		} else if (pcode == "C") {
			pcodeValue = 1000;
		}
		f1.pcost.value = pcodeValue;
		priceC();
	}

	window.addEventListener('load', function() {
		pcodeC();
	});
</script>

<section>
	<br>
	<div align=center>
		<b>회원 매출 등록</b>

		<form name="f1" action="<%=path%>/MoneyController"
			onsubmit="return ck()">
			<input type=hidden name="sw" value="I">
			<table border=1>
				<tr>
					<th>회원번호</th>
					<td><select name=custno>
							<%
							int price = 0;
							for (int i = li.size()-1; i >= 0; i--) {
								int custno = li.get(i).getCustno();
							%>
							<option value=<%=custno%>><%=custno%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<th>구매번호</th>
					<td><input type=text name="salenol" value=<%=salenol%>></td>
				</tr>
				<tr>
					<th>상품코드</th>
					<td><select name="pcode" onChange="pcodeC()">
							<option value="A001">A001</option>
							<option value="A002">A002</option>
							<option value="B001">B001</option>
							<option value="B002">B002</option>
							<option value="C001">C001</option>
					</select> (예: 'A007')</td>
				</tr>
				<tr>
					<th>상품단가</th>
					<td><input type=text id="num1" name="pcost"
						onChange="priceC()"></td>
				</tr>
				<tr>
					<th>상품수량</th>
					<td><select name="amount" onChange="priceC()">
							<option value=1>1개</option>
							<option value=2>2개</option>
							<option value=3>3개</option>
					</select></td>
				</tr>
				<tr>
					<th>구매가격</th>
					<td><input type=text name="price" value=<%=price%> readonly></td>
				</tr>
				<tr>
					<th>구입일자</th>
					<td><input type=text name="sdate" value="<%=LocalDate.now()%>">
					</td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value='등록'></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="./include/bottom.jsp"%>