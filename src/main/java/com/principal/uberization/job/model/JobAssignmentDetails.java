package com.principal.uberization.job.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.principal.uberization.userInfo.model.UserProfile;

@Entity
@Table(name = "Job_Assignment_Details")
public class JobAssignmentDetails {

	@EmbeddedId
	private JobOwnerPK id;
	
	@Column(name = "available_count")
	private Integer availableCount;
	
	@Column(name = "assigned_count")
	private Integer assignedCount;

	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private UserProfile user;
	
	@MapsId("jobPostingId")
	@ManyToOne
	@JoinColumn(name="job_posting_id",referencedColumnName="job_posting_id")
	private JobPostingDetails jobPostingDetails;
	
	public JobOwnerPK getId() {
		return id;
	}

	public void setId(JobOwnerPK id) {
		this.id = id;
	}

	public Integer getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}

	public Integer getAssignedCount() {
		return assignedCount;
	}

	public void setAssignedCount(Integer assignedCount) {
		this.assignedCount = assignedCount;
	}

}
