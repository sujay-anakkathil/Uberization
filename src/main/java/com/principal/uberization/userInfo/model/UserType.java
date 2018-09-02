package com.principal.uberization.userInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User_Type_DM",schema="uberization")
public class UserType {

	public UserType() {
		super();
	}

	public UserType(Integer userTypeId, String userTypeText) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeText = userTypeText;
	}

	@Id
	@Column(name = "user_type_id")
	private Integer userTypeId;

	@Column(name = "user_type_text")
	private String userTypeText;

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeText() {
		return userTypeText;
	}

	public void setUserTypeText(String userTypeText) {
		this.userTypeText = userTypeText;
	}

	
}
