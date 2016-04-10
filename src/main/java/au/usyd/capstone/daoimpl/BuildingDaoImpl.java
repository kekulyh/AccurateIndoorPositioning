package au.usyd.capstone.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import au.usyd.capstone.dao.BuildingDao;
import au.usyd.capstone.domain.Building;

//继承BaseDaoImpl， 并指定泛型类的类型为Building
//设置@Repository注解， Spring在扫描包时， 将其扫描到Spring容器中
@Repository
public class BuildingDaoImpl extends BaseDaoImpl<Building> implements BuildingDao {

	@Override
	public void create(Building t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Building t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Building t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Building selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Building> buildingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Building getBuilding(int buildingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBuilding(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBuilding(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBuilding(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBuildingCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
