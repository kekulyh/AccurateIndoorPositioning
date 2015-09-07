package au.usyd.capstone.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import au.usyd.capstone.dao.BaseDao;
import au.usyd.capstone.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;
	
	public BaseDao<T> getBaseDaoImpl() {
		return baseDao;
	}
	
	
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void create(T t) {
		// TODO Auto-generated method stub
		baseDao.create(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		baseDao.delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
	baseDao.update(t);	
	}

	@Override
	public T selectById(int id) {
		// TODO Auto-generated method stub
		return baseDao.selectById(id);
	}

	@Override
	public List<T> findAll(String hql) {
		// TODO Auto-generated method stub
		return baseDao.findAll(hql);
	}

	@Override
	public List<T> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		return baseDao.find(hql, params);
	}
	
	
	
}
