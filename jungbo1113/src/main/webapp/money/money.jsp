<%@page import="java.text.DecimalFormat"%>
<%@page import="DBPKG.money.MoneyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<%
@SuppressWarnings("unchecked")
List<MoneyVO> list = (List<MoneyVO>) request.getAttribute("list");
%>
<section>
	<br>
	<div align="center">
		<h2>회원매출조회</h2>
	</div>
	<div align="center">
		<table border=1 width=300>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
			for (MoneyVO m : list) {
				int custno = m.getCustno();
				String custname = m.getCustname();
				String grade = m.getGrade();
				int sumMoney = m.getSumMoney();
				if (grade.equals("A")) {
					grade = "VIP";
				} else if (grade.equals("B")) {
					grade = "일반";
				} else if (grade.equals("C")) {
					grade = "직원";
				}
				DecimalFormat df = new DecimalFormat("###,###.#");
				String sumMoneyStr=df.format(sumMoney);
			%>
			<tr align="center">
				<td><%=custno%></td>
				<td><%=custname%></td>
				<td><%=grade%></td>
				<td width=60><%=sumMoneyStr%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>
<footer> HRDKOREA Copyright&copy;2016 All rights reserved.
	Human Resources Development Service of Korea. </footer>
</body>
</html>