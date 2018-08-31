package com.principal.uberization.job.repo.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.job.model.JobPostingDetails;
import com.principal.uberization.job.repo.JobRepo;

/**
 * @author Sujay
 *
 */
@Transactional
@Repository
public class JobRepoImpl implements JobRepo{

	@Autowired
	SessionFactory sessionfactory;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JobRepoImpl.class);
	@Override
	public void publishJob(JobPostingDetails jobPostingDetails) throws UberizationSystemException {
		final String METHOD_NAME = "publishJob";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			final Session session = sessionfactory.getCurrentSession();
			session.saveOrUpdate(jobPostingDetails);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}

	}

	
}
