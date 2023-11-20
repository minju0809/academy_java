<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.io.*"%>
<%@ page import="DBPKG.*"%>
<%@ page import="DBPKG.jungbo.*"%>

<%@ include file="./include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />
<%
String sessionID = (String) session.getAttribute("sessionID");
List<MoneyVO> li = (List<MoneyVO>) request.getAttribute("li");

%>
sessionID : <%=sessionID %>

<section>
	<br>
	<div align=center>
		<b>매출막대그래프1</b>
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
		[ "Element", "매출액", { role : "style" } ],

        <%
        int i = 0;
        for (MoneyVO m : li) {
        	String custno = Integer.toString(m.getCustno()).substring(4, 6);
			String custname = m.getCustname();
			int money = m.getMoney();
        %>
        ["<%=custname%>\n[<%=custno %>]",<%=money%>, "#b87333"],
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
			width : 1000,
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