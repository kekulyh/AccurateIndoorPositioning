<%-- <%@ include file="/WEB-INF/views/include.jsp"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Accurate Indoor Positioning :: Home</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="js/vendor/jquery-2.1.4.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/general.css" >
        <link rel="stylesheet" href="css/navbarhover.css" >
        <link rel="stylesheet" href="css/footer.css">
        <link rel="stylesheet" href="css/services.css" >
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
                    <a class="navbar-brand" href="main"><span class="glyphicon glyphicon-map-marker"></span> Accurate Indoor Positioning</a>
                </div>
                <!-- navbar collapse -->
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">

                        <li class="active"><a href="main">Home</a></li>

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


        <!-- Carousel -->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="img/carousel/first_slide.jpg" alt="First Slide">
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img src="img/carousel/second_slide.jpg" alt="Second Slide">
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img src="img/carousel/third_slide.jpg" alt="Third Slide">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- Carousel End -->

        <!-- Services -->
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="service-wrapper" onclick="location.href='device-status.html';">
                            <img src="img/service-icon/manage.png" alt="Service 1">
                            <h3>Manage</h3>
                            <p>Manage the devices status. Add, edit, search and delete devices.</p>
                            <a href="devicestatus" class="btn">Details</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" onclick="location.href='monitor.html';">
                        <div class="service-wrapper">
                            <img src="img/service-icon/monitor.png" alt="Service 2">
                            <h3>Monitor</h3>
                            <p>Monitor the devices on indoor maps. Track the devices and display the trace.</p>
                            <a href="monitorforzhaidi" class="btn">Details</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" onclick="location.href='alarm-history.html';">
                        <div class="service-wrapper">
                            <img src="img/service-icon/alarm.png" alt="Service 3">
                            <h3>Alarm</h3>
                            <p>Display and manage the alarm history. Modify the alarm settings.</p>
                            <a href="alarm-history.html" class="btn">Details</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6" onclick="location.href='monitor-statistics.html';">
                        <div class="service-wrapper">
                            <img src="img/service-icon/statistics.png" alt="Service 3">
                            <h3>Statistics</h3>
                            <p>Display the monitoring statistics. Review the monitoring video.</p>
                            <a href="monitor-statistics.html" class="btn">Details</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Services End -->






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
