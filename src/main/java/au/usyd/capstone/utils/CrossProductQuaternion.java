package au.usyd.capstone.utils;

import au.usyd.capstone.domain.Quaternion;

public class CrossProductQuaternion {
	
	// Cross Product for quaternion (complex multiplication)
	public static Quaternion crossProductQuaternion(Quaternion q1, Quaternion q2){
		
	    double q1_1, q1_2, q1_3, q1_4, q2_1, q2_2, q2_3, q2_4;
	    double result1, result2, result3, result4;
	    
	    q1_1 = q1.getQ0();
	    q1_2 = q1.getQ1();
	    q1_3 = q1.getQ2();
	    q1_4 = q1.getQ3();
	    q2_1 = q2.getQ0();
	    q2_2 = q2.getQ1();
	    q2_3 = q2.getQ2();
	    q2_4 = q2.getQ3();
	    
	    result1 = q1_1 * q2_1 - q1_2 * q2_2 - q1_3 * q2_3 - q1_4 * q2_4;
	    result2 = q1_1 * q2_2 + q1_2 * q2_1 + q1_3 * q2_4 - q1_4 * q2_3;
	    result3 = q1_1 * q2_3 - q1_2 * q2_4 + q1_3 * q2_1 + q1_4 * q2_2;
	    result4 = q1_1 * q2_4 + q1_2 * q2_3 - q1_3 * q2_2 + q1_4 * q2_1;
	    
		Quaternion quaternionProduct = new Quaternion(result1, result2, result3, result4);
		
		return quaternionProduct;
		
	}
}
