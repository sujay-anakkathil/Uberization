package com.principal.uberization.userInfo.service.impl;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.uberization.exception.ErrorMessage;
import com.principal.uberization.exception.UberizationBusinessException;
import com.principal.uberization.exception.UberizationExceptionInfo;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.converter.UserProfileConverter;
import com.principal.uberization.userInfo.model.UserCredentials;
import com.principal.uberization.userInfo.repo.UserInfoRepo;
import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay This class is used for various operations on User information
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserInfoRepo userInfoRepo;

	@Autowired
	UserProfileConverter converter;

	/**
	 * @param userinfo
	 * @return This method is used to register user
	 * @throws UberizationSystemException
	 */
	@Override
	public Boolean registerUser(final UserInfoVO userinfo) throws UberizationSystemException {

		final String METHOD_NAME = "registerUser";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			return true;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}

	}

	@Override
	/**
	 * @param userId
	 * @return
	 * @throws UberizationSystemException
	 *             this method is used to get user profile by email
	 */
	public UserInfoVO getUserProfile(final String userId) throws UberizationSystemException {
		final String METHOD_NAME = "getUserProfile";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			if (StringUtils.isNotEmpty(userId)) {
				final UserCredentials userCredentials = userInfoRepo.getUserProfile(userId,null);
				LOGGER.info("Class:" + this.getClass().getName() + " METHOD exit :" + METHOD_NAME);
				return converter.convertUserProfileToUserInfo(userCredentials);
			}else {
				throw new UberizationBusinessException(
						Arrays.asList(
								new ErrorMessage(UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getErrorCode(),
										"Insufficient parameter: email",
										UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getDescription())),
						"Insufficient parameter: email");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}

}
