<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Accurate Indoor Positioning</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--<link rel="stylesheet" href="css/normalize.css">-->
    <!--<link rel="stylesheet" href="css/main.css">-->

    <!--<script src="js/vendor/modernizr-2.6.2.min.js"></script>-->
    <script src="js/vendor/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/general.css" >
    <link rel="stylesheet" href="css/navbarhover.css" >
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/registerlogin.css">
</head>

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
                    <a href="device-status.html" class="dropdown-toggle" data-toggle="dropdown" data-target="device-status.html">Manage<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="device-status.html">Device Status</a></li>
                        <li class="divider"></li>
                        <li><a href="add-device.html">Add Device</a></li>
                        <li><a href="search-device.html">Search Device</a></li>
                        <li><a href="edit-device.html">Edit Device</a></li>
                        <li><a href="delete-device.html">Delete Device</a></li>
                    </ul>
                </li>

                <li><a href="monitor">Monitor</a></li>

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


<!-- Password Reset -->
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Password Reset</h1>
            </div>
        </div>
    </div>
</div>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-sm-offset-3">
                <div class="basic-login">
                    <form>
                        <div class="form-group">
                            <label for="restore-email"><i class="icon-envelope"></i> <b>Enter Your Email</b></label>
                            <input class="form-control" id="restore-email" type="text" placeholder="">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-warning pull-right">Reset Password</button>
                            <div class="clearfix"></div>
                        </div>
                    </form>
                </div>
            </div>
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
