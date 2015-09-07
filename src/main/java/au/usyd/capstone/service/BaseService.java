package au.usyd.capstone.service;

import java.util.List;

public interface BaseService<T> {
	
	public void create(T t);
	public void delete(T t);
	public void update(T t);
	public T selectById(int id);
	public List<T> findAll(String hql);
	public List<T> find(String hql, Object... params);
	
}
