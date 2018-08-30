package com.principal.uberization.job.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Completion_Details",schema = "uberization")
public class JobCompletionDetails {
	@EmbeddedId
	private JobOwnerPK id;
	@Column(name = "status")
	private String jobStatus;
	@Column(name = "completed_count")
	private Integer completedCount;
	@Column(name = "rating")
	private Double rating;
	@Column(name = "accepted_count")
	private Integer acceptedcount;

	public JobOwnerPK getId() {
		return id;
	}

	public void setId(JobOwnerPK id) {
		this.id = id;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Integer getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(Integer completedCount) {
		this.completedCount = completedCount;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getAcceptedcount() {
		return acceptedcount;
	}

	public void setAcceptedcount(Integer acceptedcount) {
		this.acceptedcount = acceptedcount;
	}

}
