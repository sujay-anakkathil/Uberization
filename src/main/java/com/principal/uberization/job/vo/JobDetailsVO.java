package com.principal.uberization.job.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.principal.uberization.userInfo.enums.SkillEnum;

public class JobDetailsVO {

	private SkillEnum typeOfWork;
	private Integer numberOfCases;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date dateOfWork;
	private Integer responseDeadline;
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
