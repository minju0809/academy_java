<%@page import="DBPKG.member.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
@SuppressWarnings("unchecked")
List<MemberVO> list = (List<MemberVO>) request.getAttribute("list");
int maxSalenol = (int) request.getAttribute("maxSalenol");
%>
<%@ include file="/include/top.jsp"%>
<script>
	function priceC() {

		pcost = f1.pcost.value;
		amount = f1.amount.value;

		f1.price.value = pcost * amount;
		if (isNaN(pcost)) {
			f1.price.value = 0;
		}

		if(amount >= 3){
			f1.price.value -= f1.price.value*0.1;	
		} 
	}
	function pcodeC(){
		pcode = f1.pcode.value.substr(0,1);
		pcodeValue = 0;
		if(pcode == 'A'){
			pcodeValue = 500;
		}else if(pcode == 'B'){
			pcodeValue = 1000;
		}else if(pcode == 'C'){
			pcodeValue = 1500;
		}
		f1.pcost.value = pcodeValue;
		priceC();
	}
	window.onload = pcodeC;
</script>
<section>
	<br>
	<div align="center">
		<h2>주문 등록</h2>
	</div>

	<div align="center">
		<form name="f1" action="./MoneyController">
			<input type="hidden" name="sw" value="I">
			<table border=1 width=400px>
				<tr>
					<th width=150>회원번호</th>
					<td><select name="custno">
							<%
							for (MemberVO m : list) {
							%>
							<option value="<%=m.getCustno()%>"><%=m.getCustno()%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<th>구매번호</th>
					<td><input name="salenol" type="text" value="<%=maxSalenol%>"
						readonly></td>
				</tr>
				<tr>
					<th>상품코드</th>
					<td><select name="pcode" onchange="pcodeC()">
						<option value="A001">A001</option>
						<option value="A002">A002</option>
						<option value="B001">B001</option>
						<option value="B002">B002</option>
						<option value="C001">C001</option>
					</select></td>
				</tr>
				<tr>
					<th>상품단가</th>
					<td><input name="pcost" type="text" onchange="priceC()"></td>
				</tr>
				<tr>
					<th>상품수량</th>
					<td><select name="amount" onchange="priceC()">
							<%
							for (int i = 1; i <= 5; i++) {
							%>
							<option value=<%=i%>><%=i%>개</option>
							<%
							}
							%>
					</select> <!-- <td><input name="amount" type="text" onchange="priceC()"> -->
					</td>
				</tr>
				<tr>
					<th>구매가격</th>
					<td><input name="price" type="text" value="0" readonly></td>
				</tr>

				<tr>
					<th>판매일자</th>
					<td><input name="sdate" type="text"
						value="<%=LocalDate.now()%>" readonly></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit" value="매출등록"></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>
<footer> HRDKOREA Copyright&copy;2016 All rights reserved.
	Human Resources Development Service of Korea. </footer>
</body>
</html>