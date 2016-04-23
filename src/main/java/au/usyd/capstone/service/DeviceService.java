package au.usyd.capstone.service;

import au.usyd.capstone.domain.Device;

public interface DeviceService extends BaseService<Device> {
	
	public void calculateCoordinate(Device device);
	
	public void calculateGesture(Device device);
	
	public Device display(Device device);
	
	public Device deviceAdd(Device device);
	
}
