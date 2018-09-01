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
import com.principal.uberization.userInfo.enums.SkillEnum;
import com.principal.uberization.userInfo.enums.UserTypeEnum;
import com.principal.uberization.userInfo.model.Skill;
import com.principal.uberization.userInfo.model.UserType;

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
	@Override
	public void test() throws UberizationSystemException {
		final String METHOD_NAME = "test";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			final Session session = sessionfactory.getCurrentSession();
		/*	session.save(new Skill(SkillEnum.VISION_CLAIM.getId(), SkillEnum.VISION_CLAIM.getName(), SkillEnum.VISION_CLAIM.getDescription()));
			session.save(new Skill(SkillEnum.DENTAL_CLAIM.getId(), SkillEnum.DENTAL_CLAIM.getName(), SkillEnum.DENTAL_CLAIM.getDescription()));
			session.save(new Skill(SkillEnum.MEDICAL_REVIEW.getId(), SkillEnum.MEDICAL_REVIEW.getName(), SkillEnum.MEDICAL_REVIEW.getDescription()));
			session.save(new Skill(SkillEnum.DATA_ENTRY.getId(), SkillEnum.DATA_ENTRY.getName(), SkillEnum.DATA_ENTRY.getDescription()));
			session.save(new Skill(SkillEnum.CASE_PROCESSING.getId(), SkillEnum.CASE_PROCESSING.getName(), SkillEnum.CASE_PROCESSING.getDescription()));
			session.save(new UserType(UserTypeEnum.ADMIN.getId(), UserTypeEnum.ADMIN.getName()));
			session.save(new UserType(UserTypeEnum.USER.getId(), UserTypeEnum.USER.getName()));*/
			session.save(new Skill(SkillEnum.DENTAL_CLAIM_STAGING.getId(), SkillEnum.DENTAL_CLAIM_STAGING.getName(), SkillEnum.DENTAL_CLAIM_STAGING.getDescription()));
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
		
	}

	
}
