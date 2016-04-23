package au.usyd.capstone.utils;

public class InvSqrt {
	
	// Fast Inverse Square Root - John Carmack
	public static float invSqrt( float number )
	{
		 int i;
		 float x2, y;
		 float threehalfs = 1.5F;
		 x2 = number * 0.5F;
		 y = number;
		 i = Float.floatToRawIntBits(y); // evil floating point bit level hacking
		 i = 0x5f3759df - ( i >> 1 ); // what the fuck?
		 y =Float.intBitsToFloat(i);
		 y = y * ( threehalfs - ( x2 * y * y ) ); // 1st iteration
		// y = y * ( threehalfs - ( x2 * y * y ) ); // 2nd iteration, this can be removed
		 return y;
	}
}
