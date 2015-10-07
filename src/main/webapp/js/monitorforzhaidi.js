/** 
 * SVG画板上根据鼠标坐标画点 
 */
//
//function SvgClick()
//{
//    var svgMap = document.getElementById("svgMap");
//    svgMap.onclick = function(event)
//    {
//        var xmlns = "http://www.w3.org/2000/svg";
//        var tSvgMap = document.getElementById("svgMap");
//
//		/* 创建元素以添加图片 */
//        var svgImg = document.createElementNS(xmlns,"image");
//
//		/* 元素添加属性 */
//        svgImg.href.baseVal = "img/location.png" ;
//        svgImg.setAttributeNS(null,"x",event.offsetX-7.5);
//        svgImg.setAttributeNS(null,"y",event.offsetY-7.5);
//        svgImg.setAttributeNS(null,"height","15px");
//        svgImg.setAttributeNS(null,"width","15px");
//
//		/* 父元素加上新创建的元素 */
//        tSvgMap.appendChild(svgImg);
//    }
//}

/** 
 * 自定义的画坐标的函数
 */

/* 定义坐标为全局变量 */
var xOld;
var yOld;
var xNew;
var yNew;

function ShowDevice(x, y){
	var coordinateX = x;
	var coordinateY = y;
	var svgAuto = document.getElementById("svgAuto");
	var xmlns = "http://www.w3.org/2000/svg";
	var tSvgAuto = document.getElementById("svgAuto");

	/* 创建元素以添加图片 */
	var svgImg = document.createElementNS(xmlns,"image");

	/* 元素添加属性 */
	svgImg.href.baseVal = "img/location.png" ;
	svgImg.setAttributeNS(null,"x",coordinateX-7.5);
	svgImg.setAttributeNS(null,"y",coordinateY-7.5);
	svgImg.setAttributeNS(null,"height","15px");
	svgImg.setAttributeNS(null,"width","15px");

	/* 父元素加上新创建的元素 */
	tSvgAuto.appendChild(svgImg);
}


/**
 * 自定义的画轨迹函数
 */

function DrawLine() {
	var group = document.getElementById("svgAuto");
	var xmlns = "http://www.w3.org/2000/svg";

	/* 创建元素以画线 */
    var line = document.createElementNS(xmlns,"line");

	/* 定义属性 */
    this.x1 = xOld;
    this.y1 = yOld;
    this.x2 = xNew;
    this.y2 = yNew;
    this.linecolor = "rgb(00,179,253)";
    this.linewidth = "1px";
    this.DrawLine = DrawLine;

    /* 元素添加属性 */
    line.setAttribute("x1", this.x1);
    line.setAttribute("y1", this.y1);
    line.setAttribute("x2", this.x2);
    line.setAttribute("y2", this.y2);
    line.style.setProperty("stroke", this.linecolor)
    line.style.setProperty("fill", this.linecolor)
    line.style.setProperty("stroke-width", this.linewidth)
    
    /* 父元素加上新创建的元素 */
    group.appendChild(line);
}


/**
 * 自定义的AJAX交互函数
 */

function AjaxMap(){
	//jQuery的AJAX方法
	$.ajax({
		type : 'POST',
		url : 'monitor',
		data : 'action=monitor',
		contentType : 'application/json',
		dataType : 'json',
		success : 
			function(data) {
				/* 取后台传的JSON值 */
				var dataEval = eval(data);

				/* 赋值坐标 */
				xNew = dataEval.coordinateX;
				yNew = dataEval.coordinateY;

				/* 判断是否为第一个点，第一个点不画轨迹 */
				if (xOld == null || yOld == null) {
					xOld = xNew;
					yOld = yNew;
					}
				if (xNew != xOld || yNew != yOld) {
					/* 显示坐标点 */
					ShowDevice(xNew, yNew);

					/* 画轨迹 */
					DrawLine();

					/* 坐标赋给Old，为下一个轨迹使用 */
					xOld = xNew;
					yOld = yNew;

					/* 显示坐标 */
					document.getElementById("coordinateXLabel").innerHTML=xNew;
					document.getElementById("coordinateYLabel").innerHTML=yNew;
				}
				
				
			},
		error : 
			function(XMLHttpRequest, textStatus, errorThrown) {
			document.getElementById("coordinateXLabel").innerHTML="null";
			document.getElementById("coordinateYLabel").innerHTML="null";
	    	}
		});//ajax轮询函数结束
	}

/**
 * 自定义的轮询函数
 */

//全局变量，后面才可以clearInterval
var AjaxTimeout;
var AjaxInterval;

function enter() {

	/* 初始执行一次 */
    AjaxTimeout = setTimeout(function() {
		AjaxMap();
	},100);

	/* 设置每一秒轮询一次 */
	AjaxInterval = setInterval(function(){
		AjaxMap();
	},100);
	
}

/**
 * 点击按钮执行轮询
 */

$(function(){
	$("#deviceform").click( function(){
		var svgAuto = document.getElementById("svgAuto");

		/* 清现在坐标，第一个点不画轨迹 */
		xOld = null;
		yOld = null;

		/* 清轮询设置，否则轮询函数会增多 */
		clearInterval(AjaxInterval);

		/* 清地图上轨迹 */
		svgAuto.innerHTML = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';

		/* 执行轮询 */
		enter()
	}); 
});
