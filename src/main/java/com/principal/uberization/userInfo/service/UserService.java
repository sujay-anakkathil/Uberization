package com.principal.uberization.userInfo.service;

import com.principal.uberization.exception.UberizationSystemException;
import com.principal.uberization.userInfo.vo.UserInfo;

/**
 * @author Sujay
 * This interface is used for various operations on User information
 */
public interface UserService {
	/**
	 * @param userinfo
	 * @return
	 * This method is used to register user
	 * @throws UberizationSystemException 
	 */
	Boolean registerUser(final UserInfo userinfo) throws UberizationSystemException;
	UserInfo getUserProfile(final String userId) throws UberizationSystemException;
}
