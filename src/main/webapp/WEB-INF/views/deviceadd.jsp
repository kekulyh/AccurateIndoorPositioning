<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Accurate Indoor Positioning :: Manage</title>
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

                <li class="dropdown active">
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

                <li class="dropdown">
                    <a href="monitor" class="dropdown-toggle" data-toggle="dropdown" data-target="monitor">Monitor<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="monitor">Monitor</a></li>
                        <li class="divider"></li>
                        <li><a href="monitorforzhaidi">Monitor For Zhaidi</a></li>
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
                <h1>Manage</h1>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">

            <!-- Sidebar -->
            <div class="col-md-2 col-sm-2 blog-sidebar">
                <h4>Device Status</h4>
                <form>
                    <ul class="recent-posts">
                    	<li><a href="devicestatus">Device Status</a></li>
                    </ul>
                </form>
                
                <h4>Device Manage</h4>
               	
                <form id="deviceform">
                	<ul class="recent-posts">
                		<li><a href="deviceadd">Add Device</a></li>
                		<li><a href="#">Search Device</a></li>
                		<li><a href="#">Edit Device</a></li>
                		<li><a href="#">Delete Device</a></li>
                	</ul>
                </form>
                
            </div>
            <!-- End Sidebar -->

			<!-- Map Content -->
            <div class="col-md-10 col-sm-10">
                <div class="blog-post blog-single-post">
					<!-- 标题 -->
                    <div class="single-post-title" align="center">
                        <h3>Device Manage</h3>
                    </div>
					<!-- 分隔线 -->
                    <div class="single-post-info"></div>

					<div class="">
							<br>
							<div class="col-md-2"></div>

							<div class="col-md-8 servc-info">
							<h3 class="">Add Device</h3>
								<form role="form" action="deviceadd" method="post">
								
									<!-- devicename为空，添加失败alert -->
			                        <div class="alert alert-danger alert-dismissable hide" id="devicenameNull">
			                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			                                <span aria-hidden="true">&times;</span>
			                            </button>
			                            <strong>ERROR! Device name is null.</strong>
			                        </div>
			                        
			                        <!-- macaddress为空，添加失败alert -->
			                        <div class="alert alert-danger alert-dismissable hide" id="macaddressNull">
			                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			                                <span aria-hidden="true">&times;</span>
			                            </button>
			                            <strong>ERROR! MAC address is null.</strong>
			                        </div>
			                        
			                        <script type="text/javascript">
			                            $("#${requestScope.alertDeviceadd}").attr("class","alert alert-danger");
			                        </script>
			                        
								
									<div class="form-group">
                            			<label for="deviceadd-devicename"><i class="icon-user"></i> <b>Device Name</b></label>
                            			<input class="form-control" id="deviceadd-devicename" type="text" placeholder="Device Name" name="deviceadd-devicename">
                        			</div>
                        			<div class="form-group">
                            			<label for="deviceadd-macaddress"><i class="icon-lock"></i> <b>MAC Address</b></label>
                            			<input class="form-control" id="deviceadd-macaddress" type="text" placeholder="MAC Address" name="deviceadd-macaddress">
                        			</div>
                        			
                        			<div class="form-group">
                            			<label for="deviceadd-model"><i class="icon-lock"></i> <b>Model</b></label>
	                        			<div>
		                        			<select class="form-control" name="deviceadd-devicemodel">
											  <option value="Model 1">Model 1</option>
											  <option value="Model 2">Model 2</option>
											  <option value="Model 3">Model 3</option>
											  <option value="Model 4">Model 4</option>
											  <option value="Model 5">Model 5</option>
											</select>
	                        			</div>
                        			</div>
                        			
                        			<div class="form-group">
                            			<label for="deviceadd-description"><i class="icon-lock"></i> <b>Description</b></label>
                            			<textarea class="form-control" id="deviceadd-description"  placeholder="Description" name="deviceadd-description"></textarea>
                        			</div>
                        			<div class="form-group text-center">
                            			<button type="submit" class="btn btn-info">Submit</button>
                            			<div class="clearfix"></div>
                        			</div>
								</form>
								<br>
								
							</div>

							<div class="col-md-2 "></div>
							<div class="clearfix"> </div>
						</div>
						<!-- Find Medicine End -->
                    
					<!-- 分隔线 -->
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

<!--Google Analytics: change UA-XXXXX-X to be your site's ID.-->
<script>
    var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
    (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
        g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
        s.parentNode.insertBefore(g,s)}(document,'script'));
</script>

</body>
</html>
