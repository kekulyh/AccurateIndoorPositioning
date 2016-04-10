package au.usyd.capstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="capstone_floor")
public class Floor extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="floor_id")
	private int floorId;
	
	private String floorImage;
	
	private String floorName;
	
	private String floorDetail;

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getFloorImage() {
		return floorImage;
	}

	public void setFloorImage(String floorImage) {
		this.floorImage = floorImage;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorDetail() {
		return floorDetail;
	}

	public void setFloorDetail(String floorDetail) {
		this.floorDetail = floorDetail;
	}
	
	
}
