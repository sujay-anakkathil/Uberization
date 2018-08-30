package com.principal.uberization.Login.service;

import com.principal.uberization.Login.VO.LoginVO;
import com.principal.uberization.exception.UberizationAuthenticationException;
import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.vo.UserInfoVO;

/**
 * @author Sujay
 *This interface is used for Login service 
 */
public interface LoginService {
	UserInfoVO authenticateUser(final LoginVO loginVO) throws UberizationSystemException, UberizationAuthenticationException;
}
