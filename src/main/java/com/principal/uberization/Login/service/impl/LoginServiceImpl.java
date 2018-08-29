package com.principal.uberization.Login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.Login.service.LoginService;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.vo.UserInfo;

/**
 * @author Sujay
 * This class is used to get services for LOgin/authentication
 */
@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public UserInfo authenticateUser(LoginVO loginVO) throws UberizationSystemException {
		final String METHOD_NAME="authenticateUser";
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
