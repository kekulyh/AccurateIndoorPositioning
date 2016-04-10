package au.usyd.capstone.dao;

import java.util.List;

import au.usyd.capstone.domain.Room;

public interface RoomDao extends BaseDao<Room> {
	
	//get all the rooms
	public List<Room> RoomList();
	
	//get room by id
	public Room getRoom(int roomId);
	
	//add room
	public void addRoom(Room room);
	
	//update room
	public void updateRoom(Room room);
	
	//delete room
	public void deleteRoom(Room room);
	
	//get room count
	public int getRoomCount();
}
