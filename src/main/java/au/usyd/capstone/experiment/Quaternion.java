package au.usyd.capstone.experiment;

public class Quaternion {
	
	private float q0;
	
	private float q1;
	
	private float q2;
	
	private float q3;

	public Quaternion(float q0, float q1, float q2, float q3) {
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

	public float getQ0() {
		return q0;
	}

	public void setQ0(float q0) {
		this.q0 = q0;
	}

	public float getQ1() {
		return q1;
	}

	public void setQ1(float q1) {
		this.q1 = q1;
	}

	public float getQ2() {
		return q2;
	}

	public void setQ2(float q2) {
		this.q2 = q2;
	}

	public float getQ3() {
		return q3;
	}

	public void setQ3(float q3) {
		this.q3 = q3;
	}
	
}
