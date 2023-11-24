<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<section>
	<br>
	<div align=center>
		<h2>게시판 글 등록하기</h2>
		<form action="<%=path %>/BasicBoardController?sw=I" method=post enctype="multipart/form-data">
		<input type=hidden name=sw value="I">
			<table border=1>
				<tr><th>제목</th><td><input type=text name=title size=30></td></tr>
				<tr><th>글쓴이</th><td><input type=text name=sname></td></tr>
				<tr><th>내용</th><td><textarea cols=40 rows=5 name=content></textarea></td></tr>
				<tr><th>사진</th><td><input type=file name=img></td></tr>
				<tr><td colspan=2 align=center>
					<input type=submit value="글등록"> &emsp;
					<input type=reset value="다시작성">
				</td></tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>
