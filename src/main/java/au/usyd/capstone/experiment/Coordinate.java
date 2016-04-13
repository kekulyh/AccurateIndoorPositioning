package au.usyd.capstone.experiment;

// Coordinate object
public class Coordinate {
	
	private double coordinateX;
	
	private double coordinateY;
	
	public Coordinate(double coordinateX, double coordinateY) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	@Override
	public String toString() {
		return "Coordinate [coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + "]";
	}



	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}
	
	
}
