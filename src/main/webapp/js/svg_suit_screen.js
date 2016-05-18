/**
 * JavaScript函数用于调整svg和地图尺寸适配屏幕, webkit引擎及firefox、chrome均可适用
 */

var svgWidth = document.getElementById("svgDiv").offsetWidth;
var svgHeight = document.getElementById("svgDiv").offsetHeight;
var divWidthDisplay = document.getElementById("divWidth");
var divHeightDisplay = document.getElementById("divHeight");
var svgAuto = document.getElementById("svgAuto");
var svgDiv = document.getElementById("svgDiv");

/* 显示div宽高，用于调试 */
divWidthDisplay.innerHTML=svgWidth;
divHeightDisplay.innerHTML=svgHeight;

/* 由于svg没有innerHTML，所以需要通过div节点来转换一下, 详见博客解释: http://blog.csdn.net/kekulyh/article/details/50986832 */
/* 三种大小的地图 */
var mapBg = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
var mapMd = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
var mapSm = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
var mapFlex = '<image xlink:href="img/maps/level_7_office_map.png" width="'+ svgWidth +'" height="'+ (svgWidth*177)/550 +'">';
/* 创建用于转换的div节点 */
var dummyBg = document.createElement('div');
var dummyMd = document.createElement('div');
var dummySm = document.createElement('div');
var dummyFlex = document.createElement('div');
/* 向其中添加svg节点，并把内容加入svg子节点 */
dummyBg.innerHTML = '<svg>' + mapBg + '</svg>';
dummyMd.innerHTML = '<svg>' + mapMd + '</svg>';
dummySm.innerHTML = '<svg>' + mapSm + '</svg>';
dummyFlex.innerHTML = '<svg>' + mapFlex + '</svg>';
/* 获取map的html内容 */
var svgChildNodesBg = dummyBg.childNodes[0].childNodes;
var svgChildNodesMd = dummyMd.childNodes[0].childNodes;
var svgChildNodesSm = dummySm.childNodes[0].childNodes;
var svgChildNodesFlex = dummyFlex.childNodes[0].childNodes;

/* set svg and map due to the screen size */
if(svgWidth>900){
	/* suit the large screen */
	svgAuto.style.width = 900;
	svgAuto.style.height = 290;
	/* replace the last child node of svg */
	svgAuto.replaceChild(svgChildNodesBg[0],svgAuto.lastChild);
	/* firefox: need to set the div height meanwhile, otherwise the div cannot change size */
	/* must only set the height of div, let the div suit svg. If set width of div, then width read in next loop will be fixed. */
	svgDiv.style.height = "320px";
}else if(svgWidth>733){
	/* suit the middle screen */
	svgAuto.style.width = 733;
	svgAuto.style.height = 236;
	svgAuto.replaceChild(svgChildNodesMd[0],svgAuto.lastChild);
	svgDiv.style.height = "266px";
}else if(svgWidth>550){
	/* suit the small screen */
	svgAuto.style.width = 550;
	svgAuto.style.height = 177;
	svgAuto.replaceChild(svgChildNodesSm[0],svgAuto.lastChild);
	svgDiv.style.height = "207px";
}else{
	/* suit the extreme small screen */
	svgAuto.style.width = svgWidth-1;
	svgAuto.style.height = (svgWidth*177)/550;
	svgAuto.replaceChild(svgChildNodesFlex[0],svgAuto.lastChild);
	svgDiv.style.height = ""+(svgWidth*177)/550+"px";
}

/* 屏幕尺寸变动，重新设置div与svg宽高，并清空地图 */
$(window).resize(function() {
	svgWidth = document.getElementById("svgDiv").offsetWidth;
	svgHeight = document.getElementById("svgDiv").offsetHeight;
	divWidthDisplay = document.getElementById("divWidth");
	divHeightDisplay = document.getElementById("divHeight");
	svgAuto = document.getElementById("svgAuto");
	svgDiv = document.getElementById("svgDiv");
	
	divWidthDisplay.innerHTML=svgWidth;
	divHeightDisplay.innerHTML=svgHeight;

	/* 由于svg没有innerHTML，所以需要通过div节点来转换一下, 详见博客解释:  */
	/* 三种大小的地图 */
	mapBg = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
	mapMd = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
	mapSm = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
	mapFlex = '<image xlink:href="img/maps/level_7_office_map.png" width="'+ svgWidth +'" height="'+ svgHeight +'">';
    /* 创建用于转换的div节点 */
    dummyBg = document.createElement('div');
    dummyMd = document.createElement('div');
    dummySm = document.createElement('div');
    dummyFlex = document.createElement('div');
    /* 向其中添加svg节点，并把内容加入svg子节点 */
    dummyBg.innerHTML = '<svg>' + mapBg + '</svg>';
    dummyMd.innerHTML = '<svg>' + mapMd + '</svg>';
    dummySm.innerHTML = '<svg>' + mapSm + '</svg>';
    dummyFlex.innerHTML = '<svg>' + mapFlex + '</svg>';
    /* 获取map的html内容 */
    svgChildNodesBg = dummyBg.childNodes[0].childNodes;
    svgChildNodesMd = dummyMd.childNodes[0].childNodes;
    svgChildNodesSm = dummySm.childNodes[0].childNodes;
    svgChildNodesFlex = dummyFlex.childNodes[0].childNodes;
    
	if(svgWidth>900){
		svgAuto.style.width = 900;
		svgAuto.style.height = 290;
		svgAuto.replaceChild(svgChildNodesBg[0],svgAuto.lastChild);
		svgDiv.style.height = "320px";
	}else if(svgWidth>733){
		svgAuto.style.width = 733;
		svgAuto.style.height = 236;
		svgAuto.replaceChild(svgChildNodesMd[0],svgAuto.lastChild);
		svgDiv.style.height = "266px";
	}else if(svgWidth>550){
		svgAuto.style.width = 550;
		svgAuto.style.height = 177;
		svgAuto.replaceChild(svgChildNodesSm[0],svgAuto.lastChild);
		svgDiv.style.height = "207px";
	}else{
		svgAuto.style.width = svgWidth-1;
		svgAuto.style.height = (svgWidth*177)/550;
		svgAuto.replaceChild(svgChildNodesFlex[0],svgAuto.lastChild);
		svgDiv.style.height = ""+(svgWidth*177)/550+"px";
	}
	
	/* 清现在坐标，第一个点不画轨迹，否则屏幕尺寸改变后，会出现上一次取得的坐标画出来的轨迹线 */
	xOld = null;
	yOld = null;
	
}); 