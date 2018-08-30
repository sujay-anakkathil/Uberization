package com.principal.uberization.userInfo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="User_Credentials",schema="uberization")
public class UserCredentials {
	
	@EmbeddedId
	private UserCredentialPk id;
	
	@Column(name="password")
	private String password ;
	
	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name="user_id" ,referencedColumnName="user_id")
	private UserProfile userProfile;
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@ManyToOne
	@JoinColumn(name="user_type_id " ,referencedColumnName="user_type_id ")
	private UserType userType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="registered_on")
	private Date registeredOn;
	
	@Temporal(TemporalType.DATE)
	@Column(name="last_login ")
	private Date lastLogin ;

	public UserCredentialPk getId() {
		return id;
	}

	public void setId(UserCredentialPk id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	
	
	
	
}
