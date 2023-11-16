<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
List<MoneyVO> li = (List<MoneyVO>) request.getAttribute("li");
%>

<section>
<br>
	<div align=center><b>회원매출조회</b></div>
	<div align=center>
		<table border=1>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<% for (MoneyVO m : li) {
				int custno = m.getCustno();
				String custname = m.getCustname();
				String grade = m.getGrade();
				DecimalFormat df = new DecimalFormat("#,###");
				int money = m.getMoney();
				String dfNumber = df.format(money);
				
				if (grade.equals("A")) {
					grade = "VIP";
				} else if (grade.equals("B")) {
					grade = "일반";
				} else if (grade.equals("C")) {
					grade = "직원";
				} 
			%>
			
			<tr>
				<td><%=custno %></td>
				<td><%=custname %></td>
				<td><%=grade %></td>
				<td><%=dfNumber %></td>
			</tr>
			<%
			}
			%>
		</table>
		<select>
			<option value="custno">고객명</option>
		</select>
	</div>
<br>
</section>
	
<%@ include file="./include/bottom.jsp"%>
