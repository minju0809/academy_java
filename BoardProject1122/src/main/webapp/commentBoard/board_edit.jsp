
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
		  content : $('#content').val(),
		  postcode : $('#postcode').val(),
		  address : $('#address').val(),
		  detail_address : $('#detail_address').val(),
		  extra_address : $('#extra_address').val()
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
		<table border=1>
			<tr>
				<td width=400 height=400>
					<div id="map" style="width:100%;height:100%;"></div>
				</td>
				<td width=400 height=400>
					<table border=1 style="width:100%;height:100%;">
						<tr><th>번호</th><td><input type=text name=idx id="idx" size=10 value="<%=m.getIdx()%>" readonly></td></tr>
						<tr><th>제목</th><td><input type=text name=title id="title" size=30  value="<%=m.getTitle()%>"></td></tr>
						<tr><th>글쓴이</th><td><input type=text name=sname id="sname" value="<%=m.getSname()%>"></td></tr>
						<tr><th>우편번호</th><td><input type=text name=postcode id="postcode" size=10 value="<%=m.getPostcode()%>"></td></tr>
						<tr><th>주소</th><td><input type=text name=address id="address" value="<%=m.getAddress()%>"></td></tr>
						<tr><th>상세주소</th><td><input type=text name=detail_address id="detail_address" value="<%=m.getDetail_address()%>"></td></tr>
						<tr><th>참고항목</th><td><input type=text name=extra_address id="extra_address" value="<%=m.getExtra_address()%>"></td></tr>
						<tr><th>내용</th><td><textarea cols=40 rows=5 name=content id="content"><%=m.getContent()%></textarea></td></tr>
						<tr><td colspan=2 align=center>
							<input type=button value="글수정하기" id="updateK"> &emsp;
							<input type=button value="목록보기" id="listK">
							<%-- <input type="button" id="listK" value="목록보기" onclick="action='<%=path%>/CommentController?sw=S'"></td> --%>
						</td></tr>
					</table>
					<%-- <form action="<%=path%>/CommentController"> --%>
				</td>
			</tr>
		</table>
		<input type=hidden name=sw value="CI" id="cisw">
		<input type=hidden name=comment_idx value="<%=m.getIdx() %>" id=comment_idx>
			<table border=1 width=816>
				<tr>
					<td align=center>
						<input type=text size=90% name=commentContent id=commentContent>
						<input type=button id="commentInsert" value="코맨트저장">
					</td>
				</tr>
			</table>
		
		<table border=1 width=816>
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

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5fd42cdd845577dc157f2510c3e96a73&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.54326, 126.728533), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('<%=m.getAddress() %>', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><a href="http://naver.com" target="_blank"><%=m.getExtra_address() %></a></div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>

<%@ include file="/include/bottom.jsp"%>
