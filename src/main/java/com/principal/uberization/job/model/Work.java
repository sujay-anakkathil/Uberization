package com.principal.uberization.job.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.principal.uberization.userInfo.model.Skill;

@Entity
@Table(name = "work_type_dm",schema="uberization")
public class Work {
	@Id
	@Column(name = "work_type_id")
	private Integer workTypeId;
	@Column(name = "work_type_text")
	private String workTypeText;
	@Column(name = "work_type_desc")
	private String workTypeDesc;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(schema = "uberization", name = "work_skill_mapping", joinColumns = {
			@JoinColumn(name = "work_type_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
	private Set<Skill> skillSet;

	public Set<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	public Integer getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(Integer workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getWorkTypeText() {
		return workTypeText;
	}

	public void setWorkTypeText(String workTypeText) {
		this.workTypeText = workTypeText;
	}

	public String getWorkTypeDesc() {
		return workTypeDesc;
	}

	public void setWorkTypeDesc(String workTypeDesc) {
		this.workTypeDesc = workTypeDesc;
	}

}
