package com.principal.uberization.job.vo;

public class UserJobResponse {
	private Integer jobId;
	private Integer userId;
	private Integer assignedCount;
	private Integer availableCount;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAssignedCount() {
		return assignedCount;
	}

	public void setAssignedCount(Integer assignedCount) {
		this.assignedCount = assignedCount;
	}

	public Integer getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}

}
