var node;

/** 
 * 供android端调用
 */

/** 
 * 初始化Graph3dView
 */
function init(){
//	items = [
//             {
//                 label: 'Start',
//                 groupId: 'monitorgesture',
//                 action: function(){
////                     alert("start");
//                	 start();
//                 }
//             },
//             {
//                 label: 'Stop',
//                 groupId: 'monitorgesture',
//                 selected: true,
//                 action: function(){
////                	 alert("stop");
//                	 stop();
//                 }
//             },
//         ];

//         var toolbar = new ht.widget.Toolbar(items);
         dataModel = new ht.DataModel();
         var g3d = new ht.graph3d.Graph3dView(dataModel);

         borderPane = new ht.widget.BorderPane();
//         borderPane.setTopView(toolbar);
         borderPane.setCenterView(g3d);

         view = borderPane.getView();
         view.className = 'main';
         document.body.appendChild(view);
         window.addEventListener('resize', function (e) {
             borderPane.invalidate(0);
         }, false);

//    设置视角
    g3d.setEye([0, 300, 1000]);
//    控制是否可旋转
    g3d.setRotatable(false);
//    控制是否可缩放
    g3d.setZoomable(false);
//    控制是否可平移
    g3d.setPannable(false);
//    控制是否可进退
    g3d.setWalkable(false);
//    控制是否可按空格键复位
    g3d.setResettable(false);
//    控制是否可框选
    g3d.setRectSelectable(false);

//    创建3d节点
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
 * 创建3d节点
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
 * 开始姿态刷新动画（testing，已废弃）
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
 * 取当前页面的名字
 */

function pageName()
{
	var str = window.location.href;
	str=str.substring(str.lastIndexOf("/") + 1)
	return str;
}


/**
 * 自定义的AJAX交互函数
 */
function AjaxMap(){
//	获取当前页面路径，作为ajax的url
	var currentPage = pageName();
	
	//jQuery的AJAX方法
	$.ajax({
		type : 'POST',
		url : ''+ currentPage +'',
		data : 'action='+ currentPage +'',
		contentType : 'application/json',
		dataType : 'json',
		success : 
			function(data) {
				/* 取后台传的JSON值 */
				var dataEval = eval(data);
				
				yaw = dataEval.yaw * Math.PI/180;
				pitch = dataEval.pitch * Math.PI/180;
				roll = dataEval.roll * Math.PI/180;
				
				node.setRotation3d(pitch, yaw, roll);
			},
		error : 
			function(XMLHttpRequest, textStatus, errorThrown) {
				
	    	}
		});//ajax轮询函数结束
	}


function start() {
	/* 初始执行一次 */
    AjaxTimeout = setTimeout(function() {
		AjaxMap();
	},100);

	/* 设置每0.1秒轮询一次 */
	AjaxInterval = setInterval(function(){
		AjaxMap();
	},100);
	
}

function stop(){
	clearInterval(AjaxInterval);
}