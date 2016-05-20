<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Accurate Indoor Positioning :: Monitor</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="js/vendor/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/general.css" >
<link rel="stylesheet" href="css/navbarhover.css" >
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/services.css" >
<link rel="stylesheet" href="css/blog.css" >
</head>

<!-- <body> -->
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->

<!-- application content -->

<!-- Navigation -->
<div class="navbar navbar-default navbar-static-top">
    <div class="container">

        <!-- navbar header -->
        <div class="navbar-header">
            <a class="navbar-brand" href="main"><span class="glyphicon glyphicon-map-marker"></span>Accurate Indoor Positioning</a>
        </div>
        <!-- navbar collapse -->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">

                <li><a href="main">Home</a></li>

                <li class="dropdown">
                    <a href="devicestatus" class="dropdown-toggle" data-toggle="dropdown" data-target="devicestatus">Manage<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="devicestatus">Device Status</a></li>
                        <li class="divider"></li>
                        <li><a href="deviceadd">Add Device</a></li>
                        <li><a href="search-device.html">Search Device</a></li>
                        <li><a href="edit-device.html">Edit Device</a></li>
                        <li><a href="delete-device.html">Delete Device</a></li>
                    </ul>
                </li>

                <li class="dropdown active">
                            <a href="monitor" class="dropdown-toggle" data-toggle="dropdown" data-target="monitor">Monitor<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="monitor">Monitor</a></li>
                                <li class="divider"></li>
                                <li><a href="monitorforzhaidi">Monitor For Zhaidi</a></li>
                                <li><a href="monitorgesture">Monitor Gesture</a></li>
                                <li><a href="monitorandroid">Monitor For Android</a></li>
                            </ul>
                        </li>

                <li class="dropdown">
                    <a href="alarm-history.html" class="dropdown-toggle" data-toggle="dropdown" data-target="#">Alarm<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="alarm-history.html">Alarm History</a></li>
                        <li><a href="alarm-settings.html">Alarm Settings</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="monitor-statistics.html" class="dropdown-toggle" data-toggle="dropdown" data-target="#">Statistics<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="monitor-statistics.html">Monitor Statistics</a></li>
                        <li><a href="monitor-history.html">Monitor History</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="user-setting.html" class="dropdown-toggle" data-toggle="dropdown" data-target="#">Setup<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="user-setting.html">User Setting</a></li>
                        <li><a href="map-setting.html">Map Setting</a></li>
                    </ul>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="register">Register</a></li>
                <li><a href="login">Login</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- Navigation End -->


<!-- Monitor -->
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Monitor Coordinate</h1>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">

            <!-- Sidebar -->
            <div class="col-md-2 col-sm-2 blog-sidebar">
                <h4>Search devices</h4>
                <form>
                    <div class="input-group">
                        <input class="form-control input-md" id="appendedInputButtons" type="text">
                        <span class="input-group-btn">
                            <button class="btn btn-primary btn-md" type="button">Search</button>
                        </span>
                    </div>
                </form>
                <div class="single-post-info"></div>
                <h4>Devices</h4>
               	
                <form id="deviceform">
                	<ul>
                		<li><input type="button" class="btn btn-default" id="device1" name="device1" value="Device1"/></li>
                	</ul>
                </form>
                <form id="resetform">
                	<ul>
                		<li><input type="button" class="btn btn-danger" id="resetdevice1" name="resetdevice1" value="Reset Device1"/></li>
                	</ul>
                </form>
                
            </div>
            <!-- End Sidebar -->

			<!-- Map Content -->
            <div class="col-md-10 col-sm-10">
                <div class="blog-post blog-single-post">
					<!-- Title -->
                    <div class="single-post-title" align="center">
                        <h3>Level 7 Office Map</h3>
                    </div>
					<!-- Divider -->
                    <div class="single-post-info"></div>

					<!-- SVG sketch board: click to attach spot image -->
                    <!-- <div class="single-post-image">
                    	<h5 class="bg-primary">Click On Map To Draw Coordinates (Test)</h5>
                        <svg id="svgMap" version="1.1" xmlns="http://www.w3.org/2000/svg" style="width:900px;height:290px;border:0px solid black;">
                            <image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">
                        </svg>
                    </div> -->
                    
                    <!-- Divider -->
                    <!-- <div class="single-post-info"></div> -->
                    
                    <!-- SVG sketch board: AJAX post request -->
					<div id="svgDiv" class="single-post-image">
						<h5 class="bg-primary">Click Device Button To Draw Coordinates (Test)</h5>
                        <svg id="svgAuto" version="1.1" xmlns="http://www.w3.org/2000/svg" style="width:900px;height:290px;border:0px solid black;">
                            <image xlink:href="img/maps/level_7_office_map.png" width="900px" height="290px">
                        </svg>
                    </div>
                    <br>
                    
                    <!-- Display coordinate value -->
                    <div>
                    	<div class="bg-info text-left"  >Coordinate X : <span id="coordinateXLabel"></span></div>
                    	<div class="bg-info text-left"  >Coordinate Y : <span id="coordinateYLabel"></span></div>
                    </div>
                    
                    <!-- Display screen width & height value -->
                    <div>
                    	<div class="bg-info text-left"  >Width : <span id="divWidth"></span></div>
                    	<div class="bg-info text-left"  >Height : <span id="divHeight"></span></div>
                    </div>
                    
					<!-- Divider -->
                    <div class="single-post-info"></div>
                </div>
            </div>
            <!-- End Map Content -->
            
        </div>
    </div>
</div>


<!-- Footer -->
<div class="footer">
    <div class="container">
        <div class="row">

            <div class="col-footer col-md-6 col-xs-6">
                <h3>About Us</h3>
                <ul class="no-list-style footer-navigate-section">
                    <li><p><b>Accurate Indoor Positioning</b></p></li>
                    <li><p><b>Proposer:</b> Yahong Liu</p></li>
                    <li><p><b>Supervisor:</b> Zihuai Lin</p></li>
                </ul>
            </div>
            <div class="col-footer col-md-6 col-xs-6">
                <h3>Contacts</h3>
                <p class="contact-us-details">
                    <b>Address:</b> J03 - Electrical Engineering Building<br/>
                    <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>The University of Sydney NSW 2006 Australia<br/>
                    <b>Phone:</b> +61 0123456789<br/>
                    <b>Fax:</b> +61 0123456789<br/>
                    <b>Email:</b> <a href="mailto:yliu6900@uni.sydney.edu.au">yliu6900@uni.sydney.edu.au</a>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="footer-copyright">&copy; 2015 kekulyh. All rights reserved.</div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- scripts -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-2.1.4.min.js"><\/script>')</script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
<script src="js/monitorforzhaidi.js"></script>
<script src="js/svg_suit_screen.js"></script>

<!--Google Analytics: change UA-XXXXX-X to be your site's ID.-->
<script>
    var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
    (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
        g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
        s.parentNode.insertBefore(g,s)}(document,'script'));
</script>

</body>
</html>
