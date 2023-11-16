<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="DBPKG.*"%>

<%@ include file="./include/top.jsp"%>

<%
List<MoneyVO> li = (List<MoneyVO>) request.getAttribute("li");
%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);

  function drawChart() {

    var data = google.visualization.arrayToDataTable([
      ['custname', 'money'],
      <% 
      for (MoneyVO m : li) {
	String custname = m.getCustname();
	int money = m.getMoney();
      
      %>
      ['<%=custname %>', <%=money %>],
      <%
      }
      %>
    ]);

    var options = {
      title: 'My Daily Activities'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
  }
</script>
   
<section>
<br>
	<div align=center><b>회원매출조회</b>
		<div id="piechart" style="width: 900px; height: 500px;"></div>
	</div>
<br>
</section>


	
<%@ include file="./include/bottom.jsp"%>
