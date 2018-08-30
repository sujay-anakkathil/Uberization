package com.principal.uberization.userInfo.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UserInfoVO {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private MultipartFile resume;
	private List<SkillSetVO> skillSet;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public List<SkillSetVO> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(List<SkillSetVO> skillSet) {
		this.skillSet = skillSet;
	}
	
}
