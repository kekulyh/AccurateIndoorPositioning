package au.usyd.capstone.dao;

import java.util.List;

import au.usyd.capstone.domain.Floor;

public interface FloorDao extends BaseDao<Floor> {
	
	//get all the floors
	public List<Floor> floorList();
	
	//get floor by id
	public Floor getFloor(int floorId);
	
	//add floor
	public void addFloor(Floor floor);
	
	//update floor
	public void updateFloor(Floor floor);
	
	//delete floor
	public void deleteFloor(Floor floor);
	
	//get floor count
	public int getFloorCount();
}
