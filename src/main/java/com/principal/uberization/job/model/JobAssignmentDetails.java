package com.principal.uberization.job.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.principal.uberization.userInfo.model.UserProfile;

@Entity
@Table(name = "job_assignment_details",schema = "uberization")
public class JobAssignmentDetails {

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public JobPostingDetails getJobPostingDetails() {
		return jobPostingDetails;
	}

	public void setJobPostingDetails(JobPostingDetails jobPostingDetails) {
		this.jobPostingDetails = jobPostingDetails;
	}

	@EmbeddedId
	private JobOwnerPK id;
	
	@Column(name = "available_count")
	private Integer availableCount;
	
	@Column(name = "assigned_count")
	private Integer assignedCount;

	@MapsId("userId")
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private UserProfile user;
	
	@MapsId("jobPostingId")
	@ManyToOne(cascade=CascadeType.MERGE)
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
