///** 
// * SVG画板上根据鼠标坐标画点 
// */
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
 * monitor界面主要功能JavaScript，用于实现点击按钮后的AJAX交互，以及地图坐标的绘制
 */

/* 定义坐标为全局变量 */
var xOld;
var yOld;
var xNew;
var yNew;

/* 定义div宽高为全局变量 */
var svgHeight;
var svgWidth;

/* 定义上一次的div宽高变量，用以判断是否屏幕尺寸改变了 */
var svgHeightOld;
var svgWidthOld;

//全局变量，enter函数里定义，这样主函数后面才可以clearInterval
var AjaxTimeout;
var AjaxInterval;



/** 
 * 自定义的取外层div宽高的函数, 用于确定当前的屏幕尺寸
 */

function getDivWidthandHeight(){
	
	/* col-lg: 901 x 320; SVG: 900 x 290
	 * col-md: 734 x 320; SVG: 733 x 236
	 * col-sm: 551 x 320; SVG: 550 x 177
	 * 
	 * */
	
//	取得svg外层div的宽高
	svgWidth = document.getElementById("svgDiv").offsetWidth;
	svgHeight = document.getElementById("svgDiv").offsetHeight;
	
//	显示该宽高用于调试
	document.getElementById("divWidth").innerHTML=svgWidth;
	document.getElementById("divHeight").innerHTML=svgHeight;
	
}

///** 
// * 自定义的设置svg和外层div宽高的函数
// */
//
//function setSvgDivWidthHeight(){
//	
//	/* col-lg: 901 x 320;  SVG: 900 x 290
//	 * col-md: 734 x 266;  SVG: 733 x 236
//	 * col-sm: 551 x 207;  SVG: 550 x 177
//	 * 
//	 * */
//	
//	var svgAuto = document.getElementById("svgAuto");
//	
//	var svgDiv = document.getElementById("svgDiv");
//	
//	if(svgWidth>900){
//		svgAuto.style.width = 900;
//		svgAuto.style.height = 290;
//		svgAuto.innerHTML = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
//		
//		/* 只能设置高度，让div适配svg，如果同时设置宽度，则下一轮询时，读取的宽度值会固定，从而无法缩放svg */
////		svgDiv.style.width = "901px";
//		svgDiv.style.height = "320px";
//		
//	}else if(svgWidth>733){
//		svgAuto.style.width = 733;
//		svgAuto.style.height = 236;
//		svgAuto.innerHTML = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
//		
////		svgDiv.style.width = "734px";
//		svgDiv.style.height = "266px";
//		
//	}else if(svgWidth>550){
//		svgAuto.style.width = 550;
//		svgAuto.style.height = 177;
//		svgAuto.innerHTML = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
//		
////		svgDiv.style.width = "551px";
//		svgDiv.style.height = "207px";
//		
//	}
//}

/** 
 * 自定义清地图函数
 */

function cleanSvg(){
	
	getDivWidthandHeight();
	
	var svgAuto = document.getElementById("svgAuto");

	/* 由于svg没有innerHTML，所以需要通过div节点来转换一下, 详见博客解释:  */
	/* 三种大小的地图 */
	var mapBg = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
	var mapMd = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
	var mapSm = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
    /* 创建用于转换的div节点 */
    var dummyBg = document.createElement('div');
    var dummyMd = document.createElement('div');
    var dummySm = document.createElement('div');
    /* 向其中添加svg节点，并把内容加入svg子节点 */
    dummyBg.innerHTML = '<svg>' + mapBg + '</svg>';
    dummyMd.innerHTML = '<svg>' + mapMd + '</svg>';
    dummySm.innerHTML = '<svg>' + mapSm + '</svg>';
    /* 获取map的html内容 */
    var svgChildNodesBg = dummyBg.childNodes[0].childNodes;
    var svgChildNodesMd = dummyMd.childNodes[0].childNodes;
    var svgChildNodesSm = dummySm.childNodes[0].childNodes;
	
	/* 清地图上轨迹 */
	if(svgWidth>900){
		svgAuto.replaceChild(svgChildNodesBg[0],svgAuto.lastChild);
	}else if(svgWidth>733){
		svgAuto.replaceChild(svgChildNodesMd[0],svgAuto.lastChild);
	}else if(svgWidth>550){
		svgAuto.replaceChild(svgChildNodesSm[0],svgAuto.lastChild);
	}
	
}


/** 
 * 自定义的画坐标的函数
 */

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
				
				/* 取div宽高，判断屏幕大小，由此设置地图大小 */
				getDivWidthandHeight();
				/* 判断当前屏幕尺寸，确定坐标比例 */
				if(svgWidth>900){
					/* 赋值坐标 */
					xNew = dataEval.coordinateX;
					yNew = dataEval.coordinateY;
				}else if(svgWidth>733){
					/* 赋值坐标 */
					xNew = dataEval.coordinateX * 733/900;
					yNew = dataEval.coordinateY * 733/900;
				}else if(svgWidth>550){
					/* 赋值坐标 */
					xNew = dataEval.coordinateX * 550/900;
					yNew = dataEval.coordinateY * 550/900;
				}

				/* 判断是否为第一个点，第一个点不画轨迹 */
				if (xOld == null || yOld == null) {
					xOld = xNew;
					yOld = yNew;
					}
				/* 如果不是第一个点，则正常画坐标 */
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

		/* 清轮询，否则每点一次按钮都会增加一个轮询函数，使得画坐标速度倍增，逻辑错误 */
		clearInterval(AjaxInterval);

		/* 清地图上轨迹 */
		cleanSvg();

		/* 执行轮询 */
		enter();
	}); 
});
