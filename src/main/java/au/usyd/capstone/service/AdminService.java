package au.usyd.capstone.service;

import au.usyd.capstone.domain.Admin;

public interface AdminService extends BaseService<Admin> {
	
	public Admin login(Admin admin);
	
	public Admin register(Admin admin);
	
}
