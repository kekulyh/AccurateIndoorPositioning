package au.usyd.capstone.dao;

import java.util.List;

import au.usyd.capstone.domain.Building;

public interface BuildingDao extends BaseDao<Building>{
	
	//get all the buildings
	public List<Building> buildingList();
	
	//get building by id
	public Building getBuilding(int buildingId);
	
	//add building
	public void addBuilding(Building building);
	
	//update building
	public void updateBuilding(Building building);
	
	//delete building
	public void deleteBuilding(Building building);
	
//	//get building page
//	public List<Building> buildingListPage(int page, int everyPageAmount);
	
	//get building count
	public int getBuildingCount();
		
}
