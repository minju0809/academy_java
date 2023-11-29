
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%
String homeAddress = (String) request.getAttribute("homeAddress");
String homeStr = (String) request.getAttribute("homeStr");
System.out.println("homeAddress: " + homeAddress + " homeStr: " + homeStr);
%>
<section>
	<br>
	<div align=center>
		<h2>게시판 만들기 프로젝트</h2>
		<br>
		
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:90%;height:350px;"></div>
	
		<p style="margin-top:-12px">
	    <em class="link">
	        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
	            <br>혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
	        </a>
	    </em>
		</p>
	
		<br>
		<input type=button value="집" name="myHome" onClick="mapK('myHome')" style="width: 100px; height: 30px"> &nbsp;
		<input type=button value="학원" name="academy" onClick="mapK('academy')" style="width: 100px; height: 30px">
	</div>
	<br>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5fd42cdd845577dc157f2510c3e96a73&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('<%=homeAddress %>', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=homeStr %></div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>

</section>


<%@ include file="/include/bottom.jsp"%>

