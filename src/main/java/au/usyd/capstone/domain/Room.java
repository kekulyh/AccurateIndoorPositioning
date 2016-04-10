package au.usyd.capstone.domain;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name="capstone_room")
public class Room extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int floorId;
	
	private String roomImage;
	
	private String roomName;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=(CascadeType.ALL))
	@JoinColumn(name="building_id")
	private Building roomBuilding;

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Building getRoomBuilding() {
		return roomBuilding;
	}

	public void setRoomBuilding(Building roomBuilding) {
		this.roomBuilding = roomBuilding;
	}
	
}
