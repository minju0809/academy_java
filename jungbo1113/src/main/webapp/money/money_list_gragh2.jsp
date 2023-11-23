<%@page import="java.text.DecimalFormat"%>
<%@page import="DBPKG.money.MoneyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/top.jsp"%>
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
		<div id="piechart" style="width: 900px; height: 500px;"></div>
	</div>
	<br>
</section>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

    	  var data = google.visualization.arrayToDataTable([
              ['money', '매출액'],
              <% 
              for(MoneyVO vo : list){
                  String custname = vo.getCustname();
                  int sumMoney = vo.getSumMoney();
              %>
              ['<%= custname %>', <%= sumMoney %>],
              <%
              } %>
          ]);

        var options = {
          title: '회원매출조회'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
<footer> HRDKOREA Copyright&copy;2016 All rights reserved.
	Human Resources Development Service of Korea. </footer>
</body>
</html>