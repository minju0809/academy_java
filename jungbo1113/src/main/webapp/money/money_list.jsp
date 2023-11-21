<%@page import="java.sql.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="DBPKG.money.MoneyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp" %>
<%
String sessionID = (String)session.getAttribute("sessionID");
System.out.println(sessionID);
@SuppressWarnings("unchecked")
List<MoneyVO> list = (List<MoneyVO>) request.getAttribute("list");
%>
<section>
	<br>
	<div align="center">
		<h2>회원매출조회</h2>
	</div>
	<div class="tableNext" align="center">
		<table border=1 width=350>
			<tr>
				<th>판매일자</th>
				<th>매출</th>
			</tr>
			<%
			for (MoneyVO m : list) {
				Date sdate = m.getSdate();
				int sumMoney = m.getSumMoney();
				
			%>
			<tr align="center">
				<td><%=sdate%></td>
				<td><%=sumMoney%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div align="center" id="columnchart_values" style="width: 1000px; height: 500px;"></div>
	</div>
	<br>
	<br>
</section>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages: ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var color = ["red", "orange", "yellow", "green", "blue","navy", "purple"];

        var data = google.visualization.arrayToDataTable([
            ["Element", "매출액", {role: "style"}],
            <% 
            int i=0;
            for (MoneyVO m : list) {
				Date sdate = m.getSdate();
				int sumMoney = m.getSumMoney();
            %>
            ["<%= sdate%>", <%= sumMoney %>, color[<%=i%>]],
            <%
            	i++; 
            } %>
        ]);

        var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: " ",
        width: 500,
        height: 500,
        bar: {groupWidth: "85%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>
<footer> HRDKOREA Copyright&copy;2016 All rights reserved.
	Human Resources Development Service of Korea. </footer>
</body>
</html>