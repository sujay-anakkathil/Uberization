package com.principal.uberization.job.model;

import java.time.LocalDateTime;
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

import com.principal.uberization.userInfo.model.Skill;

@Entity
@Table(name = "Job_Posting_Details", schema = "uberization")
public class JobPostingDetails {
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="job_posting_id_seq",initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name = "job_posting_id")
	private Integer jobPostingId;
	
	@Column(name = "job_date")
	private java.time.LocalDateTime jobDate;
	
	@ManyToOne
	@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
	private Skill skill;
	
	@Column(name = "work_count")
	private Integer workCount;
	
	@Column(name = "job_post_date")
	private LocalDateTime jobPostDate;
	
	@Column(name = "job_resp_deadline")
	private LocalDateTime jobRespDeadline;

	public Integer getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Integer jobPostingId) {
		this.jobPostingId = jobPostingId;
	}

	public LocalDateTime getJobDate() {
		return jobDate;
	}

	public void setJobDate(LocalDateTime jobDate) {
		this.jobDate = jobDate;
	}

	
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getWorkCount() {
		return workCount;
	}

	public void setWorkCount(Integer workCount) {
		this.workCount = workCount;
	}

	public LocalDateTime getJobPostDate() {
		return jobPostDate;
	}

	public void setJobPostDate(LocalDateTime jobPostDate) {
		this.jobPostDate = jobPostDate;
	}

	public LocalDateTime getJobRespDeadline() {
		return jobRespDeadline;
	}

	public void setJobRespDeadline(LocalDateTime jobRespDeadline) {
		this.jobRespDeadline = jobRespDeadline;
	}

	
}
