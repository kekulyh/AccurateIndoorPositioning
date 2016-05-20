/**
 * JavaScript functions for adjusting svg and map sizes. Availble for Webkit,Gecko and Trident engine.
 */

var svgWidth = document.getElementById("svgDiv").offsetWidth;
var svgHeight = document.getElementById("svgDiv").offsetHeight;
var divWidthDisplay = document.getElementById("divWidth");
var divHeightDisplay = document.getElementById("divHeight");
var svgAuto = document.getElementById("svgAuto");
var svgDiv = document.getElementById("svgDiv");

/* Display div size for testig */
divWidthDisplay.innerHTML=svgWidth;
divHeightDisplay.innerHTML=svgHeight;

/* Since svg does not have innerHTML, we need to transfer through div child node. Details see: http://blog.csdn.net/kekulyh/article/details/50986832 */
/* Map of four sizes */
var mapBg = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
var mapMd = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
var mapSm = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
var mapFlex = '<image xlink:href="img/maps/level_7_office_map.png" width="'+ svgWidth +'" height="'+ (svgWidth*177)/550 +'">';
/* Create dummy node for transforming */
var dummyBg = document.createElement('div');
var dummyMd = document.createElement('div');
var dummySm = document.createElement('div');
var dummyFlex = document.createElement('div');
/* Add svg child nodes to dummy nodes and add contents into svg child node. */
dummyBg.innerHTML = '<svg>' + mapBg + '</svg>';
dummyMd.innerHTML = '<svg>' + mapMd + '</svg>';
dummySm.innerHTML = '<svg>' + mapSm + '</svg>';
dummyFlex.innerHTML = '<svg>' + mapFlex + '</svg>';
/* Retrieve html contents of map */
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

/* When screen size changes, set div and svg size again, clear coordinates. */
$(window).resize(function() {
	svgWidth = document.getElementById("svgDiv").offsetWidth;
	svgHeight = document.getElementById("svgDiv").offsetHeight;
	divWidthDisplay = document.getElementById("divWidth");
	divHeightDisplay = document.getElementById("divHeight");
	svgAuto = document.getElementById("svgAuto");
	svgDiv = document.getElementById("svgDiv");
	
	divWidthDisplay.innerHTML=svgWidth;
	divHeightDisplay.innerHTML=svgHeight;

	/* Since svg does not have innerHTML, we need to transfer through div child node. Details see: http://blog.csdn.net/kekulyh/article/details/50986832 */
	/* Map of four sizes */
	mapBg = '<image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">';
	mapMd = '<image xlink:href="img/maps/level_7_office_map.png" width="733px" height="236px">';
	mapSm = '<image xlink:href="img/maps/level_7_office_map.png" width="550px" height="177px">';
	mapFlex = '<image xlink:href="img/maps/level_7_office_map.png" width="'+ svgWidth +'" height="'+ svgHeight +'">';
	/* Create dummy node for transforming */
    dummyBg = document.createElement('div');
    dummyMd = document.createElement('div');
    dummySm = document.createElement('div');
    dummyFlex = document.createElement('div');
    /* Add svg child nodes to dummy nodes and add contents into svg child node. */
    dummyBg.innerHTML = '<svg>' + mapBg + '</svg>';
    dummyMd.innerHTML = '<svg>' + mapMd + '</svg>';
    dummySm.innerHTML = '<svg>' + mapSm + '</svg>';
    dummyFlex.innerHTML = '<svg>' + mapFlex + '</svg>';
    /* Retrieve html contents of map */
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
	
	/* Clear current coordinates spots. Set old variables to null, otherwise next loop will show invalid walking traces. */
	xOld = null;
	yOld = null;
	
}); 