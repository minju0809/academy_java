<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
List<MoneyVO> li = (List<MoneyVO>) request.getAttribute("li");

List<Integer> selectCustno = (List<Integer>)request.getAttribute("selectCustno");
%>

<style>
#city a {
	color: red;
}

</style>

<script>

</script>

<section>
	<br>
	<div align=center>
		<b>매출목록조회</b>
	</div>

	<div align=center>
		<table border=1>
			<tr>
				<th>회원번호</th>
				<th>구매번호</th>
				<th>상품코드</th>
				<th>상품단가</th>
				<th>상품수량</th>
				<th>구매가격</th>
				<th>구입일자</th>
			</tr>
			<%
			for (MoneyVO m : li) {
				int custno = m.getCustno();
				int salenol = m.getSalenol();
				String pcode = m.getPcode();
				int pcost = m.getPcost();
				int amount = m.getAmount();
				int price = m.getPrice();
				Date sDate = m.getsDate();
			%>
			<tr>
				<td><a><%=custno%></a></td>
				<td><%=salenol %></td>
				<td><%=pcode %></td>
				<td><%=pcost %></td>
				<td><%=amount %></td>
				<td><%=price %></td>
				<td><%=sDate%></td>
			</tr>
			<%
			}
			%>
		</table>
		<select value="selectCustno">
			<option value="selectCustno">회원번호</option>
		</select>
		<input type=submit value="검색">		
	</div>
	<br>
</section>
	
<%@ include file="./include/bottom.jsp"%>
