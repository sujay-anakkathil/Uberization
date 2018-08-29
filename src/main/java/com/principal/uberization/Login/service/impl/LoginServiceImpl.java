package com.principal.uberization.Login.service.impl;

import org.springframework.stereotype.Service;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.Login.service.LoginService;

/**
 * @author Sujay
 * This class is used to get services for LOgin/authentication
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public Boolean authenticateUser(LoginVO loginVO) {
		return true;
	}

}
