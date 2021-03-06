package au.usyd.capstone.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.capstone.dao.DeviceDao;
import au.usyd.capstone.daoimpl.DeviceDaoImpl;
import au.usyd.capstone.domain.Device;
import au.usyd.capstone.service.DeviceService;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
	
	@Autowired
	private DeviceDao deviceDao = new DeviceDaoImpl();
	
	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}
	
	
	@Override
	public void calculateCoordinate(Device device) {
		// TODO Auto-generated method stub
		deviceDao.calculateCoordinate(device);
	}
	
	@Override
	public void calculateGesture(Device device) {
		// TODO Auto-generated method stub
		deviceDao.calculateGesture(device);
	}
	
	@Override
	public void resetCoordinate(Device device) {
		// TODO Auto-generated method stub
		deviceDao.resetCoordinate(device);
	}
	
	@Override
	public Device display(Device device) {
		// TODO Auto-generated method stub
		return deviceDao.display(device);
	}

	@Override
	public Device deviceAdd(Device device) {
		// TODO Auto-generated method stub
		return deviceDao.deviceAdd(device);
	}
	
	
	
	
	
	//去掉 extends BaseServiceImpl<Device>，必须实现父类方法
	@Override
	public void create(Device t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Device t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Device t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Device selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> findAll(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
