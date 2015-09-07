package au.usyd.capstone.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;


import au.usyd.capstone.dao.BaseDao;



public class BaseDaoImpl<T> implements BaseDao<T>  {
	
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//通过反射获取子类确定的泛型类
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
	
	//增
	@Override
	public void create(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(t);
	}
	
	//删
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(t);
	}
	
	//改
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}
	
	//查
	@Override
	public T selectById(int id) {
		// TODO Auto-generated method stub
		return (T) hibernateTemplate.get(entityClass, id);
	}
	
	//HQL查询所有
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String hql) {
		// TODO Auto-generated method stub
		List<T> entities = hibernateTemplate.find(hql);
		return entities;
	}
	
	//HQL带参数查询
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Object... params) {
		// TODO Auto-generated method stub
		List<T> entities = hibernateTemplate.find(hql, params);
		return entities;
	}

}
