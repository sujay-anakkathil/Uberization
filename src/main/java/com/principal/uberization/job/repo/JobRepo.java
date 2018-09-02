package com.principal.uberization.job.repo;

import java.util.List;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.model.JobPostingDetails;
import com.principal.uberization.job.vo.UserJobResponse;

/**
 * @author Sujay
 *
 */
public interface JobRepo {
	/**
	 * @param jobPostingDetails
	 * @throws UberizationSystemException
	 * This method is used to publish Job
	 */
	void publishJob(final JobPostingDetails jobPostingDetails)throws UberizationSystemException;
	void test()throws UberizationSystemException;
	List<JobPostingDetails> getTaskList()throws UberizationSystemException;
	Boolean saveUserJobResponseList(List<UserJobResponse> userJobRespoonse)throws UberizationSystemException;
	JobPostingDetails getJobPostingDetails(final Integer jobId)throws UberizationSystemException;
}
