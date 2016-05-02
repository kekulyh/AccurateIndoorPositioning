package au.usyd.capstone.experiment;

import au.usyd.capstone.domain.Coordinate;
import au.usyd.capstone.domain.Gesture;
import au.usyd.capstone.domain.Quaternion;
import au.usyd.capstone.utils.CrossProductQuaternion;

// Static Calculation function 
public class CoordinateCalculation {
	
	/* Global variables for all the functions */
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
	
	
	/* For coordinateCalculation method*/
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
	
	/* For gestureCalculation method */ 
	private static double[] eulerAngles = {0, 0, 0};
	
	/* For coordinateCalculationWithGesture method */
	private static double[] velocity ={0, 0, 0};
	private static double samplePeriod = 0.1f;
	private static double[] position ={0, 0, 0};
	private static long currentPeriod;
	private static double gravity = 9.81f;
	// angle of geture to map (North of sensor to North of map)
	private static double angleSensorToMap = 18.5;
	
	/* static variable for DeviceDaoImpl calling */
	// Testing: use the fixed parameters as the starting coordiante
	// should replace with values from other node localization methods
	private static double coordinateX = 500;
	private static double coordinateY = 120;
	
	
	/**
	 * Calculate the coordinate without Quaternion (for testing).
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
		
		
		Quaternion quaternionSixAxis = QuaternionAlgorithm.calculateQuaternionSixAxis(accel1, accel2, accel3, gyro1, gyro2, gyro3);
//		System.out.println(quaternionNineAxis.toString());
		
		double[] q = {quaternionSixAxis.getQ0(), quaternionSixAxis.getQ1(), quaternionSixAxis.getQ2(), quaternionSixAxis.getQ3()};
		
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
		Gesture gesture = new Gesture(eulerAngles[0], eulerAngles[1], eulerAngles[2], quaternionSixAxis);
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

		// 把四元数转换为欧拉角
		// yaw (绕z轴)
		eulerAngles[0] = Math.atan2(2 * q[0] * q[3] + 2 * q[1] * q[2], -2 * q[2] * q[2] - 2 * q[3] * q[3] + 1)* 180/Math.PI;
		// pitch (绕y轴)
		eulerAngles[1] = Math.asin(-2 * q[1] * q[3] + 2 * q[0] * q[2])* 180/Math.PI;
		// roll (绕x轴)
		eulerAngles[2] = Math.atan2(2 * q[0] * q[1] + 2 * q[2] * q[3], -2 * q[1]*q[1] - 2 * q[2] * q[2] + 1)* 180/Math.PI;
//		System.out.println("Yaw: " + eulerAngles[0] + "Pitch: " + eulerAngles[1] +"Roll: " + eulerAngles[2]);
		
		//将 -+180度  转成0-360度
//		if(eulerAngles[0]<0){
//			eulerAngles[0]+= (double)360;
//		}
		
		// 返回gesture对象
		Gesture gesture = new Gesture(eulerAngles[0], eulerAngles[1], eulerAngles[2], quaternionNineAxis);
//		System.out.println(gesture.toString());
		
		return gesture;
				
	}
	
	/**
	 * Calculate the coordinate with Gesture (yaw, pitch, roll)
	 */
	public static Coordinate coordinateCalculationWithGesture(Gesture gesture, String a1, String a2, String a3, double coordinateX, double coordinateY) {
		
		// parse input string to double variable
		accel1 = Double.parseDouble(a1);
		accel2 = Double.parseDouble(a2);
		accel3 = Double.parseDouble(a3);
//		System.out.println("accel1: " + accel1 + "accel2: " + accel2 + "accel3: " + accel3);
		
		// Get yaw
		double yaw = gesture.getYaw();
		//将 -+180度 转成 0-360度
		if(yaw<0){
			yaw += (double)360;
		}
		System.out.println("Yaw: " + yaw);
		
		// Get quaternion from gesture
		Quaternion quaternion = gesture.getQuaternion();
		
		// Get conjugate quaternion, for unit quaternion, same with inverse of q
		Quaternion quaternionConjugate = new Quaternion(quaternion.getQ0(), 0 - quaternion.getQ1(), 0 - quaternion.getQ2(), 0 - quaternion.getQ3());
		
		// Get acceleration expressed in 4 dimension (as quaternion)
		Quaternion accelOriginalFourDimension = new Quaternion(0, accel1, accel2, accel3);
		
		// Rotate the acceleration to earth frame (reversly rotation using conjugate quaternion)
		// Quaternion rotation： p' = q x p x q^-1
		// Use conjugate of q（same with inverse of q）to reversly rotate
		// a' = (q^-1) x a x (q^-1)^-1
		Quaternion accelEarthFramFourDimension = CrossProductQuaternion.crossProductQuaternion( CrossProductQuaternion.crossProductQuaternion(quaternionConjugate, accelOriginalFourDimension), quaternion );
		
		// Transfer 4-dimensional data to 3-dimensional 
		double[] accleEarthFrame = {accelEarthFramFourDimension.getQ1(), accelEarthFramFourDimension.getQ2(), accelEarthFramFourDimension.getQ3()};
		System.out.println("Accel[0]: " + accleEarthFrame[0] + "; Accel[1]: " + accleEarthFrame[1] + "; Accel[2]: " + accleEarthFrame[2]);
		
		// get samplePeriod
		if(currentPeriod != 0){
			samplePeriod = (System.currentTimeMillis() - currentPeriod) / 1000.00000;
//			System.out.println("Sample period: "+samplePeriod);
		}
		// update current time
		currentPeriod = System.currentTimeMillis();
		
		// Resultant acceleration
		accel = Math.sqrt(Math.pow(accleEarthFrame[0], 2) + Math.pow(accleEarthFrame[1], 2) + Math.pow(accleEarthFrame[2], 2)) - 1;
//		System.out.println("Accel: "+ accel);
		
		
		/* Gait estimation method, using yaw to determine direction */
		// Determine whether user is moving
		if (accel >0.25) {
			
			// calculate real next step data
			nextStepXReal = step * Math.sin( (yaw + angleSensorToMap) * Math.PI / 180);
			nextStepYReal = step * Math.cos( (yaw + angleSensorToMap) * Math.PI / 180);
			System.out.println("nextStepXReal: " + nextStepXReal + "; nextStepYReal: " + nextStepYReal);
			
			// convert real data for displaying on UI
			nextStepX = nextStepXReal * 250/12;
			nextStepY = nextStepYReal * 250/12;
			
			// Stabilization.if time interval is larger than 500ms, update coordinate.
			if( (int) (System.currentTimeMillis() - currentTime)>500){
				// update coordinate
				coordinateX = coordinateX + nextStepX;
				coordinateY = coordinateY + nextStepY;
			}
			
			// update current time when updating coordinate
			currentTime = System.currentTimeMillis();
			
			// initialize the acceleration
			accel = 0;
		}
		
		
//		/* Integration of accel and velocity to get length in every samplePeriod */
//		// Determine whether user is moving
//		if(accel>0.25){
//			// current velocity in 3 axis
//			velocity[0] += accleEarthFrame[0] * samplePeriod * gravity;
//			velocity[1] += accleEarthFrame[1] * samplePeriod * gravity;
//			velocity[2] += (accleEarthFrame[2]-1) * samplePeriod * gravity;
//			System.out.println("Velocity[0]: "+ velocity[0] + "; Velocity[1]: "+ velocity[1] + "; Velocity[2]: "+ velocity[2]);
//			
//			// current position in 3 axis of sensor frame
//			position[0] = velocity[0] * samplePeriod;
//			position[1] = velocity[1] * samplePeriod;
//			position[2] = velocity[2] * samplePeriod;
//			
//			// transfer sensor frame to UI frame
//			nextStepXReal = position[1] * Math.cos(angleSensorToMap * Math.PI / 180);
//			nextStepYReal = position[0] * Math.cos(angleSensorToMap * Math.PI / 180);
//			System.out.println("nextStepXReal: " + nextStepXReal + "; nextStepYReal: " + nextStepYReal); 
//			
//			// convert real data for displaying on UI
//			nextStepX = nextStepXReal * 250/12;
//			nextStepY = nextStepYReal * 250/12;
//			
//			coordinateX = coordinateX + nextStepX;
//			coordinateY = coordinateY + nextStepY;
//		}else{
//			// clear velocity
//			velocity[0] = 0;
//			velocity[1] = 0;
//			velocity[2] = 0;
//		}
		
		
		// set the coordinate variable
		Coordinate coordinate = new Coordinate(coordinateX, coordinateY);
		
		return coordinate;
	}

	
}
