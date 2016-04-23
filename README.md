# Accurate Indoor Positioning
Capstone Project.<br>
Accurate Indoor Positioning Interface.<br>

****
##Features
* monitor功能目前基于usb串口数据读取，使用了Rxtx替代原生的串口api。读取速度设定在0.1s，刷新ui的速度设定在1s，可以随项目实际情况进行调整。
* usb传输换成无线传输，可以正常工作。
* 使用前需要添加`librxtxSerial.jnilib`和`RXTXcomm.jar`两个文件至`/Library/Java/Extensions `文件夹下。请在`rxtx-2.2pre2`文件夹下寻找，也可以自己生成，详情请参考Rxtx官网的指南：[Rxtx](http://rxtx.qbang.org).
* java包结构简述如下：
	* dao层为数据访问类
	* domain层为实体类
	* service层为事务类
	* web层为view类
	* 串口接收数据的类及算法实现放在experiment包下

* webapp结构简述如下：
	* css结构：
		* boostrap.css为官方的css文件
		* general.css为背景的css文件
		* blog.css为单个页面效果的css文件
		* footer.css为页脚的css文件
		* registerlogin.css为注册登录的css文件
	* img结构：
		* carousel为首页的carousel图片
		* maps里存放室内地图图片
		* hightopo为相应的3d姿态监测图片
	* js结构：
		* bootstrap.js为官方js文件
		* monitor.js为monitor界面进行地图及坐标绘制的js文件
		* svg_suit_screen.js为monitor界面的svg滑板适配屏幕的js文件
		* hightopo为3d姿态监测的api
		* monitorgesture.js为3d姿态监测的js文件
	* views为各个页面的jsp文件夹

****
##Update
* 2015/10/14
	* 数据去抖动待实现
* 2015/10/18
	* 去抖动实现
* 2015/10/24
	* 算法初步完成
* 2016/03/22
	* 重写js方法，使svg能适配屏幕
* 2016/03/26
	* monitor页面svg及定位功能适配各种size的屏幕完成。
* 2016/04/4
	* 算法待改进
* 2016/04/10
	* 修改js文件，提供android端调用的monitor页面及js方法。
* 2016/4/13
	* 后端算法改进，添加四元数计算模块
* 2016/4/21
	* 待添加功能模块：3D显示姿态，供调试。
* 2016/4/23
	* 3D监测姿态功能实现，实时性优秀。
	* pitch到达90度，yaw会瞬跳到180度，待解决。

****
##Sketch

#####Home Page

![Home Page](https://github.com/kekulyh/AccurateIndoorPositioning/blob/master/pic/homepage.png "Home Page")

#####Monitor Page

![Monitor Page](https://github.com/kekulyh/AccurateIndoorPositioning/blob/master/pic/monitorpage.png "Monitor Page")

#####Gesture Page

![Gesture Page](https://github.com/kekulyh/AccurateIndoorPositioning/blob/master/pic/gesturepage.png "Gesture Page")

#####Device Page

![Device Page](https://github.com/kekulyh/AccurateIndoorPositioning/blob/master/pic/devicepage.png "Device Page")

