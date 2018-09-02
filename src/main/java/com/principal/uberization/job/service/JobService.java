package com.principal.uberization.job.service;

import java.util.List;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.vo.JobDetailsVO;
import com.principal.uberization.job.vo.UserJobResponse;

public interface JobService {
	Boolean publishJobPosting(final JobDetailsVO jobDetailsVO)throws UberizationSystemException;
	void test()throws UberizationSystemException;
	List<JobDetailsVO> getTaskList() throws UberizationSystemException;
	Boolean saveUserJobResponseList(final List<UserJobResponse> userJobResponseList) throws UberizationSystemException;
}
