package au.usyd.capstone.experiment;

import au.usyd.capstone.domain.Coordinate;
import au.usyd.capstone.domain.Gesture;
import au.usyd.capstone.domain.Quaternion;

// Static Calculation function 
public class CoordinateCalculation {
	
	// parse string into double
	private static double accel1 = 0;
	private static double accel2 = 0;
	private static double accel3 = 1;
	private static double gyro1 = 0;
	private static double gyro2 = 0;
	private static double gyro3 = 0;
	private static double mag1 = 0;
	private static double mag2 = 0;
	private static double mag3 = 0;
	// current time
	private static long currentTime;
	// sampling time for gyro data
	private static double gyroTime = 0.1;
	// calculated acceleration data
	private static double accel = 0;
	// calculated angle data
	private static double anglex = 0;
	private static double angley = 0;
	private static double anglez = 0;
	// defined step size 
	private static double step = 0.95;
	// calculated real next step data
	private static double nextStepXReal = 0;
	private static double nextStepYReal = 0;
	// converted next step on the UI
	private static double nextStepX = 0;
	private static double nextStepY = 0;
	// static variable for DeviceDaoImpl calling
	// Testing: use the fixed parameters
	private static double coordinateX = 500;
	private static double coordinateY = 120;
	private static double[] eulerAngles = {0, 0, 0};
	
	/**
	 * Calculate the coordinate without Quaternion.
	 */
	public static Coordinate coordinateCalculation(String a1, String a2, String a3, String g1, String g2, String g3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1);
		gyro2 = Double.parseDouble(g2);
		gyro3 = Double.parseDouble(g3);
		
		// handle acceleration data
		accel = Math.sqrt(Math.pow(accel1, 2) + Math.pow(accel2, 2) + Math.pow(accel3, 2)) - 1;
		
		// handle gyro data
		anglex = anglex + gyro1 * gyroTime;
		angley = angley + gyro2 * gyroTime;
		anglez = anglez + gyro3 * gyroTime;
		
		if (accel >0.25) {
			
			// calculate real next step data
			nextStepXReal = step * Math.cos(anglez * Math.PI / 180);
			nextStepYReal = step * Math.sin(anglez * Math.PI / 180);
			
			// convert real data for displaying on UI
			nextStepX = nextStepXReal * 250/12;
			nextStepY = nextStepYReal * 250/12;
			
			// Stabilization.if time interval is larger than 500ms, update coordinate.
			if( (int) (System.currentTimeMillis() - currentTime)>500){
				// update coordinate
				coordinateX = coordinateX - nextStepX;
				coordinateY = coordinateY + nextStepY;
			}
			
			// update current time when updating coordinate
			currentTime = System.currentTimeMillis();
			
			// initialize the acceleration
			accel = 0;
		}

		// set the coordinate variable		
		Coordinate coordinate = new Coordinate(coordinateX, coordinateY);

		return coordinate;
		
	}
	
	/**
	 * Calculate the coordinate with Quaternion (six axis).
	 */
	public static Coordinate coordinateCalculationWithQuaternionSixAxis(String a1, String a2, String a3, String g1, String g2, String g3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1) * Math.PI/180;
		gyro2 = Double.parseDouble(g2) * Math.PI/180;
		gyro3 = Double.parseDouble(g3) * Math.PI/180;
		
		
		Quaternion quaternionSixAxis = QuaternionAlgorithm.calculateQuaternionSixAxis(accel1, accel2, accel3, gyro1, gyro2, gyro3);
		System.out.println(quaternionSixAxis.toString());
		
		
		// set the coordinate variable
		Coordinate coordinate = new Coordinate(coordinateX, coordinateY);
		
		return coordinate;
	}
	
	/**
	 * Calculate the coordinate with Quaternion (nine axis).
	 */
	public static Coordinate coordinateCalculationWithQuaternionNineAxis(String a1, String a2, String a3, String g1, String g2, String g3, String m1, String m2, String m3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1) * Math.PI/180;
		gyro2 = Double.parseDouble(g2) * Math.PI/180;
		gyro3 = Double.parseDouble(g3) * Math.PI/180;
		mag1 = Double.parseDouble(m1);
		mag2 = Double.parseDouble(m2);
		mag3 = Double.parseDouble(m3);
		
		
		Quaternion quaternionNineAxis = QuaternionAlgorithm.calculateQuaternionNineAxis(accel1, accel2, accel3, gyro1, gyro2, gyro3, mag1, mag2, mag3);
		System.out.println(quaternionNineAxis.toString());
		
		// set the coordinate variable
		Coordinate coordinate = new Coordinate(coordinateX, coordinateY);
		
		return coordinate;
	}
	
	/**
	 * Calculate the gesture (yaw, pitch, roll) with Quaternion (six axis).
	 */
	public static Gesture gestureCalculationWithQuaternionSixAxis(String a1, String a2, String a3, String g1, String g2, String g3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1) * Math.PI/180;
		gyro2 = Double.parseDouble(g2) * Math.PI/180;
		gyro3 = Double.parseDouble(g3) * Math.PI/180;
