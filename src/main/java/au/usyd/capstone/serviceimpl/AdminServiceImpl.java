package au.usyd.capstone.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.capstone.dao.AdminDao;
import au.usyd.capstone.daoimpl.AdminDaoImpl;
import au.usyd.capstone.domain.Admin;
import au.usyd.capstone.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
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


	
	//去掉 extends BaseServiceImpl<Admin>, 则必须实现父类方法
	@Override
	public void create(Admin t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Admin t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Admin t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Admin selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Admin> findAll(String hql) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Admin> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
