package com.principal.uberization.userInfo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.service.UserService;
import com.principal.uberization.userInfo.validator.UserServiceValidator;
import com.principal.uberization.userInfo.vo.UserInfo;

/**
 * @author Sujay
 * This class is used for various operations on User information
 */

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * @param userinfo
	 * @return
	 * This method is used to register user
	 * @throws UberizationSystemException 
	 */
	@Override
	public Boolean registerUser(UserInfo userinfo) throws UberizationSystemException {

		final String METHOD_NAME="registerUser";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			return true;
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	
	}

	@Override
	public UserInfo getUserProfile(String userId) throws UberizationSystemException {
		final String METHOD_NAME="getUserProfile";
		LOGGER.info("Class:"+this.getClass().getName()+" METHOD entry :"+METHOD_NAME);
		try {
			UserInfo user = new UserInfo();
			user.setFirstName("Sujay");
			user.setLastName("Anakkathil");
			user.setEmail("sujaysudeep93@gmail.com");
			user.setContactNumber("+918983089016");
			return user;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new UberizationSystemException(e.getMessage(), e);
		}
	}

}
