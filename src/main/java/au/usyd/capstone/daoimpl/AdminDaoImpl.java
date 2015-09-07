package au.usyd.capstone.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import au.usyd.capstone.dao.AdminDao;
import au.usyd.capstone.domain.Admin;

//拓展BaseDaoImpl， 并指定泛型类的类型为Admin
//设置@Repository注解， Spring在扫描包时， 将其扫描到Spring容器中
@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		
		Admin a = new Admin();
		
		//根据用户名查询
		String hqlUsername = "select a from au.usyd.capstone.domain.Admin a where a.username='" + admin.getUsername() + "'";
		
		//根据用户名与密码查询
		String hql = "select a from au.usyd.capstone.domain.Admin a where a.username='" + admin.getUsername() + "' and a.password='" + admin.getPassword() + "'";
		
		List<Admin> listUsername = this.findAll(hqlUsername);
		
		List<Admin> list = this.findAll(hql);
		
//		System.out.println("listUsername:"+listUsername);
		
		//判断根据用户名查询的listUsername是否有结果
		if (listUsername.isEmpty()) {
			
			//用户名不存在，返回listUsernameNotExist
			String hqlUsernameNotExist = "select a from au.usyd.capstone.domain.Admin a where a.adminId='" + admin.getAdminId() + "'";
			List<Admin> listUsernameNotExist = this.findAll(hqlUsernameNotExist);
			a =  listUsernameNotExist.get(0);
			return a;
			
		}else{
			
			if (list !=null && list.size()>0) {
				
				//用户名存在，密码正确，返回该用户
				a = list.get(0);
				return a;
				
			}else {
				
				//用户名存在，密码不正确，返回null
				return null;
				
			}
		
		}
		
	}

	@Override
	public Admin register(Admin admin) {
		// TODO Auto-generated method stub
		
		Admin a = new Admin();
		String hql = "select a from au.usyd.capstone.domain.Admin a where a.username='" + admin.getUsername() + "'";
		
		List<Admin> list = this.findAll(hql);
		
		if (list != null && list.size()>0) {
			
			//用户名已存在，则返回null
			return null;
			
		}else{
			
			//用户名不存在，新用户写入数据库
			a.setUsername(admin.getUsername());
			a.setPassword(admin.getPassword());
			this.create(a);
			return a;
			
		}
		
		
		
		
	}
	
	
	
	
	
}
