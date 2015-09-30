package au.usyd.capstone.dao;

import au.usyd.capstone.domain.Device;

public interface DeviceDao extends BaseDao<Device> {
	
	public void calculateCoordinate(Device device);
	
	public Device display(Device device);
	
	public Device deviceAdd(Device device);
	
	
}
