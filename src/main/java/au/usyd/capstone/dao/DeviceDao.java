package au.usyd.capstone.dao;

import au.usyd.capstone.domain.Device;

public interface DeviceDao extends BaseDao<Device> {
	
	public void calculateCoordinate(Device device);
	
	public void calculateGesture(Device device);
	
	public void resetCoordinate(Device device);
	
	public Device display(Device device);
	
	public Device deviceAdd(Device device);
	
	
}
