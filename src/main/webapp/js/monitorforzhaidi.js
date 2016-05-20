/** 
 * Monitoring JavaScript functions: AJAX post request and map drawing.
 */

/* Define global variables */
var xOld;
var yOld;
var xNew;
var yNew;

/* Define global div size variables */
var svgHeight;
var svgWidth;

/* Define last div size variables, for judging the changing of screen size */
var svgHeightOld;
var svgWidthOld;

// Global variables for interval functions and clearInterval functions
var AjaxTimeout;
var AjaxInterval;


/** 
 * Get outer div sizes, for retrieving current screen size.
 */

function getDivWidthandHeight(){
	
	/* *
	 * col-lg: 901 x 320; SVG: 900 x 290
	 * col-md: 734 x 320; SVG: 733 x 236
	 * col-sm: 551 x 320; SVG: 550 x 177
	 * */
	
//	get outer div size
	svgWidth = document.getElementById("svgDiv").offsetWidth;
	svgHeight = document.getElementById("svgDiv").offsetHeight;
	
//	display sizes for testing
	document.getElementById("divWidth").innerHTML=svgWidth;
	document.getElementById("divHeight").innerHTML=svgHeight;
	
}


/** 
 * Clear the map and coordinate spots
 */

function cleanSvg(){
	
	getDivWidthandHeight();
	
	var svgAuto = document.getElementById("svgAuto");

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
	
	/* Clear map and coordinate spots */
	if(svgWidth>900){
		svgAuto.replaceChild(svgChildNodesBg[0],svgAuto.lastChild);
	}else if(svgWidth>733){
		svgAuto.replaceChild(svgChildNodesMd[0],svgAuto.lastChild);
	}else if(svgWidth>550){
		svgAuto.replaceChild(svgChildNodesSm[0],svgAuto.lastChild);
	}else{
//		Responsible for extreme small screen
		svgAuto.replaceChild(svgChildNodesFlex[0],svgAuto.lastChild);
	}
	
}


/** 
 * Coordinate drawing function
 */

function ShowDevice(x, y){
	var coordinateX = x;
	var coordinateY = y;
	var svgAuto = document.getElementById("svgAuto");
	var xmlns = "http://www.w3.org/2000/svg";
	var tSvgAuto = document.getElementById("svgAuto");

	/* Create spot image element*/
	var svgImg = document.createElementNS(xmlns,"image");

	/* add attributes to element (gait estimation method in CoordinateCalculation.coordinateCalculationWithGesture() ) */
	svgImg.href.baseVal = "img/location.png" ;
	svgImg.setAttributeNS(null,"x",coordinateX-7.5);
	svgImg.setAttributeNS(null,"y",coordinateY-7.5);
	svgImg.setAttributeNS(null,"height","15px");
	svgImg.setAttributeNS(null,"width","15px");
	
//	/* add attributes to element (integration of accel and velocity method in CoordinateCalculation.coordinateCalculationWithGesture() ) */
//	svgImg.href.baseVal = "img/location.png" ;
//	svgImg.setAttributeNS(null,"x",coordinateX-2);
//	svgImg.setAttributeNS(null,"y",coordinateY-2);
//	svgImg.setAttributeNS(null,"height","4px");
//	svgImg.setAttributeNS(null,"width","4px");

	/* append element to father node */
	tSvgAuto.appendChild(svgImg);
}


/**
 * Trace drawing function
 */

function DrawLine() {
	var group = document.getElementById("svgAuto");
	var xmlns = "http://www.w3.org/2000/svg";

	/* create line element */
    var line = document.createElementNS(xmlns,"line");

	/* define attributes */
    this.x1 = xOld;
    this.y1 = yOld;
    this.x2 = xNew;
    this.y2 = yNew;
    this.linecolor = "rgb(00,179,253)";
    this.linewidth = "1px";
    this.DrawLine = DrawLine;

    /* add attributes to element */
    line.setAttribute("x1", this.x1);
    line.setAttribute("y1", this.y1);
    line.setAttribute("x2", this.x2);
    line.setAttribute("y2", this.y2);
    line.style.setProperty("stroke", this.linecolor)
    line.style.setProperty("fill", this.linecolor)
    line.style.setProperty("stroke-width", this.linewidth)
    
    /* append element to father node */
    group.appendChild(line);
}

/**
 * Get current page name
 */

function pageName()
{
	var str = window.location.href;
	str=str.substring(str.lastIndexOf("/") + 1)
	return str;
}


/**
 * Interworking function AjaxMap
 */
