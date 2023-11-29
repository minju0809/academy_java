
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<br>
	<div align=center>
		<h2>게시판 만들기 프로젝트</h2>
		<br>
		
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:90%;height:350px; "></div>
	
		<br>
		<input type=button value="집" name="myHome" onClick="mapK('myHome')" style="width: 100px; height: 30px"> &nbsp;
		<input type=button value="학원" name="academy" onClick="mapK('academy')" style="width: 100px; height: 30px">
	</div>
	<br>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5fd42cdd845577dc157f2510c3e96a73"></script>

</section>


<script>
let latitude = "37.54326";
let longitude = "126.728533";

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
        
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

function mapK(sw) {
	
	//alert("우리집")  
	if (sw == "myHome") {
		latitude = "37.54326";
		longitude = "126.728533";			
	} else if (sw == "academy") {
		latitude = "37.48453469";
		longitude = "126.92992323";
	}
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
        
        level: 3 // 지도의 확대 레벨
    };

	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
}

</script>

<%@ include file="/include/bottom.jsp"%>

