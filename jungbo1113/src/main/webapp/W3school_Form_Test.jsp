<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name='f1' method="get" autocomplete="on">
		아이디 <input type="text" id="id00" name="id" required><br>
		<input type="number"><br>
	  
		<input type="radio" id="html00" name="fav_language" value="HTML">
		<label for="html00">HTML</label>
  		<input type="radio" id="css00" name="fav_language" value="CSS" >
  		<label for="css00">CSS</label>
  		<input type="radio" id="javascript00" name="fav_language" value="JavaScript">
  		<label for="javascript00">JavaScript</label><br>
  		
  		<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
  		<label for="vehicle1"> bike</label><br>
  		<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
  		<label for="vehicle2"> car</label><br>
  		<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
  		<label for="vehicle3"> boat</label><br>
  	
  		<select id="cars" name="cars" onchange="f_onchange()">
  			<option value="volvo">Volvo</option>
  			<option value="saab">Saab</option>
  			<option value="fiat">Fiat</option>
  			<option value="audi">Audi</option>
  		</select>
  			
		<input type="submit" onClick="return f_click()" value="보내기">
	</form>
	
	
</body>

<script>
	function f_click() {
		alert("확인");
		
		f1.id.value = "ppk";
		f1.cars.options[3].selected = true;
		f1.fav_language[1].checked = true;
		f1.vehicle2.checked = true;
		f1.vehicle3.checked = true;
		return false;
	}
	
	function f_onchange() {
		for(i=0; i<4; i++) {
			f1.fav_language[i].checked = false;
			f1.vehicle2.checked = false;
			f1.vehicle3.checked = false;
		}
		f1.id.value = ""
	}
</script>

</html>
