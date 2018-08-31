package com.principal.uberization.job.service;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.vo.JobDetailsVO;

public interface JobService {
	Boolean publishJobPosting(final JobDetailsVO jobDetailsVO)throws UberizationSystemException;
	void test()throws UberizationSystemException;
}
