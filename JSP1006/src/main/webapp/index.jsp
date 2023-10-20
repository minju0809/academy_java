<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
  <tr>
    <td>이름</td>
    <td> Kang Min Ju </td>
  </tr>
  <tr>
    <td colspan="16">구구단</td>
  </tr>
  <tr>
  <%
    for (int dan = 2; dan <= 9; dan++) {
  %>
    <td><%= dan %>단</td>
    <td>
      <%
        for (int i = 1; i <= 9; i++) {
          int result = dan * i;
          %>
          <%= dan %> X <%= i %> = <%= result %><br>
          <%
        }
      %>
    </td>
  <%
    }
  %>
  </tr>
</table>
</body>
</html>