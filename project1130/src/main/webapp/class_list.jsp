<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/top.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.member.ClassVO"%>
<%@ page import="java.text.DecimalFormat"%>

<%
List<ClassVO> classList = (List<ClassVO>) request.getAttribute("classList");
%>
<section>
	<br>
	<h2 align=center>수강정보현황</h2>
	<table border=1 align=center>
		<tr>
			<td>수강월</td>
			<td>회원번호</td>
			<td>회원명</td>
			<td>수강료</td>
			<td>강사코드</td>
			<td>강사명</td>

		</tr>
		<%
		DecimalFormat df = new DecimalFormat("0");

		for (ClassVO m : classList) {
			String regist_month = (String) m.getRegist_month().substring(0, 4) + "년"
			+ (String) m.getRegist_month().substring(4, 6) + "월";
			int tuition = m.getTuition();
			df = new DecimalFormat("\u00A4 ###,###");
			String tuitionStr = df.format(tuition);

			String bgcolorArr[] = { "green", "yellow", "orange", "blue", "gold", "blue", "cyan", "deeppink", "aqua", "brown" };
			String bgcolor = bgcolorArr[Integer.parseInt(m.getRegist_month().substring(4, 6)) - 1];

			String no = m.getC_no();
			String name = "";

			if (no.equals("10001")) {
				name = "홍길동";
			} else if (no.equals("10002")) {
				name = "장발장";
			} else if (no.equals("10003")) {
				name = "임걱정";
			} else if (no.equals("20001")) {
				name = "성춘향";
			} else if (no.equals("20002")) {
				name = "이몽룡";
			}
		%>
		<tr bgcolor="<%=bgcolor%>">
			<td><%=regist_month%></td>
			<td><%=m.getC_no()%>(<%=name%>)</td>
			<td><%=m.getClass_area()%></td>
			<td><%=tuitionStr%></td>
			<td><%=m.getTeacher_code()%></td>
			<td><%=m.getTeacher_name()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
</section>
<footer align=center> HRDKOREA Copyright&copy;2016 All rights
	reserved. Human Resources Development Service of Korea. </footer>

</body>
</html>