package au.usyd.capstone.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="capstone_building")
public class Building extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="building_id")
	private int buildingId;
	
	private String buildingImage;
	
	private String buildingName;
	
	private String buildingOpeningTime;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="roomBuilding")
	
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingImage() {
		return buildingImage;
	}
	public void setBuildingImage(String buildingImage) {
		this.buildingImage = buildingImage;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingOpeningTime() {
		return buildingOpeningTime;
	}
	public void setBuildingOpeningTime(String buildingOpeningTime) {
		this.buildingOpeningTime = buildingOpeningTime;
	}
	
}
