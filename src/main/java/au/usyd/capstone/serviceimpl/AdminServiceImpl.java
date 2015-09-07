package au.usyd.capstone.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.usyd.capstone.dao.AdminDao;
import au.usyd.capstone.daoimpl.AdminDaoImpl;
import au.usyd.capstone.domain.Admin;
import au.usyd.capstone.service.AdminService;


@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
	
	@Autowired
	private AdminDao adminDao = new AdminDaoImpl();
	
	public AdminDao getAdminDao() {
		return adminDao;
	}
	
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}


	@Override
	public Admin register(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.register(admin);
	}
	
	
	
}
