/** 
 * Gesture JavaScript functions
 */

// Define global variable node
var node;

/** 
 * Init Graph3dView
 */
function init(){
	items = [
             {
                 label: 'Start',
                 groupId: 'monitorgesture',
                 action: function(){
//                     alert("start");
                	 start();
                 }
             },
             {
                 label: 'Stop',
                 groupId: 'monitorgesture',
                 selected: true,
                 action: function(){
//                	 alert("stop");
                	 stop();
                 }
             },
         ];

         var toolbar = new ht.widget.Toolbar(items);
         dataModel = new ht.DataModel();
         var g3d = new ht.graph3d.Graph3dView(dataModel);

         borderPane = new ht.widget.BorderPane();
         borderPane.setTopView(toolbar);
         borderPane.setCenterView(g3d);

         view = borderPane.getView();
         view.className = 'main';
         document.body.appendChild(view);
         window.addEventListener('resize', function (e) {
             borderPane.invalidate(0);
         }, false);

//    set viewing camera
    g3d.setEye([0, 300, 1000]);
//    set rotatable
    g3d.setRotatable(false);
//    set zoomable
    g3d.setZoomable(false);
//    set pannable
    g3d.setPannable(false);
//    set walkable
    g3d.setWalkable(false);
//    set resettable using space button
    g3d.setResettable(false);
//    set selectable
    g3d.setRectSelectable(false);

//    Create 3D node
    node = createNode([0, 0, 0], [600, 60, 300], [0.2, 1, 0.2]).s({
        'all.reverse.cull': 'false',
        'left.color': 'pink',
        'right.color': 'yellow',
        'front.color': 'red',
        'back.color': 'green',
        'top.image': 'img/hightopo/coordinate.png',
        'bottom.color': 'orange'
    });

}
/** 
 * Create 3D node
 */
function createNode(p3, s3, r3){
    var node = new ht.Node();
    node.p3(p3);
    node.s3(s3);
    node.r3(r3);
    dataModel.add(node);
    return node;
}

/** 
 * Start animation (testing,abandon)
 */
function startAnim(node){
    var i = 0;

    params = {
        frames: 60,
        interval: 16,
        finishFunc: function () {
            animation = ht.Default.startAnim(params);
        },
        action: function (t) {
            node.setRotation3d(i++, i++, i++);
        }
    }

    animation = ht.Default.startAnim(params);
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
//	retrieve current page name as url
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
				
				yaw = dataEval.yaw * Math.PI/180;
				pitch = dataEval.pitch * Math.PI/180;
				roll = dataEval.roll * Math.PI/180;
				
				node.setRotation3d(pitch, yaw, roll);
			},
		error : 
			function(XMLHttpRequest, textStatus, errorThrown) {
				
	    	}
		});// ajax interval end
	}

/**
 * Start monitoring function
 */
function start() {
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
 * Stop monitoring function
 */
function stop(){
	clearInterval(AjaxInterval);
}