package com.principal.uberization.job.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.uberization.exception.ErrorMessage;
import com.principal.uberization.exception.UberizationBusinessException;
import com.principal.uberization.exception.UberizationExceptionInfo;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.model.JobPostingDetails;
import com.principal.uberization.job.repo.JobRepo;
import com.principal.uberization.job.service.JobService;
import com.principal.uberization.job.vo.JobDetailsVO;
import com.principal.uberization.userInfo.model.Skill;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepo jobRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(JobServiceImpl.class);
	@Override
	
	public Boolean publishJobPosting(final JobDetailsVO jobDetailsVO) throws UberizationSystemException {
		final String METHOD_NAME = "publishJobPosting";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			if (null!=jobDetailsVO) {
				final JobPostingDetails jobPostingDetails = new JobPostingDetails();
				jobPostingDetails.setJobDate(jobDetailsVO.getDateOfWork().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
				jobPostingDetails.setJobPostDate(LocalDateTime.now());
				jobPostingDetails.setJobRespDeadline(LocalDateTime.now().plusHours(jobDetailsVO.getResponseDeadline()));
				jobPostingDetails.setSkill(new Skill(jobDetailsVO.getTypeOfWork().getId(), jobDetailsVO.getTypeOfWork().getName(), jobDetailsVO.getTypeOfWork().getDescription()));
				jobPostingDetails.setWorkCount(jobDetailsVO.getNumberOfCases());
				jobRepo.publishJob(jobPostingDetails);
			}else {
				throw new UberizationBusinessException(
						Arrays.asList(
								new ErrorMessage(UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getErrorCode(),
										"Insufficient parameter",
										UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getDescription())),
						"Insufficient parameter");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
		return true;
	}
	@Override
	public void test() throws UberizationSystemException {
		
		final String METHOD_NAME = "test";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			jobRepo.test();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}

	
}
