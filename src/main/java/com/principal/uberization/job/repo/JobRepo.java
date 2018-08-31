package com.principal.uberization.job.repo;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.model.JobPostingDetails;

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
}
