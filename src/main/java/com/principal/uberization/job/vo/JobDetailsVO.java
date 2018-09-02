package com.principal.uberization.job.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.principal.uberization.userInfo.enums.SkillEnum;
import com.principal.uberization.utils.CustomDateMappingDeserialize;
import com.principal.uberization.utils.JsonDateSerializer;

public class JobDetailsVO {

	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	private SkillEnum typeOfWork;
	private Integer numberOfCases;
	private Integer jobId;
	@JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = CustomDateMappingDeserialize.class)
	private Date dateOfWork;
	private Integer responseDeadline;
	private Date responseDeadLineDate;
	public Date getResponseDeadLineDate() {
		return responseDeadLineDate;
	}
	public void setResponseDeadLineDate(Date responseDeadLineDate) {
		this.responseDeadLineDate = responseDeadLineDate;
	}
	public SkillEnum getTypeOfWork() {
		return typeOfWork;
	}
	public void setTypeOfWork(SkillEnum typeOfWork) {
		this.typeOfWork = typeOfWork;
	}
	public Integer getNumberOfCases() {
		return numberOfCases;
	}
	public void setNumberOfCases(Integer numberOfCases) {
		this.numberOfCases = numberOfCases;
	}
	public Date getDateOfWork() {
		return dateOfWork;
	}
	public void setDateOfWork(Date dateOfWork) {
		this.dateOfWork = dateOfWork;
	}
	public Integer getResponseDeadline() {
		return responseDeadline;
	}
	public void setResponseDeadline(Integer responseDeadline) {
		this.responseDeadline = responseDeadline;
	}
	

}
