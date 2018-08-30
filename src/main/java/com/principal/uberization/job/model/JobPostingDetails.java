package com.principal.uberization.job.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Posting_Details", schema = "uberization")
public class JobPostingDetails {
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="job_posting_id_seq",initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "job_posting_id")
	private Integer jobPostingId;
	
	@Column(name = "job_date")
	private Date jobDate;
	
	@ManyToOne
	@JoinColumn(name = "work_type_id", referencedColumnName = "work_type_id")
	private Work workType;
	
	@Column(name = "work_count")
	private Integer workCount;
	
	@Column(name = "job_post_date")
	private Date jobPostDate;
	
	@Column(name = "job_resp_deadline")
	private Date jobRespDeadline;

	public Integer getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Integer jobPostingId) {
		this.jobPostingId = jobPostingId;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public Work getWorkType() {
		return workType;
	}

	public void setWorkType(Work workType) {
		this.workType = workType;
	}

	public Integer getWorkCount() {
		return workCount;
	}

	public void setWorkCount(Integer workCount) {
		this.workCount = workCount;
	}

	public Date getJobPostDate() {
		return jobPostDate;
	}

	public void setJobPostDate(Date jobPostDate) {
		this.jobPostDate = jobPostDate;
	}

	public Date getJobRespDeadline() {
		return jobRespDeadline;
	}

	public void setJobRespDeadline(Date jobRespDeadline) {
		this.jobRespDeadline = jobRespDeadline;
	}

	
}
