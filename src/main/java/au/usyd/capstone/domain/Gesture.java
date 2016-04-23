package au.usyd.capstone.domain;

public class Gesture {
	
	private double yaw;
	
	private double pitch;
	
	private double roll;

	public Gesture(double yaw, double pitch, double roll) {
		super();
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Gesture [yaw=" + yaw + ", pitch=" + pitch + ", roll=" + roll + "]";
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
		
}
