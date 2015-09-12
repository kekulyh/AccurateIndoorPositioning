package au.usyd.capstone.daoimpl;

import org.springframework.stereotype.Repository;

import au.usyd.capstone.dao.DeviceDao;
import au.usyd.capstone.domain.Device;

@Repository
public class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDao {

	@Override
	public Device display() {
		// TODO Auto-generated method stub
		
		Device d = new Device();
		
		//d.setCoordinateX(5);
		//d.setCoordinateY(5);
		
		return d;
	}
	
}
