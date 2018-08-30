package com.principal.uberization.Login.service.impl;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.Login.service.LoginService;
import com.principal.uberization.exception.ErrorMessage;
import com.principal.uberization.exception.UberizationAuthenticationException;
import com.principal.uberization.exception.UberizationBusinessException;
import com.principal.uberization.exception.UberizationExceptionInfo;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.converter.UserProfileConverter;
import com.principal.uberization.userInfo.model.UserCredentials;
import com.principal.uberization.userInfo.repo.UserInfoRepo;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay
 * This class is used to get services for LOgin/authentication
 */
@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UserInfoRepo userInfoRepo;
	
	@Autowired
	UserProfileConverter converter;


	@Override
	public UserInfoVO authenticateUser(LoginVO loginVO) throws UberizationAuthenticationException,UberizationSystemException {
		final String METHOD_NAME = "authenticateUser";
		LOGGER.info("Class:" + this.getClass().getName() + " METHOD entry :" + METHOD_NAME);
		try {
			if (null!=loginVO && StringUtils.isNotEmpty(loginVO.getEmailid()) && StringUtils.isNotBlank(loginVO.getPasswd())) {
				final UserCredentials userCredentials = userInfoRepo.getUserProfile(loginVO.getEmailid(),loginVO.getPasswd());
				LOGGER.info("Class:" + this.getClass().getName() + " METHOD exit :" + METHOD_NAME);
				if(null==userCredentials) {
					LOGGER.error("Invalid username or password");
					throw new UberizationAuthenticationException("Invalid username or password");
				}
				return converter.convertUserProfileToUserInfo(userCredentials);
			}else {
				throw new UberizationBusinessException(
						Arrays.asList(
								new ErrorMessage(UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getErrorCode(),
										"Insufficient parameter",
										UberizationExceptionInfo.UBERIZATION_BUSINESS_EXCEPTION.getDescription())),
						"Insufficient parameter");
			}
		} catch (Exception e) {
			if(e instanceof UberizationAuthenticationException) {
				throw e;
			}
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}

	
}
