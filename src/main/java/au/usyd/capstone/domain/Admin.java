package au.usyd.capstone.domain;

import javax.persistence.*;

//通过@Entity将Admin类标注为实体类， @Table指定了该实体类对应的表
@SuppressWarnings("serial")
@Entity
@Table(name="capstone_admin")
public class Admin extends BaseDomain {
	
	//通过@Id注解将adminId指定为ID属性， @GenerationType指定了主键值的产生策略
	//通过@Column注解将adminId属性与数据库相应字段进行绑定
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int adminId;
	
	private String username;
	private String password;	
	private String description;
	
	
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
