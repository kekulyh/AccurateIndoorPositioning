package au.usyd.capstone.experiment;

import au.usyd.capstone.domain.Quaternion;

// Quaternion Algorithm
public class QuaternionAlgorithm {
	
	// current time
	private static long currentTime;
	
	// sample frequency in Hz
	private static double sampleFreq = 10.0f;
	
	// 2 * proportional gain (Kp) 
	// related with sensor, refer to the datasheet
	private volatile static double beta = 0.1f;
	
	// quaternion of sensor frame relative to auxiliary frame
	private volatile static double q0 = 1.0f;
	private volatile static double q1 = 0.0f;
	private volatile static double q2 = 0.0f;
	private volatile static double q3 = 0.0f;
	

	// Algorithm calculating Quaternion with accelration and gyro
	public static Quaternion calculateQuaternionSixAxis(double accel1, double accel2, double accel3, double gyro1, double gyro2, double gyro3){
		
		if(currentTime != 0){
			long sampleTime = System.currentTimeMillis() - currentTime;
//			System.out.println("Sample time: "+sampleTime);
			sampleFreq = 1.0 * 1000 / sampleTime;
//			System.out.println("Sample Freq: "+sampleFreq);
		}
		
		// update current time when updating coordinate
		currentTime = System.currentTimeMillis();
		
		double normalizedDenominator;
		double s0, s1, s2, s3;
		double qDot1, qDot2, qDot3, qDot4;
		double _2q0, _2q1, _2q2, _2q3, _4q0, _4q1, _4q2 ,_8q1, _8q2, q0q0, q1q1, q2q2, q3q3;

		// The quaternion derivative describing rate of change of the earth frame relative to the sensor frame
		qDot1 = 0.5f * (-q1 * gyro1 - q2 * gyro2 - q3 * gyro3);
		qDot2 = 0.5f * (q0 * gyro1 + q2 * gyro3 - q3 * gyro2);
		qDot3 = 0.5f * (q0 * gyro2 - q1 * gyro3 + q3 * gyro1);
		qDot4 = 0.5f * (q0 * gyro3 + q1 * gyro2 - q2 * gyro1);

		// Compute feedback only if accelerometer measurement valid (avoids NaN in accelerometer normalisation)
		if(!((accel1 == 0.0f) && (accel2 == 0.0f) && (accel3 == 0.0f))) {

			// Normalise accelerometer measurement
			normalizedDenominator = 1 / Math.sqrt(accel1 * accel1 + accel2 * accel2 + accel3 * accel3);
			accel1 *= normalizedDenominator;
			accel2 *= normalizedDenominator;
			accel3 *= normalizedDenominator;   

			// Auxiliary variables to avoid repeated arithmetic
			_2q0 = 2.0f * q0;
			_2q1 = 2.0f * q1;
			_2q2 = 2.0f * q2;
			_2q3 = 2.0f * q3;
			_4q0 = 4.0f * q0;
			_4q1 = 4.0f * q1;
			_4q2 = 4.0f * q2;
			_8q1 = 8.0f * q1;
			_8q2 = 8.0f * q2;
			q0q0 = q0 * q0;
			q1q1 = q1 * q1;
			q2q2 = q2 * q2;
			q3q3 = q3 * q3;

			// Gradient decent algorithm corrective step
			s0 = _4q0 * q2q2 + _2q2 * accel1 + _4q0 * q1q1 - _2q1 * accel2;
			s1 = _4q1 * q3q3 - _2q3 * accel1 + 4.0f * q0q0 * q1 - _2q0 * accel2 - _4q1 + _8q1 * q1q1 + _8q1 * q2q2 + _4q1 * accel3;
			s2 = 4.0f * q0q0 * q2 + _2q0 * accel1 + _4q2 * q3q3 - _2q3 * accel2 - _4q2 + _8q2 * q1q1 + _8q2 * q2q2 + _4q2 * accel3;
			s3 = 4.0f * q1q1 * q3 - _2q1 * accel1 + 4.0f * q2q2 * q3 - _2q2 * accel2;
			normalizedDenominator = 1 / Math.sqrt(s0 * s0 + s1 * s1 + s2 * s2 + s3 * s3); 
			
			// normalise step magnitude
			s0 *= normalizedDenominator;
			s1 *= normalizedDenominator;
			s2 *= normalizedDenominator;
			s3 *= normalizedDenominator;

			// Apply feedback step
			qDot1 -= beta * s0;
			qDot2 -= beta * s1;
			qDot3 -= beta * s2;
			qDot4 -= beta * s3;
		}

		// Integrate rate of change of quaternion to yield quaternion
		q0 += qDot1 * (1.0f / sampleFreq);
		q1 += qDot2 * (1.0f / sampleFreq);
		q2 += qDot3 * (1.0f / sampleFreq);
		q3 += qDot4 * (1.0f / sampleFreq);

		// Normalise quaternion
		normalizedDenominator = 1 / Math.sqrt(q0 * q0 + q1 * q1 + q2 * q2 + q3 * q3);
		q0 *= normalizedDenominator;
		q1 *= normalizedDenominator;
		q2 *= normalizedDenominator;
		q3 *= normalizedDenominator;
		
		
		// set Quaternion object
		Quaternion quaternion = new Quaternion(q0, q1, q2, q3);
		
		return quaternion;
	}
	
	
	
	
	// Algorithm calculating Quaternion with accelration, gyro and magnetometer
	public static Quaternion calculateQuaternionNineAxis(
			double accel1, double accel2, double accel3, 
			double gyro1, double gyro2, double gyro3, 
			double mag1, double mag2, double mag3){
		
		if(currentTime != 0){
			long sampleTime = System.currentTimeMillis() - currentTime;
//			System.out.println("Sample time: "+sampleTime);
			sampleFreq = 1.0 * 1000 / sampleTime;
//			System.out.println("Sample Freq: "+sampleFreq);
		}
		
		// update current time when updating coordinate
		currentTime = System.currentTimeMillis();
		
		double normalizedDenominator;
		double s0, s1, s2, s3;
		double qDot1, qDot2, qDot3, qDot4;
		double hx, hy;
		double _2q0mx, _2q0my, _2q0mz, _2q1mx, _2bx, _2bz, _4bx, _4bz;
		double _2q0, _2q1, _2q2, _2q3, _2q0q2, _2q2q3, q0q0, q0q1, q0q2, q0q3, q1q1, q1q2, q1q3, q2q2, q2q3, q3q3;

		// Rate of change of quaternion from gyroscope
		qDot1 = 0.5f * (-q1 * gyro1 - q2 * gyro2 - q3 * gyro3);
		qDot2 = 0.5f * (q0 * gyro1 + q2 * gyro3 - q3 * gyro2);
		qDot3 = 0.5f * (q0 * gyro2 - q1 * gyro3 + q3 * gyro1);
		qDot4 = 0.5f * (q0 * gyro3 + q1 * gyro2 - q2 * gyro1);

		// Compute feedback only if accelerometer measurement valid (avoids NaN in accelerometer normalisation)
		if(!((accel1 == 0.0f) && (accel2 == 0.0f) && (accel3 == 0.0f))) {

			// Normalise accelerometer measurement
			normalizedDenominator = 1 / Math.sqrt(accel1 * accel1 + accel2 * accel2 + accel3 * accel3);
			accel1 *= normalizedDenominator;
			accel2 *= normalizedDenominator;
			accel3 *= normalizedDenominator;   

			// Normalise magnetometer measurement
			normalizedDenominator = 1 / Math.sqrt(mag1 * mag1 + mag2 * mag2 + mag3 * mag3);
			mag1 *= normalizedDenominator;
			mag2 *= normalizedDenominator;
			mag3 *= normalizedDenominator;

			// Auxiliary variables to avoid repeated arithmetic
			_2q0mx = 2.0f * q0 * mag1;
			_2q0my = 2.0f * q0 * mag2;
			_2q0mz = 2.0f * q0 * mag3;
			_2q1mx = 2.0f * q1 * mag1;
			_2q0 = 2.0f * q0;
			_2q1 = 2.0f * q1;
			_2q2 = 2.0f * q2;
			_2q3 = 2.0f * q3;
			_2q0q2 = 2.0f * q0 * q2;
			_2q2q3 = 2.0f * q2 * q3;
			q0q0 = q0 * q0;
			q0q1 = q0 * q1;
			q0q2 = q0 * q2;
			q0q3 = q0 * q3;
			q1q1 = q1 * q1;
			q1q2 = q1 * q2;
			q1q3 = q1 * q3;
			q2q2 = q2 * q2;
			q2q3 = q2 * q3;
			q3q3 = q3 * q3;

			// Reference direction of Earth's magnetic field
			hx = mag1 * q0q0 - _2q0my * q3 + _2q0mz * q2 + mag1 * q1q1 + _2q1 * mag2 * q2 + 
					_2q1 * mag3 * q3 - mag1 * q2q2 - mag1 * q3q3;
			hy = _2q0mx * q3 + mag2 * q0q0 - _2q0mz * q1 + _2q1mx * q2 - mag2 * q1q1 + 
					mag2 * q2q2 + _2q2 * mag3 * q3 - mag2 * q3q3;
			_2bx = Math.sqrt(hx * hx + hy * hy);
			_2bz = -_2q0mx * q2 + _2q0my * q1 + mag3 * q0q0 + _2q1mx * q3 - mag3 * q1q1 + 
					_2q2 * mag2 * q3 - mag3 * q2q2 + mag3 * q3q3;
			_4bx = 2.0f * _2bx;
			_4bz = 2.0f * _2bz;

			// Gradient decent algorithm corrective step
			s0 = -_2q2 * (2.0f * q1q3 - _2q0q2 - accel1) + _2q1 * (2.0f * q0q1 + _2q2q3 - accel2) - 
					_2bz * q2 * (_2bx * (0.5f - q2q2 - q3q3) + _2bz * (q1q3 - q0q2) - mag1) + 
					(-_2bx * q3 + _2bz * q1) * (_2bx * (q1q2 - q0q3) + _2bz * (q0q1 + q2q3) - mag2) + 
					_2bx * q2 * (_2bx * (q0q2 + q1q3) + _2bz * (0.5f - q1q1 - q2q2) - mag3);
			s1 = _2q3 * (2.0f * q1q3 - _2q0q2 - accel1) + _2q0 * (2.0f * q0q1 + _2q2q3 - accel2) - 
					4.0f * q1 * (1 - 2.0f * q1q1 - 2.0f * q2q2 - accel3) + _2bz * q3 * (_2bx * (0.5f - q2q2 - q3q3) + 
							_2bz * (q1q3 - q0q2) - mag1) + (_2bx * q2 + _2bz * q0) * (_2bx * (q1q2 - q0q3) + 
									_2bz * (q0q1 + q2q3) - mag2) + (_2bx * q3 - _4bz * q1) * (_2bx * (q0q2 + q1q3) + 
											_2bz * (0.5f - q1q1 - q2q2) - mag3);
			s2 = -_2q0 * (2.0f * q1q3 - _2q0q2 - accel1) + _2q3 * (2.0f * q0q1 + _2q2q3 - accel2) - 
					4.0f * q2 * (1 - 2.0f * q1q1 - 2.0f * q2q2 - accel3) + 
					(-_4bx * q2 - _2bz * q0) * (_2bx * (0.5f - q2q2 - q3q3) + _2bz * (q1q3 - q0q2) - mag1) + 
					(_2bx * q1 + _2bz * q3) * (_2bx * (q1q2 - q0q3) + _2bz * (q0q1 + q2q3) - mag2) + 
					(_2bx * q0 - _4bz * q2) * (_2bx * (q0q2 + q1q3) + _2bz * (0.5f - q1q1 - q2q2) - mag3);
			s3 = _2q1 * (2.0f * q1q3 - _2q0q2 - accel1) + _2q2 * (2.0f * q0q1 + _2q2q3 - accel2) + 
					(-_4bx * q3 + _2bz * q1) * (_2bx * (0.5f - q2q2 - q3q3) + _2bz * (q1q3 - q0q2) - mag1) + 
					(-_2bx * q0 + _2bz * q2) * (_2bx * (q1q2 - q0q3) + _2bz * (q0q1 + q2q3) - mag2) + 
					_2bx * q1 * (_2bx * (q0q2 + q1q3) + _2bz * (0.5f - q1q1 - q2q2) - mag3);
			normalizedDenominator = 1 / Math.sqrt(s0 * s0 + s1 * s1 + s2 * s2 + s3 * s3); 
			
			// normalise step magnitude
			s0 *= normalizedDenominator;
			s1 *= normalizedDenominator;
			s2 *= normalizedDenominator;
			s3 *= normalizedDenominator;

			// Apply feedback step
			qDot1 -= beta * s0;
			qDot2 -= beta * s1;
			qDot3 -= beta * s2;
			qDot4 -= beta * s3;
		}

		// Integrate rate of change of quaternion to yield quaternion
		q0 += qDot1 * (1.0f / sampleFreq);
		q1 += qDot2 * (1.0f / sampleFreq);
		q2 += qDot3 * (1.0f / sampleFreq);
		q3 += qDot4 * (1.0f / sampleFreq);

		// Normalise quaternion
		normalizedDenominator = 1 / Math.sqrt(q0 * q0 + q1 * q1 + q2 * q2 + q3 * q3);
		q0 *= normalizedDenominator;
		q1 *= normalizedDenominator;
		q2 *= normalizedDenominator;
		q3 *= normalizedDenominator;
		
		
		// set Quaternion object
		Quaternion quaternion = new Quaternion(q0, q1, q2, q3);
		
		return quaternion;
	}
	
	
	
	
}
