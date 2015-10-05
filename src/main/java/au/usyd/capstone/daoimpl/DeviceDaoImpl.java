package au.usyd.capstone.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;


import au.usyd.capstone.dao.DeviceDao;
import au.usyd.capstone.domain.Admin;
import au.usyd.capstone.domain.Device;
import au.usyd.capstone.experiment.RxtxSerialTest;

@Repository
public class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDao {
	
	// Define current coordinate
	private double coordinateX = 500;
	private double coordinateY = 120;
	
	/** v1.1 获取坐标写入数据库 */
	@Override
	public void calculateCoordinate(Device device) {
		// TODO Auto-generated method stub
		
		Device d = new Device();
		
		String hql = "select d from au.usyd.capstone.domain.Device d where d.devicename='" + device.getDevicename() + "'";
		
		List<Device> list = this.findAll(hql);
		
		if (list != null && list.size()>0) {
			
			//devicename存在
			
			// 实例化
			RxtxSerialTest rxtxSerialTest = new RxtxSerialTest();

			// 初始化serial监听
			rxtxSerialTest.initialize();
			
			// 获取计算后的坐标
			coordinateX = rxtxSerialTest.getCoordinateX();
			coordinateY = rxtxSerialTest.getCoordinateY();
			
			// 坐标写入数据库
			d = list.get(0);
			
			d.setCoordinateX(coordinateX);
			d.setCoordinateY(coordinateY);
			
			// 更新数据库原数据
			this.update(d);
	
		}else{		
			//devicename不存在
			
		}
		
	}
	
	//调用数据库里的device对象的坐标值
	@Override
	public Device display(Device device) {
		// TODO Auto-generated method stub
		
		Device d = new Device();
		
		
		String hql = "select d from au.usyd.capstone.domain.Device d where d.devicename='" + device.getDevicename() + "'";
		
		List<Device> list = this.findAll(hql);
		
		
		
		if (list != null && list.size()>0) {
			
			//devicename存在
			d = list.get(0);
			
			return d;
			
		}else{
			
			//devicename不存在
			return null;
			
		}
	}

	@Override
	public Device deviceAdd(Device device) {
		// TODO Auto-generated method stub
		
		Device d = new Device();
		String hql = "select d from au.usyd.capstone.domain.Device d where d.devicename='" + device.getDevicename() + "'";
		
		List<Device> list = this.findAll(hql);
		
		if (list != null && list.size()>0) {
			
			//devicename已存在，则返回null
			return null;
			
		}else{
			
			//devicename不存在，新用户写入数据库
			d.setDevicename(device.getDevicename());
			d.setDevicemacaddress(device.getDevicemacaddress());
			d.setDevicemodel(device.getDevicemodel());
			d.setDescription(device.getDescription());
			this.create(d);
			return d;
			
		}
		

	}

	
	
	
	
	
	
	
//	/** v0.1 计算随机坐标写入数据库 */
//	@Override
//	public void calculateCoordinate(Device device) {
//		// TODO Auto-generated method stub
//		
//		Device d = new Device();
//		
//		String hql = "select d from au.usyd.capstone.domain.Device d where d.devicename='" + device.getDevicename() + "'";
//		
//		List<Device> list = this.findAll(hql);
//		
//		if (list != null && list.size()>0) {
//			
//			//devicename存在
//			
//			//随机生成坐标
//			double x = Math.random() * 880 + 10;
//			double y = Math.random() * 270 + 10;
//			
//			d = list.get(0);
//			
//			d.setCoordinateX(x);
//			d.setCoordinateY(y);
//			
//			//System.out.println(d);
//			
//			this.update(d);
//			
//			
//		}else{
//			
//			//devicename不存在
//			
//			
//		}
//		
//	}

	
	
//	/** v1.0 计算坐标写入数据库 */
//	@Override
//	public void calculateCoordinate(Device device) {
//		// TODO Auto-generated method stub
//		
//		Device d = new Device();
//		
//		String hql = "select d from au.usyd.capstone.domain.Device d where d.devicename='" + device.getDevicename() + "'";
//		
//		List<Device> list = this.findAll(hql);
//		
//		if (list != null && list.size()>0) {
//			
//			//devicename存在
//			
//			// 实例化
//			RxtxSerialTest rxtxSerialTest = new RxtxSerialTest();
//
//			// 初始化serial监听
//			rxtxSerialTest.initialize();
//			
//			// 得到线程中的数据数组
//			array = rxtxSerialTest.getAry();
//			
//			// 赋值给变量
//			a1 = array[0];
//			a2 = array[1];
//			a3 = array[2];
//			g1 = array[3];
//			g2 = array[4];
//			g3 = array[5];
//			
//			// string转换为double
//			double accel1 = Double.parseDouble(a1);
//			double accel2 = Double.parseDouble(a2);
//			double accel3 = Double.parseDouble(a3);
//			double gyro1 = Double.parseDouble(g1);
//			double gyro2 = Double.parseDouble(g2);
//			double gyro3 = Double.parseDouble(g3);
//			
//			System.out.println("a1: " + accel1 +" , a2: " + accel2 + " , a3: " + accel3 + " , g1: " + gyro1 + " , g2: " + gyro1 + " , g3: " + gyro3);
//			
//			double accel = Math.sqrt(Math.pow(accel1, 2) + Math.pow(accel2, 2) + Math.pow(accel3, 2)) - 1;
//			
//			System.out.println("accel: " + accel);
//			
//			System.out.println("第一次gyrox: " + gyrox);
//			System.out.println("第二次gyroy: " + gyroy);
//			
//			double step = 0.95;
//			
//			double nextStepXReal = 0;
//			double nextStepYReal = 0;
//			
//			double nextStepX = 0;
//			double nextStepY = 0;
//			
//			if (accel >0.25) {
//				gyrox = gyrox + gyro1 * 1;
//				gyroy = gyroy + gyro2 * 1;
//				
//				System.out.println("计算后gyrox: " + gyrox);
//				System.out.println("计算后gyroy: " + gyroy);
//				
//				nextStepXReal = step * Math.cos(gyrox);
//				nextStepYReal = step * Math.cos(gyroy);
//				
//				// 转换真实坐标为显示坐标
//				nextStepX = nextStepXReal * 250/12;
//				nextStepY = nextStepYReal * 250/12;
//				
//				System.out.println("nextStepX: " + nextStepX + "nextStepY: " + nextStepY);
//				
//				coordinateX = coordinateX + nextStepX;
//				coordinateY = coordinateY + nextStepY;
//				
//				accel = 0;
//			}
//			
//			System.out.println("coordinateX: " + coordinateX + " ,coordinateY: " + coordinateY);
//			
//			
//			
//			d = list.get(0);
//			
//			d.setCoordinateX(coordinateX);
//			d.setCoordinateY(coordinateY);
//			
//			this.update(d);
//	
//		}else{		
//			//devicename不存在
//
//		}
//		
//	}
	
	
	
}
