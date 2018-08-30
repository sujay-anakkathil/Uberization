package com.principal.uberization.userInfo.repo.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.model.UserCredentials;
import com.principal.uberization.userInfo.repo.UserInfoRepo;

/**
 * @author Sujay This nmethod is used for CRUD operations on User
 *
 */
@Transactional
@Repository
public class UserInfoRepoImpl implements UserInfoRepo {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoRepoImpl.class);

	@Autowired
	SessionFactory sessionfactory;

	@Override
	/**
	 * @param email
	 * @return This method is used to get user profile data
	 * @throws UberizationSystemException
	 */
	public UserCredentials getUserProfile(final String email,final String password) throws UberizationSystemException {
		final String METHOD_NAME = "getUserProfile";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			final Session session = sessionfactory.getCurrentSession();
			final Criteria criteria = session.createCriteria(UserCredentials.class, "UserCredentials");
			criteria.add(Restrictions.eq("UserCredentials.id.userEmail", email));
			if(StringUtils.isNoneEmpty(password)) {
				criteria.add(Restrictions.eq("UserCredentials.password",password));
			}
			LOGGER.info("Class:" + this.getClass().getName() + " METHOD exit :" + METHOD_NAME);
			return (UserCredentials) criteria.uniqueResult();  

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}

	}

}
