package com.principal.uberization.userInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Skill_DM", schema = "uberization")
public class Skill {
	@Id
	@Column(name = "skill_id")
	private Integer skillId;

	@Column(name = "skill_name")
	private String skillName;

	@Column(name = "skill_desc")
	private String skillDesc;

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

	public Skill() {
		super();
	}

	public Skill(String skillName, String skillDesc) {
		super();
		this.skillName = skillName;
		this.skillDesc = skillDesc;
	}

	public Skill(Integer skillId, String skillName, String skillDesc) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDesc = skillDesc;
	}
	
	

}
