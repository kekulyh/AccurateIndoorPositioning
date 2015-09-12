package au.usyd.capstone.domain;

import javax.persistence.*;

@Entity
@Table(name="capstone_device")
public class Device extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="device_id")
	private int deviceId;
	
	private String devicename;
	
	private float coordinateX;
	
	private float coordinateY;
	
	private String description;
	
	
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	
	public float getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(float coordinateX) {
		this.coordinateX = coordinateX;
	}

	public float getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(float coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
