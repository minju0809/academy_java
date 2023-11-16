<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
List<MoneyVO> li = (List<MoneyVO>) request.getAttribute("li");
%>

<style>
.body {
	display: flex;
}

</style>

<script>

</script>

<section>
	<br>
	<div align=center>
		<b>날짜별 매출</b>
	</div>

	<div class=body align=center>
		<table border=1 width=50%>
			<tr>
				<th>구입일자</th>
				<th>구매가격</th>
			</tr>
			<%
			for (MoneyVO m : li) {
				Date sDate = m.getsDate();
				int price = m.getPrice();
			%>
			<tr>
				<td><%=sDate%></td>
				<td><%=price %></td>
			</tr>
			<%
			}
			%>
		</table>
		<b>일별매출막대그래프</b>
		<div id="columnchart_values" style="width: 1000px; height: 500px;"></div>
	</div>
	<br>
</section>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

google.charts.load("current", {packages:['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	color = [ "silver", "gold", "#e5e4e2", "#b87333" ];
	var data = google.visualization.arrayToDataTable([
		[ "Element", "일별매출액", { role : "style" } ],

        <%
        int i = 0;
        for (MoneyVO m : li) {
			Date sDate = m.getsDate();
			int price = m.getPrice();
        %>
        ["<%=sDate%>",<%=price%>, "#b87333"],
		<%
		i++;
        }
        %>
	]);

	var view = new google.visualization.DataView(data);
		view.setColumns([ 0, 1, {
			calc : "stringify",
			sourceColumn : 1,
			type : "string",
			role : "annotation"
		}, 2 ]);

		var options = {
			title : " ",
			width : 500,
			height : 500,
			bar : {
				groupWidth : "85%"
			},
			legend : {
				position : "none"
			},
		};
		var chart = new google.visualization.ColumnChart(document
				.getElementById("columnchart_values"));
		chart.draw(view, options);
	}
</script>

	
<%@ include file="./include/bottom.jsp"%>
