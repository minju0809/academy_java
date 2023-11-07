<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="pkg.JungVO"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">

</head>
<script>
function deleteStudent(sNo) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        // 사용자가 확인을 누를 때 서버로 삭제 요청을 보냄
        fetch("JungboController?sw=D&sNo=" + sNo)
            .then(response => {
                if (response.ok) {
                    // 삭제 성공 시 페이지 새로고침
                    location.reload();
                } else {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            })
            .catch(error => {
                console.error("삭제 요청 오류:", error);
            });
    }
}
</script>
<body>
	<header> (과정평가형 정보처리기능사) 성적조회 프로그램 Ver 1.0 </header>
	<nav>
		&emsp;<a href="JungboController?sw=F">성적입력</a> &emsp;<a
			href="JungboController?sw=S">성적조회</a> &emsp;<a href="index.jsp">홈으로</a>
	</nav>
	<%
	if (request.getAttribute("li") == null) {
		response.sendRedirect("JungboController?sw=S");
	} else {
		List<JungVO> li = (List<JungVO>) request.getAttribute("li");	
	%>
	
	<section>
		<br>
		<div align=center>
			<h2>성적조회목록</h2>
		</div>
		<div align=center>
			<table border=1 width=100%>
				<tbody align=center>
					<tr>
						<th>학년</th>
						<th>반</th>
						<th>번호</th>
						<th>성명</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>역사</th>
						<th>총점</th>
						<th>평균</th>
						<th>날짜</th>
						<th>날짜 시간</th>
						<th>조회수</th>
						<th>삭제</th>
					</tr>
					<%
					for (JungVO m : li) {
						String sNo = m.getsNo();
						String sName = m.getsName();
						int kor = m.getKor();
						int eng = m.getEng();
						int math = m.getMath();
						int hist = m.getHist();
						int sum = m.getKor() + m.getEng() + m.getMath() + m.getHist();
						double avg = (double) sum / 4;
						String today = m.getToday();
						Date nowDate = m.getNowDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
						String strDate = sdf.format(nowDate);
						int cnt = m.getCnt();
						
						if (today == null) {
							today = " ";
						} else {
							today = today.substring(0, 10);
						}
					%>
					<tr>
						<td><%=sNo.substring(0, 1)%></td>
						<td><%=sNo.substring(1, 3)%></td>
						<td><%=sNo.substring(3, 5)%></td>
						<td><a style='color: green'
							href="JungboController?sw=E&sNo=<%=sNo%>"><%=sName%></a></td>
						<td><%=kor%></td>
						<td><%=eng%></td>
						<td><%=math%></td>
						<td><%=hist%></td>
						<td><%=sum%></td>
						<td><%=avg%></td>
						<td><%=today%></td>
						<td><%=strDate%></td>
						<td><%=cnt%></td>
						<td><button type="button" style="color: red"
								onclick="deleteStudent('<%=sNo%>')">삭제</button></td>
					</tr>
					<%
					}

					int korSum = 0;
					int engSum = 0;
					int mathSum = 0;
					int histSum = 0;
					int totalSum = 0;
					double totalSumAvg = 0;
					int korAvg = 0;
					int engAvg = 0;
					int mathAvg = 0;
					int histAvg = 0;
					int totalAvg = 0;
					double totalAvgAvg = 0;

					for (JungVO n : li) {
					korSum += n.getKor();
					engSum += n.getEng();
					mathSum += n.getMath();
					histSum += n.getHist();
					korAvg = korSum / li.size();
					engAvg = engSum / li.size();
					mathAvg = mathSum / li.size();
					histAvg = histSum / li.size();

					totalSum = korSum + engSum + mathSum + histSum;
					totalSumAvg = (double) totalSum / 4;
					totalAvg = korAvg + engAvg + mathAvg + histAvg;
					totalAvgAvg = (double) Math.round(totalSumAvg / li.size() * 1000) / 1000.0;
					}
					%>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<th>총점</th>
						<td><%=korSum%></td>
						<td><%=engSum%></td>
						<td><%=mathSum%></td>
						<td><%=histSum%></td>
						<td><%=totalSum%></td>
						<td><%=totalSumAvg%></td>
						<td></td>
						<td></td>
						<td rowspan=2></td>
						<td rowspan=2></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<th>총평균</th>
						<td><%=korAvg%></td>
						<td><%=engAvg%></td>
						<td><%=mathAvg%></td>
						<td><%=histAvg%></td>
						<td><%=totalAvg%></td>
						<td><%=totalAvgAvg%></td>
						<td></td>
						<td></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<br>
	</section>
	<footer> HRDKOREA Copyright&copy;2018 All rights reserved.
		Human Resources Development Service of Korea </footer>
</body>
</html>