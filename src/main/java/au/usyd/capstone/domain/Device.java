package au.usyd.capstone.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="capstone_device")
public class Device extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="device_id")
	private int deviceId;
	
	private String devicename;
	
	private String devicemacaddress;
	
	private String devicemodel;
	
	private double coordinateX;
	
	private double coordinateY;
	
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
	
	public String getDevicemacaddress() {
		return devicemacaddress;
	}

	public void setDevicemacaddress(String devicemacaddress) {
		this.devicemacaddress = devicemacaddress;
	}

	public String getDevicemodel() {
		return devicemodel;
	}

	public void setDevicemodel(String devicemodel) {
		this.devicemodel = devicemodel;
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

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
