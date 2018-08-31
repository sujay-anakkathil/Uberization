package com.principal.uberization.job.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JobOwnerPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "job_posting_id")
	private Integer jobPostingId;
	
	@Column(name = "user_id")
	private Integer userId;

	public Integer getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Integer jobpostingId) {
		this.jobPostingId = jobpostingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobPostingId == null) ? 0 : jobPostingId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobOwnerPK other = (JobOwnerPK) obj;
		if (jobPostingId == null) {
			if (other.jobPostingId != null)
				return false;
		} else if (!jobPostingId.equals(other.jobPostingId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
