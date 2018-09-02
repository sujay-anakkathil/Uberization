package com.principal.uberization.job.service;

import java.util.List;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.vo.JobDetailsVO;
import com.principal.uberization.job.vo.UserJobResponse;
import com.principal.uberization.userInfo.enums.SkillEnum;

public interface JobService {
	Boolean publishJobPosting(final JobDetailsVO jobDetailsVO)throws UberizationSystemException;
	void test()throws UberizationSystemException;
	List<JobDetailsVO> getTaskList(final List<SkillEnum> skillList) throws UberizationSystemException;
	Boolean saveUserJobResponseList(final List<UserJobResponse> userJobResponseList) throws UberizationSystemException;
}
