package au.usyd.capstone.domain;

public class Quaternion {
	
	private double q0;
	
	private double q1;
	
	private double q2;
	
	private double q3;

	public Quaternion(double q0, double q1, double q2, double q3) {
		super();
		this.q0 = q0;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}

	@Override
	public String toString() {
		return "Quaternion [q0=" + q0 + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + "]";
	}

	public double getQ0() {
		return q0;
	}

	public void setQ0(double q0) {
		this.q0 = q0;
	}

	public double getQ1() {
		return q1;
	}

	public void setQ1(double q1) {
		this.q1 = q1;
	}

	public double getQ2() {
		return q2;
	}

	public void setQ2(double q2) {
		this.q2 = q2;
	}

	public double getQ3() {
		return q3;
	}

	public void setQ3(double q3) {
		this.q3 = q3;
	}
	
}
