<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Monitor Android</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="js/vendor/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>

	<div id="svgDiv">
		<svg id="svgAuto" version="1.1" xmlns="http://www.w3.org/2000/svg" style="width:900px;height:290px;border:0px solid black;">
			<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">
		</svg>
	</div>
	<br>
	
	<!-- 显示坐标 -->
	<div>
		<div class="bg-info text-left"  >Coordinate X : <span id="coordinateXLabel"></span></div>
		<div class="bg-info text-left"  >Coordinate Y : <span id="coordinateYLabel"></span></div>
	</div>
	
	<!-- 显示宽高 -->
	<div>
		<div class="bg-info text-left"  >Width : <span id="divWidth"></span></div>
		<div class="bg-info text-left"  >Height : <span id="divHeight"></span></div>
	</div>
	
	<!-- 
	<div>
		<form id="deviceform">
        	<ul>
        		<li><input type="button" class="btn btn-default" id="device1" name="device1" value="Device1 AJAX"/></li>
        	</ul>
        </form>
        <form id="abortAjax">
        	<ul>
        		<li><input type="button" class="btn btn-default" id="abort" name="abort" value="abort"/></li>
        	</ul>
        </form>
	</div>
	 -->
	

<script>window.jQuery || document.write('<script src="js/vendor/jquery-2.1.4.min.js"><\/script>')</script>
<script src="js/monitorforzhaidi.js"></script>
<script src="js/svg_suit_screen.js"></script>

</body>
</html>