//		System.out.println(accel1 + " " + accel2 + " " + accel3 + " " + gyro1 + " " + gyro2 + " " + gyro3 + " " );
		
		
		Quaternion quaternionNineAxis = QuaternionAlgorithm.calculateQuaternionSixAxis(accel1, accel2, accel3, gyro1, gyro2, gyro3);
//		System.out.println(quaternionNineAxis.toString());
		
		double[] q = {quaternionNineAxis.getQ0(), quaternionNineAxis.getQ1(), quaternionNineAxis.getQ2(), quaternionNineAxis.getQ3()};
		
		// yaw (绕z轴)
		eulerAngles[0] = Math.atan2(2 * q[0] * q[1] + 2 * q[2] * q[3], -2 * q[1]*q[1] - 2 * q[2] * q[2] + 1)* 180/Math.PI;
		// pitch (绕y轴)
		eulerAngles[1] = Math.asin(-2 * q[1] * q[3] + 2 * q[0] * q[2])* 180/Math.PI;
		// roll (绕x轴)
		eulerAngles[2] = Math.atan2(2 * q[0] * q[3] + 2 * q[1] * q[2], -2 * q[2] * q[2] - 2 * q[3] * q[3] + 1)* 180/Math.PI;
		
		//将 -+180度  转成0-360度
//		if(eulerAngles[0]<0){
//			eulerAngles[0]+= (double)360;
//		}
		// 把四元数转换为欧拉角
		Gesture gesture = new Gesture(eulerAngles[0], eulerAngles[1], eulerAngles[2]);
		System.out.println(gesture.toString());
		
		return gesture;
				
	}
	
	/**
	 * Calculate the gesture (yaw, pitch, roll) with Quaternion (nine axis).
	 */
	public static Gesture gestureCalculationWithQuaternionNineAxis(String a1, String a2, String a3, String g1, String g2, String g3, String m1, String m2, String m3) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
		gyro1 = Double.parseDouble(g1) * Math.PI/180;
		gyro2 = Double.parseDouble(g2) * Math.PI/180;
		gyro3 = Double.parseDouble(g3) * Math.PI/180;
		mag1 = Double.parseDouble(m1);
		mag2 = Double.parseDouble(m2);
		mag3 = Double.parseDouble(m3);
		
		
		Quaternion quaternionNineAxis = QuaternionAlgorithm.calculateQuaternionNineAxis(accel1, accel2, accel3, gyro1, gyro2, gyro3, mag1, mag2, mag3);
//		System.out.println(quaternionNineAxis.toString());
		
		double[] q = {quaternionNineAxis.getQ0(), quaternionNineAxis.getQ1(), quaternionNineAxis.getQ2(), quaternionNineAxis.getQ3()};
		
		// yaw (绕z轴)
		eulerAngles[0] = Math.atan2(2 * q[0] * q[1] + 2 * q[2] * q[3], -2 * q[1]*q[1] - 2 * q[2] * q[2] + 1)* 180/Math.PI;
		// pitch (绕y轴)
		eulerAngles[1] = Math.asin(-2 * q[1] * q[3] + 2 * q[0] * q[2])* 180/Math.PI;
		// roll (绕x轴)
		eulerAngles[2] = Math.atan2(2 * q[0] * q[3] + 2 * q[1] * q[2], -2 * q[2] * q[2] - 2 * q[3] * q[3] + 1)* 180/Math.PI;
		
		//将 -+180度  转成0-360度
//		if(eulerAngles[0]<0){
//			eulerAngles[0]+= (double)360;
//		}
		// 把四元数转换为欧拉角
		Gesture gesture = new Gesture(eulerAngles[0], eulerAngles[1], eulerAngles[2]);
//		System.out.println(gesture.toString());
		
		return gesture;
				
	}
	
	/**
	 * Calculate the coordinate with Gesture (yaw, pitch, roll)
	 */
	public static Coordinate coordinateCalculationWithGesture(double yaw, double pitch, double roll) {
		
		
		
		
		// set the coordinate variable
		Coordinate coordinate = new Coordinate(coordinateX, coordinateY);
		
		return coordinate;
	}

	
}
