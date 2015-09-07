package au.usyd.capstone.dao;

import au.usyd.capstone.domain.Admin;

public interface AdminDao extends BaseDao<Admin> {
	
	public Admin login(Admin admin);
	
	public Admin register(Admin admin);
}
