package com.principal.uberization.Login.service;

import com.principal.uberization.Login.VO.LoginVO;

/**
 * @author Sujay
 *This interface is used for Login service 
 */
public interface LoginService {
	Boolean authenticateUser(final LoginVO loginVO);
}
