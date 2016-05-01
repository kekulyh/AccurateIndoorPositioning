package au.usyd.capstone.domain;

public class Gesture {
	
	private double yaw;
	
	private double pitch;
	
	private double roll;
	
	private Quaternion quaternion;

	public Gesture(double yaw, double pitch, double roll, Quaternion quaternion) {
		super();
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
		this.quaternion = quaternion;
	}

	

	@Override
	public String toString() {
		return "Gesture [yaw=" + yaw + ", pitch=" + pitch + ", roll=" + roll + ", quaternion=" + quaternion + "]";
	}



	public double getYaw() {
		return yaw;
	}

	public void setYaw(double yaw) {
		this.yaw = yaw;
	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		this.roll = roll;
	}

	public Quaternion getQuaternion() {
		return quaternion;
	}

	public void setQuaternion(Quaternion quaternion) {
		this.quaternion = quaternion;
	}
	
}
