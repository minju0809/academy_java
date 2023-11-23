<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*"%>
<%@ page import="board.comment.*"%>

<%@ include file="/include/top.jsp"%>
<link href="./css/style.css" rel=stylesheet type="text/css" />

<%
BoardVO m = (BoardVO)request.getAttribute("m");
List<CommentVO> li = (List<CommentVO>)request.getAttribute("li");
%>

<script  src="http://code.jquery.com/jquery-1.10.2.js" ></script>
<script>
jQuery.ajaxSetup({cache:false}); // 캐시 사용 안함

$(document).ready( function(){
	
	$('#listK').click( function(){		 		 
	  // alert("저장성공!!" + $('#sw').val() );
	  location.replace("<%=path%>/CommentController?sw=S");
 
	}) 
			
  $('#updateK').click( function(){		 		 
	  // alert("확인2:" + $('#sw').val() + "," + $('#idx').val()   +"," +  $('#title').val()   );
	  var  dataStr={
		  sw : $('#usw').val(),
		  idx : $('#idx').val(),
		  title : $('#title').val(),
		  sname : $('#sname').val(),
		  content : $('#content').val()	
	  };
	  		 
	  $.ajax({			 
		  type: "GET",
		  url : "<%=path%>/CommentController",
		  data : dataStr,
		  success: function (data){
		  // alert("저장성공!!" + $('#sw').val() );
		  location.replace("<%=path%>/CommentController?sw=S");
		  }	  
	  })
	 
  }) 
  
  
  $('#commentInsert').click( function(){		 		 
	  // alert("확인2:" + $('#sw').val() + "," + $('#comment_idx').val()   +"," +  $('#commentContent').val()   );
	  var  dataStr={
		  sw : $('#cisw').val(),
		  comment_idx : $('#comment_idx').val(),
		  commentContent : $('#commentContent').val()	
	  };
	  		 
	  $.ajax({			 
		  type: "GET",
		  url : "<%=path%>/CommentController",
		  data : dataStr,
		  success: function (data){
		  // alert("저장성공!!" + $('#sw').val() );
		  location.replace("<%=path%>/CommentController?sw=E&idx="+$('#comment_idx').val()) ;
		  }	  
	  })
	 
  }) 
  
  $('#commentDelete').click( function(){		 		 
	  // alert("확인2:" + $('#sw').val() + "," + $('#idx').val()   +"," +  $('#comment_idx').val()   );
         var  dataStr={
              sw : "CD",
              cidx : $('#cidx').val()
         }; 
                
         $.ajax({          
            type: "GET",
            url : "<%=path%>/CommentController",
            data : dataStr,
            success: function (data){
            /* alert("저장성공!!" + $('#sw').val() ); */
               location.replace("<%=path%>/CommentController?sw=E&idx=" + $('#idx').val());
            }  
	  })
	 
  }) 
})

<%-- function deleteK(cidx, comment_idx) {
	// 삭제(idx), 돌아올 곳(comment_idx)
	location.href=path+"CommentController?sw=CD&idx="+cidx+"comment_idx="+comment_idx;
} --%>
</script>

<section>
	<br>
	<div align=center>
		<h2>코맨트 글 상세보기/수정하기</h2>
		<%-- <form action="<%=path %>/CommentController" method=get > --%>
		<input type=hidden name=sw value="U" id="usw">
		
			<table border=1 width=500>
				<tr><th>번호</th><td><input type=text name=idx id="idx" size=10 value="<%=m.getIdx()%>" readonly></td></tr>
				<tr><th>제목</th><td><input type=text name=title id="title" size=30  value="<%=m.getTitle()%>"></td></tr>
				<tr><th>글쓴이</th><td><input type=text name=sname id="sname" value="<%=m.getSname()%>"></td></tr>
				<tr><th>내용</th><td><textarea cols=40 rows=5 name=content id="content"><%=m.getContent()%></textarea></td></tr>
				<tr><td colspan=2 align=center>
					<input type=button value="글수정하기" id="updateK"> &emsp;
					<input type=button value="목록보기" id="listK">
					<%-- <input type="button" id="listK" value="목록보기" onclick="action='<%=path%>/CommentController?sw=S'"></td> --%>
				</td></tr>
			</table>
		
		<%-- <form action="<%=path%>/CommentController"> --%>
		<input type=hidden name=sw value="CI" id="cisw">
		<input type=hidden name=comment_idx value="<%=m.getIdx() %>" id=comment_idx>
			<table width=500 border=1>
				<tr>
					<td>
						<input type=text size=50 name=commentContent id=commentContent>
						<input type=button id="commentInsert" value="코맨트저장">
					</td>
				</tr>
			</table>
		
		<table border=1 width=500>
			<tr>
				<th width=20>번호</th>
				<th width=340>코맨트</th>
				<th width=100>날짜</th>
				<th width=40>삭제</th>
			</tr>
			<%
			for (CommentVO m1 : li) {
			%>
			<tr>
				<td><input type="hidden" name="cidx" id="cidx" value="<%=m1.getCidx()%>"><%=m1.getCidx() %></td>
				<td><%=m1.getCommentContent() %></td>
				<td><%=m1.getCommentDate() %></td>
				<td><input type=button value="삭제" id="commentDelete"></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>