function AjaxMap(){
	// retrieve current page name as url
	var currentPage = pageName();
	
	// jQuery AJAX method
	$.ajax({
		type : 'POST',
		url : ''+ currentPage +'',
		data : 'action='+ currentPage +'',
		contentType : 'application/json',
		dataType : 'json',
		success : 
			function(data) {
				/* retrieve JSON data from server */
				var dataEval = eval(data);
				
				/* get div width and height, determine the screen size and set map size */
				getDivWidthandHeight();
				
				/* determine screen size and coordinate scale */
				if(svgWidth>900){
					/* set coordinate */
					xNew = dataEval.coordinateX;
					yNew = dataEval.coordinateY;
				}else if(svgWidth>733){
					/* set coordinate */
					xNew = dataEval.coordinateX * 733/900;
					yNew = dataEval.coordinateY * 733/900;
				}else if(svgWidth>550){
					/* set coordinate */
					xNew = dataEval.coordinateX * 550/900;
					yNew = dataEval.coordinateY * 550/900;
				}else{
					xNew = dataEval.coordinateX * svgWidth/900;
					yNew = dataEval.coordinateY * svgWidth/900;
				}

				/* if first spot, do not draw trace */
				if (xOld == null || yOld == null) {
					xOld = xNew;
					yOld = yNew;
					}
				/* if not first spot, normal drawing */
				if (xNew != xOld || yNew != yOld) {
					
					/* display coordinate */
					ShowDevice(xNew, yNew);

					/* draw traces */
					DrawLine();

					/* set coordianteOld, for determining next trace */
					xOld = xNew;
					yOld = yNew;

					/* display coordinate values */
					document.getElementById("coordinateXLabel").innerHTML=xNew;
					document.getElementById("coordinateYLabel").innerHTML=yNew;
				}
				
			},
		error : 
			function(XMLHttpRequest, textStatus, errorThrown) {
			document.getElementById("coordinateXLabel").innerHTML="null";
			document.getElementById("coordinateYLabel").innerHTML="null";
	    	}
		});// ajax interval end
	}

/**
 * Interval function
 */
function enter() {

	/* start first timeout 0.1 second, execute once */
    AjaxTimeout = setTimeout(function() {
		AjaxMap();
	},100);

	/* set execution interval 0.1 second */
	AjaxInterval = setInterval(function(){
		AjaxMap();
	},100);
	
}

/**
 * Click button to start interval
 */
$(function(){
	$("#deviceform").click( function(){
		var svgAuto = document.getElementById("svgAuto");

		/* Clear traces, do not draw trace for first node */
		xOld = null;
		yOld = null;

		/* Clear interval, otherwise every time pressing button would add an interval function. */
		clearInterval(AjaxInterval);

		/* Clear coordinate spots */
		cleanSvg();

		/* Start interval */
		enter();
	}); 
});


/**
 * Reset interval, stop post request
 */
function AjaxReset(){
	// jQuery AJAX method
	$.ajax({
		type : 'POST',
		url : 'resetcoordinate',
		data : 'action=resetcoordinate',
		contentType : 'application/json',
		dataType : 'json',
		success : 
			function(data) {
				/* retrieve JSON data from server */
				var dataEval = eval(data);
				
				/* get div width and height, determine the screen size and set map size */
				getDivWidthandHeight();
				
				/* determine screen size and coordinate scale */
				if(svgWidth>900){
					/* set coordinate */
					xNew = dataEval.coordinateX;
					yNew = dataEval.coordinateY;
				}else if(svgWidth>733){
					/* set coordinate */
					xNew = dataEval.coordinateX * 733/900;
					yNew = dataEval.coordinateY * 733/900;
				}else if(svgWidth>550){
					/* set coordinate */
					xNew = dataEval.coordinateX * 550/900;
					yNew = dataEval.coordinateY * 550/900;
				}else{
					xNew = dataEval.coordinateX * svgWidth/900;
					yNew = dataEval.coordinateY * svgWidth/900;
				}

				/* if first spot, do not draw trace */
				if (xOld == null || yOld == null) {
					xOld = xNew;
					yOld = yNew;
					}
				/* if not first spot, normal drawing */
				if (xNew != xOld || yNew != yOld) {
					
					/* display coordinate */
					ShowDevice(xNew, yNew);

					/* draw traces */
					DrawLine();

					/* set coordianteOld, for determining next trace */
					xOld = xNew;
					yOld = yNew;

					/* display coordinate values */
					document.getElementById("coordinateXLabel").innerHTML=xNew;
					document.getElementById("coordinateYLabel").innerHTML=yNew;
				}
				
			},
		error : 
			function(XMLHttpRequest, textStatus, errorThrown) {
			document.getElementById("coordinateXLabel").innerHTML="null";
			document.getElementById("coordinateYLabel").innerHTML="null";
	    	}
		});// ajax interval end
	}

/**
 * reset interval function
 */
function reset() {
	
	/* start first timeout 0.1 second, execute once */
    AjaxTimeout = setTimeout(function() {
		AjaxReset();
	},100);
    
}

/**
 * resetform post request
 */

$(function(){
	$("#resetform").click( function(){
		
		var svgAuto = document.getElementById("svgAuto");

		/* Clear traces, do not draw trace for first node */
		xOld = null;
		yOld = null;

		/* Clear interval, otherwise every time pressing button would add an interval function. */
		clearInterval(AjaxInterval);

		/* Clear coordinate spots */
		cleanSvg();
		
		/* reset original coordinate value */
		reset();
	}); 
});

/**
 * abortAjax button function
 */

$(function(){
	$("#abortAjax").click( function(){
		clearInterval(AjaxInterval);
	}); 
});

/**
 * android app function 
 */

function androidAjax(){
//	alert("androidAjax");
	var svgAuto = document.getElementById("svgAuto");

	/* Clear traces, do not draw trace for first node */
	xOld = null;
	yOld = null;

	/* Clear interval, otherwise every time pressing button would add an interval function. */
	clearInterval(AjaxInterval);

	/* Clear coordinate spots */
	cleanSvg();

	/* Start interval */
	enter();
}

function androidAbort(){
//	alert("androidAbort");
	clearInterval(AjaxInterval);
}


